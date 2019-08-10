import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AlarmBox {
    public  static void Display(String Massege){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Instraction");
        window.setMinWidth(350);
        window.setMinHeight(200);
        Label Massage=new Label("");
        Massage.setText(Massege);
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
