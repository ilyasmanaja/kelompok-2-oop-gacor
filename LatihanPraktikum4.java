package com.mycompany.latihanpraktikum4;

import java.util.Scanner; // penting agar Scanner bisa digunakan

public class LatihanPraktikum4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        char kembali;

        do {
            System.out.println("\nCalculator Bangun Datar");
            System.out.println("1. Luas Persegi");
            System.out.println("2. Luas Lingkaran");
            System.out.println("3. Luas Segitiga");
            System.out.println("4. Luas Persegi Panjang");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("Menghitung luas Persegi");
                    System.out.print("Masukkan sisi: ");
                    int sisi = scanner.nextInt();
                    int luasPersegi = sisi * sisi;
                    System.out.println("Luas persegi adalah " + luasPersegi + " cm²");
                    break;
                case 2:
                    final double PI = 3.14;
                    System.out.println("Menghitung luas Lingkaran");
                    System.out.print("Masukkan jari-jari: ");
                    int jari = scanner.nextInt();
                    double luasLingkaran = PI * jari * jari;
                    System.out.println("Luas lingkaran adalah " + luasLingkaran + " cm²");
                    break;
                case 3:
                    System.out.println("Menghitung luas Segitiga");
                    System.out.print("Masukkan alas: ");
                    int alas = scanner.nextInt();
                    System.out.print("Masukkan tinggi: ");
                    int tinggi = scanner.nextInt();
                    double luasSegitiga = 0.5 * alas * tinggi;
                    System.out.println("Luas segitiga adalah " + luasSegitiga + " cm²");
                    break;
                case 4:
                    System.out.println("Menghitung luas Persegi Panjang");
                    System.out.print("Masukkan panjang: ");
                    int panjang = scanner.nextInt();
                    System.out.print("Masukkan lebar: ");
                    int lebar = scanner.nextInt();
                    int luasPersegiPanjang = panjang * lebar;
                    System.out.println("Luas persegi panjang adalah " + luasPersegiPanjang + " cm²");
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan kalkulator ini. Sampai jumpa!");
                    scanner.close();
                    return; // Mengakhiri program
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }

            // Meminta konfirmasi untuk kembali ke menu
            System.out.print("Apakah ingin melakukan perhitungan lagi? (y/n): ");
            kembali = scanner.next().charAt(0);
        } while (kembali == 'y' || kembali == 'Y');
    }
}
