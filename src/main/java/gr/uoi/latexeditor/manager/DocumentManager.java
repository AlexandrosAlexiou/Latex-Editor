package gr.uoi.latexeditor.manager;
/**
 * <h1>DocumentManager</h1>
 * Responsible for handling all
 * the different Document edits.
 *
 * @version 2.0
 * @since   2019-05-24
 */
import gr.uoi.latexeditor.ApplicationConstants;
import gr.uoi.latexeditor.factory.VersionStrategyFactory;
import gr.uoi.latexeditor.model.Document;
import gr.uoi.latexeditor.history.VersionsStrategy;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.HashMap;

public class DocumentManager{
    private boolean Versioning;
    private VersionsStrategy Strategy;
    private final VersionStrategyFactory strategyFactory = new VersionStrategyFactory();
    private Document currentDocument = new Document("",0,null);
    private final HashMap <String, Document> map = new HashMap <>();
    private String currentDocumentPath;

    public DocumentManager(){
        this.Versioning=true;
        this.Strategy=strategyFactory.createStrategy(ApplicationConstants.VOLATILE);
        dynamicallyLoadTemplate(ApplicationConstants.LETTER, "/templates/letter-template.tex");
        dynamicallyLoadTemplate(ApplicationConstants.REPORT,"/templates/report-template.tex");
        dynamicallyLoadTemplate(ApplicationConstants.BOOK, "/templates/book-template.tex");
        dynamicallyLoadTemplate(ApplicationConstants.ARTICLE, "/templates/article-template.tex");
    }

    private void dynamicallyLoadTemplate(String templateType,String templateFileName) {
        try {
            InputStream in = getClass().getResourceAsStream(templateFileName);
            byte[] data = IOUtils.toByteArray(in);
            map.put(templateType, new Document(new String(data),0,null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean VersioningIsEnabled(){ return Versioning; }

    public void enableVersioning(){
        this.Versioning = true;
    }

    public void disableVersioning(){
        this.Versioning = false;
    }

    public VersionsStrategy getStrategy(){
        return this.Strategy;
    }

    public void setCurrentDocument(Document documentVersion){
        this.currentDocument=documentVersion;
    }

    public Document getCurrentDocument(){
        return this.currentDocument;
    }

    public String getCurrentDocumentPath() {
        return currentDocumentPath;
    }

    public void setCurrentDocumentPath(String currentDocumentPath) {
        this.currentDocumentPath = currentDocumentPath;
    }

    public Document createDocument(String template){
        Document DocumentTemplate = map.get(template);
        Document deepCopy = new Document(DocumentTemplate);
        setCurrentDocument(deepCopy);
        return deepCopy;
    }

    public Document loadDocument(String contents,int versionId,String locationOnDisk){
        Document newDocument = new Document(contents,versionId,locationOnDisk);
        setCurrentDocument(newDocument);
        return newDocument;
    }

    public Document createVersion(String contents){
        Document newVersion = new Document(this.currentDocument);
        newVersion.setContents(contents);
        newVersion.setVersionID(newVersion.getVersionID() + 1);
        newVersion.setLocationOnDisk(this.currentDocument.getLocationOnDisk());
        this.currentDocument=newVersion;
        return newVersion;
    }

    public void changeToPreviousVersion(String previousVersion){
    	this.currentDocument.setContents(previousVersion);
    	this.currentDocument.setVersionID(this.currentDocument.getVersionID()-1);
        
    }

    public void changeStrategy(String StrategyType){
        VersionsStrategy newStrategy = this.strategyFactory.createStrategy(StrategyType);
        newStrategy.setEntireHistory(this.Strategy.getEntireHistory());
        this.Strategy=newStrategy;
    }
}