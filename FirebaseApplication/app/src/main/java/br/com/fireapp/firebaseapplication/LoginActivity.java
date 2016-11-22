package br.com.fireapp.firebaseapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText senha;
    private Button bEntrar;
    private Button bCriarConta;
    private ProgressDialog progressDialog;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.id_email);
        senha = (EditText) findViewById(R.id.id_senha);
        bEntrar = (Button) findViewById(R.id.id_entrar);
        progressDialog = new ProgressDialog(this);
        bCriarConta = (Button) findViewById(R.id.id_criar_conta);
        auth = FirebaseAuth.getInstance();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() != null) {
                    progressDialog.setMessage("Entrando...");
                    progressDialog.show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        bEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn();
            }
        });

        bCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CriarUsuarioActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

    //  Login
    private void logIn(){
        String getEmail = email.getText().toString();
        String getSenha = senha.getText().toString();

        if(TextUtils.isEmpty(getEmail) || TextUtils.isEmpty(getSenha)){
            Toast.makeText(LoginActivity.this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
        }else{
            progressDialog.setMessage("Verificando...");
            progressDialog.show();
            auth.signInWithEmailAndPassword(getEmail, getSenha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        progressDialog.cancel();
                        Toast.makeText(LoginActivity.this, "Email/Senha inválidos.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

}
