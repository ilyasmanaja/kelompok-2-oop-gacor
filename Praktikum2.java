package com.mycompany.pbopbo;

/**
 *
 * @author farah
 */
public class Praktikum2 {

    public static void main(String[] args) {
        /*
        *menampilkan nama
        */
       System.out.println("Farah");
       
       int umur;
       umur = 19;
       String nama = "Tengku Farah Nabila Syah";
       System.out.println("Nama Saya : " + nama);
       System.out.println("Umur : "+ umur);
       
       int x = 1, y = 3, z = 5;
       System.out.println(x + " " + y + " " + z);
       
       double[] ipSemester = {3.9, 3.7, 4.0, 4.0};
       System.out.println("IP Semester 3 saya adalah : " + ipSemester[3]);
       
       int intSemester1 = (int) ipSemester[0];
       System.out.println("Nilai ip Semester 1 integer : " + ipSemester[0]);
      
       long nilaiSangatBesar = 3000000000L;
       int intNilaiSangatBesar = (int) nilaiSangatBesar;
       System.out.println("Nilai long sebelum di konversi ke int : " + nilaiSangatBesar);
       System.out.println("Nilai long sesudah di konversi ke int : " + intNilaiSangatBesar);
        
        //Konstanta
        final double PI = 3.14;
        System.out.println(PI);
       
    }
}