package gr.uoi.latexeditor.command;
/**
 * <h1>DisableVersionsManagementCommand</h1>
 *  class responsible for enabling the Version tracking system.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
public class EnableVersionsManagementCommand implements Command {

    public EnableVersionsManagementCommand(){}

    @Override
    public String execute(String specifyWork) {
        manager.enableVersioning();
        return null;
    }
}
