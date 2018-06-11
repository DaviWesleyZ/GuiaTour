package com.example.android.guiatour.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.app.Dialog;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;

import com.example.android.guiatour.Adapter.PaisAdapter;
import com.google.android.gms.common.GoogleApiAvailability;
import com.example.android.guiatour.R;
import com.google.android.gms.common.ConnectionResult;

public class PaisesActivity extends AppCompatActivity {

        // GOOGLE MAP
        private static final int ERRO_REQUISICAO_DIALOGO = 9001;
        private static final String TAG = "PerfilActivity";

        Toolbar toolbar;
        ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_paises);

           if(ServicoOK())
            inicializar();


         toolbar = (Toolbar) findViewById(R.id.toolbar);
         listView = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(PaisesActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.Paises));

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Intent intent = new Intent(PaisesActivity.this, PaisAdapter.class);
                 intent.putExtra("Paises", listView.getItemAtPosition(i).toString());
                 startActivity(intent);

             }
         });
        listView.setAdapter(mAdapter);

    }


    private void inicializar() {
        Button btnMapa = (Button) findViewById(R.id.btnMapa);
               btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaisesActivity.this, MapaActivity.class);
                startActivity(intent);

            }
        });
               
    }


    public boolean ServicoOK(){
        Log.d(TAG, "SeviçoOK: Checando versão dos serviços do google");


        int disponivel = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(PaisesActivity.this);

        if(disponivel == ConnectionResult.SUCCESS){
            // TUDO OK E É POSSIVEL USAR O MAPA
            Log.d(TAG, "serviçoOK: Os serviços do google play estão funcionando");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(disponivel)){
            // OCORREU UM ERRO MAIS É POSSIVEL RESOLVER
            Log.d(TAG, "serviçosOK: um erro ocorreu mais pode ser concertado!");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(PaisesActivity.this, disponivel, ERRO_REQUISICAO_DIALOGO);
            dialog.show();
        }else{
            Toast.makeText(this, "Não é possível utilizar o google map", Toast.LENGTH_SHORT).show();
        }
        return false;
    }



}
