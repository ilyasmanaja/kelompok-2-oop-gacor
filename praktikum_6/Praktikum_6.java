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

        Produk p1 = new Produk("Laptop", 7000000, 15);
        Produk p2 = new Produk("Handphone", 1500000, 10);

        p1.tampilkanInfo();
        Produk.infoJumlahProduk();
        p1.namaSupplierFix();
        System.out.println("Harga melalui method getter: " + p1.getHarga());
        p1.setHarga(5000000);
        System.out.println("Harga melalui setelah diubah menggunakan method setter: " + p1.getHarga());
        
    }
}

