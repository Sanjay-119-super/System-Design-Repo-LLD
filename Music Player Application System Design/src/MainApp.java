import enums.DeviceType;
import enums.StrategyType;

/**
 * MainApp class music player ko run karne ka entry point hai.
 *
 * Is class me:
 * - Songs library me add kiye jaate hain
 * - Playlists create aur manage ki jaati hain
 * - Playback strategies apply ki jaati hain (Sequential, Random, Custom Queue)
 * - Devices connect karke music play/pause kiya jaata hai
 */
public class MainApp {

    /**
     * Main method application ka entry point hai.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        try {
            MusicPlayerApplication application = MusicPlayerApplication.getInstance();

            // Step 1: Songs add karo library me
            application.createSongInLibrary("Kesariya", "Arijit Singh", "/music/kesariya.mp3");
            application.createSongInLibrary("Chaiyya Chaiyya", "Sukhwinder Singh", "/music/chaiyya_chaiyya.mp3");
            application.createSongInLibrary("Tum Hi Ho", "Arijit Singh", "/music/tum_hi_ho.mp3");
            application.createSongInLibrary("Jai Ho", "A. R. Rahman", "/music/jai_ho.mp3");
            application.createSongInLibrary("Zinda", "Siddharth Mahadevan", "/music/zinda.mp3");

            // Step 2: Playlist create karo aur songs add karo
            application.createPlaylist("Bollywood Vibes");
            application.addSongToPlaylist("Bollywood Vibes", "Kesariya");
            application.addSongToPlaylist("Bollywood Vibes", "Chaiyya Chaiyya");
            application.addSongToPlaylist("Bollywood Vibes", "Tum Hi Ho");
            application.addSongToPlaylist("Bollywood Vibes", "Jai Ho");
            application.addSongToPlaylist("Bollywood Vibes", "Zinda");

            // Step 3: Single song play/pause test karo
            application.connectAudioDevice(DeviceType.BLUETOOTH);
            application.playSingleSong("Zinda");
            application.pauseCurrentSong("Zinda");
            application.playSingleSong("Zinda");

            // Step 4: Sequential playback strategy apply karo
            System.out.println("\n-- Sequential Playback --\n");
            application.selectPlayStrategy(StrategyType.SEQUENTIAL);
            application.loadPlaylist("Bollywood Vibes");
            application.playAllTrackInPlaylist();

            // Step 5: Random playback strategy apply karo
            System.out.println("\n-- Random Playback --\n");
            application.selectPlayStrategy(StrategyType.RANDOM);
            application.loadPlaylist("Bollywood Vibes");
            application.playAllTrackInPlaylist();

            // Step 6: Custom queue strategy apply karo
            System.out.println("\n-- Custom Queue Playback --\n");
            application.selectPlayStrategy(StrategyType.CUSTOM);
            application.loadPlaylist("Bollywood Vibes");
            application.queueSongNext("Kesariya");
            application.queueSongNext("Tum Hi Ho");
            application.playAllTrackInPlaylist();

            // Step 7: Sequential strategy ke through previous songs play karo
            System.out.println("\n-- Play Previous in Sequential --\n");
            application.selectPlayStrategy(StrategyType.SEQUENTIAL);
            application.loadPlaylist("Bollywood Vibes");
            application.playAllTrackInPlaylist();
            application.playPreviousTrackInPlaylist();
            application.playPreviousTrackInPlaylist();

        } catch (Exception err) {
            System.err.println("Error: " + err.getMessage());
        }
    }
}
