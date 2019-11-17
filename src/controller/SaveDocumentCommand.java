package controller;
/**
 * <h1>SaveDocumentCommand</h1>
 *  class responsible for saving a document as a .tex file on disk storage.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
public class SaveDocumentCommand implements Command {

    public SaveDocumentCommand(){}
    
    @Override
    public  String execute(String typed){
        manager.getWriter().writetofile(typed);
        return typed;
    }
}
