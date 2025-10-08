/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum_6;

/**
 *
 * @author RADIT
 */
public class Tugaspraktikum_6 {
    public static void main(String[] args) {
        
        Rekening rekeningRadit = new Rekening("12345678", 50000);
        Bank bank = new Bank("Bank Radit 123");
        
        System.out.println("Bank static: " + Bank.namaBank);
        System.out.println("nomor rekening: " + rekeningRadit.getNomorRekening());
        rekeningRadit.setNomorRekening("987654322");
        System.out.println("nomor rekening baru: " + rekeningRadit.getNomorRekening());
        System.out.println("Saldo rekening: " + rekeningRadit.getSaldo());
        rekeningRadit.setSaldo(10000);
        System.out.println("saldo baru: " + rekeningRadit.getSaldo());
        System.out.println("Nama bank: " + bank.getCabang());
        bank.setCabang("Radit 321 baru");
        System.out.println("Nama bank baru: " + bank.getCabang());
        
    }
    
}
    

