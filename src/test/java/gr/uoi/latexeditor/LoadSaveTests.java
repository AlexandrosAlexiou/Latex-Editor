package gr.uoi.latexeditor;

import static org.junit.Assert.*;

import gr.uoi.latexeditor.controller.LatexEditorController;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadSaveTests{
    private final LatexEditorController testController;

    public LoadSaveTests() {
        this.testController = new LatexEditorController();
    }

    @Test
    public final void testLoadCommand() throws IOException, URISyntaxException {
        String fullpath = findFileFullPath("templates/letter-template.tex");
        String actualOutput = testController.enact(
                ApplicationConstants.LOAD_DOCUMENT_COMMAND,
                fullpath
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(fullpath)));
        assertEquals("Test if the Load Document command works OK", expectedOutput, actualOutput);
    }

    @Test
    public final void testSaveCommand() throws IOException, URISyntaxException {
        String testSaveLocation = findFileFullPath("tex") + "/testSaveCommand.tex";
        testController.setSaveLocation(testSaveLocation);
        String actualOutput = testController.enact(
                ApplicationConstants.SAVE_DOCUMENT_COMMAND,
                "Contents."
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(findFileFullPath("tex/testSaveCommand.tex"))));
        assertEquals("Test if the Load Document command works OK", expectedOutput, actualOutput);
    }

    private String findFileFullPath(String relativePath) throws URISyntaxException {
        URI uri = ClassLoader.getSystemResource(relativePath).toURI();
        return Paths.get(uri).toString();
    }
}
