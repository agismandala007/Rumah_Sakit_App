package com.example.tugas_proyek;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "RumahSakit.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
// TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub
        String sqlPasien = "create table pasien(nik integer primary key, nama text, ttl text, jk text, alamat text, nomor integer);";
        db.execSQL(sqlPasien);

        String sqlKeluarga = "create table pasien(nik integer primary key, nama text, ttl text, jk text, alamat text, nomor integer);";
        db.execSQL(sqlKeluarga);
//        sql = "INSERT INTO biodata (no, nama, tgl, jk, alamat) VALUES ('1001', 'Fathur', '1994-02-03', 'Laki-laki','Jakarta');";
//        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2)
    {
// TODO Auto-generated method stub
    }
}
