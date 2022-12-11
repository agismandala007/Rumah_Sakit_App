package com.example.tugas_proyek;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Rumah_Sakit.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
// TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub
        String sql = "create table pasien(nik integer primary key, nama text null, ttl text null, jk text null, alamat text null, nomor integer null, rs text null, nikKel text null, namaKel text null, ttlKel text null, jkKel text null, alamatKel text null, nomorKel integer null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);

        sql = "INSERT INTO pasien(nik, nama, ttl, jk, alamat, nomor, rs, nikKel, namaKel, ttlKel, jkKel, alamatKel, nomorKel) VALUES ('2', 'Fathur', '1994-02-03', 'L','Jakarta', '12323', 'rs', '1', 'Agus', '1994-02-03', 'P','Jakarta', '23123');";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
// TODO Auto-generated method stub
    }
}
