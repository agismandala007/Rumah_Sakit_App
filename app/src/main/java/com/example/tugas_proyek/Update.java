package com.example.tugas_proyek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity {

    EditText teks1, teks2, teks3, teks4, teks5, teks6, teks7, teks8, teks9, teks10, teks11, teks12, teks13;
    DataHelper dbHelper;
    protected Cursor cursor;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        dbHelper = new DataHelper(this);

        teks1 = findViewById(R.id.updateNikPasien);
        teks2 = findViewById(R.id.updateNamaPasien);
        teks3 = findViewById(R.id.updateTtlPasien);
        teks4 = findViewById(R.id.updateJkPasien);
        teks5 = findViewById(R.id.updateAlamatPasien);
        teks6 = findViewById(R.id.updateNomorPasien);
        teks7 = findViewById(R.id.updateRsPasien);

        teks8 = findViewById(R.id.updateNikKeluarga);
        teks9 = findViewById(R.id.updateNamaKeluarga);
        teks10 = findViewById(R.id.updateTtlKeluarga);
        teks11 = findViewById(R.id.updateJkKeluarga);
        teks12 = findViewById(R.id.updateAlamatKeluarga);
        teks13 = findViewById(R.id.updateNomorKeluarga);

        button = findViewById(R.id.updateButton);

        Bundle terimaData = getIntent().getExtras();
        String nik = terimaData.getString("nama");


        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM pasien WHERE nama = '" + nik + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            teks1.setText(cursor.getString(0).toString());
            teks2.setText(cursor.getString(1).toString());
            teks3.setText(cursor.getString(2).toString());
            teks4.setText(cursor.getString(3).toString());
            teks5.setText(cursor.getString(4).toString());
            teks6.setText(cursor.getString(5).toString());
            teks7.setText(cursor.getString(6).toString());
            teks8.setText(cursor.getString(7).toString());
            teks9.setText(cursor.getString(8).toString());
            teks10.setText(cursor.getString(9).toString());
            teks11.setText(cursor.getString(10).toString());
            teks12.setText(cursor.getString(11).toString());
            teks13.setText(cursor.getString(12).toString());
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("UPDATE pasien SET nik = '" +
                    teks1.getText().toString() + "', nama = '" +
                    teks2.getText().toString() + "', ttl = '" +
                    teks3.getText().toString() + "', jk = '" +
                    teks4.getText().toString() + "', alamat = '" +
                    teks5.getText().toString() + "', nomor = '" +
                    teks6.getText().toString() + "', rs = '" +
                    teks7.getText().toString() + "', nikKel = '" +
                    teks8.getText().toString() + "', namaKel = '" +
                    teks9.getText().toString() + "', ttlKel = '" +
                    teks10.getText().toString() + "', jkKel = '" +
                    teks11.getText().toString() + "', alamatKel = '" +
                    teks12.getText().toString() + "', nomorKel = '" +
                    teks13.getText().toString() + "' WHERE nik = '" + teks1.getText().toString() + "' ");

                Intent print = new Intent(getApplicationContext(), FullDaftar.class);
                String send = teks2.getText().toString();

                print.putExtra("nama", send);
                startActivity(print);
            }
        });

    }

}