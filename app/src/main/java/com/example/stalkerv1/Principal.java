package com.example.stalkerv1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {

    private ImageView imgPic;
    private static final int CAMERA_REQUEST_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        imgPic = (ImageView) findViewById(R.id.imgPic);
    }
   // parte sobre a camera
    public void takePic(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, CAMERA_REQUEST_CODE );
        }
    }

    @Override
    protected void onActivityResult (int requestCode, int resulCode, @Nullable Intent data){
        if(requestCode == CAMERA_REQUEST_CODE && resulCode == RESULT_OK &&  data != null){
            Bundle extras = data.getExtras();
            if(extras != null && extras.containsKey("data")){
                Bitmap bmp = (Bitmap) extras.get("data");
                imgPic.setImageBitmap(bmp);

            }
        }
    }
    // termina aqui

    public void clicarBotaoCadastrar(View v){
        Intent intent = new Intent(this, Cadastrar.class);
        startActivity(intent);
    }

    public void clicarBotaoListar(View v){
        Intent intent = new Intent(this, Listar.class);
        startActivity(intent);
    }

}
