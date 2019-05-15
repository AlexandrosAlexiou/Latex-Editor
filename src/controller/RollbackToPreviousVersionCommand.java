package controller;

public class RollbackToPreviousVersionCommand implements Command{

    public RollbackToPreviousVersionCommand(){}

    @Override
    public String execute(String specifyWork){

        manager.changeToPreviousVersion(manager.getStrategy().getVersion());
        return manager.getCurrentDocument().getContents();
    }
}
