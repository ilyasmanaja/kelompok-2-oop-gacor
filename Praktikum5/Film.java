package com.mycompany.prtk1;

public class Film {
    String judul;
    String genre;
    int tahunRilis;

    //CONSTRUCTOR 1
    public Film() {
        judul = "Until Dawn";
        genre = "Horror";
        tahunRilis = 2025;
    }

    //CONSTRUCTOR 2 (OVERLOADING)
    public Film(String judul, String genre) {
        this.judul = judul;
        this.genre = genre;
    }

    //METHOD 1
    public void tampilkanInfoFilm() {
        System.out.println("Judul film ini adalah " + judul + " dan genre film ini adalah " + genre);
    }

    //METHOD 2 (OVERLOADING)
    public void tampilkanInfoFilm(int tahunRilis) {
        System.out.println("Film ini berjudul " + judul + " yang bergenre " + genre + " dan diterbitkan pada tahun " + tahunRilis);
    }
}
