/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test5;

/**
 *
 * @author Radit
 */
public class Printer {
   
    String merk;
    String warna;    
    int tahun;
    
    //CONSTRUCTOR 1
    public Printer() {
        merk = "Samsung ";
        warna = "Hitam";
        tahun = 2021;
    }
    
    //CONSTRUCTOR 2 (OVERLOADING)
    public Printer (String merk, String warna){
        this.merk = merk;
        this.warna = warna;
    }
    
    //METHOD 1
    public void tampilkanInfoPrinter() {
        System.out.println("Merk printer ini adalah: " + merk + "dan printer ini memiliki warna: " + warna);
    }
    
    //METHOD 2 (OVERLOADING)
    public void tampilkanInfoPrinter(int tahun) {
        System.out.println("Printer ini bermerk " + merk + "dan berwarna " + warna + "lalu di rilis "
        + "pada tahun " + tahun);
    } 
}

