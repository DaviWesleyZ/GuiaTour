package com.example.android.guiatour.Activity;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.android.guiatour.Modelo.Usuario;
import com.example.android.guiatour.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;


import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;

public class PerfilActivity extends AppCompatActivity{

    private CircleImageView setupImage;
    private Uri mainImageURI = null;

    private String user_id;

    private boolean isChanged = false;

    private EditText nomeEdit, contatoEdit, dataEdit;
    private TextView emailText, setupName, btnAlterar;

    private ProgressBar setupProgress;

    private StorageReference storageReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private Bitmap compressedImageFile;


    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_perfil);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("Perfil");
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_main);

        firebaseAuth = FirebaseAuth.getInstance();
        user_id = firebaseAuth.getCurrentUser().getUid();

        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());


        emailText = (TextView) findViewById(R.id.emailText);
        nomeEdit = (EditText) findViewById(R.id.nomeEdit);
        contatoEdit = (EditText) findViewById(R.id.contatoEdit);
        dataEdit = (EditText) findViewById(R.id.dataEdit);
        btnAlterar = (TextView) findViewById(R.id.btnAlterar);
        setupImage = (CircleImageView) findViewById(R.id.imgPerfil);
        setupProgress = findViewById(R.id.progressBar);
        setupName = (TextView) findViewById(R.id.nomeUsuario);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Usuario dadosUsuario = dataSnapshot.getValue(Usuario.class);
                emailText.setText(dadosUsuario.getEmail());
                contatoEdit.setText(dadosUsuario.getTelefone());
                nomeEdit.setText(dadosUsuario.getNome());
                dataEdit.setText(dadosUsuario.getDataNascimento());
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.menu_update) {

                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Usuario dadosUsuario = dataSnapshot.getValue(Usuario.class);
                            if((nomeEdit.getText().toString().equals(dadosUsuario.getNome()) )
                                    && ( contatoEdit.getText().toString().equals(dadosUsuario.getTelefone()) )
                                    && ( dataEdit.getText().toString().equals(dadosUsuario.getDataNascimento()) )){
                                Toast.makeText(PerfilActivity.this, "Nenhuma alteração detectada!", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Usuario u = new Usuario();
                                u.setNome(nomeEdit.getText().toString().trim());
                                u.setTelefone(contatoEdit.getText().toString().trim());
                                u.setDataNascimento(dataEdit.getText().toString().trim());
                                u.setEmail(emailText.getText().toString());
                                databaseReference.setValue(u);
                                Toast.makeText(PerfilActivity.this, "Dados alterados com sucesso!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                } else if (id == R.id.menu_voltar) {
                    Intent i = new Intent(PerfilActivity.this, PrincipalActivity.class);
                    startActivity(i);
                }

                return true;
            }
        });


        setupProgress.setVisibility(View.VISIBLE);
        btnAlterar.setEnabled(false);

        firebaseFirestore.collection("Usuarios").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {

                    if (task.getResult().exists()) {
                        String nome = task.getResult().getString("nome");
                        String imagem = task.getResult().getString("imagem");

                        mainImageURI = Uri.parse(imagem);

                        setupName.setText(nome);
                        nomeEdit.setText(nome);
                        RequestOptions placeholderRequest = new RequestOptions();
                        placeholderRequest.placeholder(R.drawable.defaultperfil);
                        Glide.with(PerfilActivity.this).setDefaultRequestOptions(placeholderRequest).load(imagem).into(setupImage);

                    }


                } else {
                    String error = task.getException().getMessage();
                    Toast.makeText(PerfilActivity.this, "Firestore retorno de erro: " + error, Toast.LENGTH_SHORT).show();

                }

                setupProgress.setVisibility(View.INVISIBLE);
                btnAlterar.setEnabled(true);
            }
        });

        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String user_name = nomeEdit.getText().toString();
                if (!TextUtils.isEmpty(user_name) && mainImageURI != null) {
                    setupProgress.setVisibility(View.VISIBLE);
                        if (isChanged) {

                            user_id = firebaseAuth.getCurrentUser().getUid();

                             File newImageFile = new File(mainImageURI.getPath());
                             try {
                                compressedImageFile = new Compressor(PerfilActivity.this)
                                        .setMaxHeight(125)
                                        .setMaxWidth(125)
                                        .setQuality(50)
                                        .compressToBitmap(newImageFile);

                             }catch (IOException e) {
                                 e.printStackTrace();
                             }

                             ByteArrayOutputStream baos = new ByteArrayOutputStream();
                             compressedImageFile.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                             byte[] thumbData = baos.toByteArray();

                             UploadTask image_path = storageReference.child("Fotos_Perfil").child(user_id + ".jpg").putBytes(thumbData);

                             image_path.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                 @Override
                                 public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                                     if (task.isSuccessful()) {
                                         storeFirestore(task, user_name);
                                     } else {

                                         String error = task.getException().getMessage();
                                         Toast.makeText(PerfilActivity.this, "(IMAGE Error) : " + error, Toast.LENGTH_LONG).show();

                                         setupProgress.setVisibility(View.INVISIBLE);

                            }
                        }
                    });

                } else {

                    storeFirestore(null, user_name);

                }

            }

        }

        });

        setupImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    if (ContextCompat.checkSelfPermission(PerfilActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                        Toast.makeText(PerfilActivity.this, "Permission Denied", Toast.LENGTH_LONG).show();
                        ActivityCompat.requestPermissions(PerfilActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

                    } else {
                        BringImagePicker();
                    }

                }else{
                    BringImagePicker();
                }

            }
        });

    }

    private void storeFirestore(Task<UploadTask.TaskSnapshot> task, String user_name) {
        Uri download_uri;

        if(task != null) {

            download_uri = task.getResult().getDownloadUrl();

        } else {

            download_uri = mainImageURI;

        }

        Map<String, String> userMap = new HashMap<>();
        userMap.put("nome", user_name);
        userMap.put("imagem", download_uri.toString());

        firebaseFirestore.collection("Usuarios").document(user_id).set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()){

                    Toast.makeText(PerfilActivity.this, "Upload concluido com sucesso!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(PerfilActivity.this, PerfilActivity.class);
                    startActivity(intent);

                } else {

                    String error = task.getException().getMessage();
                    Toast.makeText(PerfilActivity.this, "(FIRESTORE Error) : " + error, Toast.LENGTH_LONG).show();

                }

                setupProgress.setVisibility(View.INVISIBLE);

            }
        });


    }


    private void BringImagePicker() {

        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAspectRatio(1, 1)
                .start(PerfilActivity.this);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                mainImageURI = result.getUri();
                setupImage.setImageURI(mainImageURI);

                isChanged = true;

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                Exception error = result.getError();

            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
