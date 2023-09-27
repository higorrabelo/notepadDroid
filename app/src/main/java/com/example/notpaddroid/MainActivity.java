package com.example.notpaddroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import com.example.notpaddroid.Controllers.NoteController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText texto;
    private EditText conteudo;
    private NoteController cont = new NoteController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arquivo_activity);
    }
    public void save(View view){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        FileOutputStream fs = null;
        EditText nome = findViewById(R.id.nomeArquivo);
        EditText conteudo = findViewById(R.id.areaTexto);
        NoteController.saveToFile(this,nome.getText().toString(),conteudo.getText().toString());
        alerta.setMessage("Salvo com sucesso");
        alerta.show();
    }
    public void abrir(View view){
        setContentView(R.layout.activity_main);
    }

}