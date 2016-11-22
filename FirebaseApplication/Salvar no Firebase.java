package br.com.fireapp.firebaseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class CriarUsuarioActivity extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private EditText senha;
    private EditText confirmarSenha;
    private Button cadastrar;
    private Firebase mDatabase;
    private Debug debug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_usuario);

        debug = new Debug();

        nome = (EditText) findViewById(R.id.id_nome);
        email = (EditText) findViewById(R.id.id_email);
        senha = (EditText) findViewById(R.id.id_senha);
        confirmarSenha = (EditText) findViewById(R.id.id_confirmar_senha);
        cadastrar = (Button) findViewById(R.id.id_cadastrar);

        mDatabase = new Firebase("https://fir-application-9d853.firebaseio.com/");

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNome = nome.getText().toString();
                String getEmail = email.getText().toString();
                String getSenha = senha.getText().toString();
                String getConfirmarSenha = confirmarSenha.getText().toString();
                if(TextUtils.isEmpty(getNome) || TextUtils.isEmpty(getEmail) || TextUtils.isEmpty(getSenha) || TextUtils.isEmpty(getConfirmarSenha)){
                    Toast.makeText(CriarUsuarioActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }if(!getSenha.equals(getConfirmarSenha)){
                    Toast.makeText(CriarUsuarioActivity.this, "As senhas não são compativeis", Toast.LENGTH_SHORT).show();
                }else{
                    salvar(getNome, getEmail, getSenha);
                    Toast.makeText(CriarUsuarioActivity.this, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

    }

    //  Salvar usuario
    public void salvar(String nome, String email, String senha){
        Usuario usuario = new Usuario(nome, email, senha);
        Firebase childUser = mDatabase.child("Usuarios");
        childUser.push().setValue(usuario);
    }

}





/*
 *Classe Usuario
*/
package br.com.fireapp.firebaseapplication;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(){
        // Default constructor required for calls to DataSnapshot.getValue(Usuario.class)
    }

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString(){
        return "[id: " + getId() + ", nome: " + getNome() + ", email: " + getEmail() + ", senha: " + getSenha() + "]";
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
