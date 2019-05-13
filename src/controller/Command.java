package controller;

import model.DocumentManager;

public interface Command {

    DocumentManager manager =new DocumentManager();

    String execute(String specifyWork);


}
