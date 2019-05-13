package controller;

public class CreateDocumentCommand implements Command{

    public CreateDocumentCommand(){}

    @Override
    public String execute(String TemplateName , String dummy){
        return manager.createDocument(TemplateName).getContents();
    }

}