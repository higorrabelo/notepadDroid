package com.example.notpaddroid.Controllers;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NoteController {

    public static String salvarArquivo(String titulo, String conteudo){
        String diretorio = Environment.getExternalStorageDirectory() + "/NotPadDroid/";
        try{
            File arquivo = new File(diretorio);
            if(!arquivo.exists()){
                arquivo.mkdir();
            }
            File arq = new File(arquivo,titulo);
            FileOutputStream fo = new FileOutputStream(arq+".txt");
            fo.write(conteudo.getBytes());
            fo.close();
            return "Salvo com sucesso: "+arquivo.getPath();
        }catch(IOException e){
            return "Erro: "+e.getMessage() ;
        }
    }

    public static List<File> listar(){
        List<File> arquivos = new ArrayList<>();
        try{
            File diretorio = new File(Environment.getExternalStorageDirectory() + "/NotPadDroid/");
            for(File e : diretorio.listFiles()){
                arquivos.add(e);
            }
            return arquivos;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
