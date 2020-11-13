package gr.uoi.latexeditor;

import static org.junit.Assert.*;

import gr.uoi.latexeditor.controller.LatexEditorController;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TemplateTests {

    private final LatexEditorController testController=new LatexEditorController();

    @Test
    public final void testReportTemplate()throws Exception {
        String actualOutput=testController.enact(
                ApplicationConstants.CREATE_DOCUMENT_COMMAND,
                ApplicationConstants.REPORT
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(
                findTemplateFileFullPath("templates/report-template.tex")
        )));
        assertEquals("Test if the Report template loads OK",expectedOutput,actualOutput);
    }
    @Test
    public final void testBookTemplate()throws Exception {
        String actualOutput=testController.enact(
                ApplicationConstants.CREATE_DOCUMENT_COMMAND,
                ApplicationConstants.BOOK
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(
                findTemplateFileFullPath("templates/book-template.tex")
        )));
        assertEquals("Test if the Book template loads OK",expectedOutput,actualOutput);
    }
    @Test
    public final void testArticleTemplate() throws Exception{
        String actualOutput=testController.enact(
                ApplicationConstants.CREATE_DOCUMENT_COMMAND,
                ApplicationConstants.ARTICLE
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(
                findTemplateFileFullPath("templates/Article-template.tex")
        )));
        assertEquals("Test if the Article template loads OK",expectedOutput,actualOutput);
    }
    @Test
    public final void testLetterTemplate()throws Exception{
        String actualOutput=testController.enact(
                ApplicationConstants.CREATE_DOCUMENT_COMMAND,
                ApplicationConstants.LETTER
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(
                findTemplateFileFullPath("templates/letter-template.tex")
        )));
        assertEquals("Test if the Letter template loads OK",expectedOutput,actualOutput);
    }

    private String findTemplateFileFullPath(String relativePath) throws URISyntaxException {
        URI uri = ClassLoader.getSystemResource(relativePath).toURI();
        return Paths.get(uri).toString();
    }
}

