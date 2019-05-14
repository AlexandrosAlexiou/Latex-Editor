package model;

public interface VersionsStrategy {

    void putVersion(Document newVersion);

    Document getVersion();

}
