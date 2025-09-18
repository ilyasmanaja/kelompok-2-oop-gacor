/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum05;

/**
 *
 * @author radit
 */
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
