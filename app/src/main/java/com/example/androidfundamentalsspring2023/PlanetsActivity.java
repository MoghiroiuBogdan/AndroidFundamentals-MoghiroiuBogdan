package com.example.androidfundamentalsspring2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

public class PlanetsActivity extends AppCompatActivity {
    private List<Planet> planets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);
    }

}