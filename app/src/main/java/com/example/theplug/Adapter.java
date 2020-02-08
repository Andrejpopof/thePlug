package com.example.theplug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ExampleViewHolder> {
    private ArrayList<ItemShop> mItemList;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mCena;
        public TextView mIme;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.img);
            mCena=itemView.findViewById(R.id.cena);
            mIme=itemView.findViewById(R.id.imeProdukt);
        }
    }

    public Adapter(ArrayList<ItemShop> itemList){
        mItemList=itemList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ItemShop currentItem= mItemList.get(position);

        holder.mImageView.setImageResource(currentItem.getImage());
        holder.mCena.setText(currentItem.getmCena());
        holder.mIme.setText(currentItem.getmNaslov());

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}