package com.example.theplug.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.theplug.R;
import com.example.theplug.RecyclerView.ItemShop;

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

    public void patikiBrojSelect(View view) {
        if(view.getId()==R.id.btn1){}
        else if(view.getId()==R.id.btn2){}
        else if(view.getId()==R.id.btn3){}
        else if(view.getId()==R.id.btn4){}
        else if(view.getId()==R.id.btn5){}
        else if(view.getId()==R.id.btn6){}

    }

    public void duksBrojSelect(View view) {
        if(view.getId()==R.id.btnd1){}
        else if(view.getId()==R.id.btnd2){}
        else if(view.getId()==R.id.btnd3){}
        else if(view.getId()==R.id.btnd4){}
        else if(view.getId()==R.id.btnd5){}
        else if(view.getId()==R.id.btnd6){}
    }
}
