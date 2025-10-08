package com.mycompany.praktikum7;

public class Produk implements HargaAkhir {

    protected String nama;
    protected int harga;

    public Produk(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;

    }

    public void tampilkanInfo() {
        System.out.println("Nama produk : " + nama);
        System.out.println("Harga produk : " + harga);
    }

    public double hitungPajak() {
        return harga * 0.05;
    }

    @Override
    public double hitungHarga() {
        return harga * 1.10;
    }

}

class BarangElektronik extends Produk implements HargaAkhir {

    private int garansi;

    public BarangElektronik(String nama, int harga, int garansi) {
        super(nama, harga);
        this.garansi = garansi;
    }
    
    public void tampilkanGaransi(){
        System.out.println("Garansi :" + garansi + " bulan");
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Nama produk : " + nama);
        System.out.println("Harga produk : " + harga);
        System.out.println("Garansi : " + garansi);
    }

    @Override
    public double hitungPajak() {
        return harga * 0.01;
    }

    @Override
    public double hitungHarga() {
        return harga * 1.05;
    }

}
