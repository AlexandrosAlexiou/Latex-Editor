package gr.uoi.latexeditor.command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * <h1>LoadDocumentCommand</h1>
 *  class responsible for loading a .tex file from disk storage.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
public class LoadDocumentCommand implements Command {

    public LoadDocumentCommand(){}

    public String execute(String path){
        String DocumentContents=null;
        try{
            DocumentContents=new String(Files.readAllBytes(Paths.get(path)));
        }catch (IOException e) {
            e.printStackTrace();
        }
        manager.setCurrentDocument(manager.loadDocument(DocumentContents,0,path));
        return DocumentContents;
    }
}