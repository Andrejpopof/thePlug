package com.example.theplug;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Shop extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private static final String TAG3 = "ShopActivity: ";
    private ArrayList<ItemShop> mlista;

    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManeger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        createList();
        buildRecyclerView();

    }

    public void createList(){
        Intent intent=getIntent();
        String kluc= intent.getStringExtra("kluc");
        mlista= new ArrayList<>();
        String[] naslovi = new String[30];
        String[] ceni = new String[30];


         if(kluc.equals("SNEAKERS")) {
             Log.i(TAG3, "Se povikuva restart Loader");
             getSupportLoaderManager().restartLoader(0, null, this);

           /*lista.add(new ItemShop(R.drawable.air_jordan_4, "200 EURO", "Air Jordan 4"));
            mlista.add(new ItemShop(R.drawable.air_max_720_obj, "230 EURO", "Air Max 720 OBJ"));
            mlista.add(new ItemShop(R.drawable.reebok_dmx_trial_shadow, "180 EURO", "Nike React"));
            mlista.add(new ItemShop(R.drawable.yeezy_500, "400 EURO ", "Yeezy 500"));
            mlista.add(new ItemShop(R.drawable.yeezy_boost_700, "450 EURO", "Yeezy 700"));
            mlista.add(new ItemShop(R.drawable.nike_react_wmns, "145 EURO", "Nike React"));*/
        }
        else if (kluc.equals("HOODIES"))
        {
            /*mlista.add(new ItemShop(R.drawable.saint_laurent,"550 EURO","Saint Laurent"));
            mlista.add(new ItemShop(R.drawable.fazexchampion,"140 EURO","FaZeXChampion"));
            mlista.add(new ItemShop(R.drawable.fear_of_god,"470 EURO","Fear Of God"));
            mlista.add(new ItemShop(R.drawable.off_white_virgil,"520 EURO","Off-White c/o Virgil"));
            mlista.add(new ItemShop(R.drawable.puma,"100 EURO","Puma luxTG"));
            mlista.add(new ItemShop(R.drawable.honor_the_gift,"105 EURO","Honor The Guft Paradise"));
            mlista.add(new ItemShop(R.drawable.ovo,"160 EURO","OVO Classic Hoodie"));
            mlista.add(new ItemShop(R.drawable.fnc,"95 EURO","ChampionXFnatic"));*/
        }
    }



    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManeger = new LinearLayoutManager(this);
        mAdapter = new Adapter(mlista);

        mRecyclerView.setLayoutManager(mLayoutManeger);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(Shop.this, "Please Select CHECK DETAILS to buy/see more info about the product", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDetailsClick(int position) {
                Toast.makeText(Shop.this, "Opening details", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Shop.this,ProductDetails.class);
                intent.putExtra("Item",mlista.get(position));
                startActivity(intent);

            }
        });
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new PostsLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
