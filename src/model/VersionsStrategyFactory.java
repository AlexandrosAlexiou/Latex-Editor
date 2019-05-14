package model;

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
