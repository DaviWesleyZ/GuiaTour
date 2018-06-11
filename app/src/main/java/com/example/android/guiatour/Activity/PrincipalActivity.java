package com.example.android.guiatour.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.support.v7.widget.Toolbar;

import com.example.android.guiatour.R;
import com.google.firebase.auth.FirebaseAuth;

public class
PrincipalActivity extends AppCompatActivity {

    GridLayout menuGrid;
    FirebaseAuth auth;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        menuGrid = (GridLayout) findViewById(R.id.menugrid);
        toolbar = (Toolbar) findViewById(R.id.toolbarPrincipal);

        auth = FirebaseAuth.getInstance();

        if(auth.getCurrentUser() == null){
            fazerLogout();
        }


        toolbar.setTitle("Bem vindo!");
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_principal);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if(id  == R.id.menu_sair){
                    auth = FirebaseAuth.getInstance();
                    fazerLogout();

                }


                return false;
            }
        });

        trocartela(menuGrid);




    }

    private void fazerLogout() {
        auth.signOut();
        if(auth.getCurrentUser() == null){
            startActivity(new Intent(PrincipalActivity.this, loginActivity.class));
            finish();

        }
    }

    private void trocartela(GridLayout menuGrid) {
        for(int i = 0; i<menuGrid.getChildCount();i++){

            CardView cardView = (CardView) menuGrid.getChildAt(i);
            final int final1 = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(final1 == 0){
                        Intent abrirPerfil = new Intent(PrincipalActivity.this, PerfilActivity.class);
                        startActivity(abrirPerfil);

                    }
                    else if(final1 == 1){
                        Intent abrirPaises = new Intent(PrincipalActivity.this, PaisesActivity.class);
                        startActivity(abrirPaises);
                    }
                    else if(final1 == 2){
                        Intent abrirAgenda = new Intent(PrincipalActivity.this, AgendaActivity.class);
                        startActivity(abrirAgenda);
                    }
                    else if(final1 == 3){
                        Intent abrirCompartilhe = new Intent(PrincipalActivity.this, CompartilheActivity.class);
                        startActivity(abrirCompartilhe);
                    }


                }
            });


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return true;

    }


}
