import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PixelCalculator extends JFrame implements ActionListener {
    private static final Color BG_COLOR = new Color(0x4E342E);
    private static final Color DISPLAY_BG = new Color(0x3E2723);
    private static final Color DISPLAY_TEXT = new Color(0xFFEBEE);
    private static final Color NUM_BG = new Color(0x6D4C41);
    private static final Color NUM_TEXT = new Color(0xFFEBEE);
    private static final Color OP_BG = new Color(0x3E2723);
    private static final Color OP_TEXT = new Color(0xFF8A80);
    private static final Color SPECIAL_BG = new Color(0xF06292);
    private static final Color SPECIAL_TEXT = new Color(0xFFEBEE);
    private static Font PIXEL_FONT;
    private static Font DISPLAY_FONT;

    static {
        try {
            java.io.InputStream is = PixelCalculator.class.getResourceAsStream("/PressStart2P-Regular.ttf");

            if (is == null) {
                throw new java.io.IOException("Font 'PressStart2P-Regular.ttf' tidak ditemukan. " +
                        "Pastikan file-nya ada di dalam folder 'src'.");
            }

            Font baseFont = Font.createFont(Font.TRUETYPE_FONT, is);

            PIXEL_FONT = baseFont.deriveFont(Font.BOLD, 16f);
            DISPLAY_FONT = baseFont.deriveFont(Font.BOLD, 26f);

            is.close();

        } catch (Exception e) {
            System.err.println("Gagal load font pixel 'Press Start 2P'. Menggunakan Monospaced.");
            e.printStackTrace();

            PIXEL_FONT = new Font("Monospaced", Font.BOLD, 24);
            DISPLAY_FONT = new Font("Monospaced", Font.BOLD, 36);
        }
    }

    private JTextField display;
    private JPanel buttonPanel;

    private CalculatorLogic logic;

    public PixelCalculator() {
        logic = new CalculatorLogic();

        setTitle("Calculator Kelompok 2 Gacor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(BG_COLOR);

        display = new JTextField(logic.getLayarAwal());
        display.setEditable(false);
        display.setFont(DISPLAY_FONT);
        display.setBackground(DISPLAY_BG);
        display.setForeground(DISPLAY_TEXT);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBorder(new EmptyBorder(20, 10, 20, 10));
        add(display, BorderLayout.NORTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,4,8,8));
        buttonPanel.setBackground(BG_COLOR);
        buttonPanel.setBorder(new EmptyBorder(10,10,10,10));

        String[] buttons = {
                "C", "+/-", "%", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ".", "DEL", "="
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(PIXEL_FONT);
            button.addActionListener(this);
            button.setFocusPainted(false);
            button.setBorder(null);

            if (isOperatorSymbol(text)) {
                button.setBackground(OP_BG);
                button.setForeground(OP_TEXT);
            }   else if (text.equals("C") || text.equals("=")) {
                button.setBackground(SPECIAL_BG);
                button.setForeground(SPECIAL_TEXT);
            }   else {
                button.setBackground(NUM_BG);
                button.setForeground(NUM_TEXT);
            }
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.CENTER);
    }

    private boolean isOperatorSymbol(String text) {
        return text.equals("+") || text.equals("-") || text.equals("*")  || text.equals("/");
    }

    private boolean isDigit(String text) {
        if (text == null || text.length() != 1) {
            return false;
        }

        char c = text.charAt(0);
        return c >= '0' && c <= '9';
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        String command = e.getActionCommand();

        try {
            if (isDigit(command)) {
                logic.processDigit(command);
            }   else if (command.equals(".")) {
                logic.processDecimal();
            }   else if (command.equals("C")) {
                logic.processClear();
            }   else if (command.equals("DEL")) {
                logic.processDelete();
            }   else if (command.equals("+/-")) {
                logic.processToggleSign();
            }   else if (command.equals("%")) {
                logic.processPercent();
            }   else if (command.equals("=")) {
                logic.processEquals();
            }   else if (isOperatorSymbol(command)) {
                logic.processOperator(command);
            }
        }   catch (Exception exception) {
            logic.processClear();
            display.setText("Error");
        }
        display.setText(logic.getLayarAwal());
    }
}