package com.balpir.project;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.balpir.project.R;

public class cobaActivity extends AppCompatActivity {
    EditText lat,lng, ketiga, keempat,kelima, keenam, ketujuh;
    Button btn_carilat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);


        lat = findViewById(R.id.tv_lattt);
        lng = findViewById(R.id.tv_longgg);
        ketiga = findViewById(R.id.ketiga);
        keempat = findViewById(R.id.keempat);
        kelima = findViewById(R.id.kelima);
        keenam = findViewById(R.id.keenam);
        ketujuh = findViewById(R.id.ketujuh);
        btn_carilat = findViewById(R.id.btn_carilatt);


        btn_carilat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double pi = 3.14159265358979323846;
                Double lat1 = 3.3159187;
                Double lng1 = 99.1490449;
                Double lat2 = 3.3344348;
                Double lng2 = 99.133336;
                Double R = 6371e3;

                Double latRad1 = lat1 * (pi / 180); // lat tujuan dalam bentuk radian
                Double latRad2 = lat2 * (pi / 180);
                Double aa = lat2 - lat1;
                double aaa = pi / 180 ;
                Double deltaLatRad = aa * aaa;
                Double bb = lng2 - lng1;
                Double deltaLongRad = bb * aaa;


                //rumus raversine
                Double a = Math.sin(deltaLatRad / 2) * Math.sin(deltaLatRad / 2) + Math.cos(latRad1) * Math.cos(latRad2) * Math.sin(deltaLongRad/2) * Math.sin(deltaLongRad/2);
                Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

                //a = sin(deltaLatRad / 2) * sin(deltaLatRad / 2) + cos(latRad1) * cos(latRad2) * sin(deltaLongRad/2) * sin(deltaLongRad/2);
                // 6371e3 * ( 2 * atan2(sqrt(a),sqrt(1-a)
                Double s = R * c; //jarak dalam meter


                lat.setText(String.format("%.15f", deltaLatRad));
                lng.setText(String.valueOf(latRad1));
                ketiga.setText(String.valueOf(latRad2));
                keempat.setText(String.format("%.15f", deltaLongRad));
                kelima.setText(String.format("%.15f", a));
                keenam.setText(String.format("%.15f", c));
                ketujuh.setText(String.valueOf(s));
            }
        });
    }
}