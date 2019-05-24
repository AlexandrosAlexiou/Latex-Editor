package controller;
/**
 * <h1>VersionsStrategy</h1>
 * Interface class responsible for handling all
 * the the various Latex Editor Commands.
 *
 * @version 2.0
 * @since   2019-05-24
 */
import model.DocumentManager;

public interface Command {

    DocumentManager manager =new DocumentManager();

    String execute(String specifyWork);


}
