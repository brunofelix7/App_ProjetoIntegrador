package br.com.fireapp.firebaseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChamadoActivity1 extends AppCompatActivity {

    private Button button;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamado1);

        //RECUPERANDO O ADDRESS
        Bundle args = getIntent().getExtras();
        address = args.getString("ADDRESS");

        button = (Button) findViewById(R.id.contitunar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChamadoActivity1.this, ChamadoActivity2.class);
                Bundle params = new Bundle();
                params.putString("ADDRESS", address);
                intent.putExtras(params);
                startActivity(intent);
                finish();
            }
        });

    }

}
