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
    // atribut dengan tingkat akses berbeda
    public String nama;               // bisa diakses dari mana saja
    private double harga;             // hanya bisa diakses di dalam class Produk
    protected int stok;               // bisa diakses di class ini + subclass + package yang sama
    private final String namaSupplier = "Radit"; // final = tidak bisa diubah nilainya

    // static variable -> milik class, bukan objek
    static int jumlahProduk = 0;

    // Constructor -> dipanggil saat membuat objek baru
    public Produk(String nama, int harga, int stok) {
        this.nama = nama;   // keyword "this" mengacu pada atribut class
        this.harga = harga;
        this.stok = stok;
        jumlahProduk++;     // setiap kali objek dibuat, jumlahProduk bertambah
    }

    // method static -> bisa dipanggil tanpa bikin objek
    public static void infoJumlahProduk() {
        System.out.println("Jumlah produk yang dibuat adalah " + jumlahProduk);
    }

    // method private -> hanya bisa dipanggil di dalam class ini
    private void namaSupplier() {
        System.out.println("Nama Supplier : " + namaSupplier);
    }

    // method public untuk menampilkan semua info produk
    public void tampilkanInfo() {
        System.out.println("Nama : " + nama);
        System.out.println("Harga : " + harga);
        System.out.println("Stok : " + stok);
    }

    // method public yang memanggil method private (namaSupplier)
    public void namaSupplierFix() {
        namaSupplier(); // memanggil method private agar bisa diakses dari luar lewat method ini
    }

    // getter untuk harga -> ambil nilai harga (karena harga private)
    public double getHarga() {
        return this.harga;
    }

    // setter untuk harga -> atur harga baru dengan validasi
    public void setHarga(double hargaBaru) {
        if (hargaBaru > 0) {                  // jika lebih dari 0 -> harga diubah
            this.harga = hargaBaru;
        } else if (hargaBaru == 0) {          // jika sama dengan 0 -> produk gratis
            this.harga = hargaBaru;
            System.out.println("Produk ini gratis");
        } else {                              // jika negatif -> tidak boleh
            System.out.println("Harga produk tidak boleh negatif");
        }
    }

}
