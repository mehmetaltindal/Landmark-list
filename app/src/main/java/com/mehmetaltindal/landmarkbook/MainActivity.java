package com.mehmetaltindal.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static Bitmap selectedImage;
    ListView landmarkView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Data

        ListView landmarkView = findViewById(R.id.landmarkView);
        final ArrayList<String> landmarksName = new ArrayList<>();
        landmarksName.add("Castle of Edinburgh");
        landmarksName.add("London Bridge");
        landmarksName.add("Brooklyn Bridge");
        landmarksName.add("Tower of Pera");

        final ArrayList<String> countryName = new ArrayList<>();
        countryName.add("Scotland");
        countryName.add("England");
        countryName.add("Unite States of America");
        countryName.add("Turkey");

        Bitmap brooklyn = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.brooklyn);
        Bitmap galata = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.galata);
        Bitmap edinburgh = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.edinburgh);
        Bitmap london = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.london);

        final ArrayList<Bitmap> landmarkImages =  new ArrayList<>();
        landmarkImages.add(edinburgh);
        landmarkImages.add(london);
        landmarkImages.add(brooklyn);
        landmarkImages.add(galata);


        //ListView

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landmarksName);

        landmarkView.setAdapter(arrayAdapter);
        landmarkView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //System.out.println(landmarksName.get(i));
                //System.out.println(countryName.get(i));

                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name", landmarksName.get(i));
                intent.putExtra("country",countryName.get(i));
                selectedImage = landmarkImages.get(i);

                startActivity(intent);
            }
        });
    }
}