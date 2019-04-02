package com.example.stalkerv1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Editar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        Intent intent = getIntent();
        Integer p = intent.getIntExtra("posicao",0);
        Pessoa pessoa = Persistencia.getInstance().strs.get(p);

        EditText txt;
        txt = (EditText) findViewById(R.id.nome);
        txt.setText(pessoa.getNome());

        txt = (EditText)findViewById(R.id.emprego);
        txt.setText(pessoa.getEmprego());

        txt = (EditText)findViewById(R.id.dtnascimento);
        txt.setText(pessoa.getDtnascimento());

        txt = (EditText)findViewById(R.id.telefone);
        txt.setText(pessoa.getTelefone());

        txt = (EditText)findViewById(R.id.descricao);
        txt.setText(pessoa.getDescricao());
    }

    public void clicarBotaoSalvar(View v){
        Intent intent = getIntent();
        Integer p = intent.getIntExtra("posicao",0);

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

        Pessoa pessoa = new Pessoa(nome,emprego,dtnascimento,telefone,descricao);
        Persistencia.getInstance().strs.add(p,pessoa);
        Persistencia.getInstance().strs.remove(p+1);

        finish();
    }
}
