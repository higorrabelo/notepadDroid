package com.example.notpaddroid;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.notpaddroid.Controllers.NoteController;


public class MainActivity extends AppCompatActivity {
    private static final int PERMISSAO_ESCRITA_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSAO_ESCRITA_REQUEST);
        } else {

        }
    }
    public void save(View view){
        EditText titulo = findViewById(R.id.nomeArquivo);
        EditText conteudo = findViewById(R.id.areaTexto);
        String nota = NoteController.salvarArquivo(titulo.getText().toString(),conteudo.getText().toString());
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage(nota);
        alerta.setTitle("Mensagem");
        alerta.show();
    }
    public void abrir(View view){
        setContentView(R.layout.activity_main);
    }
    public void listar(View view){
    }
    public void gerenciador(View view){
        Intent intent = new Intent(MainActivity.this,ArquivoActivity.class);
        startActivity(intent);
    }
    public void novo(View view){
        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        startActivity(intent);
    }

}