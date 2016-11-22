package br.com.livroandroid.ciclodevida;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class BemVindoActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        //  Essa classe é usada para enviar/receber parâmetros de uma outra Activity,
        //  usando a estrutura de chave e valor
        Bundle args = getIntent().getExtras();          //  Captura o parâmetro extra passado na Activity anterior
        final String KEY = args.getString("nome");      //  String que recebe o valor com a chave 'nome' da outra Activity

        TextView text = (TextView) findViewById(R.id.text);
        text.setText(KEY + ", seja bem-vindo");

        //  Botão de voltar
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //  Chamando o Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //  Funções para os itens
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}