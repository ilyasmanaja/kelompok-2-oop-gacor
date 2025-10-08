package com.mycompany.praktikum7;

public class Praktikum7 {

    public static void main(String[] args) {
        Produk p1 = new Produk("Buku", 150000);
        Produk p2 = new BarangElektronik("Mouse", 150000, 12);

        p1.tampilkanInfo();
        System.out.print("Pajak produk biasa " + p1.hitungPajak());
        System.out.println("-----------------------");
        p2.tampilkanInfo();
//        p2.tampilkanGaransi();
        System.out.print("Pajak produk Elektronik " + p2.hitungPajak());
        System.out.println("-----------------------");

    }

}
