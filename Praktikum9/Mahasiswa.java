package com.mycompany.praktikum9;

import java.util.ArrayList;

public class Mahasiswa {
        private String nama;
        private String nim;
        private String prodi;
        private String jenisKelamin;
        private boolean active;

        public static ArrayList<Mahasiswa> mahasiswas = new ArrayList<>();

        public Mahasiswa(String nama, String nim, String prodi, String jenisKelamin, boolean active) {
            this.nama = nama;
            this.nim = nim;
            this.prodi = prodi;
            this.jenisKelamin = jenisKelamin;
            this.active = active;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getNim() {
            return nim;
        }

        public void setNim(String nim) {
            this.nim = nim;
        }

        public String getProdi() {
            return prodi;
        }

        public void setProdi(String prodi) {
            this.prodi = prodi;
        }

        public String getJenisKelamin() {
            return jenisKelamin;
        }

        public void setJenisKelamin(String jenisKelamin) {
            this.jenisKelamin = jenisKelamin;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public static ArrayList<Mahasiswa> getMahasiswa() {
            return mahasiswas;
        }

        public static void setMahasiswa(ArrayList<Mahasiswa> mahasiswa) {
            Mahasiswa.mahasiswas = mahasiswa;
        }

    }
