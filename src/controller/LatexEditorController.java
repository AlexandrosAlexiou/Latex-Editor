package controller;
/**
 * <h1>LatexEditorController</h1>
 *  class responsible for communicating with the model package and to update the Gui text field.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
import java.util.HashMap;

public class LatexEditorController{
    private String SaveLocation = null;
    private String LoadLocation = null;
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

    public void setSaveLocation(String saveLocation) {
        this.SaveLocation = saveLocation;
    }

    public void setLoadLocation(String loadLocation) {
        this.LoadLocation = loadLocation;
    }

    public String enact(String CommandName, String Action){

        if(CommandName.equals("SaveDocumentCommand")){ commands.get(CommandName).manager.getWriter().setPath(SaveLocation); }

        if(CommandName.equals("LoadDocumentCommand")){ commands.get(CommandName).manager.getReader().setPath(LoadLocation); }

        return commands.get(CommandName).execute(Action);
    }
}
