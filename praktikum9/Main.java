/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum9;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args){
        mainJFrame_ frame = new mainJFrame_();
        frame.changeMainPanel (new TambahDataPanel());
        frame.setVisible(true);
    }
}