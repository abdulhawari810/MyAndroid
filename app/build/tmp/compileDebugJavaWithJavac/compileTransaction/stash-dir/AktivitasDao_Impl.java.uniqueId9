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
import com.programmerid.myandroid.data.model.Aktivitas;
import java.lang.Class;
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
public final class AktivitasDao_Impl implements AktivitasDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Aktivitas> __insertionAdapterOfAktivitas;

  private final EntityDeletionOrUpdateAdapter<Aktivitas> __deletionAdapterOfAktivitas;

  private final EntityDeletionOrUpdateAdapter<Aktivitas> __updateAdapterOfAktivitas;

  public AktivitasDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAktivitas = new EntityInsertionAdapter<Aktivitas>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `aktivitas` (`id`,`namaAktivitas`,`tanggal`,`durasiMenit`,`selesai`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Aktivitas entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNamaAktivitas() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNamaAktivitas());
        }
        if (entity.getTanggal() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTanggal());
        }
        statement.bindLong(4, entity.getDurasiMenit());
        final int _tmp = entity.isSelesai() ? 1 : 0;
        statement.bindLong(5, _tmp);
      }
    };
    this.__deletionAdapterOfAktivitas = new EntityDeletionOrUpdateAdapter<Aktivitas>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `aktivitas` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Aktivitas entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfAktivitas = new EntityDeletionOrUpdateAdapter<Aktivitas>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `aktivitas` SET `id` = ?,`namaAktivitas` = ?,`tanggal` = ?,`durasiMenit` = ?,`selesai` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Aktivitas entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNamaAktivitas() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNamaAktivitas());
        }
        if (entity.getTanggal() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTanggal());
        }
        statement.bindLong(4, entity.getDurasiMenit());
        final int _tmp = entity.isSelesai() ? 1 : 0;
        statement.bindLong(5, _tmp);
        statement.bindLong(6, entity.getId());
      }
    };
  }

  @Override
  public void insert(final Aktivitas aktivitas) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAktivitas.insert(aktivitas);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Aktivitas aktivitas) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAktivitas.handle(aktivitas);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Aktivitas aktivitas) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAktivitas.handle(aktivitas);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Aktivitas>> getAktivitasByTanggal(final String tanggal) {
    final String _sql = "SELECT * FROM aktivitas WHERE tanggal = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tanggal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tanggal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"aktivitas"}, false, new Callable<List<Aktivitas>>() {
      @Override
      @Nullable
      public List<Aktivitas> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNamaAktivitas = CursorUtil.getColumnIndexOrThrow(_cursor, "namaAktivitas");
          final int _cursorIndexOfTanggal = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggal");
          final int _cursorIndexOfDurasiMenit = CursorUtil.getColumnIndexOrThrow(_cursor, "durasiMenit");
          final int _cursorIndexOfSelesai = CursorUtil.getColumnIndexOrThrow(_cursor, "selesai");
          final List<Aktivitas> _result = new ArrayList<Aktivitas>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Aktivitas _item;
            final String _tmpNamaAktivitas;
            if (_cursor.isNull(_cursorIndexOfNamaAktivitas)) {
              _tmpNamaAktivitas = null;
            } else {
              _tmpNamaAktivitas = _cursor.getString(_cursorIndexOfNamaAktivitas);
            }
            final String _tmpTanggal;
            if (_cursor.isNull(_cursorIndexOfTanggal)) {
              _tmpTanggal = null;
            } else {
              _tmpTanggal = _cursor.getString(_cursorIndexOfTanggal);
            }
            final int _tmpDurasiMenit;
            _tmpDurasiMenit = _cursor.getInt(_cursorIndexOfDurasiMenit);
            final boolean _tmpSelesai;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfSelesai);
            _tmpSelesai = _tmp != 0;
            _item = new Aktivitas(_tmpNamaAktivitas,_tmpTanggal,_tmpDurasiMenit,_tmpSelesai);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
