/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Latihan3;

import java.util.Scanner;

/**
 *
 * @author Radit
 */
public class Latihan3 {

    public static void main(String[] args) {
        final double PI = 3.14;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Kalkulator Tabung");
        
        System.out.print("Masukkan Jari-jari: ");
        int jari = scanner.nextInt();
        
        System.out.print("Masukkan Tinggi: ");
        int tinggi = scanner.nextInt();
        
        double volumeTabung = PI * jari * jari * tinggi;
        System.out.println("Hasil Volume Tabung adalah: " + volumeTabung + " cm^3");
    }
}
