/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.praktikum4;

import java.util.Scanner;

/**
 *
 * @author Radit
 */
public class Praktikum4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // if - else if - else
        System.out.print("Masukan nilai: ");
        int nilai = in.nextInt();

        if (nilai > 75){
            System.out.println("Anda lulus ujian");
        } else if (nilai > 65) {
            System.out.println("Nilai anda berada di ambang batas kelulusan");
        } else {
            System.out.println("Anda tidak lulus ujian");
        }

        System.out.println();

        // Switch case
        System.out.print("Masukan warna (R/G/B): ");
        String warna = in.next();

        switch (warna) {
            case "R":
                System.out.println("Warna merah");
                break;

            case "G":
                System.out.println("Warna hijau");
                break;

            case "B":
                System.out.println("Warna biru");
                break;

            default:
                System.out.println("Tidak ada warna yang dipilih");
                break;
        }

        System.out.println();

        // Nested if
        System.out.print("Masukan angka : ");
        int angka = in.nextInt();

        if (angka > 0) {
            System.out.print("Angka " + angka + " bernilai positif");
            if (angka % 2 == 0) {
                System.out.println(" dan genap");
            } else {
                System.out.println(" dan ganjil");
            }
        } else if (angka == 0) {
            System.out.println("Merupakan angka 0");
        } else {
            System.out.print("Angka " + angka + " bernilai negatif");
            if (angka % 2 == 0) {
                System.out.println(" dan genap");
            } else {
                System.out.println(" dan ganjil");
            }
        }   

        System.out.println();

        // For loop
        for (int i = 1;  i <= 3 ; i++) {
            System.out.println("For loop ke-" + i);
        }

        String[] nama= {"nama", "namaqd"};
        for (int j = 0; j < nama.length; j++) {
            System.out.println(nama[j]);
        }

        System.out.println();

        // While Loop
        int b = 1;
        while (b <= 3) {
            System.out.println("While loop ke-" + b);
            b++;
        }

        System.out.println();

        // Do While
        int c = 6;
        do {
            System.out.println("Do while loop ke-" + c);
            c++;
        } while (c <= 5);

        System.out.println();

        // Nested loop kursi
        char kursi = 'A';
        for (int j = 0; j < 3; j++) {
            for (int j2 = 1; j2 < 5; j2++) {
                System.out.print(kursi + "" + j2 + " ");
            }
            System.out.println();
            kursi++;
        }

        System.out.println();

        // Break
        for (int k = 1; k <= 10; k++) {
            if (k == 5) {
                System.out.println("Break di angka ke-" + k);
                break ;
            }
            System.out.println("Angka ke-" + k);
        }

        System.out.println();

        // Continue
        for (int h = 1; h <= 10; h++) {
            if (h % 2 == 0) {
                continue;
            }
            System.out.println("Bilangan ganjil " + h);
        }

        in.close(); // selalu tutup scanner
    }
}
