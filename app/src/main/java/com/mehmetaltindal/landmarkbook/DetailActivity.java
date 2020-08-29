package com.mehmetaltindal.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.mehmetaltindal.landmarkbook.MainActivity.selectedImage;

public class DetailActivity extends AppCompatActivity {
    ImageView display;
    TextView textLandmarks,textCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        display = findViewById(R.id.display);
        textLandmarks = findViewById(R.id.textLandmarks);
        textCountry = findViewById(R.id.textCountry);

        Intent intent = getIntent();
        String landmarks = intent.getStringExtra("name");
        textLandmarks.setText(landmarks);
        String country = intent.getStringExtra("country");
        textCountry.setText(country);

        display.setImageBitmap(selectedImage);


    }
}