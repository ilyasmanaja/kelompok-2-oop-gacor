/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.praktikum_6;

/**
 *
 * @author RADIT
 */
public class Praktikum_6 {

    public static void main(String[] args) {
        
        // Membuat objek produk pertama (p1) dengan nama Laptop, harga 7 juta, stok 15
        Produk p1 = new Produk("Laptop", 7000000, 15);
        
        // Membuat objek produk kedua (p2) dengan nama Handphone, harga 1,5 juta, stok 10
        Produk p2 = new Produk("Handphone", 1500000, 10);

        // Menampilkan informasi produk p1 (nama, harga, stok)
        p1.tampilkanInfo();
        
        // Menampilkan jumlah produk yang sudah dibuat (static variable)
        Produk.infoJumlahProduk();
        
        // Menampilkan nama supplier lewat method public yang memanggil method private
        p1.namaSupplierFix();
        
        // Mengambil nilai harga p1 lewat getter (karena atribut harga bersifat private)
        System.out.println("Harga melalui method getter: " + p1.getHarga());
        
        // Mengubah harga p1 menggunakan setter (akan divalidasi dulu)
        p1.setHarga(5000000);
        
        // Menampilkan harga setelah diubah melalui setter
        System.out.println("Harga setelah diubah menggunakan method setter: " + p1.getHarga());
        
    }
}
