package com.example.feilin.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getHotellist();
    }

    public void getHotellist() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    DataSnapshot dsAddress = ds.child("Add");
                    DataSnapshot dsName = ds.child("Name");
                    DataSnapshot dsTel = ds.child("Tel");

                    String Address = (String) dsAddress.getValue();
                    String Name = (String) dsName.getValue();
                    String Tel = (String) dsTel.getValue();

                    DataSnapshot dsimg = ds.child("Picdescribe1");
                    String imgUrl = (String)dsimg.getValue();
                    Bitmap hotelImg = getImgBitMap(imgUrl);



                    Log.v("Hotel", "旅館名稱：" + Name + "，地址：" + Address + "，電話：" + Tel);


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v("Hotel", databaseError.getMessage());
            }
        });
    }
    public Bitmap getImgBitMap(String imgUrl){
        try{
            URL url = new URL(imgUrl);
            Bitmap bm = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return bm;
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
