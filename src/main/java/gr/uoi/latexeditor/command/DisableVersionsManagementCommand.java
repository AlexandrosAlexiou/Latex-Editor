package gr.uoi.latexeditor.command;
/**
 * <h1>DisableVersionsManagementCommand</h1>
 *  class responsible for disabling the Version tracking system.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
public class DisableVersionsManagementCommand implements Command{

    public DisableVersionsManagementCommand(){}

    @Override
    public String execute(String specifyWork) {
        manager.disableVersioning();
        return null;
    }
}
