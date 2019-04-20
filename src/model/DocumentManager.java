package model;



public class DocumentManager{
    private Document letter;
    private Document book;
    private Document report;
    private Document article;
    private Document emptyDoc;

    public DocumentManager() throws Exception{
        FileReader filereader= new FileReader();
        this.letter=new Document(filereader.readFile("tex templates/letter-template.tex"),"id0");
        this.book=new Document(filereader.readFile("tex templates/book-template.tex"),"id0");
        this.report=new Document(filereader.readFile("tex templates/report-template.tex"),"id0");
        this.article=new Document(filereader.readFile("tex templates/article-template.tex"),"id0");
        this.emptyDoc=new Document();
    }

    public Document createDocument(String template){
        if(template.equals("book")){
           return this.book.cloneDeep();
        }
        if(template.equals("report")){
            return this.report.cloneDeep();
        }
        if(template.equals("letter")){
            return this.letter.cloneDeep();
        }
        if(template.equals("article")){
            return this.article.cloneDeep();
        }
        return this.emptyDoc;
    }
    public void saveDocumentToDisk(String path,String typed)throws Exception{
        FileWriter mywriter = new FileWriter(path);
        mywriter.writetofile(typed);

    }

}