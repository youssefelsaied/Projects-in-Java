import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class game1 extends Application {
    Stage Window;
    Scene welcomeScene;
    public List<ICrosser> rightBankCrossers=new ArrayList<>();
    public List<ICrosser> leftBankCrossers=new ArrayList<>();
    public List<ICrosser> boatRiders=new ArrayList<>();



    public static void main(String[] args) {
        launch(args);

    }
    public void start(Stage primaryStage) throws Exception {
        Sound sound = new Sound();
        Window = primaryStage;
        story1 s1=new story1();
        Story2 s2=new Story2();
        GraphicsContext gc;


        //home page >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Image image1=new Image(getClass().getResourceAsStream("B1.png"),100,100,false,false);
        Button story1 = new Button("Story 1");
        story1.setGraphic(new ImageView(image1));
        Image image2=new Image(getClass().getResourceAsStream("b2.png"),100,100,false,false);
        Button story2 = new Button("Story 2");
        story2.setGraphic(new ImageView(image2));
        Button loadGame = new Button("Load Game");
        Label welcomeLabel = new Label();
        welcomeLabel.setText("River Crossing ");

        StackPane welcomePane = new StackPane();

        welcomePane.setMargin(loadGame,new Insets(200,0,0,0));
        welcomePane.setMargin(story2,new Insets(100,50,100,200));
        welcomePane.setMargin(story1,new Insets(100,200,100,0));
        welcomePane.setMargin(welcomeLabel,new Insets(40,0,260,0));
        ObservableList welcomeList  = welcomePane.getChildren();
        welcomeList.addAll(story1,story2,loadGame,welcomeLabel);
        welcomeScene= new Scene(welcomePane,500,300);
        welcomeScene.getStylesheets().add("st.css");
        Window.setScene(welcomeScene);
        Window.show();


        //story 1 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        StackPane pane = new StackPane();

        Image image4=new Image(getClass().getResourceAsStream("right.png"),50,50,false,false);
        Button goAhead1 = new Button();
        goAhead1.setGraphic(new ImageView(image4));
        Image image5=new Image(getClass().getResourceAsStream("left.png"),50,50,false,false);
        Button backAhead1 = new Button();
        backAhead1.setGraphic(new ImageView(image5));
        Image image7=new Image(getClass().getResourceAsStream("redo.png"),50,50,false,false);
        Button redo = new Button();
        redo.setGraphic(new ImageView(image7));
        Image image8=new Image(getClass().getResourceAsStream("reload.png"),50,50,false,false);
        Button default1 = new Button();
        default1.setGraphic(new ImageView(image8));
        Image image9=new Image(getClass().getResourceAsStream("undo.png"),50,50,false,false);
        Button undo = new Button();
        undo.setGraphic(new ImageView(image9));
        Image image10=new Image(getClass().getResourceAsStream("exit.png"),50,50,false,false);
        Button exit = new Button();
        exit.setGraphic(new ImageView(image10));

        Image image11=new Image(getClass().getResourceAsStream("f1.png"),50,50,false,false);
        Button  farmerGo = new Button();
        farmerGo.setGraphic(new ImageView(image11));

        Image image12=new Image(getClass().getResourceAsStream("Tiger1.png"),50,50,false,false);
        Button TigerGo = new Button();
        TigerGo.setGraphic(new ImageView(image12));
        Image image13=new Image(getClass().getResourceAsStream("plant.png"),50,50,false,false);
        Button PlantGo = new Button();
        PlantGo.setGraphic(new ImageView(image13));
        Image image14=new Image(getClass().getResourceAsStream("Rabbit1.png"),50,50,false,false);
        Button RabbitGo = new Button();
        RabbitGo.setGraphic(new ImageView(image14));

        Image imageinfo1=new Image(getClass().getResourceAsStream("info.png"),50,50,false,false);
        Button info1= new Button();
        info1.setGraphic(new ImageView(imageinfo1));

        Label score1 = new Label ("moves: \n" + s1.score);

        pane.setMargin(goAhead1,new Insets(10,70,640,0));
        pane.setMargin(backAhead1,new Insets(10,70,640,0));
        pane.setMargin(default1,new Insets(550,900,100,0));
        pane.setMargin(exit,new Insets(550,750,100,10));
        pane.setMargin(undo,new Insets(550,0,100,750));
        pane.setMargin(redo,new Insets(550,10,100,600));
        pane.setMargin(info1,new Insets(550,0,100,0));
        pane.setMargin(farmerGo,new Insets(10,900,640,0));
        pane.setMargin(TigerGo,new Insets(10,750,640,10));
        pane.setMargin(PlantGo,new Insets(10,0,640,750));
        pane.setMargin(RabbitGo,new Insets(10,10,640,600));
        pane.setMargin(score1,new Insets(550,120,100,0));


        ObservableList welcomeList2  = pane.getChildren();
        welcomeList2.addAll(goAhead1,backAhead1,redo,default1,undo,exit,farmerGo,TigerGo,PlantGo,RabbitGo,info1,score1);
        Image image3=new Image("background.png");
        ImageView iv =new ImageView(image3);


        Group root =new Group();
        Scene scene2=new Scene(root,900,625);

        Canvas canvas =new Canvas(900,625);
        root.getChildren().addAll(iv,canvas,pane);
        gc =canvas.getGraphicsContext2D();
        primaryStage.setResizable(false);





        //story 2 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        StackPane pane2 = new StackPane();
        GridPane pane3 = new GridPane();

        Image image42=new Image(getClass().getResourceAsStream("right.png"),50,50,false,false);
        Button goAhead11 = new Button();
        goAhead11.setGraphic(new ImageView(image42));
        Image image52=new Image(getClass().getResourceAsStream("left.png"),50,50,false,false);
        Button backAhead11 = new Button();
        backAhead11.setGraphic(new ImageView(image52));
        Image image72=new Image(getClass().getResourceAsStream("undo.png"),50,50,false,false);
        Button undo2 = new Button();
        undo2.setGraphic(new ImageView(image72));
        Image image82=new Image(getClass().getResourceAsStream("reload.png"),50,50,false,false);
        Button default2 = new Button();
        default2.setGraphic(new ImageView(image82));
        Image image91=new Image(getClass().getResourceAsStream("redo.png"),50,50,false,false);
        Button redo2 = new Button();
        redo2.setGraphic(new ImageView(image91));
        Image image101=new Image(getClass().getResourceAsStream("exit.png"),50,50,false,false);
        Button exit2 = new Button();
        exit2.setGraphic(new ImageView(image101));

        Image imagef1=new Image(getClass().getResourceAsStream("f1-1.png"),50,50,false,false);
        Button f1 = new Button();
        f1.setGraphic(new ImageView(imagef1));

        Image imagef2=new Image(getClass().getResourceAsStream("f2-1.png"),50,50,false,false);
        Button f2 = new Button();
        f2.setGraphic(new ImageView(imagef2));

        Image imagef3=new Image(getClass().getResourceAsStream("f3-1.png"),50,50,false,false);
        Button f3 = new Button();
        f3.setGraphic(new ImageView(imagef3));

        Image imagef4=new Image(getClass().getResourceAsStream("f4-1.png"),50,50,false,false);
        Button f4 = new Button();
        f4.setGraphic(new ImageView(imagef4));

        Image imageR=new Image(getClass().getResourceAsStream("RABBIT1.png"),50,50,false,false);
        Button rabbit = new Button();
        rabbit.setGraphic(new ImageView(imageR));

        Image imageG=new Image(getClass().getResourceAsStream("GOAT1.png"),50,50,false,false);
        Button goat = new Button();
        goat.setGraphic(new ImageView(imageG));

        Image imageL=new Image(getClass().getResourceAsStream("LION1.png"),50,50,false,false);
        Button lion = new Button();
        lion.setGraphic(new ImageView(imageL));

        Image imageT=new Image(getClass().getResourceAsStream("Tiger1.png"),50,50,false,false);
        Button tiger = new Button();
        tiger.setGraphic(new ImageView(imageT));

        Image imageinfo2=new Image(getClass().getResourceAsStream("info.png"),50,50,false,false);
        Button info2= new Button();
        info2.setGraphic(new ImageView(imageinfo2));

        Label score2 = new Label ("moves: \n" + s2.score);

        pane2.setMargin(goAhead11,new Insets(10,70,640,0));
        pane2.setMargin(backAhead11,new Insets(10,70,640,0));
        pane2.setMargin(undo2,new Insets(550,0,100,750));
        pane2.setMargin(info2,new Insets(550,0,100,0));
        pane2.setMargin(default2,new Insets(550,900,100,0));
        pane2.setMargin(exit2,new Insets(550,750,100,10));
        pane2.setMargin(redo2,new Insets(550,10,100,600));
        pane2.setMargin(tiger,new Insets(10,0,640,760));
        pane2.setMargin(lion,new Insets(10,0,640,610));
        pane2.setMargin(rabbit,new Insets(10,0,640,460));
        pane2.setMargin(goat,new Insets(10,0,640,310));
        pane2.setMargin(f1,new Insets(10,895,640,0));
        pane2.setMargin(f2,new Insets(10,745,640,0));
        pane2.setMargin(f3,new Insets(10,595,640,0));
        pane2.setMargin(f4,new Insets(10,445,640,0));
        pane.setMargin(score2,new Insets(550,120,100,0));





        ObservableList welcomeList3  = pane2.getChildren();
        welcomeList3.addAll(goAhead11,backAhead11,undo2,default2,exit2,redo2,tiger,lion,rabbit,goat,f1,f2,f3,f4,info2,score2);
        Image image32=new Image("background.png");
        ImageView ivv =new ImageView(image32);
        Group root2 =new Group();

        Canvas canvas2 =new Canvas(900,625);
        root2.getChildren().addAll(ivv,canvas2,pane2,pane3);
        GraphicsContext gc2 =canvas2.getGraphicsContext2D();
        primaryStage.setResizable(false);
        Scene scene3=new Scene(root2,900,625);
        primaryStage.setResizable(true);


        //Buttons story 1>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        story1.setOnAction(event -> {
               sound.music();
            s1.draw(gc);
            Window.setScene(scene2);
            backAhead1.setVisible(false);
            goAhead1.setVisible(true);
            AlarmBox.Display(s1.getInstructions());

        });
        undo.setOnAction(event -> {


            s1.undo(gc);

        });
        redo.setOnAction(event -> {


            s1.redo(gc);

        });
        exit.setOnAction(event -> {
            Window.setScene(welcomeScene);
            s1.resetGame(gc);
            score1.setText("moves: \n 0");
        });

        farmerGo.setOnAction(event -> {

            s1.movef(gc,"f");
        });
        TigerGo.setOnAction(event -> {

            s1.movef(gc,"t");
        });
        RabbitGo.setOnAction(event -> {

            s1.movef(gc,"r");
        });
        PlantGo.setOnAction(event -> {

            s1.movef(gc,"p");
        });

        default1.setOnAction(event -> {
            s1.resetGame(gc);
            score1.setText("moves: \n 0");
            goAhead1.setVisible(true);
            backAhead1.setVisible(false);
        });

        goAhead1.setOnAction(event -> {
            if(s1.isvalid(rightBankCrossers,leftBankCrossers,boatRiders)==true) {
                s1.mover(gc, "raft");
                score1.setText("moves: \n " + s1.score);
                goAhead1.setVisible(false);
                backAhead1.setVisible(true);
            }
            else
                AlarmBox.Display("Wrong Move");

        });
        backAhead1.setOnAction(event -> {if(s1.isvalid(rightBankCrossers,leftBankCrossers,boatRiders)==true) {

            s1.mover(gc, "raft");
            score1.setText("moves: \n" + s1.score);
            goAhead1.setVisible(true);
            backAhead1.setVisible(false);
        }
        else
            AlarmBox.Display("Wrong Move");

        });
        info1.setOnAction(event -> {
            AlarmBox.Display(s1.getInstructions());
        });

        //buttons story 2>>>>>>>>>>>>>>>>>>>>>>
        story2.setOnAction(event -> {
            s2.draw(gc2);
            Window.setScene(scene3);
            backAhead11.setVisible(false);
            goAhead11.setVisible(true);
            AlarmBox.Display(s2.getInstructions());
        });
        exit2.setOnAction(event -> {
            Window.setScene(welcomeScene);
            s2.resetGame(gc2);
            score2.setText("moves: \n 0");
        });

        f1.setOnAction(event -> {

            s2.movef(gc2,"f1");
        });


        f2.setOnAction(event -> {

            s2.movef(gc2,"f2");
        });

        f3.setOnAction(event -> {

            s2.movef(gc2,"f3");
        });

        f4.setOnAction(event -> {

            s2.movef(gc2,"f4");
        });

       tiger.setOnAction(event -> {

            s2.movef(gc2,"t");
        });
        rabbit.setOnAction(event -> {

            s2.movef(gc2,"r");
        });
       lion.setOnAction(event -> {

            s2.movef(gc2,"l");
        });
        goat.setOnAction(event -> {

            s2.movef(gc2,"g");
        });
        goAhead11.setOnAction(event -> {
            if(s2.isvalid(rightBankCrossers,leftBankCrossers,boatRiders)==true) {
                s2.mover(gc2,"raft");
                goAhead11.setVisible(false);
                score2.setText("moves: \n    " + s2.score);
                backAhead11.setVisible(true);
            }
            else
                AlarmBox.Display("Move is invalid");

        });
        backAhead11.setOnAction(event -> {
            if(s2.isvalid(rightBankCrossers,leftBankCrossers,boatRiders)==true) {


                s2.mover(gc2,"raft");
                score2.setText("moves: \n    " + s2.score);
                goAhead11.setVisible(true);
                backAhead11.setVisible(false);
            }
            else
                AlarmBox.Display("Move is invalid");

        });
        default2.setOnAction(event -> {
            s2.resetGame(gc2);
            score2.setText("moves: \n 0");
            goAhead11.setVisible(true);
            backAhead11.setVisible(false);
        });
        info2.setOnAction(event -> {
            AlarmBox.Display(s2.getInstructions());
        });

        undo2.setOnAction(event -> {


            s2.undo(gc2);

        });
        redo2.setOnAction(event -> {


            s2.redo(gc2);

        });




    }
}