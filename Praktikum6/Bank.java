package com.mycompany.tugas;

public class Bank {

    public static String namaBank = "Bank BCA";
    private String cabang;

    public Bank(String cabang) {
        this.cabang = cabang;
    }

    public String getCabang() {
        return this.cabang;
    }

    public void setCabang(String cabang) {
        this.cabang = cabang;
    }
}
