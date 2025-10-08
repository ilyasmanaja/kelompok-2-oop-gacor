/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum_6;

/**
 *
 * @author RADIT
 */
public class Bank {
    public static String namaBank = "Bank BCA"; 
    private String cabang;
    
    public Bank(String cabang){
        this.cabang = cabang;
    }
    
    public String getCabang() {
       return this.cabang; 
    }
    
    public void setCabang(String cabang){
        this.cabang = cabang;
    }
}