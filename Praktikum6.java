package com.mycompany.cutepie;
import java.util.Scanner;

public class Praktikum6 {

    public static void main(String[] args) {
        
        Produk p1 = new Produk("Laptop", 7000000, 15);
        Produk p2 = new Produk("Handphone", 1500000, 10);
        
        System.out.println(p1.nama);
        System.out.println(p1.stok);
//      System.out.println(p1.harga);

        p1.namaSupplierFix();
        p1.tampilkanInfo();
        p2.tampilkanInfo();
        
        Produk.infoJumlahProduk();
        
        System.out.println("Harga : " + p1.getHarga());
        
        p1.setHarga(5000000);
        System.out.println("Harga baru produk 1 : " + p1.getHarga());
        
        }
    }

