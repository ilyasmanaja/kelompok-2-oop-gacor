package com.mycompany.praktikum9;

public class Main {

    public static void main(String[] args) {
        MainJFrame frame = new MainJFrame();
        frame.changeMainPanel(new TambahDataPanel());
        frame.setVisible(true);
    }
}
