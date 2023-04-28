package com.example.androidfundamentalsspring2023;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String ACTIVITY ="Main Activity" ;
    private WebView webViewSample;
    private Spinner spinnerPlanets;
    private List<String> dataSourcePlanets;
    protected static final String URL_Andorid = "https://www.android.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webViewSample = findViewById(R.id.webViewAndroid);
        webViewSample.getSettings().setJavaScriptEnabled(true);
        webViewSample.loadUrl(URL_Andorid);

        spinnerPlanets = findViewById(R.id.SpinnerPlanets);
        spinnerPlanets.setOnItemSelectedListener(this);
        populateSpinner();
    }

    private void populateSpinner() {
        dataSourcePlanets = getPlantes();
        ArrayAdapter<String> adapterForPlanets= getPlanetAdapter(dataSourcePlanets);
        spinnerPlanets.setAdapter(adapterForPlanets);
    }

    //step 1: add Spinner in the xml - DONE
    //step 2: get the data source(list of planets)
    //step 3: create the default adapter
    //step 4:set new adapter to the Spinner

    private List<String> getPlantes(){
        List<String> planet = new ArrayList<>();
        planet.add("Earth");
        planet.add("Saturn");
        planet.add("Jupiter");
        planet.add("Pluto");
        planet.add("Mercury");
        planet.add("Uranus");
        planet.add("Neptune");
        planet.add("Mars");
        planet.add("Venus");

    return planet;
    }

    private ArrayAdapter<String> getPlanetAdapter(List<String> planets){
        return new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planets);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedPlanet = dataSourcePlanets.get(position);
        Log.e(ACTIVITY, selectedPlanet);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void startLoginOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}