package controller;
/**
 * <h1>RollbackToPreviousVersionCommand</h1>
 *  class responsible for rolling back to a previous version of the current document.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
public class RollbackToPreviousVersionCommand implements Command{

    public RollbackToPreviousVersionCommand(){}

    @Override
    public String execute(String specifyWork){
        if(manager.VersioningIsEnabled()) {
            manager.changeToPreviousVersion(manager.getStrategy().getVersion());
            if(manager.getCurrentDocument().getContents()==null) {
                return "No previous Version";
            }
            return manager.getCurrentDocument().getContents();
        }
        return "Versioning is Disabled";

    }
}
