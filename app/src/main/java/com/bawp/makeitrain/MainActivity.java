package com.bawp.makeitrain;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button makeItRain;
    private TextView moneyValue;
    private Button showInfo;
    private int moneyCounter=0;
    private ConstraintLayout layout1;
    private  Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_layout);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                 Toast.makeText(, "Hello",Toast.LENGTH_LONG).show();
                Log.d("2nd","Hello");
            }
        });
//        makeItRain = findViewById(R.id.buttonMakeItRain);
//        moneyValue = findViewById(R.id.textViewMoneyValue);
//        layout1 = (ConstraintLayout) findViewById(R.id.layout12);
//        makeItRain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }

    public void showMoney(View view) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        moneyCounter+=1000;
        if(moneyCounter==5000){
            layout1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
        }
        if(moneyCounter==7000){
            layout1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
        }
        moneyValue.setText(String.valueOf(nf.format(moneyCounter)));
    }

    public void showInfo(View view) {
        Snackbar.make(moneyValue,R.string.app_info,Snackbar.LENGTH_LONG).
        setAction("more", view1 ->{
            Log.d("HAHA","New app");
        }).show();

    }

    public void reset(View view) {
        Toast.makeText(MainActivity.this, "App Reset", Toast.LENGTH_SHORT).show();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        moneyCounter=0;
        moneyValue.setText(String.valueOf(nf.format(moneyCounter)));
        layout1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.background1));
    }
}