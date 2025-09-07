/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.praktikum3;

import java.util.Scanner;
/**
 *
 * @author Raihan
 */
public class LatihanPraktikum3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final char PI = 76;
        System.out.println(PI);
        Scanner mobil = new Scanner(System.in);
        System.out.println("Kalkulator Tabung");
        
        System.out.print("Masukkan Jari Jari: ");
        int jari = mobil.nextInt();
        
        System.out.print("Masukkan Tinggi: ");
        int tinggi = mobil.nextInt();
        
        
        double tabung = PI*jari*jari*tinggi;
        System.out.println("Hasil Volume Kubus adalah: " + tabung + " cm^3");
    }
    
}
