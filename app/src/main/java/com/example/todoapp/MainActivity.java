package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnsignin;

    //Deklarasi variabel untuk EditText
    EditText ednama, edpassword;

    //Deklarasi variabel untuk TextView
    TextView kregister;

    //Deklarasi variabel untuk menyimpan nama dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnsignin dengan componen button pada Layout
        btnsignin = findViewById(R.id.btnSignin);

        //Menghubungkan variabel ednama dengan componen EditText pada Layout
        ednama = findViewById(R.id.edNama);

        //Menghubungkan variabel edpassword dengan componen EditText pada Layout
        edpassword = findViewById(R.id.edPassword);

        //Menghubungkan variabel kregister dengan componen TextView pada Layout
        kregister = findViewById(R.id.kRegister);

        //Membuat fungsi onclick pada TextView kregister
        kregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), register.class);
                startActivity(i);
            }
        });
        //Membuat fungsi onclick pada button btnsignin
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan input user di edittext nama kedalam variabel nama
                nama = ednama.getText().toString();

                //Menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //Mengeset nama yang benar
                String name = "Akyun";

                //Mengeset password yang benar
                String pwd = "iniAkyun";

                //mengecek apakah isi dari email dan password sudah sama dengan nama dan password yang sudah di set
                if (nama.isEmpty() && password.isEmpty()) {
                    //menampilkan pesan "nama harus anda isi"
                    ednama.setError("Nama harus anda isi");
                } else if (nama.equals(name) && (password.isEmpty())) {
                    //menampilkan pesan "Masukkan password anda"
                    edpassword.setError("Masukkan password anda");
                }else if (nama.equals(name) && password.equals(pwd)) { //Memasukkan nama "Akyun" dan Password "iniAkyun" untuk sign in
                        //membuat variabel toast dan menampilkan pesan "Login sukses"
                        Toast t = Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();

                        //membuat objek bundle
                        Bundle b = new Bundle();
                        //memasukkan value dari variabel nama dengan kunci "nama" dan dimasukkan kedalam bundle
                        b.putString("nama", nama.trim());
                        //membuat objek intent berpindah dari mainactivity ke isiantodo
                        Intent i = new Intent(getApplicationContext(), isiantodo.class);

                        //memasukkan bundle kedalam intent untuk dikirimkan ke isiantodo
                        i.putExtras(b);

                        //berpindah ke isiantodo
                        startActivity(i);
                }
                else if (nama.equals(name) && !password.equals(pwd)) {
                    //membuat variabel toast dan membuat toast dan menampilkan pesan "password salah"
                    Toast t = Toast.makeText(getApplicationContext(), "Password salah", Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();
                }
                else{
                    //membuat variabel toast dan membuat toast dan menampilkan pesan "nama salah"
                    Toast t = Toast.makeText(getApplicationContext(), "Nama salah", Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();
                }
            }
        });
    }}