package com.example.akmal_pc.jhotel_android_akmal;

public class Hotel
{
    private int id;
    private Lokasi lokasi;
    private String nama;
    private int bintang;

    public Hotel(int id, String nama, Lokasi lokasi, int bintang)
    {
        this.id = id;
        this.nama = nama;
        this.lokasi = lokasi;
        this.bintang = bintang;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }

    public void setBintang(int bintang) {
        this.bintang = bintang;
    }

    public String getNama() {
        return nama;
    }

    public int getBintang() {
        return bintang;
    }

    public int getId() {
        return id;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }
}
