import enums.DeviceType;
import enums.StrategyType;
import managers.PlaylistManager;
import modules.Song;

import java.util.ArrayList;

/**
 * MusicPlayerApplication ek Singleton class hai jo music library aur playlist ke core operations ko manage karti hai.
 * Ye application layer ka interface hai jo facade layer (MusicPlayerFacade) se interact karta hai.
 */
public class MusicPlayerApplication {

    private static MusicPlayerApplication instance = null;
    private java.util.List<Song> songsLibrary;

    /**
     * Private constructor to prevent external instantiation.
     * Initializes the local song library.
     */
    private MusicPlayerApplication() {
        songsLibrary = new ArrayList<>();
    }

    /**
     * Singleton instance getter.
     * @return MusicPlayerApplication ka ek shared instance.
     */
    public static synchronized MusicPlayerApplication getInstance() {
        if (instance == null) {
            instance = new MusicPlayerApplication();
        }
        return instance;
    }

    /**
     * Naya song create karke internal song library me add karta hai.
     *
     * @param title  Song ka title
     * @param artist Artist ka naam
     * @param path   File path jahan song stored hai
     */
    public void createSongInLibrary(String title, String artist, String path) {
        Song newSong = new Song(title, artist, path);
        songsLibrary.add(newSong);
    }

    /**
     * Song library me se title ke base pe song search karta hai.
     *
     * @param title Title of the song to search
     * @return Song object agar mil jaye; null agar nahi mila
     */
    public Song findSongByTitle(String title) {
        for (Song song : songsLibrary) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    /**
     * Ek nayi playlist create karta hai specified naam se.
     *
     * @param playlistName Playlist ka naam
     */
    public void createPlaylist(String playlistName) {
        PlaylistManager.getInstance().createPlaylist(playlistName);
    }

    /**
     * Ek existing playlist me song add karta hai (song title ke base pe search karke).
     *
     * @param playlistName Playlist jisme song add karna hai
     * @param songTitle    Title of the song to be added
     */
    public void addSongToPlaylist(String playlistName, String songTitle) {
        Song songByTitle = findSongByTitle(songTitle);
        if (songByTitle == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found in library.");
        }
        PlaylistManager.getInstance().addSongToPlaylist(playlistName, songByTitle);
    }

    /**
     * Audio device connect karta hai using DeviceType (e.g., Bluetooth, Wired).
     *
     * @param deviceType Device type to connect
     */
    public void connectAudioDevice(DeviceType deviceType) {
        MusicPlayerFacade.getInstance().connectDevice(deviceType);
    }

    /**
     * Play strategy set karta hai (e.g., Sequential, Random, Custom Queue).
     *
     * @param strategyType StrategyType enum value
     */
    public void selectPlayStrategy(StrategyType strategyType) {
        MusicPlayerFacade.getInstance().setPlayStrategy(strategyType);
    }

    /**
     * Playlist load karta hai jisse songs ko play kiya ja sake.
     *
     * @param playlistName Playlist ka naam
     */
    public void loadPlaylist(String playlistName) {
        MusicPlayerFacade.getInstance().loadPlaylist(playlistName);
    }

    /**
     * Ek specific song play karta hai based on song title.
     *
     * @param songTitle Title of the song to be played
     */
    public void playSingleSong(String songTitle) {
        Song songByTitle = findSongByTitle(songTitle);
        if (songByTitle == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found.");
        }
        MusicPlayerFacade.getInstance().playSong(songByTitle);
    }

    /**
     * Currently playing song ko pause karta hai (agar match karta hai given title se).
     *
     * @param songTitle Title of the song to be paused
     */
    public void pauseCurrentSong(String songTitle) {
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found.");
        }
        MusicPlayerFacade.getInstance().pauseSong(song);
    }

    /**
     * Puri playlist ke saare tracks ko sequentially (ya selected strategy ke according) play karta hai.
     */
    public void playAllTrackInPlaylist() {
        MusicPlayerFacade.getInstance().playAllTracks();
    }

    /**
     * Playlist me pehla gaana rewind karke pichla song play karta hai.
     */
    public void playPreviousTrackInPlaylist() {
        MusicPlayerFacade.getInstance().playPreviousTrack();
    }

    /**
     * Ek specific song ko next position ke liye queue me daal deta hai.
     *
     * @param songTitle Title of the song to queue next
     */
    public void queueSongNext(String songTitle) {
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found.");
        }
        MusicPlayerFacade.getInstance().enqueueNext(song);
    }
}
