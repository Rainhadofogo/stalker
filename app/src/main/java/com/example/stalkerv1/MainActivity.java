package com.example.stalkerv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void clicarBotaoCadastrar(View v){
        Intent intent = new Intent(this, Cadastrar.class);
        startActivity(intent);
    }

    public void clicarBotaoListar(View v){
        Intent intent = new Intent(this, Listar.class);
        startActivity(intent);
    }
}
