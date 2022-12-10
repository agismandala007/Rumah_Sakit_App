package com.example.tugas_proyek;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Konsul extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsul);
    }

    public void sendEmail(View view){
        TextView tujuan, subjek, isi;

        tujuan = (TextView) findViewById(R.id.emailTujuan);
        subjek = (TextView) findViewById(R.id.emailSubjek);
        isi = (TextView) findViewById(R.id.emailEmail);


        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setType("text/html");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {tujuan.getText().toString()});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subjek.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, isi.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));

        startActivity(emailIntent);
    }
}