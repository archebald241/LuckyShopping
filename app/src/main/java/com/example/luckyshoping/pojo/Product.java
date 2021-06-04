package com.example.luckyshoping.pojo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Product")
public class Product {

    @PrimaryKey (autoGenerate = true)
    int id;

    String videoCardName;

    String price;

    String videoMemoryType;

    String videoCardCapacity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideoCardName() {
        return videoCardName;
    }

    public void setVideoCardName(String videoCardName) {
        this.videoCardName = videoCardName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVideoMemoryType() {
        return videoMemoryType;
    }

    public void setVideoMemoryType(String videoMemoryType) {
        this.videoMemoryType = videoMemoryType;
    }

    public String getVideoCardCapacity() {
        return videoCardCapacity;
    }

    public void setVideoCardCapacity(String videoCardCapacity) {
        this.videoCardCapacity = videoCardCapacity;
    }
}
