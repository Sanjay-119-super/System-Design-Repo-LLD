package device;

import modules.Song;

/**
 * IAudioOutputDevice ek interface hai jo har output device (jaise Bluetooth speaker, Headphone speaker, etc.)
 * ke liye **standard contract** define karta hai.
 *
 * Iska main purpose hai:
 * - Har audio device ko ek common structure dena
 * - Polymorphism ke through interchangeable usage allow karna
 *
 * Is interface ko implement karne wali har class ko `playAudio(Song song)` method define karna hoga.
 */
public interface IAudioOutputDevice {

    /**
     * Ye method har output device me implement hoti hai.
     * Iska kaam hota hai diya gaya song ko device-specific way me play karna.
     *
     * @param song - jo song play karna hai device par
     */
    void playAudio(Song song);
}
