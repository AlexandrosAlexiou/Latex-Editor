package controller;


import java.util.HashMap;

public class LatexEditorController{
    private String lastSaveLocation= null;
    private String lastLoadLocation= null;
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

    public void setLastLoadLocation(String lastLoadLocation) {
        this.lastLoadLocation = lastLoadLocation;
    }

    public String enact(String CommandName, String Action){
        if(CommandName.equals("SaveDocumentCommand")){
            commands.get(CommandName).manager.getWriter().setPath(lastSaveLocation);
        }
        if(CommandName.equals("SaveDocumentCommand")){
            commands.get(CommandName).manager.getWriter().setPath(lastLoadLocation);
        }

        return commands.get(CommandName).execute(Action);
    }

}
