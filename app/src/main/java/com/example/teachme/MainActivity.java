package com.example.teachme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyListener {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner dropdown = findViewById(R.id.spinner);
        String[] items = new String[]{"Select letter", "a", "b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setSelection(0);
        PaintView p = (PaintView) findViewById(R.id.pnt);
        p.setlistener(this);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int resource = R.drawable.a;///7000051  b=7000053
                ImageView letter = (ImageView) findViewById(R.id.imageView);
                letter.setImageResource(resource+position-1);

                PaintView paintview = (PaintView) findViewById(R.id.pnt);
                Log.i("", String.valueOf(position-1+65));
                paintview.letter.caracter=Character.toString((char) (position-1+65));
                paintview.pos=position;
                //Log.i("", paintview.letter.caracter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        PaintView paintview = (PaintView) findViewById(R.id.pnt);


    }

    public void b1click(View view) {
        PaintView paintview = (PaintView) findViewById(R.id.pnt);
        paintview.clear();

    }



    @Override
    public void callback(int position) {
        position++;
        int resource = R.drawable.a;///7000051  b=7000053
        ImageView letter = (ImageView) findViewById(R.id.imageView);
        letter.setImageResource(resource+position-1);

        PaintView paintview = (PaintView) findViewById(R.id.pnt);
        Log.i("", String.valueOf(position-1+65));
        paintview.letter.caracter=Character.toString((char) (position-1+65));
        paintview.pos=position;
    }
}