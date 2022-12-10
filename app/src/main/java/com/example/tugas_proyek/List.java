package com.example.tugas_proyek;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class List<cursor> extends AppCompatActivity {

    TextView nik, nama, ttl, jk, alamat, nomor, rs;
    DataHelper dbHelper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        nik = findViewById(R.id.printNik);
        nama = findViewById(R.id.printNama);
        ttl = findViewById(R.id.printTtl);
        jk = findViewById(R.id.printJk);
        alamat = findViewById(R.id.printAlamat);
        nomor = findViewById(R.id.printNomor);
        rs = findViewById(R.id.printRs);

        dbHelper = new DataHelper(this);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pasien" + getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            nik.setText(cursor.getString(0).toString());
            nama.setText(cursor.getString(1).toString());
            ttl.setText(cursor.getString(2).toString());
            alamat.setText(cursor.getString(3).toString());
            nomor.setText(cursor.getString(4).toString());
            rs.setText(cursor.getString(5).toString());
        }
    }
}