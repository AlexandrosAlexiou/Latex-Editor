package gr.uoi.latexeditor.factory;

import gr.uoi.latexeditor.ApplicationConstants;
import gr.uoi.latexeditor.history.StableVersionsStrategy;
import gr.uoi.latexeditor.history.VersionsStrategy;
import gr.uoi.latexeditor.history.VolatileVersionsStrategy;

/**
 * <h1>VersionsStrategyFactory</h1>
 * Factory class responsible for creating the
 * different types of the version tracking system.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
public class VersionStrategyFactory {

    public VersionsStrategy createStrategy(String StrategyType){
        if(StrategyType.equals(ApplicationConstants.VOLATILE)){
            return new VolatileVersionsStrategy();
        }else if(StrategyType.equals(ApplicationConstants.STABLE)){
            return new StableVersionsStrategy();
        }else{
            throw new IllegalArgumentException();
        }
    }

}
