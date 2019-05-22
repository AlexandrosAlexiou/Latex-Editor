import static org.junit.Assert.*;
import org.junit.Test;
import controller.LatexEditorController;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadSaveTests{
    private LatexEditorController testController = new LatexEditorController();

    @Test
    public final void testLoadCommand()throws Exception{
        String ActualOutput=testController.enact("LoadDocumentCommand","tex templates/letter-template.tex");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/letter-template.tex")));
        assertEquals("Test if the Load Document command works OK",ExpectedOutput,ActualOutput);
    }

    @Test
    public final void testSaveCommand()throws Exception{
        this.testController.setSaveLocation("tex templates/test.tex");
        String ActualOutput=testController.enact("SaveDocumentCommand","Those are the document contents.");
        String ExpectedOutput =new String(Files.readAllBytes(Paths.get("tex templates/test.tex")));
        assertEquals("Test if the Load Document command works OK",ExpectedOutput,ActualOutput);
    }

}
