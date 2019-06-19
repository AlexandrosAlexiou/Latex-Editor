package TestPackage;

import static org.junit.Assert.*;
import org.junit.Test;
import controller.LatexEditorController;
import java.nio.file.Files;
import java.nio.file.Paths;
public class AddLatexCommandTests {
    private LatexEditorController testController = new LatexEditorController();

    @Test
    public final void testAddChapterCommand()throws Exception{
        String actualOutput=testController.enact("AddLatexCommand","AddChapter");
        String expectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddChapter.tex")));
        assertEquals("Test if the AddChapter command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddSectionCommand()throws Exception{
        String actualOutput=testController.enact("AddLatexCommand","AddSection");
        String expectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddSection.tex")));
        assertEquals("Test if the AddSection command works OK",expectedOutput,actualOutput);
    }
    @Test
    public final void testAddSubSectionCommand()throws Exception{
        String actualOutput=testController.enact("AddLatexCommand","AddSubSection");
        String expectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddSubsection.tex")));
        assertEquals("Test if the AddSubSection command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddSubSubSectionCommand()throws Exception{
        String actualOutput=testController.enact("AddLatexCommand","AddSubSubSection");
        String expectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddSubSubsection.tex")));
        assertEquals("Test if the AddSubSubSection command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddSimpleTableCommand()throws Exception{
        String actualOutput=testController.enact("AddLatexCommand","AddTable");
        String expectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddTable.tex")));
        assertEquals("Test if the AddSimpleTable command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddGraphicsTableCommand()throws Exception{
        String actualOutput=testController.enact("AddLatexCommand","AddGTable");
        String expectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddGTable.tex")));
        assertEquals("Test if the AddGraphicsTable command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddItemListCommand()throws Exception{
        String actualOutput=testController.enact("AddLatexCommand","AddItemList");
        String expectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddItemList.tex")));
        assertEquals("Test if the AddItemList command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddEnumListCommand()throws Exception{
        String actualOutput=testController.enact("AddLatexCommand","AddEnumList");
        String expectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddEnumList.tex")));
        assertEquals("Test if the AddEnumList command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddItemCommand()throws Exception{
        String actualOutput=testController.enact("AddLatexCommand","AddItem");
        String expectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddItem.tex")));
        assertEquals("Test if the AddItem command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddEnumCommand()throws Exception{
        String actualOutput=testController.enact("AddLatexCommand","AddItem");
        String expectedOutput = new String(Files.readAllBytes(Paths.get("tex templates/AddItem.tex")));
        assertEquals("Test if the AddItem command works OK",expectedOutput,actualOutput);
    }


}
