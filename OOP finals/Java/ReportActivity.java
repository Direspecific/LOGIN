package com.example.afinal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReportActivity extends AppCompatActivity {
    private TextView reportTextView;
    private ImageView photoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        // Initialize views
        reportTextView = findViewById(R.id.reportTextView);
        photoImageView = findViewById(R.id.photoImageView);

        // Retrieve the form data bundle
        Bundle formData = getIntent().getExtras();

        // Generate the report text
        String report = generateReport(formData);

        // Display the report
        reportTextView.setText(report);

        // Display the photo
        byte[] photoByteArray = formData.getByteArray("photo");
        if (photoByteArray != null) {
            Bitmap photoBitmap = BitmapFactory.decodeByteArray(photoByteArray, 0, photoByteArray.length);
            photoImageView.setImageBitmap(photoBitmap);
        }

        setTitle("Form Report");
    }

    private String generateReport(Bundle formData) {
        StringBuilder reportBuilder = new StringBuilder();

        // Retrieve the personal data from the bundle
        String gender = formData.getString("gender");
        String maritalStatus = formData.getString("maritalStatus");
        String firstName = formData.getString("firstName");
        String lastName = formData.getString("lastName");
        String email = formData.getString("email");
        String phone = formData.getString("phone");
        String height = formData.getString("height");
        String weight = formData.getString("weight");
        String pagibig = formData.getString("pagibig");
        String philhealth = formData.getString("philhealth");
        String tin = formData.getString("tin");
        String gsis = formData.getString("gsis");
        String emergencyName = formData.getString("emergencyName");
        String relationship = formData.getString("relationship");
        String contact = formData.getString("contact");

        // Retrieve the education data from the bundle
        String elementarySchool = formData.getString("elementarySchool");
        String elementaryEducation = formData.getString("elementaryEducation");
        String secondarySchool = formData.getString("secondarySchool");
        String secondaryEducation = formData.getString("secondaryEducation");
        String vocationalSchool = formData.getString("vocationalSchool");
        String vocationalEducation = formData.getString("vocationalEducation");
        String graduateSchool = formData.getString("graduateSchool");
        String graduateEducation = formData.getString("graduateEducation");
        String collegeSchool = formData.getString("collegeSchool");
        String collegeEducation = formData.getString("collegeEducation");

        // Retrieve the criminal data from the bundle
        boolean administrativeSelected = formData.getBoolean("administrativeSelected");
        String adminDetails = formData.getString("adminDetails");
        boolean criminalChargedSelected = formData.getBoolean("criminalChargedSelected");
        String criminalChargedDetails = formData.getString("criminalChargedDetails");
        boolean convictedSelected = formData.getBoolean("convictedSelected");
        String convictedDetails = formData.getString("convictedDetails");
        boolean indigenousSelected = formData.getBoolean("indigenousSelected");
        String indigenousDetails = formData.getString("indigenousDetails");
        boolean disabilitySelected = formData.getBoolean("disabilitySelected");
        String disabilityDetails = formData.getString("disabilityDetails");
        boolean soloParentSelected = formData.getBoolean("soloParentSelected");
        String soloParentDetails = formData.getString("soloParentDetails");

        // Append the personal data to the report
        reportBuilder.append("Personal Information").append("\n");
        reportBuilder.append("Gender: ").append(gender).append("\n");
        reportBuilder.append("Marital Status: ").append(maritalStatus).append("\n");
        reportBuilder.append("First Name: ").append(firstName).append("\n");
        reportBuilder.append("Last Name: ").append(lastName).append("\n");
        reportBuilder.append("Email: ").append(email).append("\n");
        reportBuilder.append("Phone: ").append(phone).append("\n");
        reportBuilder.append("Height: ").append(height).append("\n");
        reportBuilder.append("Weight: ").append(weight).append("\n");
        reportBuilder.append("Pag-IBIG: ").append(pagibig).append("\n");
        reportBuilder.append("PhilHealth: ").append(philhealth).append("\n");
        reportBuilder.append("TIN: ").append(tin).append("\n");
        reportBuilder.append("GSIS: ").append(gsis).append("\n");
        reportBuilder.append("Emergency Contact").append("\n");
        reportBuilder.append("Name: ").append(emergencyName).append("\n");
        reportBuilder.append("Relationship: ").append(relationship).append("\n");
        reportBuilder.append("Contact: ").append(contact).append("\n");

        // Append the education data to the report
        reportBuilder.append("\n");
        reportBuilder.append("Education Information").append("\n");

        if (elementarySchool != null && elementaryEducation != null) {
            reportBuilder.append("Elementary School: ").append(elementarySchool).append("\n");
            reportBuilder.append("Elementary Education: ").append(elementaryEducation).append("\n");
        }

        if (secondarySchool != null && secondaryEducation != null) {
            reportBuilder.append("Secondary School: ").append(secondarySchool).append("\n");
            reportBuilder.append("Secondary Education: ").append(secondaryEducation).append("\n");
        }

        if (vocationalSchool != null && vocationalEducation != null) {
            reportBuilder.append("Vocational School: ").append(vocationalSchool).append("\n");
            reportBuilder.append("Vocational Education: ").append(vocationalEducation).append("\n");
        }

        if (graduateSchool != null && graduateEducation != null) {
            reportBuilder.append("Graduate School: ").append(graduateSchool).append("\n");
            reportBuilder.append("Graduate Education: ").append(graduateEducation).append("\n");
        }

        if (collegeSchool != null && collegeEducation != null) {
            reportBuilder.append("College School: ").append(collegeSchool).append("\n");
            reportBuilder.append("College Education: ").append(collegeEducation).append("\n");
        }

        // Append the criminal data to the report
        reportBuilder.append("\n");
        reportBuilder.append("Criminal Information").append("\n");

        if (administrativeSelected) {
            reportBuilder.append("Administrative Record: Yes").append("\n");
            reportBuilder.append("Administrative Record Details: ").append(adminDetails).append("\n");
        } else {
            reportBuilder.append("Administrative Record: No").append("\n");
        }

        if (criminalChargedSelected) {
            reportBuilder.append("Criminal Charged: Yes").append("\n");
            reportBuilder.append("Criminal Charged Details: ").append(criminalChargedDetails).append("\n");
        } else {
            reportBuilder.append("Criminal Charged: No").append("\n");
        }

        if (convictedSelected) {
            reportBuilder.append("Convicted: Yes").append("\n");
            reportBuilder.append("Convicted Details: ").append(convictedDetails).append("\n");
        } else {
            reportBuilder.append("Convicted: No").append("\n");
        }

        // Append the additional information to the report
        reportBuilder.append("\n");

        if (indigenousSelected) {
            reportBuilder.append("Indigenous: Yes").append("\n");
            reportBuilder.append("Indigenous Details: ").append(indigenousDetails).append("\n");
        } else {
            reportBuilder.append("Indigenous: No").append("\n");
        }

        if (disabilitySelected) {
            reportBuilder.append("Disability: Yes").append("\n");
            reportBuilder.append("Disability Details: ").append(disabilityDetails).append("\n");
        } else {
            reportBuilder.append("Disability: No").append("\n");
        }

        if (soloParentSelected) {
            reportBuilder.append("Solo Parent: Yes").append("\n");
            reportBuilder.append("Solo Parent Details: ").append(soloParentDetails).append("\n");
        } else {
            reportBuilder.append("Solo Parent: No").append("\n");
        }

        return reportBuilder.toString();
    }
}
