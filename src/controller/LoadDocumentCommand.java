package controller;

import model.FileReader;

public class LoadDocumentCommand implements Command {

    public LoadDocumentCommand(){}

    public String execute(String path,String lal){
        String DocumentContents=null;
        try{
            DocumentContents=manager.getReader().readFile(path);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return DocumentContents;
    }
}
