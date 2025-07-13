package managers;

import enums.StrategyType;
import strategies.CustomQueueStrategy;
import strategies.PlayStrategy;
import strategies.RandomPlayStrategy;
import strategies.SequentialPlayStrategy;

/**
 * StrategyManager ek singleton class hai jo playback strategy manage karta hai.
 *
 * Ye class:
 * - Har strategy ka instance hold karti hai
 * - User ke selected StrategyType ke basis par appropriate strategy return karti hai
 *
 * Ye part hai **Strategy Design Pattern** ka.
 */
public class StrategyManager {

    private static StrategyManager manager = null;
    private SequentialPlayStrategy sequentialPlayStrategy;
    private RandomPlayStrategy randomPlayStrategy;
    private CustomQueueStrategy customQueueStrategy;

    private StrategyManager() {
        sequentialPlayStrategy = new SequentialPlayStrategy();
        randomPlayStrategy = new RandomPlayStrategy();
        customQueueStrategy = new CustomQueueStrategy();
    }

    /**
     * Singleton pattern: globally ek hi instance return karta hai
     */
    public static synchronized StrategyManager getInstance() {
        if (manager == null) {
            manager = new StrategyManager();
        }
        return manager;
    }

    /**
     * User ke selected StrategyType ke basis par appropriate strategy object return karta hai.
     *
     * @param strategyType - SEQUENTIAL / RANDOM / CUSTOM
     * @return PlayStrategy implementation
     */
    public PlayStrategy getStrategy(StrategyType strategyType) {
        if (strategyType == StrategyType.SEQUENTIAL) {
            return sequentialPlayStrategy;
        } else if (strategyType == StrategyType.RANDOM) {
            return randomPlayStrategy;
        } else {
            return customQueueStrategy;
        }
    }
}
