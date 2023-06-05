package com.example.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("Menu");
    }

    public void onhit(View v){
        Intent i = new Intent(this, Info_EncodeActivity.class);
        startActivity(i);
    }
    public void onpress(View v){
        Intent r = new Intent(this, Grade_EncodeActivity.class);
        startActivity(r);
    }
}
