package gr.uoi.latexeditor.factory;

import gr.uoi.latexeditor.command.*;

/**
 * <h1>CommandsFactory</h1>
 * Factory class responsible for creating the
 * different Latex Editor Commands.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
public class CommandFactory {

    public Command createCommand(String command) {
        switch (command) {
            case "CreateDocumentCommand":
                return new CreateDocumentCommand();
            case ("AddLatexCommand"):
                return new AddLatexCommand();
            case "SaveDocumentCommand":
                return new SaveDocumentCommand();
            case "LoadDocumentCommand":
                return new LoadDocumentCommand();
            case "RollbackToPreviousVersionCommand":
                return new RollbackToPreviousVersionCommand();
            case "EnableVersionsManagementCommand":
                return new EnableVersionsManagementCommand();
            case "DisableVersionsManagementCommand":
                return new DisableVersionsManagementCommand();
            case "ChangeVersionsStrategyCommand":
                return new ChangeVersionsStrategyCommand();
            case "CreateDocumentVersionCommand":
                return new CreateDocumentVersionCommand();
            default:
                throw new IllegalArgumentException();
        }
    }
}
