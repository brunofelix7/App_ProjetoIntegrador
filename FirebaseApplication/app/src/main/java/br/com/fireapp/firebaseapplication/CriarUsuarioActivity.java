package br.com.fireapp.firebaseapplication;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CriarUsuarioActivity extends AppCompatActivity {

    private EditText email;
    private EditText senha;
    private EditText confirmarSenha;
    private Button cadastrar;
    private ProgressDialog progressDialog;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_usuario);

        email = (EditText) findViewById(R.id.id_email);
        senha = (EditText) findViewById(R.id.id_senha);
        confirmarSenha = (EditText) findViewById(R.id.id_confirmar_senha);
        cadastrar = (Button) findViewById(R.id.id_cadastrar);
        progressDialog = new ProgressDialog(this);

        auth = FirebaseAuth.getInstance();

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });

    }

    private void cadastrarUsuario(){
        String getEmail = email.getText().toString();
        String getSenha = senha.getText().toString();
        String getConfirmarSenha = confirmarSenha.getText().toString();

        if(TextUtils.isEmpty(getEmail) || TextUtils.isEmpty(getSenha) || TextUtils.isEmpty(getConfirmarSenha)){
            Toast.makeText(CriarUsuarioActivity.this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }if(!getSenha.equals(getConfirmarSenha)){
            Toast.makeText(CriarUsuarioActivity.this, "As senhas não são compatíveis", Toast.LENGTH_SHORT).show();
            return;
        }if(getSenha.length() < 6){
            Toast.makeText(CriarUsuarioActivity.this, "A senha deve conter no mínimo 6 caracteres", Toast.LENGTH_SHORT).show();
            return;
        }else{
            progressDialog.setMessage("Cadastrando usuario...");
            progressDialog.show();
            auth.createUserWithEmailAndPassword(getEmail, getSenha)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(CriarUsuarioActivity.this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                Toast.makeText(CriarUsuarioActivity.this, "Ops, por favor tente novamente", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    });
        }
    }

}
