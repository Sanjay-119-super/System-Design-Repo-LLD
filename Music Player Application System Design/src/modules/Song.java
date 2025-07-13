package modules;

/**
 * Song class ek individual music track ko represent karti hai.
 *
 * Ye class song ke title, artist, aur file path jaise information hold karti hai.
 */
public class Song {

    private String title;
    private String artist;
    private String filePath;

    /**
     * Constructor ke through song ka title, artist, aur file path set hota hai.
     *
     * @param title - song ka naam
     * @param artist - singer ya creator ka naam
     * @param filePath - local file ya storage path jahan song store hai
     */
    public Song(String title, String artist, String filePath) {
        this.title = title;
        this.artist = artist;
        this.filePath = filePath;
    }

    /**
     * Song ka title return karta hai
     *
     * @return song title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Song ka artist (singer name) return karta hai
     *
     * @return artist name
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Song ka file path return karta hai
     *
     * @return file system path of the song
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Song ka readable format me string representation return karta hai
     *
     * @return song details as string
     */
    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
