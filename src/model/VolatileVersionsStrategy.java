package model;

import java.util.ArrayList;

public class VolatileVersionsStrategy implements VersionsStrategy {

    private ArrayList<Document> versionsHistory = new ArrayList<Document>();

    public VolatileVersionsStrategy(){}

    public ArrayList<Document> getVersionsHistory(){
        return this.versionsHistory;
    }

    @Override
    public void putVersion(Document newVersion){
        System.out.println(newVersion.getContents());
        versionsHistory.add(newVersion);
    }

    @Override
    public Document getVersion(){
        if(!versionsHistory.isEmpty()) {
            return versionsHistory.remove(versionsHistory.size() - 1);
        }
        return new Document();
    }

}
