package com.example.feilin.home;

import android.graphics.Bitmap;

/**
 * Created by Fei Lin on 2017/6/6.
 */

public class Hotel {
    private String Name;
    private String Address;
    private Bitmap Picture;
    private String Number;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Bitmap getPicture() {
        return Picture;
    }

    public void setPicture(Bitmap picture) {
        Picture = picture;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
