package com.example.luckyshoping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonCategory1;
    Button buttonCategory2;
    Button buttonCategory3;
    Button buttonCategory4;
    Button buttonCategory5;

    Intent startIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCategory1 = findViewById(R.id.but_cat_1);
        buttonCategory2 = findViewById(R.id.but_cat_2);
        buttonCategory3 = findViewById(R.id.but_cat_3);
        buttonCategory4 = findViewById(R.id.but_cat_4);
        buttonCategory5 = findViewById(R.id.but_cat_5);

        buttonCategory1.setOnClickListener(this);
        buttonCategory2.setOnClickListener(this);
        buttonCategory3.setOnClickListener(this);
        buttonCategory4.setOnClickListener(this);
        buttonCategory5.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case R.id.cat_processors:
                setStartIntent("cat_processors");
                return true;
            case R.id.cat_motherboards:
                setStartIntent("cat_motherboards");
                return true;
            case R.id.cat_ssd:
                setStartIntent("cat_ssd");
                return true;
            case R.id.cat_RAM_memory:
                setStartIntent("cat_RAM_memory");
                return true;
            case R.id.cat_video_cards:
                setStartIntent("cat_video_cards");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_cat_1:
                setStartIntent("cat_motherboards");
                break;
            case R.id.but_cat_2:
                setStartIntent("cat_processors");
                break;
            case R.id.but_cat_3:
                setStartIntent("cat_RAM_memory");
                break;
            case R.id.but_cat_4:
                setStartIntent("cat_video_cards");
                break;
            case R.id.but_cat_5:
                setStartIntent("cat_ssd");
                break;
        }
    }

    void setStartIntent(String category) {
        startIntent = new Intent(this, ProductActivity.class);
        startIntent.putExtra("category", category);
        startActivity(startIntent);
    }
}