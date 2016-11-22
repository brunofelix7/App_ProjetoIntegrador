package br.com.fireapp.firebaseapplication;

import android.app.Application;
import com.firebase.client.Firebase;

/**
 * @author Bruno Felix
 * Classe de connexão com o Firebase
 */
public class FirebaseConnection extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

}
