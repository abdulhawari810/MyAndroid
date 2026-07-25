package com.programmerid.myandroid.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.programmerid.myandroid.data.model.Aktivitas;
import java.util.List;

@Dao
public interface AktivitasDao {
    @Insert
    void insert(Aktivitas aktivitas);

    @Query("SELECT * FROM aktivitas WHERE tanggal = :tanggal ORDER BY id DESC")
    LiveData<List<Aktivitas>> getAktivitasByTanggal(String tanggal);

    @Update
    void update(Aktivitas aktivitas);

    @Delete
    void delete(Aktivitas aktivitas);
}