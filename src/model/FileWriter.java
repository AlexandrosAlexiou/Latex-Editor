package model;

import java.io.IOException;
import java.nio.file.*;;


public class FileWriter {
    private  String savePath;

    public FileWriter(String savePath){
        this.savePath=savePath;
    }

    public void writetofile(String documentContents){
        try {
            Files.write(Paths.get(this.savePath), documentContents.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
