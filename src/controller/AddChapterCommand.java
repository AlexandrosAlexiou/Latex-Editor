package controller;

public class AddChapterCommand implements Command{

    public AddChapterCommand(){}

    @Override
    public String execute(){

        return "\\chapter{....}";
    }
}
