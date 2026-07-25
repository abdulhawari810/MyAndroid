package com.programmerid.myandroid.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.programmerid.myandroid.data.model.Transaksi;
import java.util.List;

@Dao
public interface TransaksiDao {
    @Insert
    void insert(Transaksi transaksi);

  @Query("SELECT * FROM transaksi ORDER BY id DESC LIMIT 10")
LiveData<List<Transaksi>> getAllTransaksi();

    @Query("SELECT SUM(jumlah) FROM transaksi WHERE jenis = 'Pemasukan'")
    LiveData<Double> getTotalPemasukan();

    @Query("SELECT SUM(jumlah) FROM transaksi WHERE jenis = 'Pengeluaran'")
    LiveData<Double> getTotalPengeluaran();

    @Delete
    void delete(Transaksi transaksi);
}