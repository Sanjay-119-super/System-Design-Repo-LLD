package factories;

import device.BluetoothSpeakerAdapter;
import device.HeadphoneSpeakerAdapter;
import device.IAudioOutputDevice;
import device.WiredSpeakerAdapter;
import enums.DeviceType;
import externals.BluetoothSpeakerAPI;
import externals.HeadphoneSpeakerAPI;
import externals.WiredSpeakerAPI;

/**
 * DeviceFactory ek **Factory Design Pattern** ka implementation hai
 * jo runtime par audio output device ka correct adapter return karta hai
 * based on user-selected DeviceType.
 *
 * Iska main purpose hai object creation logic ko centralized rakhna
 * taaki caller ko concrete implementation ki knowledge na ho.
 */
public class DeviceFactory {

    /**
     * Ye method user ke deviceType ke basis par proper device adapter object banata hai.
     *
     * - BLUETOOTH => BluetoothSpeakerAdapter
     * - WIRED => WiredSpeakerAdapter
     * - HEADPHONE (default case) => HeadphoneSpeakerAdapter
     *
     * Har adapter ke constructor me uska corresponding external API inject kiya jata hai.
     *
     * @param deviceType - user ka selected output device type
     * @return IAudioOutputDevice implementation (adapter object)
     */
    public static IAudioOutputDevice createDevice(DeviceType deviceType) {
        switch (deviceType) {

            case BLUETOOTH:
                // Bluetooth device ke liye adapter + API
                return new BluetoothSpeakerAdapter(new BluetoothSpeakerAPI());

            case WIRED:
                // Wired speaker ke liye adapter + API
                return new WiredSpeakerAdapter(new WiredSpeakerAPI());

            case HEADPHONE:
            default:
                // Default case me Headphone adapter return karo
                return new HeadphoneSpeakerAdapter(new HeadphoneSpeakerAPI());
        }
    }
}
