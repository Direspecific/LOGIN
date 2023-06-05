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

public class Grade_EncodeActivity extends AppCompatActivity {

    private EditText lastNameEditText, firstNameEditText, attendanceEditText,
            quizEditText1, quizEditText2, quizEditText3, quizEditText4, examEditText;
    private Button btnSubmit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_encode);
        setTitle("Grade Encode");
        lastNameEditText = findViewById(R.id.lastNameEditText);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        attendanceEditText = findViewById(R.id.attendanceEditText);
        quizEditText1 = findViewById(R.id.quizEditText1);
        quizEditText2 = findViewById(R.id. quizEditText2);
        quizEditText3 = findViewById(R.id. quizEditText3);
        quizEditText4 = findViewById(R.id. quizEditText4);
        examEditText = findViewById(R.id.examEditText);
        btnSubmit = findViewById(R.id.btnSubmit);
        Intent i = new Intent(this, Grade_ViewActivity.class);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lastName = lastNameEditText.getText().toString().trim();
                String firstName = firstNameEditText.getText().toString().trim();
                String attendance = attendanceEditText.getText().toString().trim();
                String quiz1 = quizEditText1.getText().toString().trim();
                String quiz2 = quizEditText2.getText().toString().trim();
                String quiz3 = quizEditText3.getText().toString().trim();
                String quiz4 = quizEditText4.getText().toString().trim();
                String exam = examEditText.getText().toString().trim();


                if (lastName.isEmpty()
                        || firstName.isEmpty()
                        || attendance.isEmpty()
                        || quiz1.isEmpty()
                        || quiz2.isEmpty()
                        || quiz3.isEmpty()
                        || quiz4.isEmpty()
                        || exam.isEmpty()) {
                    showToast("Please fill in all the required details.");
                } else {
                        int attendanceValue = Integer.parseInt(attendance);
                        int quiz1Value = Integer.parseInt(quiz1);
                        int quiz2Value = Integer.parseInt(quiz2);
                        int quiz3Value = Integer.parseInt(quiz3);
                        int quiz4Value = Integer.parseInt(quiz4);
                        int examValue = Integer.parseInt(exam);

                        if (attendanceValue < 1 || attendanceValue > 100 ||
                                quiz1Value < 1 || quiz1Value > 100 ||
                                quiz2Value < 1 || quiz2Value > 100 ||
                                quiz3Value < 1 || quiz3Value > 100 ||
                                quiz4Value < 1 || quiz4Value > 100 ||
                                examValue < 1 || examValue > 100) {
                            showToast("Please enter values between 1 and 100 for Attendance, Quizzes, and Exam.");
                } else {
                            Intent intent = new Intent(Grade_EncodeActivity.this, Grade_ViewActivity.class);

                            // Pass the data to Grade_ViewActivity
                            intent.putExtra("lastName", lastName);
                            intent.putExtra("firstName", firstName);
                            intent.putExtra("attendance", attendanceValue);
                            intent.putExtra("quiz1", quiz1Value);
                            intent.putExtra("quiz2", quiz2Value);
                            intent.putExtra("quiz3", quiz3Value);
                            intent.putExtra("quiz4", quiz4Value);
                            intent.putExtra("exam", examValue);

                            // Start Grade_ViewActivity
                            startActivity(intent);
                            showToast("Data submitted successfully!");
                        }
                    }
                }
            });
        }

        private void showToast(String message) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
