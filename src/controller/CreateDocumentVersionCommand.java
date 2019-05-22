package controller;

public class CreateDocumentVersionCommand implements Command{

    public CreateDocumentVersionCommand(){}

    @Override
    public String execute(String specifyWork) {
        if(manager.VersioningIsEnabled()) {
            manager.getStrategy().putVersion(manager.createVersion(specifyWork));
            return null;
        }
        return "Versioning is Disabled";
    }
}
