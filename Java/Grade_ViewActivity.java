package com.example.loginui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Grade_ViewActivity extends AppCompatActivity {

    private TextView tvLastName, tvFirstName, tvAttendance, tvQuiz1, tvQuiz2, tvQuiz3, tvQuiz4, tvExam, tvAverage, tvStatus, tvRemarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_view);
        setTitle("Grade View");

        // Initialize TextView fields
        tvLastName = findViewById(R.id.tvLastName);
        tvFirstName = findViewById(R.id.tvFirstName);
        tvAttendance = findViewById(R.id.tvAttendance);
        tvQuiz1 = findViewById(R.id.tvQuiz1);
        tvQuiz2 = findViewById(R.id.tvQuiz2);
        tvQuiz3 = findViewById(R.id.tvQuiz3);
        tvQuiz4 = findViewById(R.id.tvQuiz4);
        tvExam = findViewById(R.id.tvExam);
        tvAverage = findViewById(R.id.tvAverage);
        tvStatus = findViewById(R.id.tvStatus);
        tvRemarks = findViewById(R.id.tvRemarks);

        // Get the data passed from the previous activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String lastName = extras.getString("lastName");
            String firstName = extras.getString("firstName");
            int attendance = extras.getInt("attendance");
            int quiz1 = extras.getInt("quiz1");
            int quiz2 = extras.getInt("quiz2");
            int quiz3 = extras.getInt("quiz3");
            int quiz4 = extras.getInt("quiz4");
            int exam = extras.getInt("exam");

            // Set the values to the TextViews
            tvLastName.setText(lastName);
            tvFirstName.setText(firstName);
            tvAttendance.setText(String.valueOf(attendance));
            tvQuiz1.setText(String.valueOf(quiz1));
            tvQuiz2.setText(String.valueOf(quiz2));
            tvQuiz3.setText(String.valueOf(quiz3));
            tvQuiz4.setText(String.valueOf(quiz4));
            tvExam.setText(String.valueOf(exam));

            // Calculate the average
            double average = calculateAverage(attendance, quiz1, quiz2, quiz3, quiz4, exam);
            tvAverage.setText(String.format("%.2f", average));

            // Determine the status and remarks based on the average
            String status = average >= 60 ? "Passed" : "Failed";
            String remarks = getRemarks(average);
            tvStatus.setText(status);
            tvRemarks.setText(remarks);
        }
    }

    private double calculateAverage(int attendance, int quiz1, int quiz2, int quiz3, int quiz4, int exam) {
        double attendanceWeight = 0.2;
        double quizzesWeight = 0.3;
        double examWeight = 0.5;

        double attendanceScore = attendance * attendanceWeight;
        double quizzesScore = ((quiz1 + quiz2 + quiz3 + quiz4) / 4.0) * quizzesWeight;
        double examScore = exam * examWeight;

        return attendanceScore + quizzesScore + examScore;
    }

    private String getRemarks(double average) {
        if (average >= 96 && average <= 100) {
            return "4.00";
        } else if (average >= 90 && average <= 95) {
            return "3.50";
        } else if (average >= 84 && average <= 89) {
            return "3.00";
        } else if (average >= 78 && average <= 83) {
            return "2.50";
        } else if (average >= 72 && average <= 77) {
            return "2.00";
        } else if (average >= 66 && average <= 71) {
            return "1.50";
        } else if (average >= 60 && average <= 65) {
            return "1.00";
        } else {
            return "INC";
        }
    }
}
