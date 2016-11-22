package br.com.livroandroid.ciclodevida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends DebugActivity {

    static final String KEY = "nome";

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText tLogin = (EditText) findViewById(R.id.tLogin);
                EditText tSenha = (EditText) findViewById(R.id.tSenha);

                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();

                if(login.equals("bruno") && senha.equals("123")){
                    //  this no Java representa a instancia do objeto da classe atual, no caso a MainActivity
                    //  Faz referência a classe interna e não a MainActivity, por isso não posso usar apenas o "this"
                    Intent intent = new Intent(MainActivity.this, BemVindoActivity.class);
                    Bundle params = new Bundle();
                    params.putString(KEY, "Bruno Felix");   //  Chave e o valor que eu quero passar
                    intent.putExtras(params);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Login/Senha inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
