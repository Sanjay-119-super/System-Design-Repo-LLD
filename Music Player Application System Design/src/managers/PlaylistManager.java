package managers;

import modules.Playlist;
import modules.Song;

import java.util.HashMap;
import java.util.Map;

/**
 * PlaylistManager ek singleton class hai jo system me sari playlists ko manage karti hai.
 *
 * Ye class:
 * - Playlists create karti hai
 * - Songs ko playlist me add karti hai
 * - Specific playlist ko fetch karti hai by name
 */
public class PlaylistManager {

    private static PlaylistManager playlist = null;
    private Map<String, Playlist> playlistMap;

    private PlaylistManager() {
        playlistMap = new HashMap<>();
    }

    /**
     * Singleton instance return karta hai
     */
    public static synchronized PlaylistManager getInstance() {
        if (playlist == null) {
            playlist = new PlaylistManager();
        }
        return playlist;
    }

    /**
     * Nayi playlist create karta hai by name.
     * Agar playlist already exist karti hai to exception throw hota hai.
     *
     * @param name - playlist name
     */
    public void createPlaylist(String name) {
        if (playlistMap.containsKey(name)) {
            throw new RuntimeException("Playlist \"" + name + "\" already exists.");
        }
        playlistMap.put(name, new Playlist(name));
    }

    /**
     * Diye gaye song ko specific playlist me add karta hai.
     * Agar playlist nahi milti to error throw karta hai.
     *
     * @param playlistName - jisme song add karna hai
     * @param song - song object
     */
    public void addSongToPlaylist(String playlistName, Song song) {
        if (!playlistMap.containsKey(playlistName)) {
            throw new RuntimeException("Playlist \"" + playlistName + "\" not found.");
        }
        playlistMap.get(playlistName).addSongToPlaylist(song);
    }

    /**
     * Specific playlist ko return karta hai by name.
     * Agar exist nahi karti to exception throw hota hai.
     *
     * @param playlistName - name of playlist
     * @return Playlist object
     */
    public Playlist getPlaylist(String playlistName) {
        if (!playlistMap.containsKey(playlistName)) {
            throw new RuntimeException("Playlist \"" + playlistName + "\" not found.");
        }
        return playlistMap.get(playlistName);
    }
}
