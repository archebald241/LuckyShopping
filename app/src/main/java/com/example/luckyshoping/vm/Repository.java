package com.example.luckyshoping.vm;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.luckyshoping.db.ProductDao;
import com.example.luckyshoping.db.ProductDatabase;
import com.example.luckyshoping.pojo.Product;

import java.util.List;

public class Repository {

    LiveData<List<Product>> videoCards;
    ProductDao dao;

    public Repository(Application application) {
        dao = ProductDatabase.getDatabase(application.getApplicationContext()).productDao();
        videoCards = dao.LoadAllProduct();
    }

    public LiveData<List<Product>> getProduct() {
        return videoCards;
    }

    void insertProduct(Product product) {
        ProductDatabase.dbWriteExecutor.execute(() -> dao.insertProduct(product));
    }

    void deleteProduct() {
        dao.deleteProduct();
    }
}
