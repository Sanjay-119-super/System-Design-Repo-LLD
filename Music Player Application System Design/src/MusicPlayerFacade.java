import core.AudioEngine;
import device.IAudioOutputDevice;
import enums.DeviceType;
import enums.StrategyType;
import managers.DeviceManager;
import managers.PlaylistManager;
import managers.StrategyManager;
import modules.Playlist;
import modules.Song;
import strategies.PlayStrategy;

/**
 * MusicPlayerFacade system ke core orchestration ka kaam karta hai.
 *
 * Ye class high-level actions perform karti hai jaise device connect karna,
 * playlist load karna, songs play/pause karna — bina internal complexity reveal kiye.
 *
 * Acts as a **Facade layer** between UI/Application and Subsystems like DeviceManager, StrategyManager, AudioEngine etc.
 */
public class MusicPlayerFacade {

    private static MusicPlayerFacade instance = null;
    private AudioEngine audioEngine;
    private Playlist loadedPlaylist;
    private PlayStrategy playStrategy;

    /**
     * Private constructor — Singleton pattern enforce karta hai.
     */
    private MusicPlayerFacade() {
        loadedPlaylist = null;
        playStrategy = null;
        audioEngine = new AudioEngine();
    }

    /**
     * Singleton instance getter.
     *
     * @return MusicPlayerFacade ka ek shared global instance
     */
    public static synchronized MusicPlayerFacade getInstance() {
        if (instance == null) {
            instance = new MusicPlayerFacade();
        }
        return instance;
    }

    /**
     * Audio device ko connect karta hai via DeviceManager.
     *
     * @param deviceType DeviceType enum (e.g., BLUETOOTH, WIRED, HEADPHONE)
     */
    public void connectDevice(DeviceType deviceType) {
        DeviceManager.getInstance().connect(deviceType);
    }

    /**
     * Playback ke liye strategy select karta hai (e.g., SEQUENTIAL, RANDOM).
     *
     * @param strategy StrategyType enum
     */
    public void setPlayStrategy(StrategyType strategy) {
        playStrategy = StrategyManager.getInstance().getStrategy(strategy);
    }

    /**
     * Playlist load karta hai aur selected strategy ko playlist assign karta hai.
     *
     * @param name Playlist ka naam
     * @throws RuntimeException agar strategy pehle set nahi ki gayi ho
     */
    public void loadPlaylist(String name) {
        loadedPlaylist = PlaylistManager.getInstance().getPlaylist(name);
        if (playStrategy == null) {
            throw new RuntimeException("Play strategy not set before loading playlist");
        }
        playStrategy.setPlaylist(loadedPlaylist);
    }

    /**
     * Ek individual song ko play karta hai selected output device ke through.
     *
     * @param song Song object to play
     * @throws RuntimeException agar device connect nahi hua ho
     */
    public void playSong(Song song) {
        if (!DeviceManager.getInstance().hadOutputDevice()) {
            throw new RuntimeException("No audio device connected");
        }
        IAudioOutputDevice device = DeviceManager.getInstance().getOutputDevice();
        audioEngine.play(device, song);
    }

    /**
     * Currently playing song ko pause karta hai agar title match karta ho.
     *
     * @param song Song object to pause
     * @throws RuntimeException agar song currently playing song se match na kare
     */
    public void pauseSong(Song song) {
        if (!audioEngine.getCurrentSongTitle().equals(song.getTitle())) {
            throw new RuntimeException("Cannot pause \"" + song.getTitle() + "\"; not currently playing");
        }
        audioEngine.pause();
    }

    /**
     * Saare gaane playlist se play karta hai according to selected strategy.
     *
     * @throws RuntimeException agar playlist load nahi hui ho
     */
    public void playAllTracks() {
        if (loadedPlaylist == null) {
            throw new RuntimeException("No playlist loaded");
        }
        while (playStrategy.hasNext()) {
            Song nextSong = playStrategy.next();
            IAudioOutputDevice outputDevice = DeviceManager.getInstance().getOutputDevice();
            audioEngine.play(outputDevice, nextSong);
        }
        System.out.println("Completed playlist: " + loadedPlaylist.getPlaylistName());
    }

    /**
     * Next song play karta hai current playlist aur selected strategy ke according.
     *
     * @throws RuntimeException agar playlist load nahi hui ho
     */
    public void playNextTrack() {
        if (loadedPlaylist == null) {
            throw new RuntimeException("No playlist loaded");
        }
        if (playStrategy.hasNext()) {
            Song nextSong = playStrategy.next();
            IAudioOutputDevice device = DeviceManager.getInstance().getOutputDevice();
            audioEngine.play(device, nextSong);
        } else {
            System.out.println("Completed playlist: " + loadedPlaylist.getPlaylistName());
        }
    }

    /**
     * Previous track ko play karta hai agar available ho.
     *
     * @throws RuntimeException agar playlist load nahi hui ho
     */
    public void playPreviousTrack() {
        if (loadedPlaylist == null) {
            throw new RuntimeException("No playlist loaded");
        }
        if (playStrategy.hadPrevious()) {
            Song preSong = playStrategy.previous();
            IAudioOutputDevice device = DeviceManager.getInstance().getOutputDevice();
            audioEngine.play(device, preSong);
        } else {
            System.out.println("Completed playlist: " + loadedPlaylist.getPlaylistName());
        }
    }

    /**
     * Custom queue strategy ke liye kisi song ko next queue me daal deta hai.
     *
     * @param song Song to enqueue as next
     */
    public void enqueueNext(Song song) {
        playStrategy.addToNext(song);
    }
}
