package com.example.a8_18084791_truongcongcuong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText edt_main_email,edt_main_pass;
    Button btn_main_login;
    FirebaseAuth auth;
    String email, password;
    UserDAO dao;
    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        database = Room.databaseBuilder(this,AppDatabase.class,"donut-ck")
                .allowMainThreadQueries()
                .build();
        dao = database.userDAO();

        edt_main_email = findViewById(R.id.edt_main_email);
        edt_main_pass = findViewById(R.id.edt_main_pass);
        btn_main_login = findViewById(R.id.btn_main_login);

        edt_main_email.setText("18084791_TruongCongCuong@gmail.com");
        edt_main_pass.setText("123456");

        btn_main_login.setOnClickListener(v->{
            if(validData())
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(MainActivity.this,
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(!task.isSuccessful())
                                    Toast.makeText(MainActivity.this,"Dang nhap that bai.....",Toast.LENGTH_SHORT).show();
                                else{
                                    Toast.makeText(MainActivity.this,"Dang nhap thanh cong.....",Toast.LENGTH_SHORT).show();
                                    dao.insert(new User(email, Calendar.getInstance().getTime().toString()));
                                    startActivity(new Intent(MainActivity.this, MenuActivity.class));
                                }
                            }
                        });
        });


    }

    private boolean validData() {
        this.email = edt_main_email.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(MainActivity.this,"Nhap Email.....",Toast.LENGTH_SHORT).show();
            return false;
        }
        this.password = edt_main_pass.getText().toString();
        if(TextUtils.isEmpty(password)){
            Toast.makeText(MainActivity.this,"Nhap pass.....",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}