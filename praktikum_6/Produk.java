/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum_6;

/**
 *
 * @author RADIT
 */
public class Produk {
    public String nama;
    private double harga;
    protected int stok;
    private final String namaSupplier = "Radit";

    //static variable
    static int jumlahProduk = 0;

    public Produk(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        jumlahProduk++;
    }

    public static void infoJumlahProduk() {
        System.out.println("Jumlah produk yang dibuat adalah " + jumlahProduk);
    }

    private void namaSupplier() {
        System.out.println("Nama Supplier : " + namaSupplier);
    }

    public void tampilkanInfo() {
        System.out.println("Nama : " + nama);
        System.out.println("Harga : " + harga);
        System.out.println("Stok : " + stok);
    }

    public void namaSupplierFix() {
        namaSupplier();
    }

    public double getHarga() {
        return this.harga;
    }

    public void setHarga(double hargaBaru) {
        if (hargaBaru > 0) {
            this.harga = hargaBaru;
        } else if (hargaBaru == 0) {
            this.harga = hargaBaru;
            System.out.println("Produk ini gratis");
        } else {
            System.out.println("Harga produk tidak boleh negatif");
        }
    }

}
