package controller;

public class DisableVersionsManagementCommand implements Command{

    public DisableVersionsManagementCommand(){}

    @Override
    public String execute(String specifyWork) {
        manager.disableVersioning();
        return null;
    }
}
