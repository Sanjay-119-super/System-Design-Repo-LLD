package strategies;

import modules.Playlist;
import modules.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * RandomPlayStrategy songs ko randomly select karta hai bina repeat ke.
 *
 * Isme ek history stack bhi hoti hai jisse previous song wapas play kiya ja sake.
 */
public class RandomPlayStrategy implements PlayStrategy {

    private Playlist currentPlaylist;
    private List<Song> remainingSongs; // jitne abhi tak play nahi hue
    private Stack<Song> history;       // play history ke liye
    private Random random;

    public RandomPlayStrategy() {
        this.currentPlaylist = null;
        this.random = new Random();
    }

    /**
     * Playlist set karte hi remaining songs list aur history reset hoti hai
     */
    @Override
    public void setPlaylist(Playlist playlist) {
        currentPlaylist = playlist;
        if (currentPlaylist == null || currentPlaylist.getSize() == 0) return;

        remainingSongs = new ArrayList<>(currentPlaylist.getSongs());
        history = new Stack<>();
    }

    /**
     * Jab tak remaining songs list empty nahi hai, next song available hota hai
     */
    @Override
    public boolean hasNext() {
        return currentPlaylist != null && !remainingSongs.isEmpty();
    }

    /**
     * Randomly ek song select karta hai from remaining list
     *
     * Select hone ke baad song ko remaining list se hata diya jaata hai (taaki repeat na ho)
     */
    @Override
    public Song next() {
        if (currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty");
        }

        if (remainingSongs.isEmpty()) {
            throw new RuntimeException("No songs left to play");
        }

        int index = random.nextInt(remainingSongs.size());
        Song selectedSong = remainingSongs.get(index);

        // Last item ko uthake selected index pe replace karo, fir last ko hata do
        int lastIndex = remainingSongs.size() - 1;
        remainingSongs.set(index, remainingSongs.get(lastIndex));
        remainingSongs.remove(lastIndex);

        history.push(selectedSong);
        return selectedSong;
    }

    /**
     * Agar history stack me koi song hai to true return karta hai
     */
    @Override
    public boolean hadPrevious() {
        return history.size() > 0;
    }

    /**
     * Previous song history se wapas deta hai
     */
    @Override
    public Song previous() {
        if (history.isEmpty()) {
            throw new RuntimeException("No previous song available");
        }
        return history.pop();
    }
}
