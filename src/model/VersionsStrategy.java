package model;

import java.util.ArrayList;

public interface VersionsStrategy {

    void putVersion(Document newVersion);

    String getVersion();

    void setEntireHistory(ArrayList<Document> versionsHistory);
    ArrayList<Document> getEntireHistory();

}
