package model;

import java.util.HashMap;

public class DocumentManager{
    private FileReader reader = new FileReader();
    HashMap <String, Document> map = new HashMap <String, Document>();

    public DocumentManager() throws Exception{
        map.put("letter",new Document(reader.readFile("tex templates/letter-template.tex"),"id0"));
        map.put("book",new Document(reader.readFile("tex templates/book-template.tex"),"id0"));
        map.put("report",new Document(reader.readFile("tex templates/report-template.tex"),"id0"));
        map.put("article",new Document(reader.readFile("tex templates/article-template.tex"),"id0"));
    }

    public Document createDocument(String template){
        Document DocumentTemplate = map.get(template);
        // A clone of the Prototype object is created and returned to the Client
        return DocumentTemplate.cloneDeep();
    }

    public void saveDocumentToDisk(String path,String typed){
        FileWriter writer = new FileWriter(path);
        writer.writetofile(typed);
    }

    public String openDocumentFromDisk(String path)throws Exception{
        return reader.readFile(path);
    }
}