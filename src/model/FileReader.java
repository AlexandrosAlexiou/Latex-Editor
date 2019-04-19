package model;

import java.nio.file.*;;
public class FileReader {
    public FileReader(){};

    public String readFile(String fileName)throws Exception {
        String contents = "";
        contents = new String(Files.readAllBytes(Paths.get(fileName)));
        return contents;
    }
}
