package model;

public class Document{

    private String contents;
    private int versionID;
    private String locationOnDisk;

    public Document(){}

    public Document(String contents, int versionID,String locationOnDisk){
        this.contents=contents;
        this.versionID=versionID;
        this.locationOnDisk=locationOnDisk;
    }

    //Deep-copy constructor
    public Document(Document doc){
       this.setContents(doc.getContents());
       this.setVersionID(doc.getVersionID());
       this.setLocationOnDisk(doc.getLocationOnDisk());
    }

    public void setContents(String contents){
        this.contents=contents;
    }

    public void setVersionID(int versionID) {
        this.versionID = versionID;
    }

    public void setLocationOnDisk(String locationOnDisk) {
        this.locationOnDisk = locationOnDisk;
    }

    public String getContents(){
        return this.contents;
    }

    public String getLocationOnDisk() {
        return locationOnDisk;
    }

    public int getVersionID(){
        return this.versionID;
    }

}
