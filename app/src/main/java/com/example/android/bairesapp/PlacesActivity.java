package com.example.android.bairesapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Remove status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Remove action bar
        getSupportActionBar().hide();

        setContentView(R.layout.activity_places);

        final Context context = getApplicationContext();

        final Bundle bundle = getIntent().getExtras();

        // Attach a onClickListener to the floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse(bundle.getString("Coordinates"));

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        ImageView backButton = (ImageView) findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Reference Image of place
        ImageView placeImage = (ImageView) findViewById(R.id.place_image);
        // Reference Name of place
        TextView placeName = (TextView) findViewById(R.id.place_name);
        // Reference Type of place
        TextView typeOfPlace = (TextView) findViewById(R.id.type_of_place);
        // Reference Place description
        TextView placeDescription = (TextView) findViewById(R.id.place_description);

        placeImage.setImageResource(bundle.getInt("PlaceImage"));
        placeName.setText(bundle.getInt("Name"));
        typeOfPlace.setText(bundle.getInt("TypeOfPlace"));
        placeDescription.setText(bundle.getInt("PlaceDescription"));
    }

}
