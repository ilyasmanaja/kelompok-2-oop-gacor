package com.kelompok4.pomotodo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Kelas ini bertugas sebagai MODEL.
 * Mengatur logika bisnis timer, state (status) waktu, dan pergantian mode otomatis.
 */
public class PomodoroTimer {

    // ENUM: Cara elegan mendefinisikan konstanta tipe mode.
    // Mencegah error typo string ("pomodoro" vs "Pomodoro").
    public enum TimerMode {
        POMODORO,
        SHORT_BREAK,
        LONG_BREAK
    }

    // Konstanta waktu default (dalam menit) agar mudah diubah di satu tempat.
    private static final int DEFAULT_POMODORO = 25;
    private static final int DEFAULT_SHORT_BREAK = 5;
    private static final int DEFAULT_LONG_BREAK = 15;

    // Map untuk menyimpan durasi custom setiap mode.
    // Key: TimerMode, Value: Detik (Integer)
    private final Map<TimerMode, Integer> customTimes;

    // Variable State (Status saat ini)
    private TimerMode currentMode;
    private int timeSeconds; // Sisa waktu dalam detik
    private Timeline timeline; // JavaFX Timer object
    private boolean isRunning;

    // Manajemen Set (Siklus Pomodoro)
    private int totalSets = 4;
    private int currentSet = 1;
    private boolean isInBreak = false; // Flag: lagi istirahat atau fokus?
    private Runnable onTimerComplete; // Interface fungsional untuk callback (aksi susulan)

    // JavaFX Properties: Variable "pintar" yang bisa dipantau (observed) oleh UI.
    // Kalau nilai ini berubah, UI otomatis update tanpa perlu kita suruh manual.
    private final SimpleStringProperty timeDisplay = new SimpleStringProperty("25:00");
    private final SimpleIntegerProperty currentSetProperty = new SimpleIntegerProperty(1);
    private final SimpleIntegerProperty totalSetsProperty = new SimpleIntegerProperty(4);

    /**
     * Constructor: Dijalankan pertama kali saat object dibuat.
     * Menginisialisasi waktu default dan menyiapkan timeline.
     */
    public PomodoroTimer() {
        // Simpan waktu default ke dalam Map (dikonversi ke detik)
        this.customTimes = new HashMap<>();
        this.customTimes.put(TimerMode.POMODORO, DEFAULT_POMODORO * 60);
        this.customTimes.put(TimerMode.SHORT_BREAK, DEFAULT_SHORT_BREAK * 60);
        this.customTimes.put(TimerMode.LONG_BREAK, DEFAULT_LONG_BREAK * 60);

        // Set kondisi awal
        this.currentMode = TimerMode.POMODORO;
        this.timeSeconds = getTimeForMode(currentMode);
        this.isRunning = false;

        setupTimeline(); // Siapkan mesin waktunya
        updateDisplay(); // Format text awal "25:00"
    }

    /**
     * Helper method untuk mengambil durasi dari Map berdasarkan mode.
     * Jika null, kembalikan default.
     */
    private int getTimeForMode(TimerMode mode) {
        return customTimes.getOrDefault(mode, DEFAULT_POMODORO * 60);
    }

    /**
     * Menyiapkan logika pengurangan waktu per detik.
     * Menggunakan JavaFX Timeline agar sinkron dengan UI thread.
     */
    private void setupTimeline() {
        // KeyFrame: Aksi yang dilakukan setiap 1 detik
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (timeSeconds > 0) {
                timeSeconds--; // Kurangi detik
                updateDisplay(); // Update text property
            }
            // Jika waktu habis
            if (timeSeconds <= 0) {
                timeline.stop();
                isRunning = false;
                handleTimerComplete(); // Panggil logika pergantian mode
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE); // Ulangi terus sampai distop
    }

    /**
     * Logika inti otomatisasi Pomodoro.
     * Menentukan apa yang terjadi setelah timer bunyi "kring".
     */
    private void handleTimerComplete() {
        // Jalankan callback jika ada (misal: bunyi alarm atau update UI tombol)
        if (onTimerComplete != null) {
            onTimerComplete.run();
        }

        // Logika Pergantian Mode:
        if (currentMode == TimerMode.POMODORO) {
            // Selesai kerja -> Waktunya istirahat
            isInBreak = true;
            if (currentSet == totalSets) {
                setMode(TimerMode.LONG_BREAK); // Sudah set terakhir? Istirahat panjang
            } else {
                setMode(TimerMode.SHORT_BREAK); // Belum? Istirahat pendek
            }
        } else if (currentMode == TimerMode.SHORT_BREAK || currentMode == TimerMode.LONG_BREAK) {
            // Selesai istirahat -> Kembali kerja
            isInBreak = false;
            if (currentSet < totalSets) {
                currentSet++; // Naik ke set berikutnya
                currentSetProperty.set(currentSet);
                setMode(TimerMode.POMODORO);
            } else {
                // Siklus selesai total -> Reset ke awal
                currentSet = 1;
                currentSetProperty.set(1);
                setMode(TimerMode.POMODORO);
            }
        }
        // Catatan: Timer tidak auto-start di sini, logika start ada di PixelView (callback)
    }

    /**
     * Mengubah detik (int) menjadi String format "MM:SS"
     * dan mengupdate property agar UI berubah.
     */
    private void updateDisplay() {
        int minutes = timeSeconds / 60;
        int seconds = timeSeconds % 60;
        timeDisplay.set(String.format("%02d:%02d", minutes, seconds));
    }

    /**
     * Tombol Start/Pause logic.
     */
    public void toggleTimer() {
        if (isRunning) {
            timeline.stop();
            isRunning = false;
        } else {
            timeline.play();
            isRunning = true;
        }
    }

    /**
     * Reset timer ke kondisi awal mode saat ini.
     */
    public void reset() {
        timeline.stop();
        isRunning = false;
        // Reset juga set ke 1 agar bersih
        currentSet = 1;
        currentSetProperty.set(1);
        isInBreak = false;

        // Kembalikan waktu ke full durasi
        timeSeconds = getTimeForMode(currentMode);
        updateDisplay();
    }

    /**
     * Mengganti mode secara manual atau otomatis.
     * Menghentikan timer sementara saat ganti mode.
     */
    public void setMode(TimerMode mode) {
        boolean wasRunning = isRunning;
        if (wasRunning) {
            timeline.stop();
        }
        this.currentMode = mode;
        this.timeSeconds = getTimeForMode(mode);
        updateDisplay();

        // Opsional: Kalau mau langsung jalan setelah ganti, uncomment ini.
        // Tapi logic sekarang menunggu user klik start (atau diatur di View).
        if (wasRunning) {
            timeline.play();
        }
    }

    // --- SETTER & GETTER (Encapsulation Standard) ---

    // Mengatur jumlah total set (validasi 1-20)
    public void setTotalSets(int sets) {
        if (sets > 0 && sets <= 20) {
            this.totalSets = sets;
            this.totalSetsProperty.set(sets);
            // Safety check: kalau user ubah setting pas lagi di set 5 padahal max jadi 4
            if (currentSet > totalSets) {
                currentSet = 1;
                currentSetProperty.set(1);
            }
        }
    }

    public int getTotalSets() { return totalSets; }
    public int getCurrentSet() { return currentSet; }

    // Menerima fungsi (lambda) dari luar untuk dijalankan saat timer habis
    public void setOnTimerComplete(Runnable callback) {
        this.onTimerComplete = callback;
    }

    // Getter untuk Properties (agar bisa di-bind oleh UI)
    public IntegerProperty currentSetProperty() { return currentSetProperty; }
    public IntegerProperty totalSetsProperty() { return totalSetsProperty; }
    public StringProperty timeDisplayProperty() { return timeDisplay; }

    // Mengubah durasi custom (validasi 1-120 menit)
    public void setCustomTime(TimerMode mode, int minutes) {
        if (minutes > 0 && minutes <= 120) {
            customTimes.put(mode, minutes * 60);
            // Refresh display jika kita sedang di mode yang diedit dan timer mati
            if (currentMode == mode && !isRunning) {
                timeSeconds = getTimeForMode(mode);
                updateDisplay();
            }
        }
    }

    public int getCustomTime(TimerMode mode) {
        return customTimes.getOrDefault(mode, DEFAULT_POMODORO * 60) / 60;
    }

    public TimerMode getCurrentMode() { return currentMode; }
    public boolean isRunning() { return isRunning; }
}