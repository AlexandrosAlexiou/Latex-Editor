package controller;
/**
 * <h1>CommandsFactory</h1>
 * Factory class responsible for creating the
 * different types of the Latex Editor Commands.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
public class CommandsFactory {

    public CommandsFactory() {
    }

    public Command createCommand(String command) {
        if (command.equals("CreateDocumentCommand")) {
            return new CreateDocumentCommand();
        }else if (command.equals(("AddLatexCommand"))){
            return new AddLatexCommand();
        }else if(command.equals("SaveDocumentCommand")) {
            return new SaveDocumentCommand();
        }else if(command.equals("LoadDocumentCommand")){
            return new LoadDocumentCommand();
        }else if (command.equals("RollbackToPreviousVersionCommand")){
            return new RollbackToPreviousVersionCommand();
        }else if(command.equals("EnableVersionsManagementCommand")){
            return  new EnableVersionsManagementCommand();
        }else if(command.equals("DisableVersionsManagementCommand")){
            return  new DisableVersionsManagementCommand();
        }else if(command.equals("ChangeVersionsStrategyCommand")){
            return  new ChangeVersionsStrategyCommand();
        }else if(command.equals("CreateDocumentVersionCommand")){
            return new CreateDocumentVersionCommand();
        }else{
            throw new IllegalArgumentException();
        }
    }

}
