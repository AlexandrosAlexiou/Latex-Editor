package model;

import java.util.HashMap;

public class DocumentManager{
    private boolean Versioning;
    private VersionsStrategy Strategy;
    private VersionsStrategyFactory strategyFactory = new VersionsStrategyFactory();
    private Document currentDocument;
    private FileReader reader = new FileReader();
    private FileWriter writer = new FileWriter();
    private HashMap <String, Document> map = new HashMap <String, Document>();

    public DocumentManager(){
        this.Strategy=strategyFactory.createStrategy("Volatile");
        dynamicallyLoadTemplate("letter","tex templates/letter-template.tex");
        dynamicallyLoadTemplate("report","tex templates/report-template.tex");
        dynamicallyLoadTemplate("book","tex templates/book-template.tex");
        dynamicallyLoadTemplate("article","tex templates/article-template.tex");
    }
    private void dynamicallyLoadTemplate(String templateType,String templateFileName) {
        try {
            this.reader.setPath(templateFileName);
            map.put(templateType,new Document(reader.readFile(),"id0",null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FileReader getReader() {
        return reader;
    }

    public FileWriter getWriter() {
        return writer;
    }

    public boolean isEnabled(){ return Versioning; }

    public void enableVersioning(){
        this.Versioning = true;
    }

    public void disableVersioning(){
        this.Versioning = false;
    }

    public void setStrategy(VersionsStrategy strategy) {  }

    public VersionsStrategy getStrategy(){
        return this.Strategy;
    }

    public void setCurrentDocument(Document documentVersion){
        this.currentDocument=documentVersion;
    }

    public Document getCurrentDocument(){
        return this.currentDocument;
    }

    public Document createDocument(String template){
        Document DocumentTemplate = map.get(template);
        Document deepCopy = new Document(DocumentTemplate);
        setCurrentDocument(deepCopy);
        return deepCopy;
    }

    public Document loadDocument(String contents,String versionId,String locationOnDisk){
        Document newDocument = new Document(contents,versionId,locationOnDisk);
        setCurrentDocument(newDocument);
        return newDocument;
    }

    public Document createVersion(String contents){
        Document newVersion = new Document(this.currentDocument);
        newVersion.setContents(contents);
        return newVersion;
    }

    public void changeToPreviousVersion(Document previousVersion){
        if(previousVersion!=null){
            setCurrentDocument(previousVersion);
        }

    }

}