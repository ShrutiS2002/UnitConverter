package com.example.converter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    private AdView madview;
    TextView output;
    EditText EnterNum;
    Button miles;
    Button meters;
    Button kilometers;
    Button centimeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        /*madview = findViewById(R.id.adView);
        //madview.setAdSize(AdSize.BANNER);
        //madview.setAdUnitId("ca-app-pub-3940256099942544~3347511713");
        AdRequest adRequest = new AdRequest.Builder().build();
        madview.loadAd(adRequest);*/

        output = findViewById(R.id.output);
        EnterNum = findViewById(R.id.editTextNumberDecimal);
        miles = findViewById(R.id.miles);
        meters = findViewById(R.id.meters);
        kilometers = findViewById(R.id.kilometer);
        centimeter = findViewById(R.id.centimeters);

        meters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = EnterNum.getText().toString();
                int number = Integer.parseInt(num);
                double meters = (number * 1000);
                output.setText("Value in Meters:" + meters );
            }
        });

        centimeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = EnterNum.getText().toString();
                int number = Integer.parseInt(num);
                double centimeter = (number * 100);
                output.setText("Value in Centimeter:"+ centimeter);
            }
        });

        kilometers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = EnterNum.getText().toString();
                int number = Integer.parseInt(num);
                double kilometers = (number / 1000);
                output.setText("Value in Kilometers:"+ kilometers);
            }
        });

        miles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = EnterNum.getText().toString();
                int number = Integer.parseInt(num);
                double miles = (number / 1.609);
                output.setText("Value in Miles:"+ miles);
            }
        });

    }
}