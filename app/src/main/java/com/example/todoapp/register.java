package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;
import android.widget.Toast;

public class register extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnregister;

    //Deklarasi variabel untuk EditText
    EditText ednama, edemail, edpassword, edrepassword;

    //Deklarasi variabel untuk String
    String nama, email, password, repassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Menghubungkan variabel btnregister dengan componen button pada Layout
        btnregister = findViewById(R.id.btRegister);

        //Menghubungkan variabel ednama dengan componen EditText pada Layout
        ednama = findViewById(R.id.edNama);

        //Menghubungkan variabel edemail dengan componen EditText pada Layout
        edemail = findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen EditText pada Layout
        edpassword = findViewById(R.id.edPassword);

        //Menghubungkan variabel edrepassword dengan componen EditText pada Layout
        edrepassword = findViewById(R.id.edRepassword);

        //Membuat fungsi onclick pada button btnregister
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan input user di edittext kedalam variabel nama, email, password, repassword
                nama = ednama.getText().toString();
                email = edemail.getText().toString();
                password = edpassword.getText().toString();
                repassword = edrepassword.getText().toString();
                //Membuat kondisi untuk mengecek apakah EditText kosong atau tidak
                if (TextUtils.isEmpty(nama) && TextUtils.isEmpty(email) && TextUtils.isEmpty(password) && TextUtils.isEmpty(repassword)){
                    //Menampilkan pesan notifikasi jika seluruh EditText wajib diisi
                    Toast t = Toast.makeText(getApplicationContext(),"Wajib isi seluruh data",Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();
                    //menampilkan pesan "nama harus anda isi"
                    ednama.setError("Nama harus anda isi");
                    //menampilkan pesan "email harus anda isi"
                    edemail.setError("Email harus anda isi");
                }else if(TextUtils.isEmpty(nama) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(repassword)){
                    //Menampilkan pesan notifikasi jika seluruh EditText wajib diisi
                    Toast t = Toast.makeText(getApplicationContext(),"Mohon isi semua data anda",Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();
                }
                else {
                    //Membuat kondisi untuk mencetak apakah isi dari EditText password dan EditText repassword sama atau tidak
                    if (!password.equals(repassword)){
                        //Menampilkan pesan notifikasi jika password salah
                        Toast t = Toast.makeText(getApplicationContext(),"Password Salah",Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();
                    }
                    else { Bundle b = new Bundle(); //membuat objek bundle
                        //memasukkan value dari variabel nama dengan kunci "nama" dan dimasukkan kedalam bundle
                        b.putString("nama", nama.trim());
                        //Menampilkan pesan notifikasi jika login berhasil
                        Toast t = Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();
                        //membuat objek intent berpindah dari register ke isiantodo
                        Intent i = new Intent(getApplicationContext(), isiantodo.class);
                        //memasukkan bundle kedalam intent untuk dikirimkan ke isiantodo
                        i.putExtras(b);
                        //berpindah ke isiantodo
                        startActivity(i);
                    }
                }
            }
        });
    }
}