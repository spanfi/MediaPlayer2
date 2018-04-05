package com.example.android.mediaplayer2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the category
        final TextView rock = findViewById(R.id.rock);
        TextView classic = findViewById(R.id.classic);
        TextView jazz = findViewById(R.id.jazz);
        TextView electronic = findViewById(R.id.electronic);

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rockIntent = new Intent(MainActivity.this, RockActivity.class);
                startActivity(rockIntent);
            }
        });

        classic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent classicIntent = new Intent(MainActivity.this, ClassicActivity.class);
                startActivity(classicIntent);
            }
        });

        jazz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jazzIntent = new Intent(MainActivity.this, JazzActivity.class);
                startActivity(jazzIntent);
            }
        });

        electronic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent electronicIntent = new Intent(MainActivity.this, ElectronicActivity.class);
                startActivity(electronicIntent);
            }
        });


    }
}
