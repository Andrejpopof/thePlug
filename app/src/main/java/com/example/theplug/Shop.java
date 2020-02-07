package com.example.theplug;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Shop extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManeger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Intent intent=getIntent();
        String kluc= intent.getStringExtra("kluc");


        ArrayList<ItemShop> lista= new ArrayList<>();
        lista.add(new ItemShop(R.drawable.air_jordan_4,"200 EURO","Air Jordan 4"));
        lista.add(new ItemShop(R.drawable.air_max_720_obj,"230 EURO","Air Max 720 OBJ"));
        lista.add(new ItemShop(R.drawable.reebok_dmx_trial_shadow,"180 EURO","Nike React"));
        lista.add(new ItemShop(R.drawable.yeezy_500,"400 EURO ","Yeezy 500"));
        lista.add(new ItemShop(R.drawable.yeezy_boost_700,"450 EURO","Yeezy 700"));
        lista.add(new ItemShop(R.drawable.nike_react_wmns,"145 EURO","Nike React"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManeger = new LinearLayoutManager(this);
        mAdapter = new Adapter(lista);

        mRecyclerView.setLayoutManager(mLayoutManeger);
        mRecyclerView.setAdapter(mAdapter);
    }
}
