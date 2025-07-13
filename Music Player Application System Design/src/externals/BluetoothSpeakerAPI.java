package externals;

/**
 * Ye class external Bluetooth speaker system ko represent karti hai.
 *
 * Real-world me ye kisi 3rd-party Bluetooth SDK/API ka wrapper ho sakta hai.
 * Iska kaam hai data ko Bluetooth-compatible format me send karna.
 */
public class BluetoothSpeakerAPI {

    /**
     * Ye method song data ko Bluetooth speaker par play karne ke liye bhejti hai.
     *
     * @param data - song ka readable text (title + artist)
     */
    public void playSongViaBluetooth(String data){
        System.out.println("[Bluetooth Speaker] playing: " + data);
        // Real implementation me external API call hoti yahan
    }
}
