package com.example.notpaddroid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ArquivoActivity extends AppCompatActivity {

    private static final int PERMISSAO_ESCRITA_REQUEST = 1;

    private RecyclerView listaArquivo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arquivo_activity);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSAO_ESCRITA_REQUEST);
        } else {

        }

    }
    public void mudar(View view){
        Intent intent = new Intent(ArquivoActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void listar(View view){

    }

}
