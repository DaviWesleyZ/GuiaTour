package com.example.android.guiatour.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.guiatour.R;

public class RegrasActivity extends AppCompatActivity {

    private TextView txtRegras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_regras);

        txtRegras = (TextView) findViewById(R.id.txtRegras);

        txtRegras.setText("REGRAS DE USO\n" +
                "\n" +
                "1 – Não é permitido nome de usuário ou foto que violem ou desrespeitem as condições propostas no artigo 1.2\n" +
                "1.2 – Não é permitido nenhum tipo de conteúdo abusivo e/ou obsceno.\n" +
                "2 – A área de criação de Posts deve ser utilizada apenas para assuntos relacionados à viagens e afins.\n" +
                "3 – Qualquer post que não se encaixe no padrão 2 será revisado e excluido, podendo ocasionar o banimento de sua conta.\n" +
                "4 – A parte de comentário deve ser utilizada para troca de conhecimentos e informações.\n" +
                "4.1 – Não é permitido trocar informações pessoais, como telefone de contato, endereços residênciais, etc.\n" +
                "4.2 – Não é permitido xingamentos, tratamentos abusivos ou desrespeito com nenhum usuário.\n" +
                "5 – Aqueles que desejarem contribuir com informações de bugs e/ou ajudar com ideias e sugestões, podem encaminhar um e-mail para suporteGuiaTour@gmail.com\n" +
                "6 – Qualquer regra quebrada pode ocasionar o cancelamento de sua conta.\n" +
                "7 – Criação de vários perfis pode ser monitorado e cancelados posteriormente.\n" +
                "\n");












    }}
