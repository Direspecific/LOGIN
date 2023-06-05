package com.example.loginui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Info_ViewActivity extends AppCompatActivity {

    private TextView informationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_view);
        setTitle("Info View");
        informationTextView = findViewById(R.id.informationTextView);

        // Retrieve the information string passed from the login activity
        String information = getIntent().getStringExtra("information");

        // Set the information string to the TextView
        informationTextView.setText(information);
    }
}
