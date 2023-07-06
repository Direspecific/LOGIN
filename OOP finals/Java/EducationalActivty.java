package com.example.afinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EducationalActivity extends AppCompatActivity {
    private CheckBox elementaryCheckBox, secondaryCheckBox, vocationalCheckBox, graduateCheckBox, collegeCheckBox;
    private TextView elementarySchoolTextView, elementaryEducationTextView;
    private EditText elementarySchoolEditText, elementaryEducationEditText;
    private TextView secondarySchoolTextView, secondaryEducationTextView;
    private EditText secondarySchoolEditText, secondaryEducationEditText;
    private TextView vocationalSchoolTextView, vocationalEducationTextView;
    private EditText vocationalSchoolEditText, vocationalEducationEditText;
    private TextView graduateSchoolTextView, graduateEducationTextView;
    private EditText graduateSchoolEditText, graduateEducationEditText;
    private TextView collegeSchoolTextView, collegeEducationTextView;
    private EditText collegeSchoolEditText, collegeEducationEditText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational);
        setTitle("Educational Background");

        // Initialize views
        elementaryCheckBox = findViewById(R.id.elementaryCheckBox);
        secondaryCheckBox = findViewById(R.id.secondaryCheckBox);
        vocationalCheckBox = findViewById(R.id.vocationalCheckBox);
        graduateCheckBox = findViewById(R.id.graduateCheckBox);
        collegeCheckBox = findViewById(R.id.collegeCheckBox);
        elementarySchoolTextView = findViewById(R.id.elementarySchoolTextView);
        elementaryEducationTextView = findViewById(R.id.elementaryEducationTextView);
        elementarySchoolEditText = findViewById(R.id.elementarySchoolEditText);
        elementaryEducationEditText = findViewById(R.id.elementaryEducationEditText);
        secondarySchoolTextView = findViewById(R.id.secondarySchoolTextView);
        secondaryEducationTextView = findViewById(R.id.secondaryEducationTextView);
        secondarySchoolEditText = findViewById(R.id.secondarySchoolEditText);
        secondaryEducationEditText = findViewById(R.id.secondaryEducationEditText);
        vocationalSchoolTextView = findViewById(R.id.vocationalSchoolTextView);
        vocationalEducationTextView = findViewById(R.id.vocationalEducationTextView);
        vocationalSchoolEditText = findViewById(R.id.vocationalSchoolEditText);
        vocationalEducationEditText = findViewById(R.id.vocationalEducationEditText);
        graduateSchoolTextView = findViewById(R.id.graduateSchoolTextView);
        graduateEducationTextView = findViewById(R.id.graduateEducationTextView);
        graduateSchoolEditText = findViewById(R.id.graduateSchoolEditText);
        graduateEducationEditText = findViewById(R.id.graduateEducationEditText);
        collegeSchoolTextView = findViewById(R.id.collegeSchoolTextView);
        collegeEducationTextView = findViewById(R.id.collegeEducationTextView);
        collegeSchoolEditText = findViewById(R.id.collegeSchoolEditText);
        collegeEducationEditText = findViewById(R.id.collegeEducationEditText);
    }

    public void onEducationalAttainmentChecked(View view) {
        // Enable/disable elementary school name and education fields
        elementarySchoolTextView.setEnabled(elementaryCheckBox.isChecked());
        elementarySchoolEditText.setEnabled(elementaryCheckBox.isChecked());
        elementaryEducationTextView.setEnabled(elementaryCheckBox.isChecked());
        elementaryEducationEditText.setEnabled(elementaryCheckBox.isChecked());

        // Enable/disable secondary school name and education fields
        secondarySchoolTextView.setEnabled(secondaryCheckBox.isChecked());
        secondarySchoolEditText.setEnabled(secondaryCheckBox.isChecked());
        secondaryEducationTextView.setEnabled(secondaryCheckBox.isChecked());
        secondaryEducationEditText.setEnabled(secondaryCheckBox.isChecked());

        // Enable/disable vocational school name and education fields
        vocationalSchoolTextView.setEnabled(vocationalCheckBox.isChecked());
        vocationalSchoolEditText.setEnabled(vocationalCheckBox.isChecked());
        vocationalEducationTextView.setEnabled(vocationalCheckBox.isChecked());
        vocationalEducationEditText.setEnabled(vocationalCheckBox.isChecked());

        // Enable/disable graduate school name and education fields
        graduateSchoolTextView.setEnabled(graduateCheckBox.isChecked());
        graduateSchoolEditText.setEnabled(graduateCheckBox.isChecked());
        graduateEducationTextView.setEnabled(graduateCheckBox.isChecked());
        graduateEducationEditText.setEnabled(graduateCheckBox.isChecked());

        // Enable/disable college school name and education fields
        collegeSchoolTextView.setEnabled(collegeCheckBox.isChecked());
        collegeSchoolEditText.setEnabled(collegeCheckBox.isChecked());
        collegeEducationTextView.setEnabled(collegeCheckBox.isChecked());
        collegeEducationEditText.setEnabled(collegeCheckBox.isChecked());
    }

    public void onSubmitClicked(View view) {
        String elementarySchool = "";
        String elementaryEducation = "";
        String secondarySchool = "";
        String secondaryEducation = "";
        String vocationalSchool = "";
        String vocationalEducation = "";
        String graduateSchool = "";
        String graduateEducation = "";
        String collegeSchool = "";
        String collegeEducation = "";

        if (elementaryCheckBox.isChecked()) {
            elementarySchool = elementarySchoolEditText.getText().toString().trim();
            elementaryEducation = elementaryEducationEditText.getText().toString().trim();
        }

        if (secondaryCheckBox.isChecked()) {
            secondarySchool = secondarySchoolEditText.getText().toString().trim();
            secondaryEducation = secondaryEducationEditText.getText().toString().trim();
        }

        if (vocationalCheckBox.isChecked()) {
            vocationalSchool = vocationalSchoolEditText.getText().toString().trim();
            vocationalEducation = vocationalEducationEditText.getText().toString().trim();
        }

        if (graduateCheckBox.isChecked()) {
            graduateSchool = graduateSchoolEditText.getText().toString().trim();
            graduateEducation = graduateEducationEditText.getText().toString().trim();
        }

        if (collegeCheckBox.isChecked()) {
            collegeSchool = collegeSchoolEditText.getText().toString().trim();
            collegeEducation = collegeEducationEditText.getText().toString().trim();
        }

        // Check if all necessary information is filled in
        if (elementaryCheckBox.isChecked() && (elementarySchool.isEmpty() || elementaryEducation.isEmpty())) {
            showToast("Please fill in all necessary information for Elementary.");
            return;
        }

        if (secondaryCheckBox.isChecked() && (secondarySchool.isEmpty() || secondaryEducation.isEmpty())) {
            showToast("Please fill in all necessary information for Secondary.");
            return;
        }

        if (vocationalCheckBox.isChecked() && (vocationalSchool.isEmpty() || vocationalEducation.isEmpty())) {
            showToast("Please fill in all necessary information for Vocational.");
            return;
        }

        if (graduateCheckBox.isChecked() && (graduateSchool.isEmpty() || graduateEducation.isEmpty())) {
            showToast("Please fill in all necessary information for Graduate.");
            return;
        }

        if (collegeCheckBox.isChecked() && (collegeSchool.isEmpty() || collegeEducation.isEmpty())) {
            showToast("Please fill in all necessary information for College.");
            return;
        }
        Bundle formData = getIntent().getExtras();
        formData.putString("elementarySchool", elementarySchool);
        formData.putString("elementaryEducation", elementaryEducation);
        formData.putString("secondarySchool", secondarySchool);
        formData.putString("secondaryEducation", secondaryEducation);
        formData.putString("vocationalSchool", vocationalSchool);
        formData.putString("vocationalEducation", vocationalEducation);
        formData.putString("graduateSchool", graduateSchool);
        formData.putString("graduateEducation", graduateEducation);
        formData.putString("collegeSchool", collegeSchool);
        formData.putString("collegeEducation", collegeEducation);

        Intent intent = new Intent(EducationalActivity.this, CriminalActivity.class);
        intent.putExtras(formData);
        startActivity(intent);

        showToast("Form submitted successfully!");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
