package gr.uoi.latexeditor.history;
/**
 * <h1>VersionsStrategy</h1>
 * Interface class responsible for handling
 * the two different types of the Version Tracking Mechanism.
 *
 * @version 2.0
 * @since   2019-05-24
 */
import gr.uoi.latexeditor.model.Document;

import java.util.ArrayList;

public interface VersionsStrategy {

    void putVersion(Document newVersion);

    String getVersion();

    void setEntireHistory(ArrayList<Document> versionsHistory);
    ArrayList<Document> getEntireHistory();

}
