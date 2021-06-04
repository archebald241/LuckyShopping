package com.example.luckyshoping.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.luckyshoping.MainActivity;
import com.example.luckyshoping.ProductLifecycle;
import com.example.luckyshoping.ProductRV;
import com.example.luckyshoping.R;
import com.example.luckyshoping.pojo.Product;
import com.example.luckyshoping.vm.ProductViewModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private static RecyclerView productRV;

    private static ProductViewModel productViewModel;
    String category;

    public static Lifecycle lifecycle;

    private static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        productRV = findViewById(R.id.rv_product);
        productRV.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();

        lifecycle = getLifecycle();
        ProductLifecycle productLifecycle = new ProductLifecycle();
        lifecycle.addObserver(productLifecycle);

        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);


        getDataFromDB(intent.getStringExtra("category"));

    }

    void getDataFromDB(String category) {

        this.category = category;
        count = 0;

        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                productViewModel.deleteVideoCards();

                String path = "";

                switch (category) {
                    case "cat_motherboards":
                        path = "motherboard";
                        break;
                    case "cat_processors":
                        path = "processors";
                        break;
                    case "cat_RAM_memory":
                        path = "ram";
                        break;
                    case "cat_ssd":
                        path = "ssd";
                        break;
                    case "cat_video_cards":
                        path = "video_card";
                        break;

                }

                snapshot = snapshot.child("/" + path);

                for (DataSnapshot ds : snapshot.getChildren()) {

                    Product products = new Product();
                    products.setVideoCardName(String.valueOf(ds.child("name").getValue()));
                    products.setPrice(String.valueOf(ds.child("price").getValue()));
                    products.setVideoCardCapacity(String.valueOf(ds.child("capacity").getValue()));
                    products.setVideoMemoryType(String.valueOf(ds.child("type").getValue()));
                    productViewModel.insertProduct(products);
                    count++;

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        MainActivity.getRef().addValueEventListener(vListener);
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
                if (!category.equals("cat_processors")) {
                    getDataFromDB("cat_processors");
                }
                return true;
            case R.id.cat_motherboards:
                if (!category.equals("cat_motherboards")) {
                    getDataFromDB("cat_motherboards");
                }
                return true;
            case R.id.cat_ssd:
                if (!category.equals("cat_ssd")) {
                    getDataFromDB("cat_ssd");
                }
                return true;
            case R.id.cat_RAM_memory:
                if (!category.equals("cat_RAM_memory")) {
                    getDataFromDB("cat_RAM_memory");
                }
                return true;
            case R.id.cat_video_cards:
                if (!category.equals("cat_video_cards")) {
                    getDataFromDB("cat_video_cards");
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static int getCount() {
        return count;
    }

    public static RecyclerView getProductRV() {
        return productRV;
    }

    public static ProductViewModel getProductViewModel() {
        return productViewModel;
    }
}