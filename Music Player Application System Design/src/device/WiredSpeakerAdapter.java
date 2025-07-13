package device;

import externals.WiredSpeakerAPI;
import modules.Song;

/**
 * WiredSpeakerAdapter ek adapter class hai jo `IAudioOutputDevice` interface ko implement karti hai.
 *
 * Iska kaam hai external WiredSpeakerAPI ko humare internal interface se connect karna.
 *
 * Ye class **Adapter Design Pattern** ka part hai, jahan hum external APIs ko compatible banate hain
 * system ke common interface ke through.
 *
 * Use-case:
 * Jab user wired speaker (cable se connected) use karta hai, to ye adapter WiredSpeakerAPI ke through playback handle karta hai.
 */
public class WiredSpeakerAdapter implements IAudioOutputDevice {

    private WiredSpeakerAPI wiredSpeakerAPI;

    /**
     * Constructor ke through WiredSpeakerAPI instance inject kiya jata hai.
     * Isse adapter external wired speaker system ke sath bind ho jata hai.
     *
     * @param wiredSpeakerAPI - external API jo cable-connected speaker ko handle karta hai
     */
    public WiredSpeakerAdapter(WiredSpeakerAPI wiredSpeakerAPI) {
        this.wiredSpeakerAPI = wiredSpeakerAPI;
    }

    /**
     * Ye method song ko play karne ke liye WiredSpeakerAPI ka use karti hai.
     * Song ka title aur artist mila kar ek string banayi jati hai jo external device ko bheji jati hai.
     *
     * @param song - jo song user sunna chahta hai
     */
    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        wiredSpeakerAPI.playSongByCable(payload);
    }
}
