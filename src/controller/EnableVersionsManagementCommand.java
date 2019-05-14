package controller;

public class EnableVersionsManagementCommand implements Command {

    public EnableVersionsManagementCommand(){}

    @Override
    public String execute(String specifyWork) {
        manager.setVersioning(true);
        return null;
    }
}
