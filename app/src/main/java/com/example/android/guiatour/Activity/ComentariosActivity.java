package com.example.android.guiatour.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.guiatour.Adapter.ComentariosRecyclerAdapter;
import com.example.android.guiatour.Modelo.BlogPost;
import com.example.android.guiatour.Modelo.Comentarios;
import com.example.android.guiatour.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComentariosActivity extends AppCompatActivity {

    private Toolbar comentarioToolbar;

    private EditText comentario_espaco;
    private ImageView comentario_post_btn;

    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;

    private RecyclerView comment_list;
    private ComentariosRecyclerAdapter commentsRecyclerAdapter;
    private List<Comentarios> commentsList;

    private String blog_post_id;
    private String current_user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cometarios);

        comentarioToolbar = findViewById(R.id.comentario_toolbar);
        setSupportActionBar(comentarioToolbar);
        getSupportActionBar().setTitle("Comentários");

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        current_user_id = firebaseAuth.getCurrentUser().getUid();

        blog_post_id = getIntent().getStringExtra("blog_post_id");

        comentario_espaco = findViewById(R.id.comentario_espaco);
        comentario_post_btn = findViewById(R.id.comentario_post_btn);
        comment_list = findViewById(R.id.comentarios_lista);


        // RecyclerView Firebase List
        commentsList = new ArrayList<>();
        commentsRecyclerAdapter = new ComentariosRecyclerAdapter(commentsList);
        comment_list.setHasFixedSize(true);
        comment_list.setLayoutManager(new LinearLayoutManager(this));
        comment_list.setAdapter(commentsRecyclerAdapter);

        firebaseFirestore.collection("Posts/" + blog_post_id + "/Comentarios")
                .addSnapshotListener(ComentariosActivity.this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {

                if (!documentSnapshots.isEmpty()) {

                    for (DocumentChange doc : documentSnapshots.getDocumentChanges()) {

                        if (doc.getType() == DocumentChange.Type.ADDED) {

                            String comentarioID = doc.getDocument().getId();
                            Comentarios comentarios = doc.getDocument().toObject(Comentarios.class);
                            commentsList.add(comentarios);
                            commentsRecyclerAdapter.notifyDataSetChanged();
                        }
                    }

                }



            }
        });

        comentario_post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comentario_mensagem = comentario_espaco.getText().toString();


                    Map<String, Object> comentariosMap = new HashMap<>();
                    comentariosMap.put("mensagem", comentario_mensagem);
                    comentariosMap.put("user_id", current_user_id);
                    comentariosMap.put("timestamp", FieldValue.serverTimestamp());

                    firebaseFirestore.collection("Posts/" + blog_post_id + "/Comentarios").add(comentariosMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {

                            if(!task.isSuccessful()){

                                Toast.makeText(ComentariosActivity.this, "Erro ao postar comentário: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            } else {
                                comentario_espaco.setText("");
                            }
                        }
                    });



            }
        });
    }
}
