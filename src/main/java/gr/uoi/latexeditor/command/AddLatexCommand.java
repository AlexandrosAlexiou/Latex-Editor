package gr.uoi.latexeditor.command;
/**
 * <h1>AddLatexCommand</h1>
 *  class responsible for creating the various Latex commands
 *  and adding the proper one upon request from the user.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
import gr.uoi.latexeditor.ApplicationConstants;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.HashMap;

public class AddLatexCommand implements Command{

    private final HashMap<String, String> LatexCommandsMap = new HashMap <>();

    public AddLatexCommand(){
        dynamicallyLoadLatexCommand(ApplicationConstants.ADD_CHAPTER,
                "/templates/AddChapter.tex");
        dynamicallyLoadLatexCommand(ApplicationConstants.ADD_SECTION,
                "/templates/AddSection.tex");
        dynamicallyLoadLatexCommand(ApplicationConstants.ADD_SUBSECTION,
               "/templates/AddSubSection.tex");
        dynamicallyLoadLatexCommand(ApplicationConstants.ADD_SUBSUBSECTION,
               "/templates/AddSubSubSection.tex");
        dynamicallyLoadLatexCommand(ApplicationConstants.ADD_ITEM_LIST,
               "/templates/AddItemList.tex");
        dynamicallyLoadLatexCommand(ApplicationConstants.ADD_ENUM_LIST,
                "/templates/AddEnumList.tex");
        dynamicallyLoadLatexCommand(ApplicationConstants.ADD_ITEM,
               "/templates/AddItem.tex");
        dynamicallyLoadLatexCommand(ApplicationConstants.ADD_TABLE,
                "/templates/AddTable.tex");
        dynamicallyLoadLatexCommand(ApplicationConstants.ADD_GTABLE,
                "/templates/AddGTable.tex");
    }

    private void dynamicallyLoadLatexCommand(String CommandName,String CommandFileName){
        try {
            InputStream in = getClass().getResourceAsStream(CommandFileName);
            byte[] data = IOUtils.toByteArray(in);
            LatexCommandsMap.put(CommandName, new String(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String execute(String CommandName){
        return LatexCommandsMap.get(CommandName);
    }
}
