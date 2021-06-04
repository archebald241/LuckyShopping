package com.example.luckyshoping;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.luckyshoping.activity.ProductActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonCategory1;
    Button buttonCategory2;
    Button buttonCategory3;
    Button buttonCategory4;
    Button buttonCategory5;

    Intent startIntent;

    static FirebaseDatabase firebaseDatabase;
    private static DatabaseReference ref;

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

        firebaseDatabase = FirebaseDatabase.getInstance();
        ref = firebaseDatabase.getReference("categories");
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

    public static DatabaseReference getRef() {
        return ref;
    }
}