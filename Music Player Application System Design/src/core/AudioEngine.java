package core;

import device.IAudioOutputDevice;
import modules.Song;

/**
 * AudioEngine class music system ka main core engine hai jo songs play, pause aur resume karta hai.
 * Ye class handle karta hai song ka state (paused ya not paused) aur current playing song ko track karta hai.
 *
 * Iska use MusicPlayerFacade ya kisi bhi controller class me hota hai jahan real playback ka logic chahiye hota hai.
 */
public class AudioEngine {
    private Song currentSong;
    private boolean songIsPaused;

    /**
     * Constructor initialize karta hai default state:
     * - currentSong null hoti hai (koi song loaded nahi)
     * - songIsPaused false hota hai (kuch bhi paused nahi)
     */
    public AudioEngine() {
        this.currentSong = null;
        this.songIsPaused = false;
    }

    /**
     * Ye method current playing song ka title return karta hai.
     * Agar koi song play nahi ho raha, to blank string return karega.
     *
     * @return current song title ya "" agar koi song loaded nahi hai.
     */
    public String getCurrentSongTitle(){
        if (currentSong != null){
            return currentSong.getTitle();
        }
        return "";
    }

    /**
     * Ye method batata hai ki kya song pause state me hai ya nahi.
     * @return true agar paused hai, warna false
     */
    public boolean isPaused(){
        return songIsPaused;
    }

    /**
     * Ye core method hai song ko play karne ke liye.
     *
     * Flow:
     * - Agar same song already paused hai to resume karega
     * - Agar naya song hai to currentSong ko update karega aur play karega
     *
     * @param audioOutputDevice - jisme output sunna hai (Bluetooth, Speaker, etc.)
     * @param song - play karne wala song
     */
    public void play(IAudioOutputDevice audioOutputDevice , Song song){
        if (song == null){
            throw new RuntimeException("Cannot play a null song");
        }

        // Agar same song paused hai to resume karo
        if (songIsPaused && song == currentSong){
            songIsPaused = false;
            System.out.println("Resuming song: " + song.getTitle());
            audioOutputDevice.playAudio(song);
            return;
        }

        // Naya song ya already playing song again requested
        currentSong = song;
        songIsPaused = false;
        System.out.println("Playing song: " + song.getTitle());
        audioOutputDevice.playAudio(song);
    }

    /**
     * Ye method current playing song ko pause karta hai.
     *
     * Error handling:
     * - Agar koi song play hi nahi ho raha to error throw karega
     * - Agar song already paused hai to duplicate pause se bacha lega
     */
    public void pause(){
        if (currentSong == null){
            throw new RuntimeException("No song currently playing to pause.");
        }

        if (songIsPaused){
            throw new RuntimeException("Song is already paused");
        }

        songIsPaused = true;
        System.out.println("Pausing Song: " + currentSong.getTitle());
    }
}
