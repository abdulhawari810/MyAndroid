package com.programmerid.myandroid.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transaksi")
public class Transaksi {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String jenis; // "Pemasukan" atau "Pengeluaran"
    private String kategori; // "Makan", "Gaji", "Transport"
    private double jumlah;
    private String tanggal; // "2026-07-25"
    private String catatan;

    // Constructor
    public Transaksi(String jenis, String kategori, double jumlah, String tanggal, String catatan) {
        this.jenis = jenis;
        this.kategori = kategori;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
        this.catatan = catatan;
    }

    // Getter Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getJenis() { return jenis; }
    public String getKategori() { return kategori; }
    public double getJumlah() { return jumlah; }
    public String getTanggal() { return tanggal; }
    public String getCatatan() { return catatan; }
}