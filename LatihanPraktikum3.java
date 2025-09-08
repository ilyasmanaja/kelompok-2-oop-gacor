/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.latihanpraktikum3;

/**
 *
 * @author Faiz
 */

import java.util.Scanner;

public class LatihanPraktikum3 {

    public static void main(String[] args) {
        final double PI = 3.14;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kalkulator Tabung");
        
        System.out.print("Masukkan Jari Jari: ");
        int jari = scanner.nextInt();
        
        System.out.print("Masukkan Tinggi: ");
        int tinggi = scanner.nextInt();
        
        
        double tabung = PI*jari*jari*tinggi;
        System.out.println("Hasil Volume Kubus adalah: " + tabung + " cm^3");
        
    }
}