package com.example.notpaddroid.Controllers;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class NoteController {

    public static String salvarArquivo(String titulo, String conteudo){
        try{
            File arquivo = new File(Environment.getExternalStorageDirectory(),titulo);
            FileOutputStream fo = new FileOutputStream(arquivo+titulo+".txt");
            fo.write(conteudo.getBytes());
            fo.close();
            return "Salvo com sucesso: "+arquivo.getPath();
        }catch(IOException e){
            return "Erro: "+e.getMessage() ;
        }

    }

}
