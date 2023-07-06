package com.example.afinal;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

public class CriminalActivity extends AppCompatActivity {

    private RadioButton administrativeYesRadioButton, administrativeNoRadioButton;
    private RadioButton criminalChargedYesRadioButton, criminalChargedNoRadioButton;
    private RadioButton convictedYesRadioButton, convictedNoRadioButton;
    private RadioButton indigenousYesRadioButton, indigenousNoRadioButton;
    private RadioButton disabilityYesRadioButton, disabilityNoRadioButton;
    private RadioButton soloParentYesRadioButton, soloParentNoRadioButton;
    private EditText adminEditText, criminalChargedEditText, convictedEditText;
    private EditText indigenousEditText, disabilityEditText, soloParentEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criminal);
        setTitle("Criminal Background");

        administrativeYesRadioButton = findViewById(R.id.administrativeYesRadioButton);
        administrativeNoRadioButton = findViewById(R.id.administrativeNoRadioButton);
        criminalChargedYesRadioButton = findViewById(R.id.criminalChargedYesRadioButton);
        criminalChargedNoRadioButton = findViewById(R.id.criminalChargedNoRadioButton);
        convictedYesRadioButton = findViewById(R.id.convictedYesRadioButton);
        convictedNoRadioButton = findViewById(R.id.convictedNoRadioButton);
        indigenousYesRadioButton = findViewById(R.id.indigenousYesRadioButton);
        indigenousNoRadioButton = findViewById(R.id.indigenousNoRadioButton);
        disabilityYesRadioButton = findViewById(R.id.disabilityYesRadioButton);
        disabilityNoRadioButton = findViewById(R.id.disabilityNoRadioButton);
        soloParentYesRadioButton = findViewById(R.id.soloParentYesRadioButton);
        soloParentNoRadioButton = findViewById(R.id.soloParentNoRadioButton);
        adminEditText = findViewById(R.id.adminEditText);
        criminalChargedEditText = findViewById(R.id.criminalChargedEditText);
        convictedEditText = findViewById(R.id.convictedEditText);
        indigenousEditText = findViewById(R.id.indigenousEditText);
        disabilityEditText = findViewById(R.id.disabilityEditText);
        soloParentEditText = findViewById(R.id.soloParentEditText);
        submitButton = findViewById(R.id.submitButton);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if (ContextCompat.checkSelfPermission(CriminalActivity.this,
                    Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(CriminalActivity.this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }

        administrativeYesRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            adminEditText.setEnabled(isChecked);
            adminEditText.setText(isChecked ? "" : null);
        });

        administrativeNoRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            adminEditText.setEnabled(!isChecked);
            adminEditText.setText(isChecked ? null : "");
        });

        criminalChargedYesRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            criminalChargedEditText.setEnabled(isChecked);
            criminalChargedEditText.setText(isChecked ? "" : null);
        });

        criminalChargedNoRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            criminalChargedEditText.setEnabled(!isChecked);
            criminalChargedEditText.setText(isChecked ? null : "");
        });

        convictedYesRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            convictedEditText.setEnabled(isChecked);
            convictedEditText.setText(isChecked ? "" : null);
        });

        convictedNoRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            convictedEditText.setEnabled(!isChecked);
            convictedEditText.setText(isChecked ? null : "");
        });

        indigenousYesRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            indigenousEditText.setEnabled(isChecked);
            indigenousEditText.setText(isChecked ? "" : null);
        });

        indigenousNoRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            indigenousEditText.setEnabled(!isChecked);
            indigenousEditText.setText(isChecked ? null : "");
        });

        disabilityYesRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            disabilityEditText.setEnabled(isChecked);
            disabilityEditText.setText(isChecked ? "" : null);
        });

        disabilityNoRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            disabilityEditText.setEnabled(!isChecked);
            disabilityEditText.setText(isChecked ? null : "");
        });

        soloParentYesRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            soloParentEditText.setEnabled(isChecked);
            soloParentEditText.setText(isChecked ? "" : null);
        });

        soloParentNoRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            soloParentEditText.setEnabled(!isChecked);
            soloParentEditText.setText(isChecked ? null : "");
        });

        submitButton.setOnClickListener(v -> {
            makeNotification();
            boolean allFieldsFilled = true;

            boolean administrativeSelected = administrativeYesRadioButton.isChecked();
            String adminDetails = adminEditText.getText().toString().trim();

            boolean criminalChargedSelected = criminalChargedYesRadioButton.isChecked();
            String criminalChargedDetails = criminalChargedEditText.getText().toString().trim();

            boolean convictedSelected = convictedYesRadioButton.isChecked();
            String convictedDetails = convictedEditText.getText().toString().trim();

            boolean indigenousSelected = indigenousYesRadioButton.isChecked();
            String indigenousDetails = indigenousEditText.getText().toString().trim();

            boolean disabilitySelected = disabilityYesRadioButton.isChecked();
            String disabilityDetails = disabilityEditText.getText().toString().trim();

            boolean soloParentSelected = soloParentYesRadioButton.isChecked();
            String soloParentDetails = soloParentEditText.getText().toString().trim();

            if (administrativeSelected && adminDetails.isEmpty()) {
                adminEditText.setError("Please provide details for the administrative background");
                allFieldsFilled = false;
            }

            if (criminalChargedSelected && criminalChargedDetails.isEmpty()) {
                criminalChargedEditText.setError("Please provide details for the criminal charged background");
                allFieldsFilled = false;
            }

            if (convictedSelected && convictedDetails.isEmpty()) {
                convictedEditText.setError("Please provide details for the convicted background");
                allFieldsFilled = false;
            }

            if (indigenousSelected && indigenousDetails.isEmpty()) {
                indigenousEditText.setError("Please provide details for the indigenous background");
                allFieldsFilled = false;
            }

            if (disabilitySelected && disabilityDetails.isEmpty()) {
                disabilityEditText.setError("Please provide details for the disability background");
                allFieldsFilled = false;
            }

            if (soloParentSelected && soloParentDetails.isEmpty()) {
                soloParentEditText.setError("Please provide details for the solo parent");
                allFieldsFilled = false;
            }


            if (allFieldsFilled) {
                // If all necessary information is provided, create a bundle and pass it to the next activity
                Bundle formData = getIntent().getExtras();
                formData.putBoolean("administrativeSelected", administrativeSelected);
                formData.putString("adminDetails", adminDetails);
                formData.putBoolean("criminalChargedSelected", criminalChargedSelected);
                formData.putString("criminalChargedDetails", criminalChargedDetails);
                formData.putBoolean("convictedSelected", convictedSelected);
                formData.putString("convictedDetails", convictedDetails);
                formData.putBoolean("indigenousSelected", indigenousSelected);
                formData.putString("indigenousDetails", indigenousDetails);
                formData.putBoolean("disabilitySelected", disabilitySelected);
                formData.putString("disabilityDetails", disabilityDetails);
                formData.putBoolean("soloParentSelected", soloParentSelected);
                formData.putString("soloParentDetails", soloParentDetails);

                Intent intent = new Intent(this, ReportActivity.class);
                intent.putExtras(formData);
                startActivity(intent);
                makeNotification();
            } else {
                Toast.makeText(this, "Please fill in all necessary information", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void makeNotification() {
        String channelId = "CHANNEL_ID_NOTIFICATION";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Form Submitted")
                .setContentText("Your form has been submitted successfully.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        Intent notificationIntent = new Intent(this, ReportActivity.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        notificationIntent = new Intent(this, ReportActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, PendingIntent.FLAG_MUTABLE);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(channelId);
            if (notificationChannel == null) {
                int importance = NotificationManager.IMPORTANCE_HIGH;
                notificationChannel = new NotificationChannel(channelId, "some description", importance);
                notificationChannel.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        notificationManager.notify(0, builder.build());
    }
}
