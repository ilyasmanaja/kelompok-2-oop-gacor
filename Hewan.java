package com.mycompany.prtk1;

abstract public class Hewan {
    String nama;
    
    Hewan(String nama) {
        this.nama = nama;
    }
    
    abstract void suara();
    
    void info() {
        System.out.println("Nama hewan : " + this.nama);
    }
}
