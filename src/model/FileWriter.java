package model;

import java.io.IOException;
import java.nio.file.*;;


public class FileWriter {
    private  String savepath;

    public FileWriter(String savepath){
        this.savepath=savepath;
    }
    public void writetofile(String documentContents)throws Exception {
        try {
            Files.write(Paths.get(this.savepath), documentContents.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
