package controller;

public class CreateBookCommand implements Command {

    public CreateBookCommand(){}

    @Override
    public String execute(){
        return manager.createDocument("book").getContents();
    }

}
