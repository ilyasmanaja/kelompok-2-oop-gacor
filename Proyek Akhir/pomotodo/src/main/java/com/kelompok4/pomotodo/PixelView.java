package com.kelompok4.pomotodo;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * PixelView: Kelas yang menangani Tampilan (View) dan Interaksi (Controller).
 * Kelas ini bertugas merakit komponen UI, menangkap klik user, dan menghubungkannya
 * ke logic timer (Model).
 */
public class PixelView {

    // COMPOSITION: View 'memiliki' Model. Ini memisahkan UI dari Logic.
    private final PomodoroTimer timerModel;

    // Referensi ke komponen UI agar bisa diupdate nanti
    private Button btnStart;
    private Label lblTimer;
    private Label lblSetProgress; // Label untuk menampilkan progress set
    private List<TaskItem> taskItems; // List untuk menyimpan data tugas di memori
    private TextField taskInput;
    private VBox taskContainer;
    // Persistence flags
    private boolean suppressSave = false;

    // Toggle Group agar tombol mode bekerja seperti Radio Button (pilih satu saja)
    private ToggleGroup modeToggleGroup;
    private ToggleButton btnPomodoro;
    private ToggleButton btnShortBreak;
    private ToggleButton btnLongBreak;

    /**
     * Constructor: Inisialisasi Model dan Callback.
     */
    public PixelView() {
        this.timerModel = new PomodoroTimer();
        this.taskItems = new ArrayList<>();

        // OBSERVER PATTERN: Callback untuk auto-switch mode.
        // Saat Model selesai menghitung, dia akan 'memberi tahu' View lewat sini.
        timerModel.setOnTimerComplete(() -> {
            // THREADING ISSUE: Timer berjalan di thread background/timeline.
            // Perubahan UI (seperti ganti warna tombol) HARUS dilakukan di JavaFX Application Thread.
            // Platform.runLater() memindahkan eksekusi kode ini ke thread UI agar tidak error.
            Platform.runLater(() -> {
                try {
                    PomodoroTimer.TimerMode mode = timerModel.getCurrentMode();
                    // Update visual tombol mode (sorot tombol yang aktif sekarang)
                    if (btnPomodoro != null && btnShortBreak != null && btnLongBreak != null) {
                        if (mode == PomodoroTimer.TimerMode.POMODORO) {
                            btnPomodoro.setSelected(true);
                        } else if (mode == PomodoroTimer.TimerMode.SHORT_BREAK) {
                            btnShortBreak.setSelected(true);
                        } else if (mode == PomodoroTimer.TimerMode.LONG_BREAK) {
                            btnLongBreak.setSelected(true);
                        }
                    }

                    // Logic: Auto-start timer setelah pergantian mode
                    if (!timerModel.isRunning()) {
                        timerModel.toggleTimer();
                    }

                    // Update teks tombol agar sinkron (Start vs Pause)
                    if (btnStart != null) {
                        btnStart.setText(timerModel.isRunning() ? "Pause" : "Start");
                    }
                } catch (Exception ignored) {
                    // Safety net: mencegah crash jika komponen belum siap
                }
            });
        });
    }

    /**
     * Method Utama Pembentuk UI.
     * Mengembalikan 'Parent' node yang siap ditampilkan di Scene utama.
     */
    public Parent getView() {
        // StackPane digunakan sebagai root agar bisa menumpuk Background di belakang Konten.
        StackPane root = new StackPane();
        root.setPrefSize(360, 600); // Ukuran rasio mobile

        // --- LAYER 1: BACKGROUND ---
        // Menggunakan Try-Catch untuk Resource Loading.
        // Jika file gambar hilang/salah nama, aplikasi tidak crash, tapi pakai warna fallback.
        try {
            Image bgImage = new Image(Objects.requireNonNull(
                    getClass().getResourceAsStream("/com/kelompok4/pomotodo/images/background.png")));
            ImageView bgImageView = new ImageView(bgImage);
            bgImageView.setFitWidth(360);
            bgImageView.setFitHeight(600);
            bgImageView.setPreserveRatio(false); // Stretch gambar memenuhi layar
            root.getChildren().add(bgImageView);
        } catch (Exception e) {
            // Fallback: Warna hijau solid jika gambar gagal load
            root.setStyle("-fx-background-color: #2d5016;");
        }

        // --- LAYER 2: CONTENT ---
        // VBox menyusun komponen secara vertikal (atas ke bawah)
        VBox contentBox = new VBox(15); // Spasi antar elemen 15px
        contentBox.setPadding(new Insets(20, 15, 15, 15));
        contentBox.setAlignment(Pos.TOP_CENTER);
        contentBox.setPrefSize(360, 600);

        // Load Custom Font (Pixel Style)
        Font pixelFont = Font.loadFont(Objects.requireNonNull(
                getClass().getResourceAsStream("/com/kelompok4/pomotodo/fonts/PressStart2P-Regular.ttf")), 12);

        // Load CSS Style
        try {
            contentBox.getStylesheets().add(Objects.requireNonNull(
                    getClass().getResource("/com/kelompok4/pomotodo/styles/style.css")).toExternalForm());
        } catch (Exception e) {
            System.err.println("CSS not found, using inline styles");
        }

        // --- KOMPONEN 1: TOP BAR (Settings) ---
        HBox topBar = new HBox();
        topBar.setAlignment(Pos.TOP_RIGHT);
        topBar.setPadding(new Insets(0, 0, 10, 0));

        Button btnSettings = new Button("⚙");
        btnSettings.getStyleClass().add("settings-button"); // Style dari CSS
        if (pixelFont != null) {
            btnSettings.setFont(Font.font(pixelFont.getFamily(), 16));
        }
        btnSettings.setPrefSize(50, 50);
        // EVENT HANDLER: Membuka dialog pengaturan saat diklik
        btnSettings.setOnAction(e -> showSettingsDialog(pixelFont));

        topBar.getChildren().add(btnSettings);

        // --- KOMPONEN 2: MODE BUTTONS (Pomo, Short, Long) ---
        HBox modeBox = createModeButtons(pixelFont);

        // Gabungkan TopBar dan ModeButtons dalam satu container header
        VBox topSection = new VBox(5);
        topSection.setAlignment(Pos.TOP_CENTER);
        topSection.getChildren().addAll(topBar, modeBox);
        contentBox.getChildren().add(topSection);

        // --- KOMPONEN 3: TIMER DISPLAY ---
        Parent timerPanel = createTimerPanel(pixelFont);
        contentBox.getChildren().add(timerPanel);

        // --- KOMPONEN 4: CONTROLS (Start/Reset) ---
        HBox controlsBox = createTimerControls(pixelFont);
        contentBox.getChildren().add(controlsBox);

        // --- KOMPONEN 5: TASK LIST ---
        VBox taskSection = createTaskSection(pixelFont);
        // Priority.ALWAYS: Task section akan memanjang mengisi sisa ruang kosong di bawah
        VBox.setVgrow(taskSection, Priority.ALWAYS);
        contentBox.getChildren().add(taskSection);

        root.getChildren().add(contentBox);
        // Muat tugas yang tersimpan dari disk setelah komponen UI dibuat
        loadTasksFromDisk();
        return root;
    }

    /**
     * Membuat baris tombol pilihan mode.
     */
    private HBox createModeButtons(Font pixelFont) {
        HBox modeBox = new HBox(10);
        modeBox.setAlignment(Pos.CENTER);

        // ToggleGroup memastikan hanya 1 tombol yang aktif dalam satu waktu
        modeToggleGroup = new ToggleGroup();

        // Membuat tombol menggunakan Helper Method (DRY Principle)
        btnPomodoro = createModeButton("Pomodoro", "cat.png", pixelFont);
        btnPomodoro.setToggleGroup(modeToggleGroup);
        btnPomodoro.setSelected(true); // Default terpilih
        // Mengubah mode di Model saat diklik
        btnPomodoro.setOnAction(e -> timerModel.setMode(PomodoroTimer.TimerMode.POMODORO));

        btnShortBreak = createModeButton("Short Break", "frog.png", pixelFont);
        btnShortBreak.setToggleGroup(modeToggleGroup);
        btnShortBreak.setOnAction(e -> timerModel.setMode(PomodoroTimer.TimerMode.SHORT_BREAK));

        btnLongBreak = createModeButton("Long Break", "rabbit.png", pixelFont);
        btnLongBreak.setToggleGroup(modeToggleGroup);
        btnLongBreak.setOnAction(e -> timerModel.setMode(PomodoroTimer.TimerMode.LONG_BREAK));

        modeBox.getChildren().addAll(btnPomodoro, btnShortBreak, btnLongBreak);
        return modeBox;
    }

    /**
     * Helper Method: Membuat ToggleButton kustom dengan Gambar + Teks.
     * Mengurangi duplikasi kode untuk 3 tombol mode.
     */
    private ToggleButton createModeButton(String text, String imageFileName, Font pixelFont) {
        VBox contentBox = new VBox(5);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setPadding(new Insets(5));

        // Load gambar icon hewan
        ImageView imageView = null;
        try {
            Image animalImage = new Image(Objects.requireNonNull(
                    getClass().getResourceAsStream("/com/kelompok4/pomotodo/images/" + imageFileName)));
            imageView = new ImageView(animalImage);
            imageView.setFitWidth(40);
            imageView.setFitHeight(40);
            imageView.setPreserveRatio(true);
        } catch (Exception e) {
            // Fallback mekanis jika gambar hewan tidak ada
            // Mengambil potongan kecil dari background.png sebagai placeholder
            try {
                Image placeholderImage = new Image(Objects.requireNonNull(
                        getClass().getResourceAsStream("/com/kelompok4/pomotodo/images/background.png")));
                imageView = new ImageView(placeholderImage);
                imageView.setFitWidth(40);
                imageView.setFitHeight(40);
                imageView.setPreserveRatio(true);
                imageView.setViewport(new Rectangle2D(0, 0, 40, 40)); // Crop
            } catch (Exception e2) {
                System.out.println("Gambar tidak ditemukan: " + imageFileName);
            }
        }

        // Label teks di bawah icon
        Label textLabel = new Label(text);
        textLabel.getStyleClass().add("mode-button-text");
        if (pixelFont != null) {
            textLabel.setFont(Font.font(pixelFont.getFamily(), 7));
        }
        textLabel.setTextFill(Color.web("#2d5016"));
        textLabel.setAlignment(Pos.CENTER);

        if (imageView != null) {
            contentBox.getChildren().add(imageView);
        }
        contentBox.getChildren().add(textLabel);

        // Buat ToggleButton
        ToggleButton btn = new ToggleButton();
        btn.setGraphic(contentBox); // Isi tombol adalah VBox (Gambar+Teks) tadi
        btn.getStyleClass().add("mode-button");
        btn.setPrefWidth(90);
        btn.setPrefHeight(70);
        btn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        return btn;
    }

    /**
     * Membuat Panel Timer (Kotak Waktu).
     * Menggunakan konsep DATA BINDING yang kuat.
     */
    private Parent createTimerPanel(Font pixelFont) {
        StackPane container = new StackPane();
        container.setPrefSize(330, 150);
        container.setMaxSize(330, 150);

        // Background panel transparan dengan sudut bulat
        Region bgPanel = new Region();
        bgPanel.setPrefSize(330, 150);
        bgPanel.setMaxSize(330, 150);
        // Menggunakan JavaFX Background API untuk set warna dengan opacity (transparansi)
        javafx.scene.layout.BackgroundFill bgFill = new javafx.scene.layout.BackgroundFill(
                Color.web("#a8d5ba", 0.85), // Opacity 0.85
                new javafx.scene.layout.CornerRadii(12),
                Insets.EMPTY
        );
        javafx.scene.layout.Background bg = new javafx.scene.layout.Background(bgFill);
        bgPanel.setBackground(bg);

        // Styling border via CSS string
        bgPanel.setStyle(
                "-fx-border-color: #2d5016;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 12px;"
        );

        VBox timerPanel = new VBox(5);
        timerPanel.setAlignment(Pos.CENTER);
        timerPanel.setPadding(new Insets(20));
        timerPanel.setBackground(null); // Transparent background

        // Label Progress Set (misal: "SET 1/4")
        lblSetProgress = new Label();
        lblSetProgress.getStyleClass().add("set-progress-label");
        if (pixelFont != null) {
            lblSetProgress.setFont(Font.font(pixelFont.getFamily(), 8));
        }
        lblSetProgress.setTextFill(Color.web("#2d5016"));

        // COMPLEX BINDING:
        // Text label ini otomatis terikat dengan nilai 'currentSet' dan 'totalSets' di Model.
        // Jika model berubah, teks di sini otomatis update formatnya.
        lblSetProgress.textProperty().bind(
                javafx.beans.binding.Bindings.concat(
                        "SET ", timerModel.currentSetProperty().asString(),
                        "/", timerModel.totalSetsProperty().asString()
                )
        );

        // Label Timer (misal: "25:00")
        lblTimer = new Label();
        // SIMPLE BINDING: Terikat langsung ke property string waktu di Model.
        lblTimer.textProperty().bind(timerModel.timeDisplayProperty());
        lblTimer.getStyleClass().add("timer-label");
        if (pixelFont != null) {
            lblTimer.setFont(Font.font(pixelFont.getFamily(), 32));
        }
        lblTimer.setTextFill(Color.web("#333333"));

        timerPanel.getChildren().addAll(lblSetProgress, lblTimer);

        container.getChildren().addAll(bgPanel, timerPanel);

        return container;
    }

    private HBox createTimerControls(Font pixelFont) {
        HBox controlsBox = new HBox(10);
        controlsBox.setAlignment(Pos.CENTER);
        controlsBox.setPadding(new Insets(10, 0, 10, 0));

        // Tombol Start
        btnStart = new Button("Start");
        btnStart.getStyleClass().add("start-button");
        if (pixelFont != null) {
            btnStart.setFont(Font.font(pixelFont.getFamily(), 10));
        }
        btnStart.setPrefWidth(180);
        btnStart.setPrefHeight(40);

        // Logic Start/Pause
        btnStart.setOnAction(e -> {
            timerModel.toggleTimer(); // Perintahkan model untuk start/stop
            // Update UI manual (karena status isRunning tidak dibind ke text tombol)
            btnStart.setText(timerModel.isRunning() ? "Pause" : "Start");
        });

        // Tombol Reset
        Button btnReset = new Button("⟳");
        btnReset.getStyleClass().add("reset-button");
        if (pixelFont != null) {
            btnReset.setFont(Font.font(pixelFont.getFamily(), 14));
        }
        btnReset.setPrefWidth(40);
        btnReset.setPrefHeight(40);
        btnReset.setOnAction(e -> {
            timerModel.reset(); // Reset model
            btnStart.setText("Start"); // Reset text tombol UI
        });

        controlsBox.getChildren().addAll(btnStart, btnReset);
        return controlsBox;
    }

    /**
     * Membuat area Tugas (To-Do List).
     * Area ini kompleks karena melibatkan ScrollPane dan Input dinamis.
     */
    private VBox createTaskSection(Font pixelFont) {
        StackPane container = new StackPane();
        container.setPrefWidth(330);
        container.setMaxWidth(330);
        container.setAlignment(Pos.TOP_LEFT);

        // Background panel semi-transparan
        Region bgPanel = new Region();
        bgPanel.setPrefWidth(330);
        bgPanel.setMinHeight(200);
        javafx.scene.layout.BackgroundFill bgFill = new javafx.scene.layout.BackgroundFill(
                Color.web("#a8d5ba", 0.85),
                new javafx.scene.layout.CornerRadii(12),
                Insets.EMPTY
        );
        javafx.scene.layout.Background bg = new javafx.scene.layout.Background(bgFill);
        bgPanel.setBackground(bg);

        bgPanel.setStyle(
                "-fx-border-color: #2d5016;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 12px;"
        );

        // Wrapper konten tugas
        VBox taskSection = new VBox(10);
        taskSection.setPadding(new Insets(12));
        taskSection.setBackground(null); // Transparent background
        taskSection.setMinHeight(200);
        taskSection.setPrefHeight(250);
        taskSection.setMaxHeight(350); // Batas tinggi agar tidak memenuhi layar

        // ScrollPane: Agar daftar tugas bisa discroll jika banyak
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true); // Konten dipaksa selebar scrollpane
        scrollPane.setPrefHeight(200);
        scrollPane.setMinHeight(150);
        scrollPane.setMaxHeight(250);
        // Menghilangkan background bawaan ScrollPane yg jelek
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Matikan scroll horizontal
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        // Container tempat TaskItem akan ditambahkan
        taskContainer = new VBox(8);
        taskContainer.setPadding(new Insets(5));
        scrollPane.setContent(taskContainer);

        // --- LOGIKA INPUT TUGAS ---
        HBox addTaskBox = new HBox(5);
        addTaskBox.setAlignment(Pos.CENTER_LEFT);

        Label addLabel = new Label("+");
        addLabel.getStyleClass().add("add-task-label");
        if (pixelFont != null) {
            addLabel.setFont(Font.font(pixelFont.getFamily(), 8));
        }
        addLabel.setTextFill(Color.web("#333333"));
        addLabel.setStyle("-fx-underline: true;");

        taskInput = new TextField();
        taskInput.setVisible(false); // Default tersembunyi
        taskInput.getStyleClass().add("task-input");
        if (pixelFont != null) {
            taskInput.setFont(Font.font(pixelFont.getFamily(), 8));
        }
        taskInput.setPrefWidth(280);

        // Klik tombol '+' -> Munculkan input text
        addLabel.setOnMouseClicked(e -> {
            addLabel.setVisible(false);
            taskInput.setVisible(true);
            taskInput.requestFocus(); // Langsung fokus kursor ke input
        });

        // Tekan Enter di input -> Simpan tugas
        taskInput.setOnAction(e -> {
            String text = taskInput.getText().trim();
            if (!text.isEmpty()) {
                addTask(text);
                taskInput.clear();
            }
            // Sembunyikan input, munculkan tombol '+' lagi
            taskInput.setVisible(false);
            addLabel.setVisible(true);
        });

        // Jika user klik di luar input (hilang fokus) -> Sembunyikan input
        taskInput.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && taskInput.getText().trim().isEmpty()) {
                taskInput.setVisible(false);
                addLabel.setVisible(true);
            }
        });

        addTaskBox.getChildren().addAll(addLabel, taskInput);

        // Title for the task section
        Label tasksTitle = new Label("TO DO LIST");
        tasksTitle.getStyleClass().add("tasks-title");
        if (pixelFont != null) tasksTitle.setFont(Font.font(pixelFont.getFamily(), 9));
        tasksTitle.setTextFill(Color.web("#2d5016"));
        // Center the title horizontally
        tasksTitle.setAlignment(Pos.CENTER);
        tasksTitle.setMaxWidth(Double.MAX_VALUE);

        taskSection.getChildren().addAll(tasksTitle, scrollPane, addTaskBox);

        container.getChildren().addAll(bgPanel, taskSection);

        // Set tinggi container yang tetap agar tidak terus berubah saat mengetik
        container.setMinHeight(200);
        container.setPrefHeight(250);
        container.setMaxHeight(350);

        // Binding tinggi background agar selalu mengikuti tinggi konten
        bgPanel.prefHeightProperty().bind(container.prefHeightProperty());
        bgPanel.minHeightProperty().bind(container.minHeightProperty());
        bgPanel.maxHeightProperty().bind(container.maxHeightProperty());

        VBox wrapper = new VBox(container);
        VBox.setVgrow(wrapper, Priority.ALWAYS);
        return wrapper;
    }

    /**
     * Menambahkan item tugas baru ke dalam tampilan.
     */
    private void addTask(String text) {
        // Load font lagi (lokal)
        Font pixelFont = null;
        try {
            pixelFont = Font.loadFont(Objects.requireNonNull(
                    getClass().getResourceAsStream("/com/kelompok4/pomotodo/fonts/PressStart2P-Regular.ttf")), 10);
        } catch (Exception e) {}

        // Buat objek TaskItem baru
        TaskItem task = new TaskItem(text, pixelFont);
        taskItems.add(task); // Simpan ke list
        taskContainer.getChildren().add(task.getView()); // Tampilkan ke VBox

        // Event listener checkbox: toggle + save
        task.getCheckbox().setOnAction(e -> {
            task.toggleCompleted();
            saveTasksToDisk();
        });

        // Save tasks (unless suppressed e.g. during initial load)
        if (!suppressSave) {
            saveTasksToDisk();
        }
    }

    /**
     * Inner Static Class: Membungkus logika tampilan per item tugas.
     * Menggunakan Enkapsulasi private field.
     */
    private class TaskItem {
        private CheckBox checkbox;
        private Label label;
        private HBox container;
        private boolean completed;

        public TaskItem(String text, Font pixelFont) {
            this.completed = false;
            this.container = new HBox(8);
            this.container.setAlignment(Pos.CENTER_LEFT);

            this.checkbox = new CheckBox();
            this.checkbox.getStyleClass().add("task-checkbox");

            this.label = new Label(text);
            this.label.getStyleClass().add("task-label");
            if (pixelFont != null) {
                this.label.setFont(Font.font(pixelFont.getFamily(), 8));
            }
            this.label.setTextFill(Color.web("#333333"));

            container.getChildren().addAll(checkbox, label);
        }

        // Logika visual coret (strikethrough) saat selesai
        public void toggleCompleted() {
            completed = !completed;
            if (completed) {
                label.setStyle("-fx-strikethrough: true;");
                label.setTextFill(Color.web("#888888")); // Abu-abu
            } else {
                label.setStyle("-fx-strikethrough: false;");
                label.setTextFill(Color.web("#333333")); // Hitam
            }
        }

        public CheckBox getCheckbox() { return checkbox; }
        public HBox getView() { return container; }
        public boolean isCompleted() { return completed; }
        public String getText() { return label.getText(); }
    }

    // Add a task during load without triggering save repeatedly
    private void addTaskFromLoad(String text, boolean completed) {
        suppressSave = true;
        addTask(text);
        if (completed) {
            TaskItem t = taskItems.get(taskItems.size() - 1);
            if (!t.isCompleted()) t.toggleCompleted();
        }
        suppressSave = false;
    }

    // Persistence helpers: save/load tasks to a simple text file in user's home (.pomotodo/tasks.txt)
    private Path getTasksFile() {
        Path dir = Paths.get(System.getProperty("user.home"), ".pomotodo");
        try {
            if (!Files.exists(dir)) {
                Files.createDirectories(dir);
            }
        } catch (IOException ignored) {}
        return dir.resolve("tasks.txt");
    }

    private void saveTasksToDisk() {
        if (suppressSave) return;
        Path file = getTasksFile();
        List<String> lines = taskItems.stream()
            .map(t -> (t.isCompleted() ? "1" : "0") + "|" + t.getText())
            .collect(Collectors.toList());
        try {
            Files.write(file, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Failed to save tasks: " + e.getMessage());
        }
    }

    private void loadTasksFromDisk() {
        Path file = getTasksFile();
        if (!Files.exists(file)) return;
        try {
            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            for (String ln : lines) {
                if (ln == null || ln.trim().isEmpty()) continue;
                String[] parts = ln.split("\\|", 2);
                boolean completed = parts.length > 0 && "1".equals(parts[0]);
                String text = parts.length > 1 ? parts[1] : "";
                addTaskFromLoad(text, completed);
            }
        } catch (IOException e) {
            System.err.println("Failed to load tasks: " + e.getMessage());
        }
    }

    /**
     * Menampilkan Dialog Settings (Pop-up Modal).
     * Modal berarti user tidak bisa klik window utama sebelum dialog ini ditutup.
     */
    private void showSettingsDialog(Font pixelFont) {
        // Font handling ...
        Font dialogFont;
        if (pixelFont != null) {
            dialogFont = pixelFont;
        } else {
            try {
                dialogFont = Font.loadFont(Objects.requireNonNull(
                        getClass().getResourceAsStream("/com/kelompok4/pomotodo/fonts/PressStart2P-Regular.ttf")), 10);
            } catch (Exception e) {
                dialogFont = null;
            }
        }

        final Font finalDialogFont = dialogFont; // Variabel final untuk lambda

        Stage dialogStage = new Stage();
        // MODALITY: Memblokir interaksi ke window utama
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle("Settings");
        dialogStage.setResizable(false);

        // Layout Dialog
        VBox dialogBox = new VBox(15);
        dialogBox.setPadding(new Insets(20));
        dialogBox.setAlignment(Pos.CENTER);
        dialogBox.setPrefWidth(300);

        // Background panel
        Region bgPanel = new Region();
        bgPanel.setStyle(
                "-fx-background-color: #a8d5ba;" +
                        "-fx-background-radius: 12px;" +
                        "-fx-border-color: #2d5016;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 12px;"
        );

        StackPane container = new StackPane();
        container.getChildren().addAll(bgPanel, dialogBox);
        bgPanel.prefWidthProperty().bind(dialogBox.widthProperty());
        bgPanel.prefHeightProperty().bind(dialogBox.heightProperty());

        // Title
        Label titleLabel = new Label("TIMER SETTINGS");
        titleLabel.getStyleClass().add("settings-title");
        if (finalDialogFont != null) {
            titleLabel.setFont(Font.font(finalDialogFont.getFamily(), 10));
        }
        titleLabel.setTextFill(Color.web("#2d5016"));

        // Input Fields: Mengambil nilai saat ini dari timerModel
        VBox inputBox = new VBox(12);
        inputBox.setAlignment(Pos.CENTER);

        HBox pomodoroBox = createTimeInput("Pomodoro", timerModel.getCustomTime(PomodoroTimer.TimerMode.POMODORO), finalDialogFont);
        HBox shortBreakBox = createTimeInput("Short Break", timerModel.getCustomTime(PomodoroTimer.TimerMode.SHORT_BREAK), finalDialogFont);
        HBox longBreakBox = createTimeInput("Long Break", timerModel.getCustomTime(PomodoroTimer.TimerMode.LONG_BREAK), finalDialogFont);
        HBox setsBox = createTimeInput("Total Sets", timerModel.getTotalSets(), finalDialogFont);

        // Hack: Mengubah label "min" jadi "sets" khusus untuk input Total Sets
        try {
            Label setsUnitLabel = (Label) setsBox.getChildren().get(2);
            setsUnitLabel.setText("sets");
        } catch (Exception ignored) {}

        inputBox.getChildren().addAll(pomodoroBox, shortBreakBox, longBreakBox, setsBox);

        // Buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);

        Button btnSave = new Button("SAVE");
        btnSave.getStyleClass().add("settings-button");
        if (finalDialogFont != null) {
            btnSave.setFont(Font.font(finalDialogFont.getFamily(), 8));
        }
        btnSave.setPrefWidth(100);

        Button btnCancel = new Button("CANCEL");
        btnCancel.getStyleClass().add("settings-button");
        if (finalDialogFont != null) {
            btnCancel.setFont(Font.font(finalDialogFont.getFamily(), 8));
        }
        btnCancel.setPrefWidth(100);

        buttonBox.getChildren().addAll(btnSave, btnCancel);

        dialogBox.getChildren().addAll(titleLabel, inputBox, buttonBox);

        // Mengambil referensi TextField dari dalam HBox untuk dibaca nanti
        TextField pomodoroInput = (TextField) pomodoroBox.getChildren().get(1);
        TextField shortBreakInput = (TextField) shortBreakBox.getChildren().get(1);
        TextField longBreakInput = (TextField) longBreakBox.getChildren().get(1);
        TextField setsInput = (TextField) setsBox.getChildren().get(1);

        // Logic Tombol Save
        btnSave.setOnAction(e -> {
            try {
                // Parsing String ke Integer
                int pomodoro = Integer.parseInt(pomodoroInput.getText().trim());
                int shortBreak = Integer.parseInt(shortBreakInput.getText().trim());
                int longBreak = Integer.parseInt(longBreakInput.getText().trim());
                int totalSets = Integer.parseInt(setsInput.getText().trim());

                // VALIDASI DATA: Mencegah input ngawur (misal minus atau nol)
                if (pomodoro > 0 && pomodoro <= 120 &&
                        shortBreak > 0 && shortBreak <= 120 &&
                        longBreak > 0 && longBreak <= 120 &&
                        totalSets > 0 && totalSets <= 20) {

                    // Update Model
                    timerModel.setCustomTime(PomodoroTimer.TimerMode.POMODORO, pomodoro);
                    timerModel.setCustomTime(PomodoroTimer.TimerMode.SHORT_BREAK, shortBreak);
                    timerModel.setCustomTime(PomodoroTimer.TimerMode.LONG_BREAK, longBreak);
                    timerModel.setTotalSets(totalSets);

                    // Reset timer agar perubahan durasi langsung terasa (jika tidak sedang jalan)
                    if (!timerModel.isRunning()) {
                        timerModel.reset();
                    }

                    dialogStage.close(); // Tutup dialog
                } else {
                    showErrorDialog("Invalid input! Time: 1-120 minutes, Sets: 1-20.", finalDialogFont);
                }
            } catch (NumberFormatException ex) {
                showErrorDialog("Please enter valid numbers!", finalDialogFont);
            }
        });

        btnCancel.setOnAction(e -> dialogStage.close());

        // Show Stage
        Scene dialogScene = new Scene(container, 300, 250);
        try {
            dialogScene.getStylesheets().add(Objects.requireNonNull(
                    getClass().getResource("/com/kelompok4/pomotodo/styles/style.css")).toExternalForm());
        } catch (Exception e) {
            // Ignore
        }

        dialogStage.setScene(dialogScene);
        dialogStage.show();
    }

    /**
     * Helper membuat input field angka dengan validasi sederhana.
     */
    private HBox createTimeInput(String labelText, int currentValue, Font pixelFont) {
        HBox inputBox = new HBox(10);
        inputBox.setAlignment(Pos.CENTER);

        Label label = new Label(labelText + ":");
        if (pixelFont != null) {
            label.setFont(Font.font(pixelFont.getFamily(), 7));
        }
        label.setTextFill(Color.web("#2d5016"));
        label.setPrefWidth(100);

        TextField input = new TextField(String.valueOf(currentValue));
        input.getStyleClass().add("settings-input");
        if (pixelFont != null) {
            input.setFont(Font.font(pixelFont.getFamily(), 8));
        }
        input.setPrefWidth(80);
        input.setAlignment(Pos.CENTER);

        // VALIDASI REAL-TIME:
        // Listener ini mencegah user mengetik huruf. Hanya angka yang diizinkan.
        input.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.matches("\\d*")) {
                input.setText(newVal.replaceAll("[^\\d]", "")); // Hapus karakter non-angka
            }
            // Batasi panjang input maks 3 digit
            if (input.getText().length() > 3) {
                input.setText(input.getText().substring(0, 3));
            }
        });

        Label unitLabel = new Label("min");
        if (pixelFont != null) {
            unitLabel.setFont(Font.font(pixelFont.getFamily(), 7));
        }
        unitLabel.setTextFill(Color.web("#2d5016"));

        inputBox.getChildren().addAll(label, input, unitLabel);
        return inputBox;
    }

    // Menampilkan pesan error sederhana
    private void showErrorDialog(String message, Font pixelFont) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}