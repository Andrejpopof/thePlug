package com.example.theplug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Intent intent = getIntent();
        ItemShop itemShop = intent.getParcelableExtra("Item");

        int imageRes = itemShop.getImage();
        String naslov = itemShop.getmNaslov();
        String cena = itemShop.getmCena();

        ImageView mImg = findViewById(R.id.slika);
        mImg.setImageResource(imageRes);
        TextView mNaslov = findViewById(R.id.naslov);
        mNaslov.setText(naslov);
        TextView mCena = findViewById(R.id.cena);
        mCena.setText(cena);

    }

    public void orderSubmit(View view) {
        Toast.makeText(this, "The product has been added to your basket", Toast.LENGTH_SHORT).show();
    }
}
