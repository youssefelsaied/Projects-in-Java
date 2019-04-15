import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.*;
import javafx.scene.control.Label;
public class AlarmBox {


    public  static void DisplayAlert(){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Bus Station");
        window.setMinWidth(250);
        window.setMinHeight(200);
        Label Massage=new Label(" NO More Avilable Seats");
        Button closebtn=new Button("Close");
        closebtn.setOnAction(e -> window.close());

        VBox vlay=new VBox(10);
        vlay.getChildren().addAll(Massage,closebtn);
        vlay.setAlignment(Pos.CENTER);
        Scene vScene=new Scene(vlay);
        window.setScene(vScene);
        window.showAndWait();
    }
}
