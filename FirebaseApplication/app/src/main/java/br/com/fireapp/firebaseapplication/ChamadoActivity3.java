package br.com.fireapp.firebaseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ChamadoActivity3 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button button;
    private String key1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamado3);

        //  RECUPERANDO PARAMETROS
        Bundle args = getIntent().getExtras();
        key1 = args.getString("KEY1");

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        button = (Button) findViewById(R.id.proximo);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                radioButton = (RadioButton) findViewById(selectedId);
                String opcaoSelecionada = radioButton.getText().toString();

                Intent intent = new Intent(ChamadoActivity3.this, ChamadoActivity4.class);
                Bundle params = new Bundle();
                params.putString("KEY1", key1);
                params.putString("KEY2", opcaoSelecionada);
                intent.putExtras(params);
                startActivity(intent);
                finish();
            }
        });

    }
}
