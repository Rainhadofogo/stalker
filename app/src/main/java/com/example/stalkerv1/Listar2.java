package com.example.stalkerv1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Listar2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar2);

        Intent intent = getIntent();
        Integer p = intent.getIntExtra("posicao",0);
        Pessoa pessoa = Persistencia.getInstance().strs.get(p);

        TextView txt;
        txt = (TextView) findViewById(R.id.nome);
        txt.setText(pessoa.getNome());

        txt = (TextView)findViewById(R.id.emprego);
        txt.setText(pessoa.getEmprego());

        txt = (TextView)findViewById(R.id.dtnascimento);
        txt.setText(pessoa.getDtnascimento());

        txt = (TextView)findViewById(R.id.telefone);
        txt.setText(pessoa.getTelefone());

        txt = (TextView)findViewById(R.id.descricao);
        txt.setText(pessoa.getDescricao());
    }

    public void clicarBotaoApagar(View v){
        Intent intent = getIntent();
        Integer p = intent.getIntExtra("posicao",0);
        Pessoa pessoa = Persistencia.getInstance().strs.get(p);
        Persistencia.getInstance().strs.remove(pessoa);
        finish();
    }

    public void clicarBotaoEditar(View v){
        Intent intent = getIntent();
        Integer p = intent.getIntExtra("posicao",0);
        Intent intent2 = new Intent(v.getContext(),Editar.class);
        intent2.putExtra("posicao", p);
        v.getContext().startActivity(intent2);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            Intent intent2 = getIntent();
            setResult(Activity.RESULT_CANCELED, intent2);
            finish();

    }
}
