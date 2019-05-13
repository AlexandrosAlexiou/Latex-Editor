package controller;

import model.FileWriter;

public class SaveDocumentCommand implements Command {

    public SaveDocumentCommand(){}


    @Override
    public  String execute(String typed, String path){

        FileWriter writer = new FileWriter(path);
        writer.writetofile(typed);

        return "Save Successful";
    }
}
