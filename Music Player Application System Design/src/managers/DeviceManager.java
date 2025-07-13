package managers;

import device.IAudioOutputDevice;
import enums.DeviceType;
import factories.DeviceFactory;

/**
 * DeviceManager ek **singleton class** hai jo currently connected audio output device ko manage karti hai.
 *
 * Ye class:
 * - Device ko connect karne ka centralized logic deti hai
 * - Factory pattern ka use karke proper adapter banati hai
 * - Current connected device ka reference hold karti hai
 */
public class DeviceManager {

    private static DeviceManager deviceManager = null;
    private IAudioOutputDevice currentOutputDevice;

    private DeviceManager() {
        currentOutputDevice = null;
    }

    /**
     * Singleton pattern: globally ek hi instance maintain karta hai
     */
    public static synchronized DeviceManager getInstance() {
        if (deviceManager == null) {
            deviceManager = new DeviceManager();
        }
        return deviceManager;
    }

    /**
     * Ye method user ke selected device type ke basis par audio output device connect karta hai.
     * Internally DeviceFactory ka use karta hai adapter banane ke liye.
     *
     * @param deviceType - user selected device type (BLUETOOTH / WIRED / HEADPHONE)
     */
    public void connect(DeviceType deviceType) {
        if (currentOutputDevice != null) {
            // already connected, optionally disconnect or overwrite
        }

        currentOutputDevice = DeviceFactory.createDevice(deviceType);

        // Device type ke according console message
        switch (deviceType) {
            case BLUETOOTH:
                System.out.println("Bluetooth device connected");
                break;
            case WIRED:
                System.out.println("Wired device connected");
                break;
            case HEADPHONE:
                System.out.println("Headphone device connected");
                break;
        }
    }

    /**
     * Ye method return karta hai currently connected output device.
     * Agar koi device connected nahi hai to exception throw karega.
     *
     * @return IAudioOutputDevice - connected device
     */
    public IAudioOutputDevice getOutputDevice() {
        if (currentOutputDevice == null) {
            throw new RuntimeException("No device connected");
        }
        return currentOutputDevice;
    }

    /**
     * Utility method jo batata hai ki device connected hai ya nahi.
     *
     * @return true if device connected, false otherwise
     */
    public boolean hadOutputDevice() {
        return currentOutputDevice != null;
    }
}
