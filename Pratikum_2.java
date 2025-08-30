/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pratikum_2;
/**
 *
 * @author Muhammad Faiz Al Khairi
 */
public class Pratikum_2 {

    public static void main(String[] args) {

      /**
       * inisialisasi Nama
       * inisialisasi NIM
       * inisialisasi IP Semester di dalam aray
       * inisialisasi Alamat
       * inisialisasi Umur
       * inisialisasi Golongan Darah
       * Konversi nilai ipSemester dari type double ke byte
       * Menampilkan Data" yang sudah diinisialisasikan
       */
      
      String nama = "Muhammad Faiz Al Khairi"; 
      String nim = "2407134861";
      double[] ipSemester = {3.7 , 3.8 , 3.9};
      String alamat = "Jln Cipta Karya, gang Kuindra";
      final int UMUR = 20;
      final String DARAH = "A";
      byte byteIp = (byte)ipSemester[1] ; 
      
      System.out.println("Perkenalkan Nama saya " + nama);
      System.out.println("umur saya " + UMUR);
      System.out.println("Saya tinggal di " + alamat);
      System.out.println("golongan darah saya " + DARAH);
      System.out.println("Lalu NIM saya " + nim);
      for(int i=0;i<ipSemester.length;++i){
         System.out.println("Ip Semester " + (i+1) + " adalah " + ipSemester[i]);
      }
      System.out.println("dan nilai IP Semester saya dalam bentuk integer " + byteIp);
      
    }
}
