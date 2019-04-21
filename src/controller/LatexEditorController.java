package controller;

import model.DocumentManager;

public class LatexEditorController{

    private DocumentManager manager =new DocumentManager();

    public LatexEditorController(){}

   public String makeDocument(String templateName){
        return manager.createDocument(templateName).getContents();
    }

    public void saveTemplateDocument(String path,String text)throws Exception{
        manager.saveDocumentToDisk(path,text);
    }

    public String openFile(String path)throws Exception{
        return manager.openDocumentFromDisk(path);
    }
}
