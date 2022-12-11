package com.example.tugas_proyek;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FullDaftar extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    TextView text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_daftar);

        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.printNik);
        text2 = (TextView) findViewById(R.id.printNama);
        text3 = (TextView) findViewById(R.id.printTtl);
        text4 = (TextView) findViewById(R.id.printJk);
        text5 = (TextView) findViewById(R.id.printAlamat);
        text13 = (TextView) findViewById(R.id.printNomor);
        text6 = (TextView) findViewById(R.id.printRs);

        text7 = (TextView) findViewById(R.id.printNikKeluarga);
        text8 = (TextView) findViewById(R.id.printNamaKeluarga);
        text9 = (TextView) findViewById(R.id.printTtlKeluarga);
        text10 = (TextView) findViewById(R.id.printJkKeluarga);
        text11 = (TextView) findViewById(R.id.printAlamatKeluarga);
        text12 = (TextView) findViewById(R.id.printNomorKeluarga);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM pasien WHERE nama = '" + getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
            text13.setText(cursor.getString(5).toString());
            text6.setText(cursor.getString(6).toString());
            text7.setText(cursor.getString(7).toString());
            text8.setText(cursor.getString(8).toString());
            text9.setText(cursor.getString(9).toString());
            text10.setText(cursor.getString(10).toString());
            text11.setText(cursor.getString(11).toString());
            text12.setText(cursor.getString(12).toString());
        }
    }
}