package com.example.android.guiatour.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.guiatour.Modelo.Agenda;
import com.example.android.guiatour.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AgendaActivity extends AppCompatActivity{

    Button btnInicio;
    Calendar mcurrentDate;
    TextView dataInicio;
    EditText edtLocal, titulo, detalhes;
    Toolbar toolbarAgenda;
    ListView listV_dados;
    ImageView imgLocal;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    private String user_id;

    Agenda itemAgendaSelecionado;

    private List<Agenda> listAgenda = new ArrayList<Agenda>();
    private ArrayAdapter<Agenda> arrayAdapterAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_agenda);

        btnInicio = (Button) findViewById(R.id.btnInicio);
        toolbarAgenda = (Toolbar) findViewById(R.id.toolbarAgenda);
        imgLocal = (ImageView) findViewById(R.id.imgLocal);
        listV_dados = (ListView) findViewById(R.id.listEventos);

        dataInicio = (TextView) findViewById(R.id.dataInicio);
        titulo = (EditText) findViewById(R.id.edtTitulo);
        detalhes = (EditText) findViewById(R.id.edtDetalhes) ;
        edtLocal = (EditText) findViewById(R.id.edtLocal);

        inicializaFirebase();

        eventoDatabase();

        listV_dados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                itemAgendaSelecionado = (Agenda)parent.getItemAtPosition(position);
                titulo.setText(itemAgendaSelecionado.getTitulo());
                edtLocal.setText(itemAgendaSelecionado.getLocal());
                dataInicio.setText(itemAgendaSelecionado.getDataInicio());
                detalhes.setText(itemAgendaSelecionado.getDetalhes());
            }
        });

        toolbarAgenda.setTitle("Agenda");
        setSupportActionBar(toolbarAgenda);
        toolbarAgenda.inflateMenu(R.menu.menu_agenda);

        toolbarAgenda.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.menu_cancelar){
                    Intent intent = new Intent(AgendaActivity.this, PrincipalActivity.class);
                    startActivity(intent);
                }

                if(id == R.id.menu_agenda_salvar){
                    String tit = titulo.getText().toString().trim();
                    String loc = edtLocal.getText().toString().trim();
                    String dat = dataInicio.getText().toString().trim();
                    if(tit.length() == 0 && loc.length() == 0 && dat.length() == 0 && detalhes.getText().toString().length() == 0){
                        Toast.makeText(AgendaActivity.this, "Preencha os campos!", Toast.LENGTH_SHORT).show();

                    }else{
                        Agenda agenda = new Agenda();
                        agenda.setUid(UUID.randomUUID().toString());
                        agenda.setTitulo(titulo.getText().toString());
                        agenda.setLocal(edtLocal.getText().toString());
                        agenda.setDataInicio(dataInicio.getText().toString());
                        agenda.setDetalhes(detalhes.getText().toString());
                        databaseReference.child(user_id).child("Agenda").child(agenda.getUid()).setValue(agenda);
                        limparCampos();

                    }
                }

                if(id == R.id.menu_agenda_deletar){
                    if(titulo.getText().toString().length() == 0) {
                        Toast.makeText(AgendaActivity.this, "Selecione um evento para deletar!", Toast.LENGTH_SHORT).show();
                    }else{
                        Agenda a = new Agenda();
                        a.setUid(itemAgendaSelecionado.getUid());
                        databaseReference.child(user_id).child("Agenda").child(a.getUid()).removeValue();
                        limparCampos();
                    }



                }

                return true;
            }
        });



        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mcurrentDate = Calendar.getInstance();
                int ano = mcurrentDate.get(Calendar.YEAR);
                int mes = mcurrentDate.get(Calendar.MONTH);
                int dia = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AgendaActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int selectYear, int selectMonth, int selectDay) {
                        Agenda agenda = new Agenda();
                        String data = selectDay+"/"+selectMonth+"/"+selectYear;
                        agenda.setDataInicio(data);
                        mcurrentDate.set(selectYear, selectMonth, selectDay);
                        dataInicio.setText(agenda.getDataInicio());

                    }
                }, ano, mes, dia);
                datePickerDialog.show();
            }
        });


}

    private void eventoDatabase() {
        user_id = mAuth.getCurrentUser().getUid();
        databaseReference.child(user_id).child("Agenda").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listAgenda.clear();
                for(DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Agenda agenda = objSnapshot.getValue(Agenda.class);
                    listAgenda.add(agenda);
                }
                arrayAdapterAgenda = new ArrayAdapter<Agenda>(AgendaActivity.this, android.R.layout.simple_list_item_1, listAgenda);
                listV_dados.setAdapter(arrayAdapterAgenda);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void inicializaFirebase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        mAuth = FirebaseAuth.getInstance();
        user_id = mAuth.getCurrentUser().getUid();
    }

    private void limparCampos() {
        titulo.setText("");
        edtLocal.setText("");
        detalhes.setText("");
        dataInicio.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_agenda, menu);

        return true;
    }
}
