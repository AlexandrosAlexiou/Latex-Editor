package controller;


import java.util.HashMap;

public class LatexEditorController{
    private String lastSaveLocation= null;
    private CommandsFactory factory = new CommandsFactory();
    private HashMap<String, Command> commands = new HashMap<String, Command>();

    public LatexEditorController(){
        commands.put("CreateDocumentCommand",factory.createCommand("CreateDocumentCommand"));
        commands.put("AddLatexCommand",factory.createCommand("AddLatexCommand"));
        commands.put("SaveDocumentCommand",factory.createCommand("SaveDocumentCommand"));
        commands.put("LoadDocumentCommand",factory.createCommand("LoadDocumentCommand"));
    }

    public void setLastSaveLocation(String lastSaveLocation) {
        this.lastSaveLocation = lastSaveLocation;
    }

    public String enact(String CommandName, String Action){

        return commands.get(CommandName).execute(Action,lastSaveLocation);
    }

}
