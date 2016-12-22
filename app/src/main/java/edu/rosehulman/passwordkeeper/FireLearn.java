package edu.rosehulman.passwordkeeper;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Simon on 09.12.2016.
 */

public class FireLearn extends Application{


    @Override
            public void onCreate(){
        super.onCreate();


        if (!FirebaseApp.getApps(this).isEmpty()){
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
    }
}
