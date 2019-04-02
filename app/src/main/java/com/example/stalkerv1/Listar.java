package com.example.stalkerv1;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

public class Listar extends AppCompatActivity implements SearchView.OnQueryTextListener{

    public Integer posicao=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        this.criaBotoes();
    }

    private void criaBotoes(){
        LinearLayout layout = (LinearLayout) findViewById(R.id.Laylista);
        for(final Pessoa str: Persistencia.getInstance().strs){
            final Button btn = new Button(this);
            btn.setText(str.getNome());
            btn.setId(Persistencia.getInstance().strs.indexOf(str));
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    posicao = btn.getId();
                    Intent intent = new Intent(v.getContext(),Listar2.class);
                    intent.putExtra("posicao", posicao);
                    v.getContext().startActivity(intent);
                    finish();
                    //startActivityForResult(intent, 1);
                }
            });
            layout.addView(btn);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.main, menu);
        SearchView sview = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sview.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        int id = Persistencia.queryStr(s);
        if(id > -1){
            Intent intent = new Intent(getApplicationContext(),Listar2.class);
            intent.putExtra("posicao", id);
            startActivity(intent);
            finish();
            return true;
        }
        Toast.makeText(this, "Not found!", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
