import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class music {
    private static music ourInstance = new music();

    public static music getInstance() {
        return ourInstance;
    }

    private music() {

    }
    public static void play()
    {
        String uriString = new File("src\\game-of-thrones-theme-song-ringtone-30782.mp3").toURI().toString();
        MediaPlayer Player = new MediaPlayer( new Media(uriString));
        Player.play();
            }
}
