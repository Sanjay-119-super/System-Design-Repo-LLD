package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ✅ TimeUtils — Date aur time se related reusable utility methods provide karta hai
 *
 * ⚙️ Working:
 * - `getCurrentTime()` current system time ko custom format me return karta hai
 * - Format: "EEE MMM dd HH:mm:ss yyyy" (e.g., Mon Jun 09 17:45:32 2025)
 *
 * 💬 Interview Angle:
 * - Utility classes single-responsibility principle follow karte hain
 * - DateTimeFormatter ka use thread-safe aur flexible hota hai
 *
 * ❓ Why?
 * - Logging aur notifications me human-readable timestamp chahiye hota hai
 * - Standardization ke liye ek hi consistent format use karna best practice hoti hai
 */
public class TimeUtils {

    /**
     * getCurrentTime — System ka current date & time return karta hai ek specific string format me
     *
     * @return String — formatted current timestamp (e.g., "Mon Jun 09 17:45:32 2025")
     */
    public static String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss yyyy");
        return now.format(formatter);
    }
}
