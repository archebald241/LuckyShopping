package com.example.luckyshoping;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.luckyshoping.activity.ProductActivity;
import com.example.luckyshoping.pojo.Product;

import java.util.List;

public class ProductLifecycle implements LifecycleOwner, LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void initViewModel() {
        ProductActivity.getProductViewModel().getVideoCards().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> productVideoCards) {
                if (ProductActivity.getCount() == productVideoCards.size()) {
                    ProductActivity.getProductRV().setAdapter(new ProductRV(productVideoCards));
                }
            }
        });
    }


    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return ProductActivity.lifecycle;
    }
}
