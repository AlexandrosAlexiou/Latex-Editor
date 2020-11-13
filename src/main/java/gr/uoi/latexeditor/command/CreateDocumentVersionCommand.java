package gr.uoi.latexeditor.command;

import gr.uoi.latexeditor.ApplicationConstants;

/**
 * <h1>CreateDocumentVersionCommand</h1>
 *  class responsible for creating the Document history adding new Versions upon request from the user.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
public class CreateDocumentVersionCommand implements Command{

    public CreateDocumentVersionCommand(){}

    @Override
    public String execute(String specifyWork) {
        if(manager.VersioningIsEnabled()) {
            manager.getStrategy().putVersion(manager.createVersion(specifyWork));
            return ApplicationConstants.SUCCESS;
        }
        return ApplicationConstants.DISABLED;
    }
}
