package controller;

import model.FileReader;

import java.util.HashMap;
import java.io.BufferedReader;


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
        FileReader reader = new FileReader();
        try {
            LatexCommandsMap.put(CommandName, reader.readFile(CommandFileName));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String execute(String CommandName){
        return LatexCommandsMap.get(CommandName);
    }
}
