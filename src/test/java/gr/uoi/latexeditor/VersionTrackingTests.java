package gr.uoi.latexeditor;

import gr.uoi.latexeditor.controller.LatexEditorController;


import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class VersionTrackingTests {
    private final String documentVersionPath;

    public VersionTrackingTests() {
        documentVersionPath = System.getProperty("user.dir");
    }

    @Test
    public final void testDisableVersionTracking() {
        LatexEditorController testController=new LatexEditorController();
        testController.enact(
                ApplicationConstants.DISABLE_VERSIONS_MANAGEMENT_COMMAND,
                ApplicationConstants.DISABLE
        );
        String actualOutput = testController.enact(
                ApplicationConstants.CREATE_DOCUMENT_VERSION_COMMAND,
                "Contents"
        );
        String expectedOutput = ApplicationConstants.DISABLED;
        assertEquals("Test if the Disable Version Tracking mechanism works OK", expectedOutput, actualOutput);
    }

    @Test
    public final void testVolatileVersionTracking() {
        LatexEditorController testController=new LatexEditorController();
        testController.enact(
                ApplicationConstants.ENABLE_VERSIONS_MANAGEMENT_COMMAND,
                ApplicationConstants.ENABLE
        );
        testController.enact(
                ApplicationConstants.CHANGE_VERSIONS_STRATEGY_COMMAND,
                ApplicationConstants.VOLATILE
        );
        testController.enact(
                ApplicationConstants.CREATE_DOCUMENT_VERSION_COMMAND,
                "Contents"
        );
        String actualOutput =testController.enact(
                ApplicationConstants.ROLLBACK_TO_PREVIOUS_VERSION_COMMAND,
                null
        );
        String expectedOutput = "Contents";
        assertEquals("Test if the Commit Version mechanism works OK", expectedOutput, actualOutput);
    }

    @Test
    public final void testStableVersionTracking() throws Exception {
        LatexEditorController testController=new LatexEditorController();
        testController.enact(
                ApplicationConstants.ENABLE_VERSIONS_MANAGEMENT_COMMAND,
                ApplicationConstants.ENABLE
        );
        testController.enact(
                ApplicationConstants.CHANGE_VERSIONS_STRATEGY_COMMAND,
                ApplicationConstants.STABLE
        );
        testController.enact(
                ApplicationConstants.CREATE_DOCUMENT_VERSION_COMMAND,
                "Contents"
        );
        String actualOutput = new String(Files.readAllBytes(Paths.get(documentVersionPath + "/" + "1.tex")));
        String expectedOutput = "Contents";
        assertEquals("Test if the Commit Version mechanism works OK", expectedOutput, actualOutput);
        File actual = new File(documentVersionPath + "/" + "1.tex");
        actual.delete();
    }

    @Test
    public final void testChangeStrategy()throws Exception {
        LatexEditorController testController=new LatexEditorController();
        testController.enact(
                ApplicationConstants.CHANGE_VERSIONS_STRATEGY_COMMAND,
                ApplicationConstants.VOLATILE
        );
        testController.enact(
                ApplicationConstants.CREATE_DOCUMENT_VERSION_COMMAND,
                "Contents"
        );
        testController.enact(
                ApplicationConstants.CHANGE_VERSIONS_STRATEGY_COMMAND,
                ApplicationConstants.STABLE
        );
        String actualOutput = new String(Files.readAllBytes(Paths.get(documentVersionPath + "/" + "1.tex")));

        String expectedOutput = "Contents";
        assertEquals(
                "Test if the Change Version Tracking System mechanism works OK",
                expectedOutput,
                actualOutput
        );
        File actual = new File(documentVersionPath + "/" + "1.tex");
        actual.delete();
    }

    @Test
    public final void testRollbackVersion() {
        LatexEditorController testController=new LatexEditorController();
        testController.enact(
                ApplicationConstants.CHANGE_VERSIONS_STRATEGY_COMMAND,
                ApplicationConstants.VOLATILE
        );
        testController.enact(
                ApplicationConstants.CREATE_DOCUMENT_VERSION_COMMAND,
                "Contents1"
        );
        String actualOutput =testController.enact(
                ApplicationConstants.ROLLBACK_TO_PREVIOUS_VERSION_COMMAND,
                "null"
        );
        String expectedOutput = "Contents1";
        assertEquals("Test if the Rollback Document version mechanism works OK",expectedOutput,actualOutput);

    }

    private String findFileFullPath(String relativePath) throws URISyntaxException {
        URI uri = ClassLoader.getSystemResource(relativePath).toURI();
        return Paths.get(uri).toString();
    }
}
