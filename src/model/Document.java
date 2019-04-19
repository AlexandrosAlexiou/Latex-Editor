package model;

public class Document{

    private String contents;
    private String versionID;

    public Document(){};

    public Document(String contents, String versionID){
        this.contents=contents;
        this.versionID=versionID;
    }

    public void setContents(String template){
        this.contents=null;
        this.contents=template;
    }

    public String getContents(){
        String lala="lala";
        return lala;
    }

    public void save(){

    }

    public Document cloneDeep(){

        return new Document(new String(this.contents),new String(this.versionID));

    }
}
