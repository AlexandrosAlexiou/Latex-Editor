package controller;
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
            manager.getReader().setPath(path);
            DocumentContents=manager.getReader().readFile();
        }catch (Exception e) {
            e.printStackTrace();
        }
        manager.setCurrentDocument(manager.loadDocument(DocumentContents,0,path));
        return DocumentContents;
    }
}
