package controller;
/**
 * <h1>AddLatexCommand</h1>
 *  class responsible for creating the various Latex commands
 *  and adding the proper one upon request from the user.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
import model.FileReader;
import java.util.HashMap;

public class AddLatexCommand implements Command{

    private HashMap<String, String> LatexCommandsMap = new HashMap <String, String>();

    public AddLatexCommand(){
        dynamicallyLoadLatexCommand("AddChapter","tex templates/AddChapter.tex");
        dynamicallyLoadLatexCommand("AddSection","tex templates/AddSection.tex");
        dynamicallyLoadLatexCommand("AddSubSection","tex templates/AddSubSection.tex");
        dynamicallyLoadLatexCommand("AddSubSubSection","tex templates/AddSubSubSection.tex");
        dynamicallyLoadLatexCommand("AddItemList","tex templates/AddItemList.tex");
        dynamicallyLoadLatexCommand("AddEnumList","tex templates/AddEnumList.tex");
        dynamicallyLoadLatexCommand("AddItem","tex templates/AddItem.tex");
        dynamicallyLoadLatexCommand("AddTable","tex templates/AddTable.tex");
        dynamicallyLoadLatexCommand("AddGTable","tex templates/AddGTable.tex");
    }

    private void dynamicallyLoadLatexCommand(String CommandName,String CommandFileName){
        try {
            manager.getReader().setPath(CommandFileName);
            LatexCommandsMap.put(CommandName, manager.getReader().readFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String execute(String CommandName){
        return LatexCommandsMap.get(CommandName);
    }
}
