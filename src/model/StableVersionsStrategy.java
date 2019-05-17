package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class StableVersionsStrategy implements VersionsStrategy {
    private String versionsPath="Stable Versioning/";
    private int maxVersionNumber=0;
    private ArrayList<Document> versionsHistory = new ArrayList<Document>();

    public StableVersionsStrategy(){}

    @Override
    public void putVersion(Document newVersion){
        try {
            Files.write(Paths.get(this.versionsPath+newVersion.getVersionID()+".tex"), newVersion.getContents().getBytes());
            this.maxVersionNumber+=1;
            versionsHistory.add(newVersion);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getVersion(){
        if(maxVersionNumber>=1) {
            String contents = null;
            try {
                //System.out.println(maxVersionNumber);
                contents = new String(Files.readAllBytes(Paths.get(this.versionsPath + (maxVersionNumber) + ".tex")));
                versionsHistory.remove(maxVersionNumber);
                this.maxVersionNumber -= 1;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return contents;
        }
        return null;
    }

    @Override
    public void setEntireHistory(ArrayList<Document> versionsHistory){
        Iterator<Document> iterator =versionsHistory.iterator();
        while (iterator.hasNext()) {
            try {
                Document temp =iterator.next();
                Files.write(Paths.get("Stable Versioning/"+temp.getVersionID()+".tex"), temp.getContents().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public ArrayList<Document> getEntireHistory(){
        return this.versionsHistory;
    }
}
