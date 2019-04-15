import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AlertAtm {

    public static void wrongPassOrNum() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Log_in Validate");

        window.setMinWidth(300);
        window.setMinHeight(200);

        Label wrong = new Label("Wrong Card_Number or Password");
        Button close = new Button("Close");
        close.setOnAction(event -> window.close());
        VBox wrongLayout = new VBox();
        wrongLayout.getChildren().addAll(wrong, close);
        wrongLayout.setAlignment(Pos.CENTER);

        Scene wrongScene = new Scene(wrongLayout);
        wrongScene.getStylesheets().add("styleAtm.css");

        window.setScene(wrongScene);
        window.showAndWait();
    }

    public static void wrongWithdraw() {
        Stage windowWithdraw = new Stage();
        windowWithdraw.initModality(Modality.APPLICATION_MODAL);
        windowWithdraw.setTitle(" Withdraw ");

        windowWithdraw.setMinWidth(400);
        windowWithdraw.setMinHeight(200);

        Label wrongWithdraw = new Label("No enough Balance To Withdraw");
        Button closeWithdraw = new Button("Close");
        closeWithdraw.setOnAction(event -> windowWithdraw.close());

        VBox wrongWithdrawLayout = new VBox();
        wrongWithdrawLayout.getChildren().addAll(wrongWithdraw, closeWithdraw);
        wrongWithdrawLayout.setAlignment(Pos.CENTER);

        Scene wrongWithdrawScene = new Scene(wrongWithdrawLayout);
        wrongWithdrawScene.getStylesheets().add("styleAtm.css");

        windowWithdraw.setScene(wrongWithdrawScene);
        windowWithdraw.showAndWait();
    }


}
