package com.mycompany.latihanpraktikum7;

public class Enemy {

    private String nama;
    private int hp;
    private int baseDamage;

    public Enemy(String nama, int hp, int baseDamage) {
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

    public void serang(Player player) {
        System.out.println(nama + " menyerang " + player.getNama() + " dengan damage " + baseDamage);
        int hpSekarang = player.getHp() - baseDamage;
        player.setHp(hpSekarang);
    }
}

class Goblin extends Enemy {

    public Goblin(String nama, int hp, int baseDamage) {
        super(nama, hp, baseDamage);
    }

    @Override
    public void serang(Player player) {
        double peluang = Math.random();

        if (peluang <= 0.05) {
            int damageSpecial = getBaseDamage() * 2;
            System.out.println(getNama() + " melakukan SERANGAN SPESIAL! Damage double: " + damageSpecial);
            int hpSekarang = player.getHp() - damageSpecial;
            player.setHp(hpSekarang);
        } else {
            System.out.println(getNama() + " menyerang " + player.getNama() + " dengan damage " + getBaseDamage());
            int hpSekarang = player.getHp() - getBaseDamage();
            player.setHp(hpSekarang);
        }
    }
    
        public void teriak(){
        System.out.println(getNama() + " berteriak: GRRRR!!!");
    }
}
