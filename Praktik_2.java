package com.mycompany.Praktik_2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Muhammad Faiz Al Khairi
 */
public class Praktik_2 {
   public static void main(String[] args) {
       //System di bawah ini sebagai perintah menampilkan Hallo World!
       System.out.println("Hallo World!");
       /* 
       *Inisialisasi Variable
       *Menampilkan Nama dan Menampilkan Umur
       */
       String nama;
       nama = "Muhammad Faiz Al Khairi";
       
       int umur;
       umur = 20;
       //perintah menampilkan nama dan umur
       System.out.println("Perkenalkan Nama saya " + nama);
       System.out.println("lalu Umur saya " + umur);
       
       //Deklarasi Multiple variables
       int x = 1 , y = 2, z = 3;
       System.out.println(x + " " + y + " " + z);

       //Penggunaan array untuk menampilkan IP
       double[] ipSemester = {3.5, 3.6, 3.7, 3.8, 3.9};
       System.out.println("IP Semester 2 saya adalah " + ipSemester[1]);
       
       //Konversi nilai type double ke int
       int inSemester = (int) ipSemester [0];
       System.out.println("IP Semester 1 saya adalah " + inSemester);//output 3
       
       //Konversi nilai dari long ke integer
       long nilaiSangatBesar = 3000000000L;
       int intNilaiSangatBesar = (int)nilaiSangatBesar;
       System.out.println("Nilai long sebelum dikonversi = " + nilaiSangatBesar);
       System.out.println("Nilai long sesudah dikonversi ke int = " + intNilaiSangatBesar);
       
       // Nilai yang sudah dideklarasikan dengan final tidak dapat dirubah
       final double PI = 3.14;
       System.out.println("Nilai final Pi adalah = " + PI);
   }
}

