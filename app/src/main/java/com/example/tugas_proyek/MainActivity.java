package com.example.tugas_proyek;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        String addr = "";

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
        switch (view.getId()){
            case R.id.konsul:
                Intent menuKonsul = new Intent(MainActivity.this, Konsul.class);
                startActivity(menuKonsul);
                break;

            case R.id.daftar:
                Intent menuDaftar = new Intent(MainActivity.this, Daftar.class);
                startActivity(menuDaftar);
                break;

            case R.id.list:
                Intent menuList = new Intent(MainActivity.this, List.class);
                startActivity(menuList);
                break;

            case R.id.bayar:
                Intent menuBayar = new Intent(MainActivity.this, Bayar.class);
                startActivity(menuBayar);
                break;
        }
    }
}