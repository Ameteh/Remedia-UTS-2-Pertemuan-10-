package com.example;

public class DataPadel {
    private int id;
    private String name;
    private int nohp;
    private String tanggal;
    private String jamMulai;
    private String jamSelesai;
    private String lapanganOptions;

    public DataPadel(int id, String name, int nohp, String tanggal, String jamMulai, String jamSelesai, String lapanganOptions) {
        this.id = id;
        this.name = name;
        this.nohp = nohp;
        this.tanggal = tanggal;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.lapanganOptions = lapanganOptions;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoHP() {
        return nohp;
    }

    public void setNoHP(int nohp) {
        this.nohp = nohp;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public String getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(String jamSelesai) {
        this.jamSelesai = jamSelesai;
    }

    public String getLapangan() {
        return lapanganOptions;
    }

    public void setLapangan(String lapanganOptions) {
        this.lapanganOptions = lapanganOptions;
    }
}