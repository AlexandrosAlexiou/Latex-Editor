package controller;

public class CommandsFactory {

    public CommandsFactory() {
    }

    public Command createCommand(String command) {
        if (command.equals("CreateDocumentCommand")) {
            return new CreateDocumentCommand();
        }else if (command.equals(("AddLatexCommand"))){
            return new AddLatexCommand();
        }else{
            throw new IllegalArgumentException();
        }
    }

}
