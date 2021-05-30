package com.example.luckyshoping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ProductActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Intent intent = getIntent();

        fragmentManager = getSupportFragmentManager();
        startFragment(intent.getStringExtra("category"));

    }

    void startFragment(String category) {

        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, new ProductFragment(category))
                .commit();
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
//                startFragment("cat_processors");
                return true;
            case R.id.cat_motherboards:
//                startFragment("cat_motherboards");
                return true;
            case R.id.cat_ssd:
//                startFragment("cat_ssd");
                return true;
            case R.id.cat_RAM_memory:
//                startFragment("cat_RAM_memory");
                return true;
            case R.id.cat_video_cards:
//                startFragment("cat_video_cards");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}