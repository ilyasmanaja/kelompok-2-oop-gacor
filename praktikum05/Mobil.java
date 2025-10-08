/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum05;

/**
 *
 * @author ASUS
 */
public class Mobil {
    
    // Attributes
    String merk;
    String warna;
    int tahunKeluar;
        
    // Constructor
    public Mobil() {
        this.merk = "Unknown";
        this.warna = "Putih";
        this.tahunKeluar = 2010;
    }

    public Mobil(String merk, String warna, int tahunKeluar) {
        this.merk = merk;
        this.warna = warna;
        this.tahunKeluar = tahunKeluar;
    }
    
    // Method
    public void panaskanMobil() {
        System.out.println("Mobil sedang dipanaskan");   
    }
}





