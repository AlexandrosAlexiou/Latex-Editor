package model;

import java.util.ArrayList;

public class StableVersionsStrategy implements VersionsStrategy {

    private ArrayList<Document> versionsHistory = new ArrayList<Document>();

    public StableVersionsStrategy(){}

    @Override
    public void putVersion(Document newVersion){

    }

    @Override
    public Document getVersion(){
        return null;
    }
}
