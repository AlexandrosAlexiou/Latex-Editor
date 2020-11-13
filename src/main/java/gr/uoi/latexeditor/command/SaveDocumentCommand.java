package gr.uoi.latexeditor.command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * <h1>SaveDocumentCommand</h1>
 *  class responsible for saving a document as a .tex file on disk storage.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
public class SaveDocumentCommand implements Command {

    public SaveDocumentCommand(){}
    
    @Override
    public  String execute(String typed){
        try {
            Files.write(Paths.get(manager.getCurrentDocumentPath()), manager.getCurrentDocument().getContents().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return typed;
    }
}
