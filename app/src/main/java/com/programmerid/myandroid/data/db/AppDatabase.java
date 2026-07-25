package com.programmerid.myandroid.data.db;

import android.content.Context;
import androidx.room.*;

import com.programmerid.myandroid.data.model.*;

@Database(entities = {Transaksi.class, Aktivitas.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract TransaksiDao transaksiDao();
    public abstract AktivitasDao aktivitasDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "duit_aktivitas_db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}