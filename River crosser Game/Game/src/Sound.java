import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import sun.audio.*;

import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;


public class Sound {
    public void music()

    {
         URL resource = getClass().getResource("a.mp3");
         Media media = new Media(resource.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);

    }
}
