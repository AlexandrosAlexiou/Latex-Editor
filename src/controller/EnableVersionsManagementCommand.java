package controller;

public class EnableVersionsManagementCommand implements Command {

    public EnableVersionsManagementCommand(){}

    @Override
    public String execute(String specifyWork) {
        manager.enableVersioning();
        return null;
    }
}
