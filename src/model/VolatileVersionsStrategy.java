package model;

import java.util.ArrayList;

public class VolatileVersionsStrategy implements VersionsStrategy {

    private ArrayList<Document> versionsHistory = new ArrayList<Document>();

    public VolatileVersionsStrategy(){}

    public void putVersion(Document newVersion){
        versionsHistory.add(newVersion);
    }

    public Document getVersion(){
        return versionsHistory.remove(versionsHistory.size()-1);
    }

}
