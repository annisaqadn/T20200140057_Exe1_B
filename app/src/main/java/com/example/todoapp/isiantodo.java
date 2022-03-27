package com.example.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class isiantodo extends AppCompatActivity {
    //Deklarasi variabel untuk TextView
    TextView tnama;

    //Deklarasi variabel dengan tipe data EditText
    EditText edtask, edjenistask, edtimetask;

    //Deklarasi variabel dengan tipe data String
    String nama, task, jenistask, timetask;

    //Deklarasi variabel dengan tipe data Floating Action Button
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isiantodo);

        //Menghubungkan variabel tnama dengan componen TextView pada Layout
        tnama = findViewById(R.id.Nama);

        //Menghubungkan variabel edtask dengan componen EditText pada Layout
        edtask = findViewById(R.id.edTask);

        //Menghubungkan variabel edjenistask dengan componen EditText pada Layout
        edjenistask = findViewById(R.id.edJenisTask);

        //Menghubungkan variabel edtimetask dengan componen EditText pada Layout
        edtimetask = findViewById(R.id.edTimeTask);

        //Menghubungkan variabel fabSimpan dengan componen FloatingActionButton pada Layout
        fab = findViewById(R.id.fabAdd);

        //membuat objek bundle dan mengambil data yang dikirimkan dari mainactivity dan register
        Bundle bundle = getIntent().getExtras();
        //variabel string yang digunakan untuk menyimpan data yang dikirimkan dari mainactivity dan register dengan kunci "nama"
        nama = bundle.getString("nama");
        //menampilkan value dari variabel nama kedalam tnama
        tnama.setText(nama);

        //membuat method untuk event dari floating button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = edtask.getText().toString();
                jenistask = edjenistask.getText().toString();
                timetask = edtimetask.getText().toString();
                //Membuat kondisi untuk mengecek apakah EditText kosong atau tidak
                if (edtask.getText().toString().isEmpty() &&
                    edjenistask.getText().toString().isEmpty() &&
                    edtimetask.getText().toString().isEmpty())
                {
                    //Menampilkan pesan notifikasi jika seluruh data wajib diisi
                    Toast t = Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_LONG);
                    t.show();
                } else if (edjenistask.getText().toString().isEmpty() &&
                        edtimetask.getText().toString().isEmpty())
                {
                    //menampilkan pesan "Jenis task!"
                    edjenistask.setError("Jenis Task!");
                } else if (edtimetask.getText().toString().isEmpty()) {
                    //menampilkan pesan "Lama Task!"
                    edtimetask.setError("Lama Task!");
                } else {
                    //Menampilkan pesan notifikasi jika pengisian berhasil
                    Toast t = Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();

                    //membuat objek bundle
                    Bundle b = new Bundle();
                    //memasukkan value dari variabel task dengan kunci "a", variabel jenistask dengan kunci "b", variabel timetask dengan kunci "c" dan dimasukkan kedalam bundle
                    b.putString("a", task.trim());
                    b.putString("b", jenistask.trim());
                    b.putString("c", timetask.trim());

                    //membuat objek intent berpindah dari isiantodo ke hasiltodo
                    Intent i = new Intent(getApplicationContext(), hasiltodo.class);
                    //memasukkan bundle kedalam intent untuk dikirimkan ke hasiltodo
                    i.putExtras(b);
                    //berpindah ke hasiltodo
                    startActivity(i);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Membuat kondisi jika yang dipilih adalah mnSubmit
        if (item.getItemId() == R.id.mnSubmit) {
            task = edtask.getText().toString();
            jenistask = edjenistask.getText().toString();
            timetask = edtimetask.getText().toString();
            //Membuat kondisi untuk mengecek apakah EditText kosong atau tidak
            if (edtask.getText().toString().isEmpty() &&
                    edjenistask.getText().toString().isEmpty() &&
                    edtimetask.getText().toString().isEmpty())
            {
                //Menampilkan pesan notifikasi jika seluruh data wajib diisi
                Toast t = Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_LONG);
                t.show();
            } else if (edjenistask.getText().toString().isEmpty() &&
                    edtimetask.getText().toString().isEmpty())
            {
                //menampilkan pesan "Jenis task!"
                edjenistask.setError("Jenis Task!");
            } else if (edtimetask.getText().toString().isEmpty()) {
                //menampilkan pesan "Lama Task!"
                edtimetask.setError("Lama Task!");
            } else {
                //Menampilkan pesan notifikasi jika pengisian berhasil
                Toast t = Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG);
                //menampilkan toast
                t.show();

                //membuat objek bundle
                Bundle b = new Bundle();
                //memasukkan value dari variabel task dengan kunci "a", variabel jenistask dengan kunci "b", variabel timetask dengan kunci "c" dan dimasukkan kedalam bundle
                b.putString("a", task.trim());
                b.putString("b", jenistask.trim());
                b.putString("c", timetask.trim());

                //membuat objek intent berpindah dari isiantodo ke hasiltodo
                Intent i = new Intent(getApplicationContext(), hasiltodo.class);
                //memasukkan bundle kedalam intent untuk dikirimkan ke hasiltodo
                i.putExtras(b);
                //berpindah ke hasiltodo
                startActivity(i);
            }
        } else {
            //Method untuk ke "MainActivity"
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            //berpindah ke mainactivity
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}