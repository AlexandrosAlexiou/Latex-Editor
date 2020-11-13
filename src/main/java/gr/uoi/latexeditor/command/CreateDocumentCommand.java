package gr.uoi.latexeditor.command;
/**
 * <h1>CreateDocumentCommand</h1>
 *  class responsible for creating the
 * different LaTeX templates and to load the proper one upon request from the user.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
public class CreateDocumentCommand implements Command{

    public CreateDocumentCommand(){}

    @Override
    public String execute(String TemplateName){
        return manager.createDocument(TemplateName).getContents();
    }

}