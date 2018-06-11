package com.example.android.guiatour.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.annotation.NonNull;

import com.example.android.guiatour.Conexão.Conexao;
import com.example.android.guiatour.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.karan.churi.PermissionManager.PermissionManager;

public class loginActivity extends AppCompatActivity {


    EditText editEmail1, editSenha1;
    Button btnLogar;
    TextView txtCadastro, txtRecuperar;
    private FirebaseAuth auth;
    PermissionManager permissionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        editEmail1 = (EditText) findViewById(R.id.editEmail1);
        editSenha1 = (EditText) findViewById(R.id.editSenha1);
        btnLogar = (Button) findViewById(R.id.btnLogar);
        txtCadastro = (TextView) findViewById(R.id.txtCadastro);
        txtRecuperar = (TextView) findViewById(R.id.txtRecuperar);

        permissionManager = new PermissionManager() {};
        permissionManager.checkAndRequestPermissions(this);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail1.getText().toString().trim();
                String senha = editSenha1.getText().toString().trim();
                if(editEmail1.getText().length() == 0 || editSenha1.getText().length() == 0)
                    alert("Os campos não podem estar vazios!");
                else
                    login(email,senha);
            }
        });

        txtRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirResetSenha = new Intent(loginActivity.this, ResetSenhaActivity.class);
                startActivity(abrirResetSenha);
            }
        });

        txtCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AbrirTelaCadastro = new Intent(loginActivity.this, CadastroActivity.class);
                startActivity(AbrirTelaCadastro);
                finish();
            }
        });


}

    private void login(final String email, String senha) {
        auth.signInWithEmailAndPassword(email,senha)
                .addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i = new Intent(loginActivity.this, PrincipalActivity.class);
                            startActivity(i);
                        }
                        else
                            alert("email ou senha incorretos!");

                    }
                });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionManager.checkResult(requestCode, permissions, grantResults);
    }

    private void alert(String mensagem) {
        Toast.makeText(loginActivity.this, mensagem, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();

        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null) {
            startActivity(new Intent(loginActivity.this, PrincipalActivity.class));
            finish();
        }


    }
}































































































