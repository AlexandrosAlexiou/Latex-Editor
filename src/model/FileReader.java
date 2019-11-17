package model;

import java.nio.file.*;;

public class FileReader {

    private String path;

    public FileReader(){}

    public void setPath(String path) {
        this.path = path;
    }

    public String readFile()throws Exception {
        String contents;
        contents = new String(Files.readAllBytes(Paths.get(this.path)));
        return contents;
    }
}
