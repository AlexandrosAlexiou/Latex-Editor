package model;

import java.util.HashMap;

public class DocumentManager{
    private boolean Versioning;
    private VersionsStrategy Strategy;
    private Document currentDocument;
    private FileReader reader = new FileReader();
    private FileWriter writer = new FileWriter();
    private HashMap <String, Document> map = new HashMap <String, Document>();

    public DocumentManager(){
        dynamicallyLoadTemplate("letter","tex templates/letter-template.tex");
        dynamicallyLoadTemplate("report","tex templates/report-template.tex");
        dynamicallyLoadTemplate("book","tex templates/book-template.tex");
        dynamicallyLoadTemplate("article","tex templates/article-template.tex");
    }
    private void dynamicallyLoadTemplate(String templateType,String templateFileName) {
        try {
            map.put(templateType,new Document(reader.readFile(templateFileName),"id0"));
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

    public void setVersioning(boolean Versioning){
        this.Versioning = Versioning;
    }
    public Document createDocument(String template){
        Document DocumentTemplate = map.get(template);
        return DocumentTemplate.cloneDeep();
    }
}