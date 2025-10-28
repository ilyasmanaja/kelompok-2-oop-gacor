/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.praktikum8;

import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class Praktikum8 {

    public static void main(String[] args) {
        
        // JFrame
        JFrame frame = new JFrame("My First GUI");
        
        // Set Size
        frame.setSize(400, 300);
        
        //Mengatur operasi saat ditutup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Frame terlihat
        frame.setVisible(true);
        
        // Agar muncul ditengah
        frame.setLocationRelativeTo(null);
        
         JLabel label1 = new JLabel ("Contoh JLabel", SwingConstants.CENTER);
         frame.add(label1);
         JTextField textField = new JTextField(5);
         frame.add(textField);
         JButton button = new JButton("Click Me");
         frame.add(button);
        
        //jTextField1 = new javax.swing.JTextField();
        
      
    }
}
