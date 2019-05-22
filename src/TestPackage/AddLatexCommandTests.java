import static org.junit.Assert.*;
import org.junit.Test;
import controller.LatexEditorController;
import java.nio.file.Files;
import java.nio.file.Paths;
public class AddLatexCommandTests {
    private LatexEditorController testController = new LatexEditorController();

    @Test
    public final void testAddChapterCommand()throws Exception{
        String ActualOutput=testController.enact("AddLatexCommand","AddChapter");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddChapter.tex")));
        assertEquals("Test if the AddChapter command works OK",ExpectedOutput,ActualOutput);
    }

    @Test
    public final void testAddSectionCommand()throws Exception{
        String ActualOutput=testController.enact("AddLatexCommand","AddSection");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddSection.tex")));
        assertEquals("Test if the AddSection command works OK",ExpectedOutput,ActualOutput);
    }
    @Test
    public final void testAddSubSectionCommand()throws Exception{
        String ActualOutput=testController.enact("AddLatexCommand","AddSubSection");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddSubsection.tex")));
        assertEquals("Test if the AddSubSection command works OK",ExpectedOutput,ActualOutput);
    }

    @Test
    public final void testAddSubSubSectionCommand()throws Exception{
        String ActualOutput=testController.enact("AddLatexCommand","AddSubSubSection");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddSubSubsection.tex")));
        assertEquals("Test if the AddSubSubSection command works OK",ExpectedOutput,ActualOutput);
    }

    @Test
    public final void testAddSimpleTableCommand()throws Exception{
        String ActualOutput=testController.enact("AddLatexCommand","AddTable");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddTable.tex")));
        assertEquals("Test if the AddSimpleTable command works OK",ExpectedOutput,ActualOutput);
    }

    @Test
    public final void testAddGraphicsTableCommand()throws Exception{
        String ActualOutput=testController.enact("AddLatexCommand","AddGTable");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddGTable.tex")));
        assertEquals("Test if the AddGraphicsTable command works OK",ExpectedOutput,ActualOutput);
    }

    @Test
    public final void testAddItemListCommand()throws Exception{
        String ActualOutput=testController.enact("AddLatexCommand","AddItemList");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddItemList.tex")));
        assertEquals("Test if the AddItemList command works OK",ExpectedOutput,ActualOutput);
    }

    @Test
    public final void testAddEnumListCommand()throws Exception{
        String ActualOutput=testController.enact("AddLatexCommand","AddEnumList");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddEnumList.tex")));
        assertEquals("Test if the AddEnumList command works OK",ExpectedOutput,ActualOutput);
    }

    @Test
    public final void testAddItemCommand()throws Exception{
        String ActualOutput=testController.enact("AddLatexCommand","AddItem");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddItem.tex")));
        assertEquals("Test if the AddItem command works OK",ExpectedOutput,ActualOutput);
    }

    @Test
    public final void testAddEnumCommand()throws Exception{
        String ActualOutput=testController.enact("AddLatexCommand","AddItem");
        String ExpectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddItem.tex")));
        assertEquals("Test if the AddItem command works OK",ExpectedOutput,ActualOutput);
    }


}
