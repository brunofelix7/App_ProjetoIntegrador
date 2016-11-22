package br.com.fireapp.firebaseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import org.json.JSONArray;
import org.json.JSONObject;
import  org.json.JSONException;
import java.util.Map;

public class FirebaseTesteActivity extends AppCompatActivity {

    private Firebase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_teste);

        mDatabase = new Firebase("https://fir-application-9d853.firebaseio.com/Ocorrencias");


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //  Pegar dados com String, Map ou JSON
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
