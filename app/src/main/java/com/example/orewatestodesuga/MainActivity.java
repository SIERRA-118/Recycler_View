package com.example.orewatestodesuga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    GridView MovieList;

    public static String[] Movielist = {
            "Top Gun",
            "Free Guy",
            "Iron man",
            "Batman",
    };


    int logos[] = { R.drawable.topgunlogo,
            R.drawable.freguylt,
            R.drawable.ironman,
            R.drawable.btmnlt,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = findViewById(R.id.textmovi);
        MovieList =  findViewById(R.id.tmgrd);
        Adapter customAdapter = new Adapter(getApplicationContext(),Movielist, logos);
        MovieList.setAdapter(customAdapter);


        MovieList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent =new Intent(MainActivity.this,Top_gun.class);

                    startActivity(intent);
                }

                if (position == 1){
                    Intent intent1 = new Intent(MainActivity.this,Freeguy.class);
                    startActivity(intent1);
                }

                if (position == 2){
                    Intent intent2 = new Intent(MainActivity.this,BAtman.class);
                    startActivity(intent2);

                }

                if (position == 3){
                    Intent intent3 = new Intent(MainActivity.this,batmanbegins.class);
                    startActivity(intent3);
                }
            }
        });
    }
}


