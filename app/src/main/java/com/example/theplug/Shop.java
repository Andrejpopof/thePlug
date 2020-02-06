package com.example.theplug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Intent intent=getIntent();
        intent.getStringExtra("kluc");

        ArrayList<ItemShop> lista= new ArrayList<>();
        lista.add(new ItemShop(R.drawable.nike_react_wmns,"8600 MKD","Nike React"));

    }
}
