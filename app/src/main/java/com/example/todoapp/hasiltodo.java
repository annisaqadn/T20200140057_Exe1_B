package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class hasiltodo extends AppCompatActivity {
    //Mendeklarasikan variabel dengan tipe data TextView
    TextView edtask, edjenistask, edtimetask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasiltodo);
        //Menghubungkan variabel edtask dengan componen Textview pada Layout
        edtask = findViewById(R.id.edTask);

        //Menghubungkan variabel edjenistask dengan componen Textview pada Layout
        edjenistask = findViewById(R.id.edJenisTask);

        //Menghubungkan variabel edtimetask dengan componen Textview pada Layout
        edtimetask = findViewById(R.id.edTimeTask);

        //Mendeklarasikan variabel bundle yang akan digunakan untuk mengambil pesan yang dikirimkan melalui method intent
        Bundle bundle = getIntent().getExtras();

        //membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan dari activity sebelumnya dengan kunci "a"
        String task = bundle.getString("a");

        //membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan dari activity sebelumnya dengan kunci "b"
        String jenistask = bundle.getString("b");

        //membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan dari activity sebelumnya dengan kunci "c"
        String timetask = bundle.getString("c");

        //menampilkan value dari variabel task kedalam edtask
        edtask.setText(task);

        //menampilkan value dari variabel edjenistask kedalam jenistask
        edjenistask.setText(jenistask);

        //menampilkan value dari variabel edtimetask kedalam timetask
        edtimetask.setText(timetask);
    }
}