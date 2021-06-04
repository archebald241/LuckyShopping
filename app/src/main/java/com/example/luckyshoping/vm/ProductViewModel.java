package com.example.luckyshoping.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.luckyshoping.pojo.Product;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    LiveData<List<Product>> videoCards;
    Repository repository;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        videoCards = repository.getProduct();
    }

    public LiveData<List<Product>> getVideoCards() {
        return videoCards;
    }

    public void insertProduct(Product product) {
        repository.insertProduct(product);
    }

    public void deleteVideoCards() {
        repository.deleteProduct();
    }

}
