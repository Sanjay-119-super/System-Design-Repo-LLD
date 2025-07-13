package strategies;

import modules.Playlist;
import modules.Song;

/**
 * SequentialPlayStrategy ek simple strategy hai jisme songs order-wise play hote hain.
 * Jaise: first -> second -> third -> ...
 */
public class SequentialPlayStrategy implements PlayStrategy {

    private Playlist currentPlaylist;
    private int currentIndex;

    public SequentialPlayStrategy() {
        this.currentPlaylist = null;
        this.currentIndex = -1;
    }

    /**
     * Playlist set karte hi index reset hota hai
     */
    @Override
    public void setPlaylist(Playlist playlist) {
        currentPlaylist = playlist;
        currentIndex = -1;
    }

    /**
     * Next song sequential order me return karta hai
     */
    @Override
    public Song next() {
        if (currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        currentIndex += 1;
        return currentPlaylist.getSongs().get(currentIndex);
    }

    /**
     * Check karta hai agar next index playlist size se chhota hai
     */
    @Override
    public boolean hasNext() {
        return (currentPlaylist != null && (currentIndex + 1) < currentPlaylist.getSize());
    }

    /**
     * Previous song return karta hai agar available ho
     */
    @Override
    public Song previous() {
        if (currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        currentIndex = Math.max(0, currentIndex - 1);
        return currentPlaylist.getSongs().get(currentIndex);
    }

    /**
     * Check karta hai agar current index > 0 hai to previous song available hai
     */
    @Override
    public boolean hadPrevious() {
        return currentIndex > 0;
    }
}
