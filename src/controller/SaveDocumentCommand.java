package controller;

public class SaveDocumentCommand implements Command {

    public SaveDocumentCommand(){}
    
    @Override
    public  String execute(String typed){
        manager.getWriter().writetofile(typed);
        return typed;
    }
}
