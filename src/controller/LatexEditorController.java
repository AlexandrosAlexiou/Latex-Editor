package controller;


import model.VersionsStrategy;

import java.util.HashMap;

public class LatexEditorController{
    private VersionsStrategy Strategy;
    private String lastSaveLocation= null;
    private String lastLoadLocation= null;
    private CommandsFactory factory = new CommandsFactory();
    private HashMap<String, Command> commands = new HashMap<String, Command>();

    public LatexEditorController(){
        commands.put("CreateDocumentCommand",factory.createCommand("CreateDocumentCommand"));
        commands.put("AddLatexCommand",factory.createCommand("AddLatexCommand"));
        commands.put("SaveDocumentCommand",factory.createCommand("SaveDocumentCommand"));
        commands.put("LoadDocumentCommand",factory.createCommand("LoadDocumentCommand"));
        commands.put("RollbackToPreviousVersionCommand",factory.createCommand("RollbackToPreviousVersionCommand"));
        commands.put("EnableVersionsManagementCommand",factory.createCommand("EnableVersionsManagementCommand"));
        commands.put("DisableVersionsManagementCommand",factory.createCommand("DisableVersionsManagementCommand"));
        commands.put("ChangeVersionsStrategyCommand",factory.createCommand("ChangeVersionsStrategyCommand"));
        commands.put("CreateDocumentVersionCommand",factory.createCommand("CreateDocumentVersionCommand"));
    }

    public void setLastSaveLocation(String lastSaveLocation) {
        this.lastSaveLocation = lastSaveLocation;
    }

    public void setLastLoadLocation(String lastLoadLocation) {
        this.lastLoadLocation = lastLoadLocation;
    }

    public void setStrategy(VersionsStrategy strategy) {
        Strategy = strategy;
    }

    public String enact(String CommandName, String Action){
        if(CommandName.equals("SaveDocumentCommand")){
            commands.get(CommandName).manager.getWriter().setPath(lastSaveLocation);
        }
        if(CommandName.equals("SaveLoadCommand")){
            commands.get(CommandName).manager.getWriter().setPath(lastLoadLocation);
        }

        return commands.get(CommandName).execute(Action);
    }

}
