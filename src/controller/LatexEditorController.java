package controller;


import java.util.HashMap;

public class LatexEditorController{
    private CommandsFactory factory = new CommandsFactory();
    private HashMap<String, Command> commands = new HashMap<String, Command>();

    public LatexEditorController(){
        commands.put("CreateDocumentCommand",factory.createCommand("CreateDocumentCommand"));
        commands.put("AddLatexCommand",factory.createCommand("AddLatexCommand"));
    }

    public String enact(String CommandName,String Action){
        return commands.get(CommandName).execute(Action);
    }

}
