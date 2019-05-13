package model;

import java.io.IOException;
import java.nio.file.*;;


public class FileWriter {
    private  String Path;

    public FileWriter(){}

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        this.Path = path;
    }

    public void writetofile(String documentContents){
        try {
            Files.write(Paths.get(this.Path), documentContents.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
