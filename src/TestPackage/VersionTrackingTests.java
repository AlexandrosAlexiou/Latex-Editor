package TestPackage;

import static org.junit.Assert.*;
import org.junit.Test;
import controller.LatexEditorController;
import java.nio.file.Files;
import java.nio.file.Paths;


public class VersionTrackingTests {


    @Test
    public final void testDisableVersionTracking() {
        LatexEditorController testController=new LatexEditorController();
        testController.enact("DisableVersionsManagementCommand","disable");
        String actualOutput = testController.enact("CreateDocumentVersionCommand","Contents");
        String expectedOutput = "Versioning is Disabled";
        assertEquals("Test if the Disable Version Tracking mechanism works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testVolatileVersionTracking() {
        LatexEditorController testController=new LatexEditorController();
        testController.enact("EnableVersionsManagementCommand","enable");
        testController.enact("ChangeVersionsStrategyCommand","Volatile");
        testController.enact("CreateDocumentVersionCommand","Contents");
        String actualOutput =testController.enact("RollbackToPreviousVersionCommand",null);
        String expectedOutput = "Contents";
        assertEquals("Test if the Commit Version mechanism works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testStableVersionTracking()throws Exception {
        LatexEditorController testController=new LatexEditorController();
        testController.enact("EnableVersionsManagementCommand","enable");
        testController.enact("ChangeVersionsStrategyCommand","Stable");
        testController.enact("CreateDocumentVersionCommand","Contents");
        String actualOutput = new String(Files.readAllBytes(Paths.get("Stable Versioning/1.tex")));
        String expectedOutput = "Contents";
        assertEquals("Test if the Commit Version mechanism works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testChangeStrategy()throws Exception {
        LatexEditorController testController=new LatexEditorController();
        testController.enact("ChangeVersionsStrategyCommand","Volatile");
        testController.enact("CreateDocumentVersionCommand","Contents");
        testController.enact("ChangeVersionsStrategyCommand","Stable");
        String actualOutput = new String(Files.readAllBytes(Paths.get("Stable Versioning/1.tex")));
        String expectedOutput = "Contents";
        assertEquals("Test if the Change Version Tracking System mechanism works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testRollbackVersion(){
        LatexEditorController testController=new LatexEditorController();
        testController.enact("ChangeVersionsStrategyCommand","Volatile");
        testController.enact("CreateDocumentVersionCommand","Contents1");
        String actualOutput =testController.enact("RollbackToPreviousVersionCommand","null");
        String expectedOutput = "Contents1";
        assertEquals("Test if the Rollback Document version mechanism works OK",expectedOutput,actualOutput);

    }

}
