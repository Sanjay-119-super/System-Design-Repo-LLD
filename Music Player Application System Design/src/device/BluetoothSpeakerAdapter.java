package device;

import externals.BluetoothSpeakerAPI;
import modules.Song;

/**
 * BluetoothSpeakerAdapter ek adapter class hai jo `IAudioOutputDevice` interface ko implement karti hai.
 * Ye class 3rd-party BluetoothSpeakerAPI ko internally wrap karti hai aur usse connect karti hai humare app ke flow se.
 *
 * Use-case:
 * Jab bhi hum Bluetooth output device use karte hain, ye adapter internally external API se communicate karta hai.
 */
public class BluetoothSpeakerAdapter implements IAudioOutputDevice {

    private BluetoothSpeakerAPI bluetoothSpeakerAPI;

    /**
     * Constructor me external BluetoothSpeakerAPI object inject kiya jata hai.
     * Isse adapter external dependency ke sath tightly bind ho jata hai (dependency injection pattern).
     *
     * @param bluetoothSpeakerAPI external API jo Bluetooth speaker ke sath communicate karta hai
     */
    public BluetoothSpeakerAdapter(BluetoothSpeakerAPI bluetoothSpeakerAPI) {
        this.bluetoothSpeakerAPI = bluetoothSpeakerAPI;
    }

    /**
     * Ye method interface ka implementation hai.
     * Song ke title aur artist se ek string payload bana kar external Bluetooth API ko bhejta hai.
     *
     * Real-world me yahi payload external speaker par song information dikhata hai.
     *
     * @param song - jo song play karna hai
     */
    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        bluetoothSpeakerAPI.playSongViaBluetooth(payload);
    }
}
