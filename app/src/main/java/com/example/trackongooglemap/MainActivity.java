package com.example.trackongooglemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText source, destination;
    Button btn_track;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        source = findViewById(R.id.source);
        destination = findViewById(R.id.destination);
        btn_track = findViewById(R.id.btn_track);

        btn_track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xsource = source.getText().toString().trim();
                String xdestination = destination.getText().toString().trim();

                if (xsource.equals("") && xdestination.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter to form your location", Toast.LENGTH_SHORT).show();
                } else {
                    displayTrack(xsource, xdestination);
                }


            }
        });


    }

    private void displayTrack(String xsource, String xdestination) {
        try {
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + xsource + "/" + xdestination);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
