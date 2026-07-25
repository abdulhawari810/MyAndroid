package com.programmerid.myandroid.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "aktivitas")
public class Aktivitas {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String namaAktivitas;
    private String tanggal; // "2026-07-25"
    private int durasiMenit;
    private boolean selesai;

    public Aktivitas(String namaAktivitas, String tanggal, int durasiMenit, boolean selesai) {
        this.namaAktivitas = namaAktivitas;
        this.tanggal = tanggal;
        this.durasiMenit = durasiMenit;
        this.selesai = selesai;
    }

    // Getter Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNamaAktivitas() { return namaAktivitas; }
    public String getTanggal() { return tanggal; }
    public int getDurasiMenit() { return durasiMenit; }
    public boolean isSelesai() { return selesai; }
    public void setSelesai(boolean selesai) { this.selesai = selesai; }
}