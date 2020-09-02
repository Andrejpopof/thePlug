package com.example.theplug.RecyclerView;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemShop implements Parcelable {
    private int mImage;
    private String mCena;
    private String mNaslov;

        public ItemShop(int image,String cena,String naslov){
            mImage=image;
            mCena=cena;
            mNaslov=naslov;
        }


    protected ItemShop(Parcel in) {
        mImage = in.readInt();
        mCena = in.readString();
        mNaslov = in.readString();
    }

    public static final Creator<ItemShop> CREATOR = new Creator<ItemShop>() {
        @Override
        public ItemShop createFromParcel(Parcel in) {
            return new ItemShop(in);
        }

        @Override
        public ItemShop[] newArray(int size) {
            return new ItemShop[size];
        }
    };

    public int getImage(){return mImage;}
        public String getmCena(){return mCena;}
        public String getmNaslov(){return mNaslov;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImage);
        dest.writeString(mCena);
        dest.writeString(mNaslov);
    }
}
