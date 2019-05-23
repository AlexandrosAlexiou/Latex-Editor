package TestPackage;

import static org.junit.Assert.*;
import org.junit.Test;
import controller.LatexEditorController;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TemplateTests {
    private LatexEditorController testController=new LatexEditorController();

    @Test
    public final void testReportTemplate()throws Exception {
        String ActualOutput=testController.enact("CreateDocumentCommand","report");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/report-template.tex")));
        assertEquals("Test if the Report template loads OK",ExpectedOutput,ActualOutput);
    }
    @Test
    public final void testBookTemplate()throws Exception {
        String ActualOutput=testController.enact("CreateDocumentCommand","book");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/book-template.tex")));
        assertEquals("Test if the Book template loads OK",ExpectedOutput,ActualOutput);
    }
    @Test
    public final void testArticleTemplate() throws Exception{
        String ActualOutput=testController.enact("CreateDocumentCommand","article");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/Article-template.tex")));
        assertEquals("Test if the Article template loads OK",ExpectedOutput,ActualOutput);
    }
    @Test
    public final void testLetterTemplate()throws Exception{
        String ActualOutput=testController.enact("CreateDocumentCommand","letter");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/letter-template.tex")));
        assertEquals("Test if the Letter template loads OK",ExpectedOutput,ActualOutput);
    }
}

