package com.example.android.guiatour.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.guiatour.Fragmentos.HomeFragment;
import com.example.android.guiatour.Fragmentos.NotificacaoFragment;
import com.example.android.guiatour.Fragmentos.RegrasFragment;
import com.example.android.guiatour.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class CompartilheActivity extends AppCompatActivity {

    private Toolbar compartilheToolbar;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;

    private String current_user_id;

    private FloatingActionButton addPostBtn;

    private BottomNavigationView bottomNav;

    private HomeFragment homeFragment;
    private NotificacaoFragment notificacaoFragment;
    private RegrasFragment regrasFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_compartilhe);

        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        compartilheToolbar = (Toolbar) findViewById(R.id.compartilhe_toolbar);
        setSupportActionBar(compartilheToolbar);
        getSupportActionBar().setTitle("Compartilhe!");

        compartilheToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.menu_sair) {
                    Intent intent = new Intent(CompartilheActivity.this, PrincipalActivity.class);
                    startActivity(intent);
                    finish();

                }
                return true;
            }
        });

        if(mAuth.getCurrentUser() != null) {

        bottomNav = findViewById(R.id.BottomNav);

        // FRAGMENTOS

        homeFragment = new HomeFragment();
        notificacaoFragment = new NotificacaoFragment();
        regrasFragment = new RegrasFragment();

        trocarFragment(homeFragment);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.bottom_action_home:
                        trocarFragment(homeFragment);
                        return true;

                    case R.id.bottom_action_notif:
                        trocarFragment(notificacaoFragment);
                        return true;

                    case R.id.bottom_action_perfil:
                        Intent intent = new Intent(CompartilheActivity.this, RegrasActivity.class);
                        startActivity(intent);
                        return true;

                    default:
                        return false;

                }
            }
        });

        addPostBtn = findViewById(R.id.add_post_btn);
        addPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CompartilheActivity.this, NovoPostActivity.class);
                startActivity(intent);

            }
        });

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser() == null){
            Intent intent = new Intent(CompartilheActivity.this, loginActivity.class);
            startActivity(intent);
            finish();
        } else {
            current_user_id = mAuth.getCurrentUser().getUid();
            firebaseFirestore.collection("Usuarios").document(current_user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    if(task.isSuccessful()){

                        if(!task.getResult().exists()){

                            Intent perfilIntent = new Intent(CompartilheActivity.this, PerfilActivity.class);
                            startActivity(perfilIntent);
                            finish();

                        }

                    }
                }
            });

        }

    }

    private void trocarFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.compartilhe_container, fragment);
        fragmentTransaction.commit();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_compartilhe, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
