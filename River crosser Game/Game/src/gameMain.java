import javafx.application.Application;
import javafx.stage.Stage;

public class gameMain extends Application {
    game g=game.getInstance();

    public static void main(String[] args) {
        music.play();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        g.start(primaryStage);
    }
}
