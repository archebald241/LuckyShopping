package com.example.luckyshoping.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.luckyshoping.pojo.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM Product")
    LiveData<List<Product>> LoadAllProduct();

    @Query("DELETE FROM Product")
    void deleteProduct();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduct(Product product);

}
