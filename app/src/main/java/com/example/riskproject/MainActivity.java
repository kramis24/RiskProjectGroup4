package com.example.riskproject;

/**
 * ActivityMain: ties everything together
 *
 * @author Dylan Kramis, Phi Nguyen, Charlie Benning
 * @version 9/19/2021 GUI Prototype
 */

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializes mapView object
        MapView mapView = (MapView) findViewById(R.id.mapView);
    }
}