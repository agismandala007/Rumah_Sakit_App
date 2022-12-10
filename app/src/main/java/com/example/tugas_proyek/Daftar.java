package com.example.tugas_proyek;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Daftar extends AppCompatActivity {

    DataHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
    }

    public void sendDaftar(View view){
        EditText nikPasien, namaPasien, ttlPasien, jkPasien, alamatPasien, nomorPasien, rsPasien;
        EditText nikKeluarga, namaKeluarga, ttlKeluarga, jkKeluarga, alamatKeluarga, nomorKeluarga;

        //Pasien
        nikPasien = findViewById(R.id.inputNikPasien);
        namaPasien = findViewById(R.id.inputNamaPasien);
        ttlPasien = findViewById(R.id.inputTtlPasien);
        jkPasien = findViewById(R.id.inputJkPasien);
        alamatPasien = findViewById(R.id.inputAlamatPasien);
        nomorPasien = findViewById(R.id.inputNomorPasien);
        rsPasien = findViewById(R.id.inputRsPasien);

        //Keluarga
        nikKeluarga = findViewById(R.id.inputNikKeluarga);
        namaKeluarga = findViewById(R.id.inputNamaKeluarga);
        ttlKeluarga = findViewById(R.id.inputTtlKeluarga);
        jkKeluarga = findViewById(R.id.inputJkKeluarga);
        alamatKeluarga = findViewById(R.id.inputAlamatKeluarga);
        nomorKeluarga = findViewById(R.id.inputNomorKeluarga);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        
        //Dapatkan Nilai Pasien
        String nikP = nikPasien.getText().toString();
        String namaP = namaPasien.getText().toString();
        String ttlP = ttlPasien.getText().toString();
        String jkP = jkPasien.getText().toString();
        String alamatP = alamatPasien.getText().toString();
        String nomorP = nomorPasien.getText().toString();
        String rsP = rsPasien.getText().toString();


        db.execSQL("INSERT INTO pasien(nik, nama, ttl, jk, alamat, nomor, rs) VALUES (nikP, namaP, ttlP, jkP, alamatP, nomotP, rsP);");

        Toast.makeText(getApplicationContext(),"Berhasil", Toast.LENGTH_LONG).show();
    }
}