/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.latihanpraktikum02;

/**
 *
 * @author Radit
 */
public class LatihanPraktikum02 {

    public static void main(String[] args) {
        
        // Menginisialisasi variabel
        String nama = "Raditya Yhori Pratama", alamat = "Jalan Taman Karya";
        long nim = 2407110797L;
        final String GOLONGAN_DARAH = "O";
        int umur = 19;
        byte umurDiperkecil = (byte) umur;
        
        double[] ipSetiapSemester = {3.7, 3.8, 4.0};
        
        
        // Menampilkan biodata
        System.out.println("Nama : " + nama);
        System.out.println("NIM : " + nim);
        System.out.println("IP Semester 1 : " + ipSetiapSemester[0]);
        System.out.println("IP Semester 2 : " + ipSetiapSemester[1]);
        System.out.println("IP Semester 3 : " + ipSetiapSemester[2]);
        System.out.println("Alamat : " + alamat);
        System.out.println("Umur : " + umurDiperkecil);
        System.out.println("Golongan Darah : " + GOLONGAN_DARAH);
    }
}
