package com.mycompany.prtk1;

/**
 *
 * @author farahimuttttttt
 */

public class Praktikum5 {
    public static void main(String[] args) {
        
        Mobil mobilSaya = new Mobil("Toyota", "Merah", 2025);
        Mobil mobilKedua = new Mobil("Alphard", "Hitam", 2020);
        Mobil mobilKetiga = new Mobil();
        
        Kalkulator cal = new Kalkulator();
        System.out.println("1 + 10 = " + cal.tambah(1, 10));
        System.out.println("2.4 + 3.3 = " + cal.tambah(2.4, 3.3));
        
//      Hewan kucing = new Hewan;
    
    }
}
