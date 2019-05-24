package model;
/**
 * <h1>VersionsStrategyFactory</h1>
 * Factory class responsible for creating the
 * different types of the version tracking system.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */
public class VersionsStrategyFactory {

    public VersionsStrategyFactory(){}

    public VersionsStrategy createStrategy(String StrategyType){
        if(StrategyType.equals("Volatile")){
            return new VolatileVersionsStrategy();
        }else if(StrategyType.equals("Stable")){
            return new StableVersionsStrategy();
        }else{
            throw new IllegalArgumentException();
        }

    }
}
