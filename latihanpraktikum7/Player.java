/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.latihanpraktikum7;

/**
 *
 * @author ASUS
 */
public class Player {

    private String nama;
    private int hp;
    private int baseDamage;

    public Player(String nama, int hp, int baseDamage) {
        this.nama = nama;
        this.hp = hp;
        this.baseDamage = baseDamage;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void serang(Enemy enemy) {
        double peluang = Math.random();

        if (peluang <= 0.05) {
            int damageSpecial = getBaseDamage() * 2;
            System.out.println(getNama() + " melakukan SERANGAN SPESIAL! Damage double: " + damageSpecial);
            int hpSekarang = enemy.getHp() - damageSpecial;
            enemy.setHp(hpSekarang);
        } else {
            System.out.println(getNama() + " menyerang " + enemy.getNama() + " dengan damage " + getBaseDamage());
            int hpSekarang = enemy.getHp() - getBaseDamage();
            enemy.setHp(hpSekarang);
        }
    }
}
