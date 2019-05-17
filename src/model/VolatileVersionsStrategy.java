package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class VolatileVersionsStrategy implements VersionsStrategy {

    private ArrayList<Document> versionsHistory = new ArrayList<Document>();

    public VolatileVersionsStrategy(){}

    public ArrayList<Document> getVersionsHistory(){
        return this.versionsHistory;
    }

    @Override
    public void putVersion(Document newVersion){
        versionsHistory.add(newVersion);
    }

    @Override
    public String getVersion(){
        if(!versionsHistory.isEmpty()) {
            return versionsHistory.remove(versionsHistory.size() - 1).getContents();
        }
      return null;
    }

    @Override
    public void setEntireHistory(ArrayList<Document> versionsHistory){
        this.versionsHistory=versionsHistory;


    }

    @Override
    public ArrayList<Document> getEntireHistory(){
        return this.versionsHistory;
    }
}