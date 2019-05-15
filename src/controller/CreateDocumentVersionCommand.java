package controller;

public class CreateDocumentVersionCommand implements Command{

    public CreateDocumentVersionCommand(){}

    @Override
    public String execute(String specifyWork) {
        manager.getStrategy().putVersion(manager.createVersion(specifyWork));
        return null;
    }
}
