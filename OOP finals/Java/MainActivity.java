package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private Button photoButton, submitButton;
    private ImageView photoImageView;
    private RadioGroup genderRadioGroup, maritalStatusRadioGroup;
    private RadioButton maleRadioButton, femaleRadioButton, singleRadioButton, marriedRadioButton,
            separatedRadioButton, widowedRadioButton, othersRadioButton;
    private EditText firstNameEditText, lastNameEditText, phoneEditText, heightEditText,
            weightEditText, pagibigEditText, philhealthEditText, tinEditText, gsisEditText,
            contactEditText, emergencyNameEditText, emailEditText;
    private Spinner relationshipSpinner;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Bitmap photoBitmap;
    private Bundle formData;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Personal Background");

        // Initialize views
        photoButton = findViewById(R.id.photoButton);
        photoImageView = findViewById(R.id.photoImageView);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);
        maritalStatusRadioGroup = findViewById(R.id.maritalStatusRadioGroup);
        singleRadioButton = findViewById(R.id.singleRadioButton);
        marriedRadioButton = findViewById(R.id.marriedRadioButton);
        separatedRadioButton = findViewById(R.id.separatedRadioButton);
        widowedRadioButton = findViewById(R.id.widowedRadioButton);
        othersRadioButton = findViewById(R.id.othersRadioButton);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        pagibigEditText = findViewById(R.id.pagibigEditText);
        philhealthEditText = findViewById(R.id.philhealthEditText);
        tinEditText = findViewById(R.id.tinEditText);
        gsisEditText = findViewById(R.id.gsisEditText);
        emergencyNameEditText = findViewById(R.id.emergencyNameEditText);
        relationshipSpinner = findViewById(R.id.relationshipSpinner);
        contactEditText = findViewById(R.id.contactEditText);
        emailEditText = findViewById(R.id.emailEditText);
        submitButton = findViewById(R.id.submitButton);

        // Set click listener for photoButton
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to launch the camera app
                Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                // Check if there is a camera app available to handle the intent
                if (takePhotoIntent.resolveActivity(getPackageManager()) != null) {
                    // Start the camera activity and wait for the result
                    startActivityForResult(takePhotoIntent, REQUEST_IMAGE_CAPTURE);
                } else {
                    Toast.makeText(MainActivity.this, "No camera app available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set click listener for submitButton
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    // Create a Bundle to store the form data
                    formData = new Bundle();

                    // Retrieve the selected gender
                    int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
                    RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
                    String gender = selectedGenderRadioButton.getText().toString();
                    formData.putString("gender", gender);

                    // Retrieve the selected marital status
                    int selectedMaritalStatusId = maritalStatusRadioGroup.getCheckedRadioButtonId();
                    RadioButton selectedMaritalStatusRadioButton = findViewById(selectedMaritalStatusId);
                    String maritalStatus = selectedMaritalStatusRadioButton.getText().toString();
                    formData.putString("maritalStatus", maritalStatus);

                    // Retrieve the text values from EditText fields
                    String firstName = firstNameEditText.getText().toString().trim();
                    formData.putString("firstName", firstName);

                    String lastName = lastNameEditText.getText().toString().trim();
                    formData.putString("lastName", lastName);

                    String email = emailEditText.getText().toString().trim();
                    formData.putString("email", email);

                    String phone = phoneEditText.getText().toString().trim();
                    formData.putString("phone", phone);

                    String height = heightEditText.getText().toString().trim();
                    formData.putString("height", height);

                    String weight = weightEditText.getText().toString().trim();
                    formData.putString("weight", weight);

                    String pagibig = pagibigEditText.getText().toString().trim();
                    formData.putString("pagibig", pagibig);

                    String philhealth = philhealthEditText.getText().toString().trim();
                    formData.putString("philhealth", philhealth);

                    String tin = tinEditText.getText().toString().trim();
                    formData.putString("tin", tin);

                    String gsis = gsisEditText.getText().toString().trim();
                    formData.putString("gsis", gsis);

                    String emergencyName = emergencyNameEditText.getText().toString().trim();
                    formData.putString("emergencyName", emergencyName);

                    String relationship = relationshipSpinner.getSelectedItem().toString();
                    formData.putString("relationship", relationship);

                    String contact = contactEditText.getText().toString().trim();
                    formData.putString("contact", contact);

                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    photoBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte[] photoByteArray = stream.toByteArray();
                    formData.putByteArray("photo", photoByteArray);

                    // Create an intent to start the next activity
                    Intent intent = new Intent(MainActivity.this, EducationalActivity.class);
                    intent.putExtras(formData);

                    // Start the next activity
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Please fill in all necessary information", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Retrieve the captured image
            Bundle extras = data.getExtras();
            photoBitmap = (Bitmap) extras.get("data");

            // Display the captured image in the ImageView
            photoImageView.setImageBitmap(photoBitmap);
        }
    }

    private boolean validateForm() {
        // Check if all necessary fields are filled
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String height = heightEditText.getText().toString().trim();
        String weight = weightEditText.getText().toString().trim();
        String contact = contactEditText.getText().toString().trim();
        String emergencyName = emergencyNameEditText.getText().toString().trim();

        // Check if gender is selected
        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        boolean isGenderSelected = selectedGenderId != -1;

        // Check if civil status is selected
        int selectedMaritalStatusId = maritalStatusRadioGroup.getCheckedRadioButtonId();
        boolean isMaritalStatusSelected = selectedMaritalStatusId != -1;

        // Check if relationship is selected
        String selectedRelationship = relationshipSpinner.getSelectedItem().toString();
        boolean isRelationshipSelected = !selectedRelationship.equals("Select Relationship");

        return !firstName.isEmpty() && !lastName.isEmpty() && !phone.isEmpty() && !height.isEmpty() &&
                !weight.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !emergencyName.isEmpty() &&
                isGenderSelected && isMaritalStatusSelected && isRelationshipSelected;
    }
}
