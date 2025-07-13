package strategies;

import modules.Playlist;
import modules.Song;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * CustomQueueStrategy ek flexible playback strategy hai jo user-defined queue support karta hai.
 *
 * ➤ Isme 2 key feature hote hain:
 *   - nextQueue: jisme user manually song queue karta hai (priority next)
 *   - preStack: playback history maintain karta hai taaki "previous" support ho
 *
 * Ye strategy useful hai jab user kuch specific gaane priority me sunna chahta ho,
 * lekin original playlist order bhi maintain rahe.
 */
public class CustomQueueStrategy implements PlayStrategy {

    private Playlist currentPlaylist;
    private int currentIndex;
    private Queue<Song> nextQueue;    // Custom user-added next songs
    private Stack<Song> preStack;     // Previously played songs history

    // Constructor: Strategy initialize karta hai
    public CustomQueueStrategy() {
        currentPlaylist = null;
        currentIndex = -1;
        nextQueue = new LinkedList<>();
        preStack = new Stack<>();
    }

    // Playlist set karte hi sab queue & history clear hoti hai
    @Override
    public void setPlaylist(Playlist playlist) {
        currentPlaylist = playlist;
        currentIndex = -1;
        nextQueue.clear();
        preStack.clear();
    }

    /**
     * Return karta hai agar koi next song available ho (in queue ya playlist).
     */
    @Override
    public boolean hasNext() {
        return currentPlaylist != null && (currentIndex + 1) < currentPlaylist.getSize();
    }

    /**
     * Next song return karta hai.
     * ➤ Agar user ne queue me koi song add kiya hai to pehle usi ko play karega.
     * ➤ Nahi to normal playlist order follow karega.
     */
    @Override
    public Song next() {
        if (currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty");
        }

        if (!nextQueue.isEmpty()) {
            Song song = nextQueue.poll();  // user-defined priority next
            preStack.push(song);          // history me store
            // playlist me is song ka index find karke currentIndex update karo
            for (int i = 0; i < currentPlaylist.getSongs().size(); i++) {
                if (currentPlaylist.getSongs().get(i) == song) {
                    currentIndex = i;
                    break;
                }
            }
            return song;
        }

        return nextSequential();  // default playlist flow
    }

    /**
     * Previous song available hai ya nahi — check karta hai.
     */
    @Override
    public boolean hadPrevious() {
        return preStack.size() > 0;
    }

    /**
     * Previous song return karta hai from history (stack).
     * ➤ Agar history empty ho, to playlist me previous index se song deta hai.
     */
    @Override
    public Song previous() {
        if (currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty");
        }

        if (!preStack.isEmpty()) {
            Song song = preStack.pop();  // last played song
            for (int i = 0; i < currentPlaylist.getSongs().size(); i++) {
                if (currentPlaylist.getSongs().get(i) == song) {
                    currentIndex = i;
                    break;
                }
            }
            return song;
        }

        return previousSequential();  // fallback to playlist previous
    }

    /**
     * User ne agar koi song priority me next play karne ke liye queue kiya ho to ye method use hoti hai.
     */
    @Override
    public void addToNext(Song song) {
        if (song == null) {
            throw new RuntimeException("Cannot enqueue null song");
        }
        nextQueue.add(song);
    }

    // ➤ Private method: next song in original playlist order
    private Song nextSequential() {
        if (currentPlaylist.getSize() == 0) {
            throw new RuntimeException("Playlist is empty");
        }
        currentIndex += 1;
        Song next = currentPlaylist.getSongs().get(currentIndex);
        preStack.push(next);  // history maintain
        return next;
    }

    // ➤ Private method: previous song in original playlist order
    private Song previousSequential() {
        if (currentPlaylist.getSize() == 0) {
            throw new RuntimeException("Playlist is empty");
        }
        currentIndex = Math.max(0, currentIndex - 1);
        return currentPlaylist.getSongs().get(currentIndex);
    }
}
