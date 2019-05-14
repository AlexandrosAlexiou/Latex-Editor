package model;

public class StableVersionsStrategy implements VersionsStrategy {

    public StableVersionsStrategy(){}

    public void putVersion(Document newVersion){

    }

    public Document getVersion(){
        return new Document("lala","lala");
    }
}
