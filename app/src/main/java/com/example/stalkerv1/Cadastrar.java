package com.example.stalkerv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Cadastrar extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
    }

    public void clicarBotaoSalvar(View v) {
        String nome;
        String emprego;
        String dtnascimento;
        String telefone;
        String descricao;
        EditText txt;

        txt = findViewById(R.id.nome);
        nome = txt.getText().toString();
        txt = findViewById(R.id.emprego);
        emprego = txt.getText().toString();
        txt = findViewById(R.id.dtnascimento);
        dtnascimento = txt.getText().toString();
        txt = findViewById(R.id.telefone);
        telefone = txt.getText().toString();
        txt = findViewById(R.id.descricao);
        descricao = txt.getText().toString();

        Pessoa p = new Pessoa(nome, emprego, dtnascimento, telefone, descricao);
        Persistencia.getInstance().strs.add(p);
        finish();
    }

}
