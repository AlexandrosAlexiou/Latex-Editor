package controller;


import java.util.HashMap;

public class LatexEditorController{

    private CommandsFactory factory = new CommandsFactory();
    private HashMap<String, Command> commands = new HashMap<String, Command>();

    public LatexEditorController(){
        commands.put("CreateBook",factory.createCommand("CreateBook"));
        commands.put("CreateLetter",factory.createCommand("CreateLetter"));
        commands.put("CreateArticle",factory.createCommand("CreateArticle"));
        commands.put("CreateReport",factory.createCommand("CreateReport"));
        commands.put("AddChapter",factory.createCommand("AddChapter"));
    }

    public String enact(String name){
        return commands.get(name).execute();
    }

}
