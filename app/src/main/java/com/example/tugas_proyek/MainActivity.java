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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        public Button sakitJiwa, ibuAnak, umumDaerah;
//        public EditText pencarian;
//
//
//        ibuAnak  = (Button) findViewById(R.id.rskai);
//        sakitJiwa = (Button) findViewById(R.id.rsj);
//        umumDaerah = (Button) findViewById(R.id.rsud);



//        ibuAnak.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String addr = String.format("geo: 0, 0?= %s", "Rumah Sakit Khusus Ibu dan Anak");
//                Uri uri = Uri.parse(addr);
//
//                Intent cari = new Intent(Intent.ACTION_VIEW, uri);
//                cari.setPackage("com.google.android.apps.maps");
//                startActivity(cari);
//            }
//        });
//
//        sakitJiwa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String addr = String.format("geo: 0, 0?= %s", "Rumah Sakit Jiwa");
//                Uri uri = Uri.parse(addr);
//
//                Intent cari = new Intent(Intent.ACTION_VIEW, uri);
//                cari.setPackage("com.google.android.apps.maps");
//                startActivity(cari);
//            }
//        });
//
//        umumDaerah.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Uri uri = Uri.parse("geo:0,0?q=Rumah Sakit Umum Daerah");
//
//                Intent cari = new Intent(Intent.ACTION_VIEW, uri);
//                cari.setPackage("com.google.android.apps.maps");
//                startActivity(cari);
//            }
//        });

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
}