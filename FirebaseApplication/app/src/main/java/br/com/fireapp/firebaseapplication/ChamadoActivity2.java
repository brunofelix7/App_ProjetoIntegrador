package br.com.fireapp.firebaseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ChamadoActivity2 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamado2);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        button = (Button) findViewById(R.id.proximo);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                radioButton = (RadioButton) findViewById(selectedId);
                String opcaoSelecionada = radioButton.getText().toString();

                Intent intent = new Intent(ChamadoActivity2.this, ChamadoActivity3.class);
                Bundle params = new Bundle();
                params.putString("KEY1", opcaoSelecionada);
                intent.putExtras(params);
                startActivity(intent);
                finish();
            }
        });

    }


}
