package enums;

/**
 * StrategyType enum define karta hai ki playlist ke songs ko kis order me play karna hai.
 *
 * Ye enum help karta hai dynamic strategy selection me (Strategy Design Pattern).
 */
public enum StrategyType {

    /**
     * Songs ko unke original order me ek ke baad ek play kiya jata hai.
     */
    SEQUENTIAL,

    /**
     * Songs ko random order me shuffle karke play kiya jata hai.
     */
    RANDOM,

    /**
     * User custom queue banata hai jisme kisi bhi song ko next me enqueue kiya ja sakta hai.
     */
    CUSTOM;
}
