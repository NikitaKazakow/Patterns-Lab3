package strategy;

import strategy.impl.DOMStrategy;
import strategy.impl.SAXStrategy;

public class Main {
    public static void main(String[] args) {
        Strategy saxStrategy = new SAXStrategy(args[0], args[1]);
        Strategy domStrategy = new DOMStrategy(args[0], args[2]);

        //saxStrategy.checkAverage();
        domStrategy.checkAverage();
    }
}
