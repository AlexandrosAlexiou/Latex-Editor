package model;
/**
 * <h1>StableVersionsStrategy</h1>
 *  class responsible for holding the various Document versions in main memory.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
import java.util.ArrayList;

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
