import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainAtm extends Application {
    Stage window;
    Scene loguser, logpass, home, deposits, withdraws;
    logicAtm back = new logicAtm();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        back.difTranscation();
        window = primaryStage;
        window.setTitle("login_ATM");
        //********** Scene one card number *********//
        Label lb1 = new Label("card number ");
        TextField tx1 = new TextField();
        Button button1 = new Button("next");
        button1.getStyleClass().add("login_button");
        button1.setOnAction(e -> window.setScene(logpass));

        Button b1 = new Button("1");
        b1.setOnAction(event -> tx1.setText(tx1.getText() + "1"));
        Button b2 = new Button("2");
        b2.setOnAction(event -> tx1.setText(tx1.getText() + "2"));
        Button b3 = new Button("3");
        b3.setOnAction(event -> tx1.setText(tx1.getText() + "3"));
        Button b4 = new Button("4");
        b4.setOnAction(event -> tx1.setText(tx1.getText() + "4"));
        Button b5 = new Button("5");
        b5.setOnAction(event -> tx1.setText(tx1.getText() + "5"));
        Button b6 = new Button("6");
        b6.setOnAction(event -> tx1.setText(tx1.getText() + "6"));
        Button b7 = new Button("7");
        b7.setOnAction(event -> tx1.setText(tx1.getText() + "7"));
        Button b8 = new Button("8");
        b8.setOnAction(event -> tx1.setText(tx1.getText() + "8"));
        Button b9 = new Button("9");
        b9.setOnAction(event -> tx1.setText(tx1.getText() + "9"));
        Button b0 = new Button("0");
        b0.setOnAction(event -> tx1.setText(tx1.getText() + "0"));
        Button bcl = new Button("Clr");
        bcl.setOnAction(event -> tx1.setText(""));
        Button clo = new Button("Close");
        clo.setOnAction(event -> window.close());

        GridPane grid1 = new GridPane();

        grid1.add(lb1, 0, 0);
        grid1.add(tx1, 1, 0);
        grid1.add(button1, 3, 0);
        grid1.add(b1, 0, 4);
        grid1.add(b2, 1, 4);
        grid1.add(b3, 2, 4);
        grid1.add(b4, 0, 6);
        grid1.add(b5, 1, 6);
        grid1.add(b6, 2, 6);
        grid1.add(b7, 0, 8);
        grid1.add(b8, 1, 8);
        grid1.add(b9, 2, 8);
        grid1.add(b0, 1, 9);
        grid1.add(bcl, 2, 9);
        grid1.add(clo, 0, 9);
        grid1.setAlignment(Pos.CENTER);

        loguser = new Scene(grid1, 500, 500);
        loguser.getStylesheets().add("styleAtm.css");
        //********** End Scene one card number *********//

        //********** Scene two Password *********//
        Label lb2 = new Label("Password    ");
        PasswordField tx2 = new PasswordField();
        Button button2 = new Button("Prev");
        Button b01 = new Button("1");
        b01.setOnAction(event -> tx2.setText(tx2.getText() + "1"));
        Button b02 = new Button("2");
        b02.setOnAction(event -> tx2.setText(tx2.getText() + "2"));
        Button b03 = new Button("3");
        b03.setOnAction(event -> tx2.setText(tx2.getText() + "3"));
        Button b04 = new Button("4");
        b04.setOnAction(event -> tx2.setText(tx2.getText() + "4"));
        Button b05 = new Button("5");
        b05.setOnAction(event -> tx2.setText(tx2.getText() + "5"));
        Button b06 = new Button("6");
        b06.setOnAction(event -> tx2.setText(tx2.getText() + "6"));
        Button b07 = new Button("7");
        b07.setOnAction(event -> tx2.setText(tx2.getText() + "7"));
        Button b08 = new Button("8");
        b08.setOnAction(event -> tx2.setText(tx2.getText() + "8"));
        Button b09 = new Button("9");
        b09.setOnAction(event -> tx2.setText(tx2.getText() + "9"));
        Button b00 = new Button("0");
        b00.setOnAction(event -> tx2.setText(tx2.getText() + "0"));
        Button b0cl = new Button("Clr");
        b0cl.setOnAction(event -> tx2.setText(""));

        button2.setOnAction(e -> primaryStage.setScene(loguser));
        Button log_in = new Button("log in");
        log_in.getStyleClass().add("login_button");

        log_in.setOnAction(e -> {
            String username = tx1.getText();
            String password = tx2.getText();
            boolean valid = back.validate(username, password);
            if (valid) {
                window.setScene(home);
                tx1.setText("");
                tx2.setText("");
            } else {
                tx1.setText("");
                tx2.setText("");
                AlertAtm.wrongPassOrNum();
                window.setScene(loguser);
            }
        });
        GridPane grid2 = new GridPane();
        grid2.add(lb2, 0, 0);
        grid2.add(tx2, 1, 0);
        grid2.add(log_in, 4, 0);
        grid2.add(b01, 0, 4);
        grid2.add(b02, 1, 4);
        grid2.add(b03, 2, 4);
        grid2.add(b04, 0, 5);
        grid2.add(b05, 1, 5);
        grid2.add(b06, 2, 5);
        grid2.add(b07, 0, 6);
        grid2.add(b08, 1, 6);
        grid2.add(b09, 2, 6);
        grid2.add(b00, 1, 7);
        grid2.add(b0cl, 2, 7);
        grid2.add(button2, 0, 7);


        grid2.setAlignment(Pos.CENTER);
        logpass = new Scene(grid2, 500, 500);
        logpass.getStylesheets().add("styleAtm.css");

        // scene2.getStylesheets().add("style.css");

        //********** End Scene two Password *********//
        button1.setOnAction(e -> window.setScene(logpass));
        //**********  Scene Withdraw *********//
        Label withlabel = new Label("Enter the amount");
        withlabel.getStyleClass().add("label_stoke");
        TextField withtext = new TextField();
        Button withbutton = new Button("Withdraw");

        Button b001 = new Button("1");
        b001.setOnAction(event -> withtext.setText(withtext.getText() + "1"));
        Button b002 = new Button("2");
        b002.setOnAction(event -> withtext.setText(withtext.getText() + "2"));
        Button b003 = new Button("3");
        b003.setOnAction(event -> withtext.setText(withtext.getText() + "3"));
        Button b004 = new Button("4");
        b004.setOnAction(event -> withtext.setText(withtext.getText() + "4"));
        Button b005 = new Button("5");
        b005.setOnAction(event -> withtext.setText(withtext.getText() + "5"));
        Button b006 = new Button("6");
        b006.setOnAction(event -> withtext.setText(withtext.getText() + "6"));
        Button b007 = new Button("7");
        b007.setOnAction(event -> withtext.setText(withtext.getText() + "7"));
        Button b008 = new Button("8");
        b008.setOnAction(event -> withtext.setText(withtext.getText() + "8"));
        Button b009 = new Button("9");
        b009.setOnAction(event -> withtext.setText(withtext.getText() + "9"));
        Button b000 = new Button("0");
        b000.setOnAction(event -> withtext.setText(withtext.getText() + "0"));
        Button b00cl = new Button("Clr");
        b00cl.setOnAction(event -> withtext.setText(""));


        GridPane withgrid = new GridPane();

        withgrid.add(b001, 0, 4);
        withgrid.add(b002, 1, 4);
        withgrid.add(b003, 2, 4);
        withgrid.add(b004, 0, 6);
        withgrid.add(b005, 1, 6);
        withgrid.add(b006, 2, 6);
        withgrid.add(b007, 0, 8);
        withgrid.add(b008, 1, 8);
        withgrid.add(b009, 2, 8);
        withgrid.add(b000, 1, 9);
        withgrid.add(b00cl, 2, 9);
        withgrid.add(withlabel, 0, 0);
        withgrid.add(withtext, 1, 0);
        withgrid.add(withbutton, 3, 0);
        withbutton.getStyleClass().add("home_button");
        withgrid.setAlignment(Pos.CENTER);
        withdraws = new Scene(withgrid, 600, 400);
        withdraws.getStylesheets().add("styleAtm.css");

        //**********  End Scene Withdraw *********//

        //**********   Scene Deposit *********//
        Label depolabel = new Label("Enter the amount");
        depolabel.getStyleClass().add("label_stoke");
        TextField depotext = new TextField();
        Button depobutton = new Button("Deposit");
        Button b10 = new Button("1");
        b10.setOnAction(event -> depotext.setText(depotext.getText() + "1"));
        Button b20 = new Button("2");
        b20.setOnAction(event -> depotext.setText(depotext.getText() + "2"));
        Button b30 = new Button("3");
        b30.setOnAction(event -> depotext.setText(depotext.getText() + "3"));
        Button b40 = new Button("4");
        b40.setOnAction(event -> depotext.setText(depotext.getText() + "4"));
        Button b50 = new Button("5");
        b50.setOnAction(event -> depotext.setText(depotext.getText() + "5"));
        Button b60 = new Button("6");
        b60.setOnAction(event -> depotext.setText(depotext.getText() + "6"));
        Button b70 = new Button("7");
        b70.setOnAction(event -> depotext.setText(depotext.getText() + "7"));
        Button b80 = new Button("8");
        b80.setOnAction(event -> depotext.setText(depotext.getText() + "8"));
        Button b90 = new Button("9");
        b90.setOnAction(event -> depotext.setText(depotext.getText() + "9"));
        Button b0o0 = new Button("0");
        b0o0.setOnAction(event -> depotext.setText(depotext.getText() + "0"));
        Button bcl00 = new Button("Clr");
        bcl00.setOnAction(event -> depotext.setText(""));


        GridPane depogrid = new GridPane();
        depogrid.add(depolabel, 0, 0);
        depogrid.add(depotext, 1, 0);
        depogrid.add(depobutton, 3, 0);
        depogrid.add(b10, 0, 4);
        depogrid.add(b20, 1, 4);
        depogrid.add(b30, 2, 4);
        depogrid.add(b40, 0, 6);
        depogrid.add(b50, 1, 6);
        depogrid.add(b60, 2, 6);
        depogrid.add(b70, 0, 8);
        depogrid.add(b80, 1, 8);
        depogrid.add(b90, 2, 8);
        depogrid.add(b0o0, 1, 9);
        depogrid.add(bcl00, 2, 9);

        depogrid.setAlignment(Pos.CENTER);

        deposits = new Scene(depogrid, 600, 400);
        deposits.getStylesheets().add("styleAtm.css");


//**********  End Scene Deposit *********//

//**********  Scene Home *********//
        GridPane gridh = new GridPane();

        Button pre = new Button("previous");
        pre.getStyleClass().add("home_button");

        Button balan = new Button("Balance");
        balan.setAlignment(Pos.CENTER);
        balan.getStyleClass().add("home_button");
        gridh.add(balan, 1, 0);

        Label transactiont = new Label("");
        transactiont.setAlignment(Pos.CENTER);
        GridPane.setHalignment(transactiont, HPos.CENTER);
        transactiont.getStyleClass().add("tran");
        gridh.add(transactiont, 1, 2);

        Button next = new Button("Next");
        next.getStyleClass().add("home_button");


        next.setOnAction(event -> {
            back.incre();
            transactiont.setText(back.gettransactione());

        });
        pre.setOnAction(event -> {
            back.decre();
            transactiont.setText(back.gettransactione());
        });

        balan.setOnAction(event ->
        {
            back.getbalance();
            transactiont.setText(String.valueOf(back.gettransaction()));

        });

        Button withdraw = new Button("Withdraw");
        withdraw.getStyleClass().add("home_button");
        withdraw.setOnAction(event -> {
            window.setScene(withdraws);
        });
        gridh.add(withdraw, 2, 0);

        Button deposit = new Button("Deposit");
        deposit.getStyleClass().add("home_button");
        deposit.setOnAction(event -> {
            window.setScene(deposits);
        });

        gridh.add(deposit, 0, 0);
        gridh.add(pre, 0, 2);
        gridh.add(next, 2, 2);

        Button history = new Button("History");
        history.setAlignment(Pos.BASELINE_CENTER);
        history.getStyleClass().add("home_button");
        history.setOnAction(event -> {
          transactiont.setText(String.valueOf(back.gettransaction()));
        });
        gridh.add(history, 1, 1);

        Button logout = new Button("Log_out");
        logout.setOnAction(event -> window.setScene(loguser));
        gridh.add(logout, 1, 3);

        gridh.setAlignment(Pos.CENTER);
        home = new Scene(gridh, 700, 600);
        home.getStylesheets().add("styleAtm.css");

        GridPane.setMargin(history, new Insets(10, 0, 10, 70));
        GridPane.setMargin(balan, new Insets(0, 70, 0, 70));
        GridPane.setMargin(logout, new Insets(0, 0, 0, 80));

        //**********  End Scene Home *********//
        withbutton.setOnAction(event -> {
            back.Withdraw(Integer.parseInt(withtext.getText()));
            window.setScene(home);
            withtext.setText("");
            transactiont.setText(String.valueOf(back.gettransaction()));
        });
        depobutton.setOnAction(event -> {
            back.Deposite(Integer.parseInt(depotext.getText()));
            window.setScene(home);
            depotext.setText("");
            transactiont.setText(String.valueOf(back.gettransaction()));
        });


        //****************** default Scene ****************//
        primaryStage.setScene(loguser);
        primaryStage.show();
        //****************** End default Scene ****************//

    }
}
