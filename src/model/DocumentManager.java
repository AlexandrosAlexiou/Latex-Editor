package model;

import java.util.HashMap;

public class DocumentManager{
    private FileReader reader = new FileReader();
    HashMap <String, Document> map = new HashMap <String, Document>();

    public DocumentManager() throws Exception{
        dynamicallyLoadTemplate("letter","tex templates/letter-template.tex");
        dynamicallyLoadTemplate("report","tex templates/report-template.tex");
        dynamicallyLoadTemplate("book","tex templates/book-template.tex");
        dynamicallyLoadTemplate("article","tex templates/article-template.tex");
    }

    public void dynamicallyLoadTemplate(String templateType,String templateFileName) {
        try {
            map.put(templateType,new Document(reader.readFile("tex templates/letter-template.tex"),"id0"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Document createDocument(String template){
        Document DocumentTemplate = map.get(template);
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