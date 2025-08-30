package com.mycompany.pbopbo;

/**
 *
 * @author farah
 */
public class Latihan2 {

    public static void main(String[] args) {
// Mengisi data mahasiswa
        String nama = "Tengku Farah Nabila Syah";
        String nim = "2407113705";
        String alamat = "Jl Baraq";
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
