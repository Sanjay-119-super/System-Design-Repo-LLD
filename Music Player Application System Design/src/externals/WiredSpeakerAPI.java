package externals;

/**
 * Ye class wired speaker systems ko represent karti hai
 * jo generally AUX cable ya other wired connection ke through kaam karte hain.
 *
 * External devices ke liye ye API song data ko device tak transfer karti hai.
 */
public class WiredSpeakerAPI {

    /**
     * Ye method cable-connected speaker par song play karne ke liye data print karti hai.
     *
     * @param data - song ka description (title + artist)
     */
    public void playSongByCable(String data){
        System.out.println("[Wired Speaker playing]: " + data);
    }
}
