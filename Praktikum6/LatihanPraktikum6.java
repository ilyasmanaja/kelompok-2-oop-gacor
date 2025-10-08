package com.mycompany.tugas;

public class LatihanPraktikum6 {

    public static void main(String[] args) {
        Rekening rek1 = new Rekening("24071176", 500000);
        Bank bank = new Bank("Bank Farah");

        System.out.println("Bank static: " + Bank.namaBank);
        System.out.println("nomor rekening: " + rek1.getNomorRekening());
        rek1.setNomorRekening("24071124");
        System.out.println("nomor rekening Baru: " + rek1.getNomorRekening());
        System.out.println("saldo rekening: " + rek1.getSaldo());
        rek1.setSaldo(10000);
        System.out.println("saldo baru: " + rek1.getSaldo());
        System.out.println("nama bank: " + bank.getCabang());
        bank.setCabang("Farah New");
        System.out.println("nama bank baru: " + bank.getCabang());
    }
}
