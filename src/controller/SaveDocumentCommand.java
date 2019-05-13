package controller;

import model.FileWriter;

public class SaveDocumentCommand implements Command {

    public SaveDocumentCommand(){}


    @Override
    public  String execute(String typed){
        manager.getWriter().writetofile(typed);

        return "Save Successful";
    }
}
