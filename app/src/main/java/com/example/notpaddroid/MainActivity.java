package com.example.notpaddroid;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.notpaddroid.Controllers.NoteController;


public class MainActivity extends AppCompatActivity {
    private boolean status = true;
    private static final int PERMISSAO_ESCRITA_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Se não estiver concedida, solicite a permissão ao usuário
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSAO_ESCRITA_REQUEST);
        } else {
            // A permissão já foi concedida, você pode continuar com a operação de salvamento de arquivos.
        }
    }
    public void save(View view){
        EditText titulo = findViewById(R.id.nomeArquivo);
        EditText conteudo = findViewById(R.id.areaTexto);
        String nota = NoteController.salvarArquivo(titulo.getText().toString(),conteudo.getText().toString());
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage(nota);
        alerta.setTitle("Alerta");
        alerta.show();
    }
    public void abrir(View view){
    }
    public void listar(View view){
    }
    public void gerenciador(View view){
    }

}