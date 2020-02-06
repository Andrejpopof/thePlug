package com.example.theplug;

public class ItemShop {
    private int mImage;
    private String mCena;
    private String mNaslov;

        public ItemShop(int image,String cena,String naslov){
            mImage=image;
            mCena=cena;
            mNaslov=naslov;
        }


        public int getImage(){return mImage;}
        public String getmCena(){return mCena;}
        public String getmNaslov(){return mNaslov;}

}
