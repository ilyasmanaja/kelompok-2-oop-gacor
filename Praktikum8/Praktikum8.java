package com.mycompany.praktikum8;
import javax.swing.*;

public class Praktikum8 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Contoh JFrame");

        frame.setSize(400, 300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        frame.setLocationRelativeTo(null);
        
        JLabel label1 = new JLabel ("Contoh JLabel");
        frame.add(label1);
        JTextField textfield = new JTextField(5);
        frame.add(textfield);
        JButton button = new JButton("Click Me");
        frame.add(button);
        
        //jTextField1 = new javax.swing.JTextField();
        
      
    }
}
