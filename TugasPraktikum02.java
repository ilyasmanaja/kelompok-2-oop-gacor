/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.praktikum02;

/**
 *
 * @author Raihan
 */
public class TugasPraktikum02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String nama = "Muhammad Raihan Ilyasman";
        String nim = "2407113326";
        String alamat = "Jl Kubang Raya"
                + "";
        final String GOLONGAN_DARAH = "B+";
        int umur = 19;
        
        double[] ipSemester = {3.6, 3.7, 3.8};
        byte ipSemesterKonversi = (byte) ipSemester[0];
        
        // Menampilkan umur
        System.out.println("Nama Saya: " + nama);
        System.out.println("Nim Saya: " + nim);
        System.out.println("Alamat Saya: " + alamat);
        System.out.println("Ip Semester 1 saya: " + ipSemester[0]);
        System.out.println("Ip Semester 2 saya: " + ipSemester[1]);
        System.out.println("Ip Semester 3 saya: " + ipSemester[2]);
        System.out.println("Umur saya: " + umur);
        System.out.println("Golongan darah saya: " + GOLONGAN_DARAH);
    }
    
}
