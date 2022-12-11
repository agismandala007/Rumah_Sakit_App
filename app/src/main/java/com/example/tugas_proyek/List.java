package com.example.tugas_proyek;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class List extends AppCompatActivity {

    String[] daftar;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static List ls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ls = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }

    public void onCari(View view){
        EditText cari;
        cari = (EditText) findViewById(R.id.cariNama);

        Intent pencarian = new Intent(List.this, Cari.class);
        String nama = cari.getText().toString();


        pencarian.putExtra("nama", nama);
        startActivity(pencarian);
    }

    public void RefreshList(){

        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT nik, nama FROM pasien",null);

        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }

        ListView01 = (ListView)findViewById(R.id.listView1);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {

                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = {"Lihat Data", "Update Data","Pembayaran", "Hapus Data"};
                AlertDialog.Builder builder = new AlertDialog.Builder(List.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int item) {
                                switch(item){
                                    case 0 :
                                        Intent i = new Intent(getApplicationContext(), FullDaftar.class);
                                        i.putExtra("nama", selection);
                                        startActivity(i);
                                        break;
                                    case 1 :
                                        Intent in = new Intent(getApplicationContext(), Update.class);
                                        in.putExtra("nama", selection);
                                        startActivity(in);
                                        break;
                                    case 2 :
                                        Intent pay = new Intent(getApplicationContext(), Bayar.class);
                                        pay.putExtra("nik", selection);
                                        startActivity(pay);
                                        break;
                                    case 3:
                                        SQLiteDatabase db = dbcenter.getWritableDatabase();
                                        db.execSQL("delete from pasien where nama = '"+selection+"'");
                                        RefreshList();
                                        break;
                                }
                            }
                        });
                builder.create().show();
            }});
        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
    }
}