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
        String ActualOutput = testController.enact("CreateDocumentVersionCommand","Contents");
        String ExpectedOutput = "Versioning is Disabled";
        assertEquals("Test if the Disable Version Tracking mechanism works OK",ExpectedOutput,ActualOutput);
    }

    @Test
    public final void testVolatileVersionTracking() {
        LatexEditorController testController=new LatexEditorController();
        testController.enact("EnableVersionsManagementCommand","enable");
        testController.enact("ChangeVersionsStrategyCommand","Volatile");
        testController.enact("CreateDocumentVersionCommand","Contents");
        String ActualOutput =testController.enact("RollbackToPreviousVersionCommand",null);
        String ExpectedOutput = "Contents";
        assertEquals("Test if the Commit Version mechanism works OK",ExpectedOutput,ActualOutput);
    }

    @Test
    public final void testStableVersionTracking()throws Exception {
        LatexEditorController testController=new LatexEditorController();
        testController.enact("EnableVersionsManagementCommand","enable");
        testController.enact("ChangeVersionsStrategyCommand","Stable");
        testController.enact("CreateDocumentVersionCommand","Contents");
        String ActualOutput = new String(Files.readAllBytes(Paths.get("Stable Versioning/1.tex")));
        String ExpectedOutput = "Contents";
        assertEquals("Test if the Commit Version mechanism works OK",ExpectedOutput,ActualOutput);
    }

}
