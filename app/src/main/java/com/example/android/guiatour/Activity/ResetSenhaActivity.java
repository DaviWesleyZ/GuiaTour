package com.example.android.guiatour.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.guiatour.Conexão.Conexao;
import com.example.android.guiatour.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetSenhaActivity extends AppCompatActivity {

    private EditText editEmail3;
    private Button btnResetar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_resetsenha);

        editEmail3 = (EditText) findViewById(R.id.editEmail3);
        btnResetar = (Button) findViewById(R.id.btnResetar);

        btnResetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail3.getText().toString().trim();
                if(editEmail3.getText().length() == 0)
                    alert("Campo não pode ser vazio!");
                else
                    reset(email);
            }
        });
    }

    private void reset(String email) {
        auth.sendPasswordResetEmail(email).addOnCompleteListener(ResetSenhaActivity.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                    alert("Redefinição enviada para seu email com sucesso!");
                else
                    alert("Email não encontrado!");
            }
        });
    }

    private void alert(String msg) {
        Toast.makeText(ResetSenhaActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }
}
