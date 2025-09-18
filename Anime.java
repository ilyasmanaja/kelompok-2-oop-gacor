/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.latihanpraktikum5;

/**
 *
 * @author muham
 */
public class Anime {
    String judul;
    String studio;
    String genre;
    double rating;
    int rilis;
    
   //Constructor 1
    public Anime (){
        this.judul = "Attack on Titan";
        this.studio = "Mappa and Wit";
        this.genre = "Action dan dark fantasy";
    }
    
    //Constuctor (overloaadiang)
    public Anime (String judul, String studio, String genre){
        this.judul=judul;
        this.studio=studio;
        this.genre=genre;
    }
    //Method 1
    public void tampilkanInfoAnime (){
        System.out.println("Judul Anime ini adalah " + judul + " yang digarap oleh studio "
                + studio + " dengan genre " + genre);
    }
    
    //Method 2 (Overloading)
    public void tampilkanInfoAnime (int rilis, double rating){
        System.out.println("Anime ini berjudul " + judul + " yang rilis pada tahun " + rilis +
                " diproduksi oleh studio " + studio + ", anime ini memiliki genre " + genre + " dengan rating " + rating);
    }
}
