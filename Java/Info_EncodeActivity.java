package com.example.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Calendar;

public class Info_EncodeActivity extends AppCompatActivity {
    private EditText lastNameEditText;
    private EditText firstNameEditText;
    private EditText courseEditText;
    private EditText yearEditText;
    private EditText emailEditText;
    private EditText contactEditText;
    private EditText birthYearEditText;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_encode);
        setTitle("Info Encode");
        lastNameEditText = findViewById(R.id.lastNameEditText);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        courseEditText = findViewById(R.id.courseEditText);
        yearEditText = findViewById(R.id.yearEditText);
        emailEditText = findViewById(R.id.emailEditText);
        contactEditText = findViewById(R.id.contactEditText);
        birthYearEditText = findViewById(R.id.birthYearEditText);
        submitBtn = findViewById(R.id.submitBtn);
        Intent intent = new Intent(this, Info_ViewActivity.class);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lastName = lastNameEditText.getText().toString().trim();
                String firstName = firstNameEditText.getText().toString().trim();
                String course = courseEditText.getText().toString().trim();
                String year = yearEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String contact = contactEditText.getText().toString().trim();
                String birthYear = birthYearEditText.getText().toString().trim();

                if (TextUtils.isEmpty(lastName)
                        || TextUtils.isEmpty(firstName)
                        || TextUtils.isEmpty(course)
                        || TextUtils.isEmpty(year)
                        || TextUtils.isEmpty(email)
                        || TextUtils.isEmpty(contact)
                        || TextUtils.isEmpty(birthYear)) {
                    showToast("Please fill in all the fields");
                } else if (!isNumeric(year) || !isNumeric(contact) || !isNumeric(birthYear)) {
                    showToast("Year, Contact Number, and Birth Year should be numeric");
                } else {
                    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                    int age = currentYear - Integer.parseInt(birthYear);

                    String information = "Last Name: " + lastName + "\n"
                            + "First Name: " + firstName + "\n"
                            + "Course: " + course + "\n"
                            + "Year: " + year + "\n"
                            + "Email Address: " + email + "\n"
                            + "Contact Number: " + contact + "\n"
                            + "Birth Year: " + birthYear + "\n"
                            + "Age: " + age;

                    showToast("Login successful!");

                    // Start the view information activity and pass the information string
                    intent.putExtra("information", information);
                    startActivity(intent);
                }
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
