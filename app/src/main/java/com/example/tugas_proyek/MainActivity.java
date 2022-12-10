package com.example.tugas_proyek;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout konsultasi, pendaftaran, list, pembayaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view){
        Button sakitJiwa, ibuAnak, umumDaerah;
        EditText pencarian;

        String addr = "";

        ibuAnak  = (Button) findViewById(R.id.rskai);
        sakitJiwa = (Button) findViewById(R.id.rsj);
        umumDaerah = (Button) findViewById(R.id.rsud);

        switch (view.getId()){
            case R.id.rsj:
                addr = "geo:0,0?q=Rumah Sakit Jiwa";
                break;

            case R.id.rsud:
                addr = "geo:0,0?q=Rumah Sakit Umum Daerah";
                break;

            case R.id.rskai:
                addr = "geo:0,0?q=Rumah Sakit Khusus Ibu dan Anak";
                break;
        }

        Uri uri = Uri.parse(addr);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onFitur(View view){
        konsultasi = (LinearLayout) findViewById(R.id.konsul);
        pendaftaran = (LinearLayout) findViewById(R.id.daftar);
        list = (LinearLayout) findViewById(R.id.list);
        pembayaran = (LinearLayout) findViewById(R.id.bayar);

        switch (view.getId()){
            case R.id.konsul:
                Toast toast = Toast.makeText(MainActivity.this, "konsul", Toast.LENGTH_SHORT);
                toast.show();
                break;

            case R.id.daftar:
                Toast daftar = Toast.makeText(MainActivity.this, "daftar", Toast.LENGTH_SHORT);
                daftar.show();
                break;

            case R.id.list:
                Toast listT = Toast.makeText(MainActivity.this, "list", Toast.LENGTH_SHORT);
                listT.show();
                break;

            case R.id.bayar:
                Toast bayar = Toast.makeText(MainActivity.this, "bayar", Toast.LENGTH_SHORT);
                bayar.show();
                break;
        }
    }
}