package com.example.notpaddroid.Controllers;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class NoteController {
    public static String salvar(){

        String conteudo = "conteudooooo";
        String nome = "arquivo";

        try {
            File diretorio = new File(Environment.getExternalStorageDirectory(),"Download");

            File arquivo = new File(diretorio, nome+".txt");

            FileOutputStream writer = new FileOutputStream(arquivo);
            writer.write(conteudo.getBytes());
            writer.close();
            return "Salvo com sucesso";
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro em salvar "+e.getMessage();
        }
    }

    public List<File> abrirArquivos(){
        List<File> arq = new ArrayList<>();
        File pasta = new File("");
        try{
            File[] arquivos  = pasta.listFiles();
            for (File arquivo : arquivos){
                arq.add(arquivo);
            }
            return arq;
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }


}
