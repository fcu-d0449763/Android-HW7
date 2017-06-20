package com.example.feilin.home;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by Fei Lin on 2017/6/6.
 */

public class FirebaseThread extends Thread {
    private DataSnapshot dataSnapshot;

    public void setDataSnapshot(DataSnapshot dataSnapshot) {
        this.dataSnapshot = dataSnapshot;
    }

    public void run(){
        for(DataSnapshot ds : dataSnapshot.getChildren(){

        })
    }
}
