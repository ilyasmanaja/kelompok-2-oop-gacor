/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.praktikum_3;

import java.util.Scanner;

/**
 *
 * @author muham
 */
public class Praktikum_3 {

    public static void main(String[] args) {
        int a = 10, b = 2;
        
        
        // Operator Aritmatika
        System.out.println("Tambah (+) : " + (a + b));
        System.out.println("Kurang (-) : " + (a - b));
        System.out.println("Kali (*) : " + (a * b));
        System.out.println("Bagi (/) : " + (a / b));
        System.out.println("Modulus (%) : " + (a % b));
        
        // Operator Perbandingan
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));
        System.out.println("a > b : " + (a > b));
        System.out.println("a < b : " + (a < b));
        System.out.println("a >= b : " + (a >= b));
        System.out.println("a <= b : " + (a <= b));
        
        // Operator Logika
        boolean x = true, y = false;
        System.out.println("x && y : " + (x && y));
        System.out.println("x || y : " + (x || y));
        System.out.println("!x : " + (!x));
        
        // Operator Assignment
        int i = 10;
        i+= 2;
        System.out.println("i += 2 : " + (i));
        
        // Operator Ternary
        int nilai = 40;
        char grade = (nilai >= 80) ? 'A' : (nilai >= 75) ? 'B' : (nilai >= 60) ? 'C' : 'D';
        System.out.println("Grade : " + grade);
        
        // Output printf
        String nama = "Khairi";
        int umur = 20;
        double tinggi = 175.5f;
        
        System.out.printf("Halo saya %s, umur %d, tinggi %.1f cm", nama, umur, tinggi);
        System.out.println();
        
        // Input Scanner
        Scanner scanner = new Scanner(System.in);
        
        // User Input
        System.out.print("Masukkan NIM anda: ");
        String nim = scanner.nextLine();
        System.out.println("NIM anda adalah : " + nim);
        
        try {
            System.out.print("Masukkan umur : ");
            int umurUser = scanner.nextInt();
       
            System.out.println("Umur anda adalah : " + umurUser);
        }
        catch (Exception e) {
            System.out.println("Anda salah input");
        }
        
        // Wrapper Class
        String strUmur= "20";
        
        int intUmur = Integer.parseInt(strUmur);
        System.out.println("strUmur yang telah dikonversi adalah : " + intUmur);
        
        int value = 235;
        String strValue = Integer.toString(value);
        System.out.println(strValue);
        
        enum Hari {
            SENIN, SELASA, RABU, KAMIS, JUMAT, SABTU, MINGGU
        }
        
        Hari hariIni = Hari.RABU;
        
        if (hariIni == Hari.RABU){
            System.out.println("Hari ini adalah hari RABU");
            System.out.println("Dan besok adalah hari " + Hari.KAMIS);
        }
    }
}

