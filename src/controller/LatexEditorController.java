package controller;

import model.DocumentManager;

public class LatexEditorController{

    private DocumentManager manager =new DocumentManager();

    public LatexEditorController() throws Exception {}

   public String enact(){
        return manager.createDocument("report").getContents();
    }
}
