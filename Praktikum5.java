/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.praktikum5;

/**
 *
 * @author muham
 */
public class Praktikum5 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Mobil mobilSaya = new Mobil("Toyota", "Merah", 2025);
        Mobil mobilKedua = new Mobil("Alpart", "Hitam", 2020);

        Mobil mobilKetiga = new Mobil();
        
        Kalkulator cal = new Kalkulator();
        System.out.println("1 + 10 = " + cal.tambah(1, 10) );
        System.out.println("2.4 + 10.6 = " + cal.tambah(2.4, 10.6) );
        
 //       Hewan kucing = new Hewan();
    }
}