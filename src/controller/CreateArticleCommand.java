package controller;

public class CreateArticleCommand implements Command {

    public CreateArticleCommand(){}

    @Override
    public String execute(){
        return manager.createDocument("article").getContents();
    }
}
