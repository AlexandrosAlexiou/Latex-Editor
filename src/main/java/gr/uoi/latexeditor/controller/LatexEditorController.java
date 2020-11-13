package gr.uoi.latexeditor.controller;
/**
 * <h1>LatexEditorController</h1>
 *  class responsible for communicating with the model package and to update the Gui text field.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
import gr.uoi.latexeditor.ApplicationConstants;
import gr.uoi.latexeditor.command.Command;
import gr.uoi.latexeditor.factory.CommandFactory;

import java.util.HashMap;

public class LatexEditorController{
    private String SaveLocation;
    private String LoadLocation;
    private final HashMap<String, Command> commands = new HashMap<>();

    public LatexEditorController() {
        CommandFactory commandFactory = new CommandFactory();
        commands.put(ApplicationConstants.CREATE_DOCUMENT_COMMAND,
                commandFactory.createCommand(ApplicationConstants.CREATE_DOCUMENT_COMMAND));
        commands.put(ApplicationConstants.ADD_LATEX_COMMAND,
                commandFactory.createCommand(ApplicationConstants.ADD_LATEX_COMMAND));
        commands.put(ApplicationConstants.SAVE_DOCUMENT_COMMAND,
                commandFactory.createCommand(ApplicationConstants.SAVE_DOCUMENT_COMMAND));
        commands.put(ApplicationConstants.LOAD_DOCUMENT_COMMAND,
                commandFactory.createCommand(ApplicationConstants.LOAD_DOCUMENT_COMMAND));
        commands.put(ApplicationConstants.ROLLBACK_TO_PREVIOUS_VERSION_COMMAND,
                commandFactory.createCommand(ApplicationConstants.ROLLBACK_TO_PREVIOUS_VERSION_COMMAND));
        commands.put(ApplicationConstants.ENABLE_VERSIONS_MANAGEMENT_COMMAND,
                commandFactory.createCommand(ApplicationConstants.ENABLE_VERSIONS_MANAGEMENT_COMMAND));
        commands.put(ApplicationConstants.DISABLE_VERSIONS_MANAGEMENT_COMMAND,
                commandFactory.createCommand(ApplicationConstants.DISABLE_VERSIONS_MANAGEMENT_COMMAND));
        commands.put(ApplicationConstants.CHANGE_VERSIONS_STRATEGY_COMMAND,
                commandFactory.createCommand(ApplicationConstants.CHANGE_VERSIONS_STRATEGY_COMMAND));
        commands.put(ApplicationConstants.CREATE_DOCUMENT_VERSION_COMMAND,
                commandFactory.createCommand(ApplicationConstants.CREATE_DOCUMENT_VERSION_COMMAND));
    }

    public void setSaveLocation(String saveLocation) {
        this.SaveLocation = saveLocation;
    }

    public void setLoadLocation(String loadLocation) {
        this.LoadLocation = loadLocation;
    }

    public String enact(String CommandName, String Action){

        if(CommandName.equals(ApplicationConstants.SAVE_DOCUMENT_COMMAND)){
            commands.get(CommandName).manager.setCurrentDocumentPath(SaveLocation);
            commands.get(CommandName).manager.getCurrentDocument().setContents(Action);}

        if(CommandName.equals(ApplicationConstants.LOAD_DOCUMENT_COMMAND)){
            commands.get(CommandName).manager.setCurrentDocumentPath(LoadLocation); }

        return commands.get(CommandName).execute(Action);
    }
}
