package com.mycompany.prtk1;

public class Mobil {
    String merk;
    String warna;
    int tahunKeluar;
    
    public Mobil() {
        this.merk = "Unknown";
        this.warna = "Putih";
        this.tahunKeluar = 2020;
    }
    
    public Mobil(String merk, String warna, int tahunKeluar) {
        this.merk = merk;
        this.warna = warna;
        this.tahunKeluar = tahunKeluar;
    }
 
    public void panaskanMobil(){
        System.out.println("Mobil sedang dipanaskan");
    }
    
}