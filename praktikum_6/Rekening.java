/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum_6;

/**
 *
 * @author RADIT
 */
public class Rekening {
    private String nomorRekening;
    private int saldo;
    
    public Rekening(String nomorRekening, int saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
    }
    
    public String getNomorRekening() {
        return this.nomorRekening;
    }
    
    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }
    
    public int getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(int saldo) {
        if (saldo >= 0 ) {
            this.saldo = saldo;
        } else {
            System.out.println("saldo tidak boleh negatif");
        }
        
    }
}
