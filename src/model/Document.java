package model;


public class Document {

    private String contents;
    private String versionID;

    private Document(String contents, String versionID){
        this.contents=contents;
        this.versionID=versionID;
    }

    public void setContents(String template){

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
