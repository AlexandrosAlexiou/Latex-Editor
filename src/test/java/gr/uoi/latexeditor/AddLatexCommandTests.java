package gr.uoi.latexeditor;

import gr.uoi.latexeditor.controller.LatexEditorController;

import org.junit.Test;
import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddLatexCommandTests {
    private final LatexEditorController testController;
    private final String commandTemplatesPath;

    public AddLatexCommandTests() throws URISyntaxException {
        this.testController = new LatexEditorController();
        URI uri = ClassLoader.getSystemResource("templates/AddChapter.tex").toURI();
        this.commandTemplatesPath = Paths.get(uri).getParent().toString();
    }

    @Test
    public final void testAddChapterCommand() throws Exception{
        String actualOutput=testController.enact(
                ApplicationConstants.ADD_LATEX_COMMAND,
                ApplicationConstants.ADD_CHAPTER
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(commandTemplatesPath + "/AddChapter.tex")));
        assertEquals("Test if the AddChapter command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddSectionCommand() throws Exception{
        String actualOutput=testController.enact(
                ApplicationConstants.ADD_LATEX_COMMAND,
                ApplicationConstants.ADD_SECTION
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(commandTemplatesPath + "/AddSection.tex")));
        assertEquals("Test if the AddSection command works OK",expectedOutput,actualOutput);
    }
    @Test
    public final void testAddSubSectionCommand() throws Exception{
        String actualOutput=testController.enact(
                ApplicationConstants.ADD_LATEX_COMMAND,
                ApplicationConstants.ADD_SUBSECTION
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(commandTemplatesPath + "/AddSubsection.tex")));
        assertEquals("Test if the AddSubSection command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddSubSubSectionCommand() throws Exception{
        String actualOutput=testController.enact(
                ApplicationConstants.ADD_LATEX_COMMAND,
                ApplicationConstants.ADD_SUBSUBSECTION
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(commandTemplatesPath + "/AddSubSubsection.tex")));
        assertEquals("Test if the AddSubSubSection command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddSimpleTableCommand() throws Exception{
        String actualOutput=testController.enact(
                ApplicationConstants.ADD_LATEX_COMMAND,
                ApplicationConstants.ADD_TABLE
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(commandTemplatesPath + "/AddTable.tex")));
        assertEquals("Test if the AddSimpleTable command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddGraphicsTableCommand() throws Exception{
        String actualOutput=testController.enact(
                ApplicationConstants.ADD_LATEX_COMMAND,
                ApplicationConstants.ADD_GTABLE
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(commandTemplatesPath + "/AddGTable.tex")));
        assertEquals("Test if the AddGraphicsTable command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddItemListCommand() throws Exception{
        String actualOutput=testController.enact(
                ApplicationConstants.ADD_LATEX_COMMAND,
                ApplicationConstants.ADD_ITEM_LIST
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(commandTemplatesPath + "/AddItemList.tex")));
        assertEquals("Test if the AddItemList command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddEnumListCommand() throws Exception{
        String actualOutput=testController.enact(
                ApplicationConstants.ADD_LATEX_COMMAND,
                ApplicationConstants.ADD_ENUM_LIST
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(commandTemplatesPath + "/AddEnumList.tex")));
        assertEquals("Test if the AddEnumList command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddItemCommand() throws Exception{
        String actualOutput=testController.enact(
                ApplicationConstants.ADD_LATEX_COMMAND,
                ApplicationConstants.ADD_ITEM
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(commandTemplatesPath + "/AddItem.tex")));
        assertEquals("Test if the AddItem command works OK",expectedOutput,actualOutput);
    }

    @Test
    public final void testAddEnumCommand() throws Exception{
        String actualOutput=testController.enact(
                ApplicationConstants.ADD_LATEX_COMMAND,
                ApplicationConstants.ADD_ITEM
        );
        String expectedOutput = new String(Files.readAllBytes(Paths.get(commandTemplatesPath + "/AddItem.tex")));
        assertEquals("Test if the AddItem command works OK",expectedOutput,actualOutput);
    }


}
