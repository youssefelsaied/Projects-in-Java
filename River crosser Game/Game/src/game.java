import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class game {
    private static game ourInstance = new game();

    public static game getInstance() {
        return ourInstance;
    }

    private game() {}
    Stage Window;
    Scene welcomeScene;
    public List<ICrosser> rightBankCrossers=new ArrayList<>();
    public List<ICrosser> leftBankCrossers=new ArrayList<>();
    public List<ICrosser> boatRiders=new ArrayList<>();

    Stack AofChars =new Stack<String>();
    String g;

    public void start(Stage primaryStage) throws Exception {
        Window = primaryStage;
        story1 s1=new story1();
        Story2 s2=new Story2();
        story3 s3 = new story3();
        GraphicsContext gc;


        //home page >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Image image1=new Image(getClass().getResourceAsStream("B1.png"),100,100,false,false);
        Button story1 = new Button("Story 1");
        story1.setGraphic(new ImageView(image1));

        Image image2=new Image(getClass().getResourceAsStream("b2.png"),100,100,false,false);
        Button story2 = new Button("Story 2");
        story2.setGraphic(new ImageView(image2));

        Image images3=new Image(getClass().getResourceAsStream("b2.png"),100,100,false,false);
        Button story3 = new Button("Story 3");
        story3.setGraphic(new ImageView(images3));

        Button loadGame = new Button("Load story 1");
        Button loadGame2 = new Button("Load Story 2");
        Button loadGame3 = new Button("Load Story 3");
        Label welcomeLabel = new Label();
        welcomeLabel.setText("River Crossing ");

        StackPane welcomePane = new StackPane();

        welcomePane.setMargin(welcomeLabel,new Insets(40,0,260,0));

        welcomePane.setMargin(story1,new Insets(100,380,100,20));
        welcomePane.setMargin(loadGame,new Insets(200,380,0,20));

        welcomePane.setMargin(story2,new Insets(100,200,100,200));
        welcomePane.setMargin(loadGame2,new Insets(200,200,0,200));

        welcomePane.setMargin(story3,new Insets(100,20,100,380));
        welcomePane.setMargin(loadGame3,new Insets(200,20,0,380));

        ObservableList welcomeList  = welcomePane.getChildren();
        welcomeList.addAll(story1,story2,loadGame,welcomeLabel,loadGame2,story3,loadGame3);
        welcomeScene= new Scene(welcomePane,600,300);
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
        Image image15=new Image(getClass().getResourceAsStream("solve1.png"),50,50,false,false);
        Button solve1 =new Button();
        solve1.setGraphic(new ImageView(image15));
        Image imageinfo1=new Image(getClass().getResourceAsStream("info.png"),50,50,false,false);
        Button info1= new Button();
        info1.setGraphic(new ImageView(imageinfo1));

        Label score1 = new Label ("moves: " + s1.score);
        score1.getStyleClass().add("score");

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
        pane.setMargin(solve1,new Insets(550,0,100,150));
        pane.setMargin(score1,new Insets(550,120,100,500));


        ObservableList welcomeList2  = pane.getChildren();
        welcomeList2.addAll(goAhead1,backAhead1,redo,default1,undo,exit,farmerGo,TigerGo,PlantGo,RabbitGo,info1,score1,solve1);
        Image image3=new Image("background.png");
        ImageView iv =new ImageView(image3);


        Group root =new Group();
        Scene scene2=new Scene(root,900,625);

        Canvas canvas =new Canvas(900,625);
        root.getChildren().addAll(iv,canvas,pane);
        gc =canvas.getGraphicsContext2D();
        primaryStage.setResizable(false);

        scene2.getStylesheets().add("st.css");




        //story 2 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        StackPane pane2 = new StackPane();

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


        Image imageG=new Image(getClass().getResourceAsStream("GOAT1.png"),50,50,false,false);
        Button goat = new Button();
        goat.setGraphic(new ImageView(imageG));


        Image imageinfo2=new Image(getClass().getResourceAsStream("info.png"),50,50,false,false);
        Button info2= new Button();
        info2.setGraphic(new ImageView(imageinfo2));

        Label score2 = new Label ("moves: \n" + s2.score);

        pane2.setMargin(goAhead11,new Insets(10,0,640,750));
        pane2.setMargin(backAhead11,new Insets(10,0,640,750));
        pane2.setMargin(undo2,new Insets(550,0,100,750));
        pane2.setMargin(info2,new Insets(550,0,100,0));
        pane2.setMargin(default2,new Insets(550,900,100,0));
        pane2.setMargin(exit2,new Insets(550,750,100,10));
        pane2.setMargin(redo2,new Insets(550,10,100,600));
        pane2.setMargin(goat,new Insets(10,295,640,0));
        pane2.setMargin(f1,new Insets(10,895,640,0));
        pane2.setMargin(f2,new Insets(10,745,640,0));
        pane2.setMargin(f3,new Insets(10,595,640,0));
        pane2.setMargin(f4,new Insets(10,445,640,0));
        pane2.setMargin(score2,new Insets(550,120,100,0));


        ObservableList welcomeList3  = pane2.getChildren();
        welcomeList3.addAll(goAhead11,backAhead11,undo2,default2,exit2,redo2,goat,f1,f2,f3,f4,info2,score2);
        Image image32=new Image("background.png");
        ImageView ivv =new ImageView(image32);
        Group root2 =new Group();

        Canvas canvas2 =new Canvas(900,625);
        root2.getChildren().addAll(ivv,canvas2,pane2);
        GraphicsContext gc2 =canvas2.getGraphicsContext2D();
        primaryStage.setResizable(false);
        Scene scene3=new Scene(root2,900,625);
        primaryStage.setResizable(true);



        //story 3 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        StackPane paneS3 = new StackPane();

        Image imageS31=new Image(getClass().getResourceAsStream("right.png"),50,50,false,false);
        Button goAhead3 = new Button();
        goAhead3.setGraphic(new ImageView(imageS31));

        Image imageS32=new Image(getClass().getResourceAsStream("left.png"),50,50,false,false);
        Button backAhead3 = new Button();
        backAhead3.setGraphic(new ImageView(imageS32));

        Image imageS33=new Image(getClass().getResourceAsStream("undo.png"),50,50,false,false);
        Button undo3 = new Button();
        undo3.setGraphic(new ImageView(imageS33));

        Image imageS34=new Image(getClass().getResourceAsStream("reload.png"),50,50,false,false);
        Button default3= new Button();
        default3.setGraphic(new ImageView(imageS34));

        Image imageS35=new Image(getClass().getResourceAsStream("redo.png"),50,50,false,false);
        Button redo3 = new Button();
        redo3.setGraphic(new ImageView(imageS35));

        Image imageS36=new Image(getClass().getResourceAsStream("exit.png"),50,50,false,false);
        Button exit3 = new Button();
        exit3.setGraphic(new ImageView(imageS36));

        Image imagep1=new Image(getClass().getResourceAsStream("p1-1.png"),50,50,false,false);
        Button p1 = new Button();
        p1.setGraphic(new ImageView(imagep1));

        Image imagep2=new Image(getClass().getResourceAsStream("p2-1.png"),50,50,false,false);
        Button p2 = new Button();
        p2.setGraphic(new ImageView(imagep2));

        Image imagep3=new Image(getClass().getResourceAsStream("p3-1.png"),50,50,false,false);
        Button p3 = new Button();
        p3.setGraphic(new ImageView(imagep3));

        Image imagep4=new Image(getClass().getResourceAsStream("p4-1.png"),50,50,false,false);
        Button p4 = new Button();
        p4.setGraphic(new ImageView(imagep4));


        Image imagep5=new Image(getClass().getResourceAsStream("p5-1.png"),50,50,false,false);
        Button p5 = new Button();
        p5.setGraphic(new ImageView(imagep5));


        Image imageinfo3=new Image(getClass().getResourceAsStream("info.png"),50,50,false,false);
        Button info3= new Button();
        info3.setGraphic(new ImageView(imageinfo3));

        Label score3 = new Label ("moves: \n" + s3.score);

        paneS3.setMargin(goAhead3,new Insets(10,0,640,750));
        paneS3.setMargin(backAhead3,new Insets(10,0,640,750));
        paneS3.setMargin(undo3,new Insets(550,0,100,750));
        paneS3.setMargin(info3,new Insets(550,0,100,0));
        paneS3.setMargin(default3,new Insets(550,900,100,0));
        paneS3.setMargin(exit3,new Insets(550,750,100,10));
        paneS3.setMargin(redo3,new Insets(550,10,100,600));
        paneS3.setMargin(p5,new Insets(10,295,640,0));
        paneS3.setMargin(p1,new Insets(10,895,640,0));
        paneS3.setMargin(p2,new Insets(10,745,640,0));
        paneS3.setMargin(p3,new Insets(10,595,640,0));
        paneS3.setMargin(p4,new Insets(10,445,640,0));
        paneS3.setMargin(score3,new Insets(550,120,100,0));

        ObservableList welcomeListS3  = paneS3.getChildren();

        welcomeListS3.addAll(goAhead3,backAhead3,undo3,default3,exit3,redo3,p5,p1,p2,p3,p4,info3,score3);
        Image imageS3=new Image("background.png");
        ImageView iv3 =new ImageView(imageS3);
        Group root3 =new Group();

        Canvas canvas3 =new Canvas(900,625);
        root3.getChildren().addAll(iv3,canvas3,paneS3);
        GraphicsContext gc3 =canvas3.getGraphicsContext2D();
        primaryStage.setResizable(false);
        Scene sceneS3=new Scene(root3,900,625);
        primaryStage.setResizable(true);



        //Buttons story 1>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        story1.setOnAction(event -> {

            s1.draw(gc);
            Window.setScene(scene2);
            backAhead1.setVisible(false);
            goAhead1.setVisible(true);
            AlarmBox.Display(s1.getInstructions());

        });

        undo.setOnAction(event -> {

            if (s1.canUndo()==true)
                s1.undo(gc);
            else
                AlarmBox.Display("No Previous Moves");

            score1.setText("moves: \n " + s1.score);

        });
        redo.setOnAction(event -> {

            //   if (s1.canRedo()==true)
            s1.redo(gc);
            score1.setText("moves: \n " + s1.score);
            // else
            //   AlarmBox.Display("No Previous Moves");


        });
        exit.setOnAction(event -> {
            s1.save();
            Window.setScene(welcomeScene);
            s1.resetGame(gc);
            score1.setText("moves: \n 0");
        });
        solve1.setOnAction(event -> {
            s1.resetGame(gc);
            s1.movef(gc,"f");
            s1.movef(gc,"r");
            AlarmBox.Display(" rabbit first");
            s1.mover(gc,"raft");
            score1.setText("moves: \n " + s1.score);
            s1.movef(gc,"f");
            AlarmBox.Display("let the farmer go back");
            s1.mover(gc,"raft");
            score1.setText("moves: \n " + s1.score);
            s1.movef(gc,"f");
            s1.movef(gc,"t");
            AlarmBox.Display("take tiger");
            s1.mover(gc,"raft");
            score1.setText("moves: \n " + s1.score);
            s1.movef(gc,"f");
            s1.movef(gc,"r");
            AlarmBox.Display("go back with  rabbit");
            s1.mover(gc,"raft");
            score1.setText("moves: \n " + s1.score);
            s1.movef(gc,"f");
            s1.movef(gc,"p");
            AlarmBox.Display("take plant");
            s1.mover(gc,"raft");
            score1.setText("moves: \n " + s1.score);
            s1.movef(gc,"f");
            AlarmBox.Display("let the farmer go back");
            s1.mover(gc,"raft");
            score1.setText("moves: \n " + s1.score);
            s1.movef(gc,"f");
            s1.movef(gc,"r");
            AlarmBox.Display("  finally rabbit ");
            s1.mover(gc,"raft");
            score1.setText("moves: \n " + s1.score);
        });
        farmerGo.setOnAction(event -> {

            s1.movef(gc,"f");
            AofChars.push("f");

        });
        TigerGo.setOnAction(event -> {
            s1.movef(gc,"t");
        });
        RabbitGo.setOnAction(event -> {
            s1.movef(gc,"r");
            AofChars.push("r");

        });
        PlantGo.setOnAction(event -> {

            s1.movef(gc,"p");
            AofChars.push("p");

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
        loadGame.setOnAction(e->
        {

            Window.setScene(scene2);
            s1.readxml(gc);
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
            s2.save();
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
        loadGame2.setOnAction(e->
        {

            Window.setScene(scene3);
            s2.readxml(gc2);
        });
        undo2.setOnAction(event -> {
            if (s2.canUndo()==true)
                s2.undo(gc2);
            else
                AlarmBox.Display("No Previous Moves");

            score2.setText("moves: \n    " + s2.score);
        });
        redo2.setOnAction(event -> {

            //   if (s2.canRedo()==true)
            s2.redo(gc2);
            score2.setText("moves: \n    " + s2.score);
            //    else
            //        AlarmBox.Display("No Previous Moves");


        });

        // buttons story 3>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        story3.setOnAction(event -> {
            s3.draw(gc3);
            Window.setScene(sceneS3);
            backAhead3.setVisible(false);
            goAhead3.setVisible(true);
            AlarmBox.Display(s3.getInstructions());
        });
        exit3.setOnAction(event -> {
            s3.save();
            Window.setScene(welcomeScene);
            s3.resetGame(gc3);
            score3.setText("moves: \n ");
        });

        p1.setOnAction(event -> {

            s3.movef(gc3,"f1");
        });


        p2.setOnAction(event -> {

            s3.movef(gc3,"f2");
        });

        p3.setOnAction(event -> {

            s3.movef(gc3,"f3");
        });

        p4.setOnAction(event -> {

            s3.movef(gc3,"f4");
        });


        p5.setOnAction(event -> {

            s3.movef(gc3,"f5");
        });
        goAhead3.setOnAction(event -> {
            if(s3.isvalid(rightBankCrossers,leftBankCrossers,boatRiders)==true) {
                s3.mover(gc3,"raft");
                goAhead3.setVisible(false);
                score3.setText("moves: \n    " + s3.score);
                backAhead3.setVisible(true);
            }
            else
                AlarmBox.Display("Move is invalid");

        });
        backAhead3.setOnAction(event -> {
            if(s3.isvalid(rightBankCrossers,leftBankCrossers,boatRiders)==true) {


                s3.mover(gc3,"raft");
                score3.setText("moves: \n    " + s3.score);
                goAhead3.setVisible(true);
                backAhead3.setVisible(false);
            }
            else
                AlarmBox.Display("Move is invalid");

        });
        default3.setOnAction(event -> {
            s3.resetGame(gc3);
            score3.setText("moves: \n ");
            goAhead3.setVisible(true);
            backAhead3.setVisible(false);
        });
        info3.setOnAction(event -> {
            AlarmBox.Display(s3.getInstructions());
        });
        loadGame3.setOnAction(e->
        {

            Window.setScene(sceneS3);
            s3.readxml(gc3);
        });
        undo3.setOnAction(event -> {
            if (s3.canUndo()==true)
                s3.undo(gc3);
            else
                AlarmBox.Display("No Previous Moves");

            score3.setText("moves: \n    " + s3.score);
        });
        redo3.setOnAction(event -> {

            //   if (s2.canRedo()==true)
            s3.redo(gc3);
            score3.setText("moves: \n    " + s3.score);
            //    else
            //        AlarmBox.Display("No Previous Moves");


        });


    }
}

