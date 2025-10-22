/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.praktikum7;

/**
 *
 * @author ASUS
 */
public class Praktikum7 {
    
    public static void main(String[] args) {
       Product p1 = new Product("Buku", 150000);
       BarangElektronik p2 = new BarangElektronik("Mouse", 150000, 12);
       
       p1.tampilkanInfo();
       System.out.println("Pajak Produk Umum : " + p1.hitungPajak());
       System.out.println("---------------------------------");
       p2.tampilkanInfo();
       p2.tampilkanGaransi();
       System.out.println("Pajak Barang Elektronik : " + p2.hitungPajak()); 
       System.out.println("Harga Akhir produk : " + p2.hitungHarga()); 
    }
}

