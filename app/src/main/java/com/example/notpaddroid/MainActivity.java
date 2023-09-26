package com.example.notpaddroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.notpaddroid.Controllers.NoteController;

public class MainActivity extends AppCompatActivity {
    private EditText texto;
    private EditText conteudo;
    private NoteController cont = new NoteController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void save(View view){
        texto = findViewById(R.id.nomeArquivo);
        conteudo = findViewById(R.id.areaTexto);
        String titulo = texto.getText().toString();
        String content  = conteudo.getText().toString();
        String mensagem = cont.salvar();
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Alerta").setMessage(mensagem).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Ação a ser executada ao pressionar o botão "OK"
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Ação a ser executada ao pressionar o botão "Cancelar"
                        dialog.dismiss(); // Fecha a caixa de diálogo
                    }
                });
        AlertDialog dialog = alerta.create();
        dialog.show();

    }

}