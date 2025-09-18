/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.test5;

/**
 *
 * @author Radit
 */
public class Latihanprak5 {

    public static void main(String[] args) {
        
        Printer printer1 = new Printer();
        System.out.println("Objek printer 1: ");
        printer1.tampilkanInfoPrinter();
        System.out.println("------------------------------------------------------------");

        Printer printer2 = new Printer("Epson ", "Hitam");
        System.out.println("Objek printer 2: ");
        printer2.tampilkanInfoPrinter();
        System.out.println("------------------------------------------------------------");

        Printer printer3 = new Printer("Canon ", "Hitam ");
        System.out.println("Objek printer 3: ");
        printer3.tampilkanInfoPrinter(2021);
        System.out.println("------------------------------------------------------------");
        
    }
}
