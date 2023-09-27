package com.example.notpaddroid.Controllers;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class NoteController {
        public static void saveToFile(Context context, String fileName, String content) {
            FileOutputStream fos = null;
            try {
                fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
                fos.write(content.getBytes());
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}
