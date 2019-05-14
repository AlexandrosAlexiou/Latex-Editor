package controller;

public class DisableVersionsManagementCommand implements Command{

    public DisableVersionsManagementCommand(){}

    @Override
    public String execute(String specifyWork) {
        manager.setVersioning(false);
        return null;
    }
}
