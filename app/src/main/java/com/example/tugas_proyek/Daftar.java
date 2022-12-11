package com.example.tugas_proyek;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Daftar extends AppCompatActivity {

    DataHelper dbHelper;
    EditText nikPasien, namaPasien, ttlPasien, jkPasien, alamatPasien, nomorPasien, rsPasien;
    EditText nikKeluarga, namaKeluarga, ttlKeluarga, jkKeluarga, alamatKeluarga, nomorKeluarga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
    }

    public void sendDaftar(View view){

        dbHelper = new DataHelper(this);
        //Pasien
        nikPasien = (EditText) findViewById(R.id.inputNikPasien);
        namaPasien = (EditText) findViewById(R.id.inputNamaPasien);
        ttlPasien = (EditText) findViewById(R.id.inputTtlPasien);
        jkPasien = (EditText) findViewById(R.id.inputJkPasien);
        alamatPasien = (EditText) findViewById(R.id.inputAlamatPasien);
        nomorPasien = (EditText) findViewById(R.id.inputNomorPasien);
        rsPasien = (EditText) findViewById(R.id.inputRsPasien);

        //Keluarga
        nikKeluarga = (EditText) findViewById(R.id.inputNikKeluarga);
        namaKeluarga = (EditText) findViewById(R.id.inputNamaKeluarga);
        ttlKeluarga = (EditText) findViewById(R.id.inputTtlKeluarga);
        jkKeluarga = (EditText) findViewById(R.id.inputJkKeluarga);
        alamatKeluarga = (EditText) findViewById(R.id.inputAlamatKeluarga);
        nomorKeluarga = (EditText) findViewById(R.id.inputNomorKeluarga);

// TODO Auto-generated method stub
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("insert into pasien(nik, nama, ttl, jk, alamat, nomor, rs, nikKel, namaKel, ttlKel, jkKel, alamatKel, nomorKel) values('" +
                nikPasien.getText().toString() + "','" +
                namaPasien.getText().toString() + "','" +
                ttlPasien.getText().toString() + "','" +
                jkPasien.getText().toString() + "','" +
                alamatPasien.getText().toString() + "','" +
                nomorPasien.getText().toString() + "','" +
                rsPasien.getText().toString() + "', '" +
                nikKeluarga.getText().toString() + "','" +
                namaKeluarga.getText().toString() + "','" +
                ttlKeluarga.getText().toString() + "','" +
                jkKeluarga.getText().toString() + "','" +
                alamatKeluarga.getText().toString() + "','" +
                nomorKeluarga.getText().toString() + "')");


        Toast.makeText(Daftar.this,"Berhasil", Toast.LENGTH_SHORT).show();
        List.ls.RefreshList();
        finish();
    }
}