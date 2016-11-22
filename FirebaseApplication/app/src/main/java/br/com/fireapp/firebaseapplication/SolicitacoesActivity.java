package br.com.fireapp.firebaseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolicitacoesActivity extends AppCompatActivity {

    private String key1;
    private String key2;
    private String key3;
    private String endereco;
    private Map<String, String> chamado;
    private Button button;
    private Button button2;
    private TextView txt_endereco;
    private TextView txt_urgencia;
    private TextView txt_consciente;
    private TextView txt_respiracao;
    private Firebase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacoes);

        mDatabase = new Firebase("https://fir-application-9d853.firebaseio.com/");

        //  RECUPERANDO TODOS OS PARAMETROS DA SOLICITAÇÃO.
        Bundle args = getIntent().getExtras();
        key1 = args.getString("KEY1");
        key2 = args.getString("KEY2");
        key3 = args.getString("KEY3");
        endereco = args.getString("ENDERECO");

        chamado = new HashMap<String, String>();
        chamado.put("endereco", endereco);
        chamado.put("urgencia", key1);
        chamado.put("ciencia", key2);
        chamado.put("respiracao", key3);

        txt_endereco = (TextView) findViewById(R.id.txt_endereco);
        txt_urgencia = (TextView) findViewById(R.id.txt_urgencia);
        txt_consciente = (TextView) findViewById(R.id.txt_consciente);
        txt_respiracao = (TextView) findViewById(R.id.txt_respiracao);
        button = (Button) findViewById(R.id.enviar);
        button2 = (Button) findViewById(R.id.cancelar);

        txt_urgencia.setText(key1);
        txt_consciente.setText(key2);
        txt_respiracao.setText(key3);
        txt_endereco.setText(endereco);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase child = mDatabase.child("Ocorrencias/Chamados");
                child.push().setValue(chamado);
                Intent intent = new Intent(SolicitacoesActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(SolicitacoesActivity.this, "Ocorrência registrada com sucesso", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(SolicitacoesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }




}
