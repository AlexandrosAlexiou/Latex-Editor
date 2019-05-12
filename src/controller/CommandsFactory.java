package controller;

public class CommandsFactory {

    public CommandsFactory() {
    }

    public Command createCommand(String command) {
        if (command.equals("CreateBook")) {
            return new CreateBookCommand();
        } else if (command.equals("CreateLetter")) {
            return new CreateLetterCommand();
        } else if (command.equals("CreateArticle")) {
            return new CreateArticleCommand();
        }else if (command.equals("CreateReport")) {
            return new CreateReportCommand();
        }else if (command.equals(("AddChapter"))){
            return new AddChapterCommand();
        }else{
            throw new IllegalArgumentException();
        }
    }

}
