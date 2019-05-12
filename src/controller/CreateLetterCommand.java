package controller;

public class CreateLetterCommand implements Command{

    public CreateLetterCommand(){}

    @Override
    public String execute(){
        return manager.createDocument("letter").getContents();
    }

}
