package controller;

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
