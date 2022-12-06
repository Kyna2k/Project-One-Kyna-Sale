package com.example.kynasale.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.kynasale.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().getDecorView().setSystemUiVisibility(0);

    }
}