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
        String actualOutput=testController.enact("CreateDocumentCommand","report");
        String expectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/report-template.tex")));
        assertEquals("Test if the Report template loads OK",expectedOutput,actualOutput);
    }
    @Test
    public final void testBookTemplate()throws Exception {
        String actualOutput=testController.enact("CreateDocumentCommand","book");
        String expectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/book-template.tex")));
        assertEquals("Test if the Book template loads OK",expectedOutput,actualOutput);
    }
    @Test
    public final void testArticleTemplate() throws Exception{
        String actualOutput=testController.enact("CreateDocumentCommand","article");
        String expectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/Article-template.tex")));
        assertEquals("Test if the Article template loads OK",expectedOutput,actualOutput);
    }
    @Test
    public final void testLetterTemplate()throws Exception{
        String actualOutput=testController.enact("CreateDocumentCommand","letter");
        String expectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/letter-template.tex")));
        assertEquals("Test if the Letter template loads OK",expectedOutput,actualOutput);
    }
}

