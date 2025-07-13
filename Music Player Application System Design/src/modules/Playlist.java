package modules;

import java.util.ArrayList;
import java.util.List;

/**
 * Playlist class ek logical group hai songs ka.
 * Ye represent karta hai ek specific playlist jisme user ne kuch songs add kiye hote hain.
 *
 * Real-world example: "Bollywood Vibes", "Workout Mix", etc.
 */
public class Playlist {

    private String playlistName;
    private List<Song> songs;

    /**
     * Constructor ke through nayi playlist banai jaati hai aur uska naam set hota hai.
     *
     * @param playlistName - playlist ka unique name
     */
    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        songs = new ArrayList<>();
    }

    /**
     * Playlist ka naam return karta hai
     *
     * @return playlist name
     */
    public String getPlaylistName() {
        return playlistName;
    }

    /**
     * Playlist ke andar jitne songs hain wo return karta hai
     *
     * @return list of Song objects
     */
    public List<Song> getSongs() {
        return songs;
    }

    /**
     * Kitne songs hain playlist me uska size return karta hai
     *
     * @return number of songs
     */
    public int getSize() {
        return songs.size();
    }

    /**
     * Diya gaya song playlist me add karta hai
     *
     * @param song - song to be added
     */
    public void addSongToPlaylist(Song song) {
        if (song == null) {
            System.out.println("Song cannot be added. Input song is null.");
            return;
        }
        songs.add(song);
    }

    /**
     * Playlist ka readable format me string representation deta hai
     *
     * @return playlist info as string
     */
    @Override
    public String toString() {
        return "Playlist{" +
                "playlistName='" + playlistName + '\'' +
                ", songs=" + songs +
                '}';
    }
}
