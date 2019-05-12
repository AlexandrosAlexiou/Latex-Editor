package controller;

public class CreateReportCommand implements Command{

    public CreateReportCommand(){}

    @Override
    public String execute(){
        return manager.createDocument("report").getContents();
    }

}