package com.mycompany.cutepie;

public class Produk {
    public String nama;
    private int harga;
    protected int stok;
    private final String namaSupplier = "Chris";
    
    //static variable
    static int jumlahProduk = 0;
    
    public Produk(String nama, int harga, int stok){
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        jumlahProduk++;
    }
    
    public static void infoJumlahProduk(){
        System.out.println("Jumlah produk yang dibuat adalah " + jumlahProduk);
    }
    
    private void namaSupplier(){
    System.out.println("Nama Supplier : " + namaSupplier);
    }
    
    public void tampilkanInfo(){
    System.out.println("Nama : " + nama);
    System.out.println("Harga : " + harga);
    System.out.println("Stok : " + stok);
    }
    
//    private void namaSupplier(){
//        stok = stok +=10;
//    System.out.println("Nama Supplier : " + namaSupplier);
//    }
    
    public void namaSupplierFix(){
        namaSupplier();
    }
    public int getHarga(){
        return harga;
    }
    public void setHarga(int hargaBaru){
        if (hargaBaru>0){
            this.harga = hargaBaru;
        }
        else if (hargaBaru == 0){
            this.harga = hargaBaru;
            System.out.println("Produk ini gratis");
        }
        else {
            System.out.println("Harga produk tidak boleh negatif");
        }
    }
    
    
    }

