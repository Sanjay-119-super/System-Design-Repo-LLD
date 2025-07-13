package externals;

/**
 * Ye class headphone speaker system ko represent karti hai.
 *
 * Usually ye wired jack se connected devices ke liye hoti hai.
 * Iska role hai input data ko headphone device tak bhejna.
 */
public class HeadphoneSpeakerAPI {

    /**
     * Ye method headphone jack ke through song play karne ka simulation karti hai.
     *
     * @param data - song details (title + artist)
     */
    public void playSongViaJack(String data){
        System.out.println("[Headphone]: " + data);
    }
}
