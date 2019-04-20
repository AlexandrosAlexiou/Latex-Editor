package controller;

import model.DocumentManager;

public class LatexEditorController{

    private DocumentManager manager =new DocumentManager();

    public LatexEditorController() throws Exception {}

   public String makeReportDocument(){
        return manager.createDocument("report").getContents();
    }

    public String makeBookDocument(){
        return manager.createDocument("book").getContents();
    }

    public String makeLetterDocument(){
        return manager.createDocument("letter").getContents();
    }

    public String makeArticleDocument(){
        return manager.createDocument("article").getContents();
    }
    public void saveTemplateDocument(String path,String text)throws Exception{
        manager.saveDocumentToDisk(path,text);
    }

    public String openFile(String path)throws Exception{
        return manager.openDocumentFromDisk(path);
    }
}
