/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.latihanpraktikum7;

/**
 *
 * @author ASUS
 */
public class LatihanPraktikum7 {

    public static void main(String[] args) {

        Player p1 = new Player("Farah", 100, 30);
        Goblin e1 = new Goblin("Goblin Kecil", 90, 15);
        
        System.out.println("Selamat datang di Dunia Ajaib!\n");

        System.out.println(p1.getNama() + " bertemu dengan " + e1.getNama() + "!");
        System.out.println(p1.getNama() + " HP: " + p1.getHp());
        System.out.println(e1.getNama() + " HP: " + e1.getHp() + "\n");

        System.out.println("----- Ronde 1 -----");
        p1.serang(e1);
        System.out.println(p1.getNama() + " HP: " + p1.getHp());
        System.out.println(e1.getNama() + " HP: " + e1.getHp() + "\n");

        System.out.println("----- Ronde 2 -----");
        e1.serang(p1);
        System.out.println(p1.getNama() + " HP: " + p1.getHp());
        System.out.println(e1.getNama() + " HP: " + e1.getHp() + "\n");

        System.out.println("----- Ronde 3 -----");
        p1.serang(e1);
        System.out.println(p1.getNama() + " HP: " + p1.getHp());
        System.out.println(e1.getNama() + " HP: " + e1.getHp() + "\n");  

        System.out.println("Pertarungan Selesai!");
        System.out.println(p1.getNama() + " HP: " + p1.getHp());
        System.out.println(e1.getNama() + " HP: " + e1.getHp());
        
        e1.teriak();

        if (e1.getHp() <= 0) {
            System.out.println("\n" + p1.getNama() + " menang! "+ e1.getNama() +" telah dikalahkan.");
        }
        else {
            System.out.println("\n" + e1.getNama() + " masih belum dikalahkan.");
        }
    }
}
