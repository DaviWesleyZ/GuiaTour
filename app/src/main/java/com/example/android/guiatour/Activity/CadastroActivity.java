package com.example.android.guiatour.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.guiatour.Conexão.Conexao;
import com.example.android.guiatour.Modelo.Usuario;
import com.example.android.guiatour.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class CadastroActivity extends AppCompatActivity {

    EditText editNome, editEmail2, editSenha2, editSenha3;
    Button btnCancelar, btnRegistrar;
    private FirebaseAuth auth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String nome, email, telefone, dataNascimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        editNome = (EditText) findViewById(R.id.editNome);
        editEmail2 = (EditText) findViewById(R.id.editEmail2);
        editSenha2 = (EditText) findViewById(R.id.editSenha2);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        editSenha3 = (EditText) findViewById(R.id.editSenha3);

        auth = FirebaseAuth.getInstance();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltarParaLogin = new Intent(CadastroActivity.this, loginActivity.class);
                startActivity(voltarParaLogin);
                finish();
            }
        });

        btnRegistrar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = editEmail2.getText().toString().trim();
                String senha = editSenha2.getText().toString().trim();
                String senha2 = editSenha3.getText().toString().trim();
                nome = editNome.getText().toString().trim();
                telefone = " ";
                dataNascimento = " ";

                if(email.length() == 0 || senha.length() == 0 || editNome.getText().length() == 0 || senha2.length() == 0)
                    alert("Nenhum campo pode estar vazio!");
                else if(!senha.equals(senha2))
                    alert("As senhas não são iguais!");
                else if(senha.length() <= 4)
                    alert("Senha deve conter mais de 4 caracteres!");
                else {
                    criarUser(email, senha);

                }

                }
        }));

    }



    public void registrarNoBancoDados() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(auth.getUid());
        Usuario usuario = new Usuario(nome, email, telefone, dataNascimento);
        databaseReference.setValue(usuario);



    }


    private void criarUser(String email, String senha) {
        auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    registrarNoBancoDados();
                    alert("Usuário cadastro com sucesso!");
                    Intent i = new Intent (CadastroActivity.this, loginActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    alert("Email inválido ou em uso!");

                }
            }
        });
    }

    private void alert(String msg){
        Toast.makeText(CadastroActivity.this,msg,Toast.LENGTH_SHORT).show();

    }

}















































