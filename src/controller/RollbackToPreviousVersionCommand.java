package controller;

public class RollbackToPreviousVersionCommand implements Command{

    public RollbackToPreviousVersionCommand(){}

    @Override
    public String execute(String specifyWork){
        if(manager.VersioningIsEnabled()) {
            manager.changeToPreviousVersion(manager.getStrategy().getVersion());
            if(manager.getCurrentDocument().getContents()==null) {
                return "No previous Version";
            }
            return manager.getCurrentDocument().getContents();
        }
        return "Versioning is Disabled";

    }
}
