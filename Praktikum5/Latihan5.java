package com.mycompany.prtk1;

public class Latihan5 {
    public static void main(String[] args) {
        Film film1 = new Film();
        System.out.println("Objek film 1: ");
        film1.tampilkanInfoFilm();
        System.out.println("------------------------------------------------------------");

        Film film2 = new Film("The Witch", "Horror");
        System.out.println("Objek film 2: ");
        film2.tampilkanInfoFilm();
        System.out.println("------------------------------------------------------------");

        Film film3 = new Film("La La Land", "Musical");
        System.out.println("Objek film 3: ");
        film3.tampilkanInfoFilm(2016);
        System.out.println("------------------------------------------------------------");
    }
}
