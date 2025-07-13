package strategies;

import modules.Playlist;
import modules.Song;

/**
 * PlayStrategy ek interface hai jo different playback algorithms define karta hai.
 *
 * Ye part hai Strategy Design Pattern ka.
 * Har strategy (Sequential, Random, CustomQueue) is interface ko implement karti hai.
 */
public interface PlayStrategy {

    /**
     * Current playlist ko set karta hai jisko ye strategy handle karegi.
     *
     * @param playlist - loaded playlist
     */
    void setPlaylist(Playlist playlist);

    /**
     * Next song ko return karta hai according to the strategy.
     *
     * @return next Song
     */
    Song next();

    /**
     * Check karta hai ki koi next song available hai ya nahi.
     *
     * @return true if next song available
     */
    boolean hasNext();

    /**
     * Previous song ko return karta hai (agar history maintain ki gayi ho).
     *
     * @return previous Song
     */
    Song previous();

    /**
     * Check karta hai ki koi previous song available hai ya nahi.
     *
     * @return true if previous song available
     */
    boolean hadPrevious();

    /**
     * Kuch strategies (jaise custom queue) me dynamically song add karna ho to ye method use hoti hai.
     *
     * @param song - song to add in next play queue
     */
    default void addToNext(Song song) {
        // By default kuch nahi karta. Override in custom queue strategy.
    }
}
