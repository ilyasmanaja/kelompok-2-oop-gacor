/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.latihanpraktikum5;

/**
 *
 * @author muham
 */
public class LatihanPraktikum5 {

    public static void main(String[] args) {
        
        //
        Anime anime1 = new Anime();
        System.out.println("Anime 1 : ");
        anime1.tampilkanInfoAnime();
        System.out.println("---------------------------------------");
        
        Anime anime2 = new Anime("Tenki no ko", "CoMix Wave Films", "Romance Fantasy");
        System.out.println("Anime 2 : ");
        anime2.tampilkanInfoAnime();
        System.out.println("---------------------------------------");
        
        Anime anime3 = new Anime("Naruto", "Pierrot", "Adventure");
        System.out.println("Anime 3 : ");
        anime3.tampilkanInfoAnime(2002, 8.4);
        System.out.println("---------------------------------------");
 }
}