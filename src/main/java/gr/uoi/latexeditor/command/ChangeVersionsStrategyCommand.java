package gr.uoi.latexeditor.command;
/**
 * <h1>ChangeVersionsStrategyCommand</h1>
 *  class responsible for changing the Version tracking Strategy from Volatile to Stable and vice-versa.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
public class ChangeVersionsStrategyCommand implements Command {

    public ChangeVersionsStrategyCommand(){}

    @Override
    public String execute(String specifyWork){
        this.manager.changeStrategy(specifyWork);
        return null;
    }
}
