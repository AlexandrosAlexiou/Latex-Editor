package controller;

public class ChangeVersionsStrategyCommand implements Command {

    public ChangeVersionsStrategyCommand(){}

    @Override
    public String execute(String specifyWork){
        this.manager.changeStrategy(specifyWork);
        return null;
    }
}