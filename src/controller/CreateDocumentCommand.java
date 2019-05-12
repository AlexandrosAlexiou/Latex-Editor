package controller;

public class CreateDocumentCommand implements Command{

    public CreateDocumentCommand(){}

    @Override
    public String execute(String TemplateName){
        return manager.createDocument(TemplateName).getContents();
    }

}