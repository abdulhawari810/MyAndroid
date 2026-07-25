package com.programmerid.myandroid.data.db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.programmerid.myandroid.data.model.Transaksi;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TransaksiDao_Impl implements TransaksiDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Transaksi> __insertionAdapterOfTransaksi;

  private final EntityDeletionOrUpdateAdapter<Transaksi> __deletionAdapterOfTransaksi;

  public TransaksiDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTransaksi = new EntityInsertionAdapter<Transaksi>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `transaksi` (`id`,`jenis`,`kategori`,`jumlah`,`tanggal`,`catatan`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Transaksi entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getJenis() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getJenis());
        }
        if (entity.getKategori() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getKategori());
        }
        statement.bindDouble(4, entity.getJumlah());
        if (entity.getTanggal() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTanggal());
        }
        if (entity.getCatatan() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getCatatan());
        }
      }
    };
    this.__deletionAdapterOfTransaksi = new EntityDeletionOrUpdateAdapter<Transaksi>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `transaksi` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Transaksi entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public void insert(final Transaksi transaksi) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTransaksi.insert(transaksi);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Transaksi transaksi) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTransaksi.handle(transaksi);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Transaksi>> getAllTransaksi() {
    final String _sql = "SELECT * FROM transaksi ORDER BY id DESC LIMIT 10";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"transaksi"}, false, new Callable<List<Transaksi>>() {
      @Override
      @Nullable
      public List<Transaksi> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfJenis = CursorUtil.getColumnIndexOrThrow(_cursor, "jenis");
          final int _cursorIndexOfKategori = CursorUtil.getColumnIndexOrThrow(_cursor, "kategori");
          final int _cursorIndexOfJumlah = CursorUtil.getColumnIndexOrThrow(_cursor, "jumlah");
          final int _cursorIndexOfTanggal = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggal");
          final int _cursorIndexOfCatatan = CursorUtil.getColumnIndexOrThrow(_cursor, "catatan");
          final List<Transaksi> _result = new ArrayList<Transaksi>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Transaksi _item;
            final String _tmpJenis;
            if (_cursor.isNull(_cursorIndexOfJenis)) {
              _tmpJenis = null;
            } else {
              _tmpJenis = _cursor.getString(_cursorIndexOfJenis);
            }
            final String _tmpKategori;
            if (_cursor.isNull(_cursorIndexOfKategori)) {
              _tmpKategori = null;
            } else {
              _tmpKategori = _cursor.getString(_cursorIndexOfKategori);
            }
            final double _tmpJumlah;
            _tmpJumlah = _cursor.getDouble(_cursorIndexOfJumlah);
            final String _tmpTanggal;
            if (_cursor.isNull(_cursorIndexOfTanggal)) {
              _tmpTanggal = null;
            } else {
              _tmpTanggal = _cursor.getString(_cursorIndexOfTanggal);
            }
            final String _tmpCatatan;
            if (_cursor.isNull(_cursorIndexOfCatatan)) {
              _tmpCatatan = null;
            } else {
              _tmpCatatan = _cursor.getString(_cursorIndexOfCatatan);
            }
            _item = new Transaksi(_tmpJenis,_tmpKategori,_tmpJumlah,_tmpTanggal,_tmpCatatan);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Double> getTotalPemasukan() {
    final String _sql = "SELECT SUM(jumlah) FROM transaksi WHERE jenis = 'Pemasukan'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"transaksi"}, false, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Double> getTotalPengeluaran() {
    final String _sql = "SELECT SUM(jumlah) FROM transaksi WHERE jenis = 'Pengeluaran'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"transaksi"}, false, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
