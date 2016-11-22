package br.com.fireapp.firebaseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ChamadoActivity4 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button button;
    private String key1;
    private String key2;
    private String endereco = "Rua Estevao Gérson Carneiro da Cunha";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamado4);

        //  RECUPERANDO PARAMETROS
        Bundle args = getIntent().getExtras();
        key1 = args.getString("KEY1");
        key2 = args.getString("KEY2");

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        button = (Button) findViewById(R.id.proximo);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                radioButton = (RadioButton) findViewById(selectedId);
                String opcaoSelecionada = radioButton.getText().toString();

                Intent intent = new Intent(ChamadoActivity4.this, SolicitacoesActivity.class);
                Bundle params = new Bundle();
                params.putString("KEY1", key1);
                params.putString("KEY2", key2);
                params.putString("KEY3", opcaoSelecionada);
                params.putString("ENDERECO", endereco);
                intent.putExtras(params);
                startActivity(intent);
                finish();
            }
        });


    }
}
