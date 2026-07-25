package com.programmerid.myandroid.data.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile TransaksiDao _transaksiDao;

  private volatile AktivitasDao _aktivitasDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `transaksi` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `jenis` TEXT, `kategori` TEXT, `jumlah` REAL NOT NULL, `tanggal` TEXT, `catatan` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `aktivitas` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `namaAktivitas` TEXT, `tanggal` TEXT, `durasiMenit` INTEGER NOT NULL, `selesai` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'db51de8a8ce9035da5da35965735225f')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `transaksi`");
        db.execSQL("DROP TABLE IF EXISTS `aktivitas`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsTransaksi = new HashMap<String, TableInfo.Column>(6);
        _columnsTransaksi.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaksi.put("jenis", new TableInfo.Column("jenis", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaksi.put("kategori", new TableInfo.Column("kategori", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaksi.put("jumlah", new TableInfo.Column("jumlah", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaksi.put("tanggal", new TableInfo.Column("tanggal", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaksi.put("catatan", new TableInfo.Column("catatan", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTransaksi = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTransaksi = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTransaksi = new TableInfo("transaksi", _columnsTransaksi, _foreignKeysTransaksi, _indicesTransaksi);
        final TableInfo _existingTransaksi = TableInfo.read(db, "transaksi");
        if (!_infoTransaksi.equals(_existingTransaksi)) {
          return new RoomOpenHelper.ValidationResult(false, "transaksi(com.programmerid.myandroid.data.model.Transaksi).\n"
                  + " Expected:\n" + _infoTransaksi + "\n"
                  + " Found:\n" + _existingTransaksi);
        }
        final HashMap<String, TableInfo.Column> _columnsAktivitas = new HashMap<String, TableInfo.Column>(5);
        _columnsAktivitas.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAktivitas.put("namaAktivitas", new TableInfo.Column("namaAktivitas", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAktivitas.put("tanggal", new TableInfo.Column("tanggal", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAktivitas.put("durasiMenit", new TableInfo.Column("durasiMenit", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAktivitas.put("selesai", new TableInfo.Column("selesai", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAktivitas = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAktivitas = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAktivitas = new TableInfo("aktivitas", _columnsAktivitas, _foreignKeysAktivitas, _indicesAktivitas);
        final TableInfo _existingAktivitas = TableInfo.read(db, "aktivitas");
        if (!_infoAktivitas.equals(_existingAktivitas)) {
          return new RoomOpenHelper.ValidationResult(false, "aktivitas(com.programmerid.myandroid.data.model.Aktivitas).\n"
                  + " Expected:\n" + _infoAktivitas + "\n"
                  + " Found:\n" + _existingAktivitas);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "db51de8a8ce9035da5da35965735225f", "a857996328687d1bcfa4c071207c6275");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "transaksi","aktivitas");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `transaksi`");
      _db.execSQL("DELETE FROM `aktivitas`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(TransaksiDao.class, TransaksiDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AktivitasDao.class, AktivitasDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public TransaksiDao transaksiDao() {
    if (_transaksiDao != null) {
      return _transaksiDao;
    } else {
      synchronized(this) {
        if(_transaksiDao == null) {
          _transaksiDao = new TransaksiDao_Impl(this);
        }
        return _transaksiDao;
      }
    }
  }

  @Override
  public AktivitasDao aktivitasDao() {
    if (_aktivitasDao != null) {
      return _aktivitasDao;
    } else {
      synchronized(this) {
        if(_aktivitasDao == null) {
          _aktivitasDao = new AktivitasDao_Impl(this);
        }
        return _aktivitasDao;
      }
    }
  }
}
