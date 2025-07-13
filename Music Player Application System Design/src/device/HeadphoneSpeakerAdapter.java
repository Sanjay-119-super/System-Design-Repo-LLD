package device;

import externals.HeadphoneSpeakerAPI;
import modules.Song;

/**
 * HeadphoneSpeakerAdapter ek adapter class hai jo `IAudioOutputDevice` interface ko implement karti hai.
 * Iska kaam hai: 3rd-party HeadphoneSpeakerAPI ko humare audio system ke interface ke sath bridge karna.
 *
 * Jab hum wired headphone ya jack-based speaker connect karte hain,
 * to ye adapter internally HeadphoneSpeakerAPI ka use karke output device ko handle karta hai.
 */
public class HeadphoneSpeakerAdapter implements IAudioOutputDevice {

    private HeadphoneSpeakerAPI headphoneSpeakerAPI;

    /**
     * Constructor dependency injection ke through external HeadphoneSpeakerAPI ko receive karta hai.
     * Isse adapter tightly couple ho jata hai external API ke sath, bina hardcoding ke.
     *
     * @param headphoneSpeakerAPI - external API jo jack-based speaker ko handle karta hai
     */
    public HeadphoneSpeakerAdapter(HeadphoneSpeakerAPI headphoneSpeakerAPI) {
        this.headphoneSpeakerAPI = headphoneSpeakerAPI;
    }

    /**
     * Ye method interface ka actual implementation hai.
     * Song ke title aur artist ka ek human-readable payload banake external API ko send karta hai.
     *
     * Real-world me ye payload jack-connected device par song information bhejta hai.
     *
     * @param song - jo song play karna hai
     */
    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        headphoneSpeakerAPI.playSongViaJack(payload);
    }
}
