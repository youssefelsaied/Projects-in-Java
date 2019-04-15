import com.sun.org.apache.bcel.internal.generic.Select;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.StringTokenizer;

public class GUwelcome extends Application {
    Stage Window;
    Label driverID2;
    Label driverCarNumText;
    Label driverCarNumOfSeatsText;
    Label driverNameText;
    Label driverCarColorText;
    Label driverCarTypeText;
    Label driverIDText2;
    Label passengername;
    String save;
    StringTokenizer strPrice;
    StringTokenizer strPrice1;
    StringTokenizer strPrice2;
    StringTokenizer strPrice3;
    Trips trips=new Trips();
    Trips trips1=new Trips();
    Trips trips2=new Trips();
    Trips trips3=new Trips();
    Trips trips4=new Trips();
    Trips trips5=new Trips();
    Ticket ticket = new Ticket();
    Ticket ticket1 = new Ticket();
    Driver driverObject =new Driver();
    passenger passengerObject=new passenger();
    public String user="passenger";
    public String curLocation = "Alexandria";
    private Scene welcomescene;
    public Scene managerTripss;
    public Scene managerScene2;
    public Scene managerScene3;
    public Scene driverScene2;
    public Scene passengerScene;
    public Scene passenger2;
    public Scene passenger3;
    public Scene passenger4;
    public Scene passenger5;
    public Scene passenger6;
    public Scene passenger7;
    public Scene passenger8;
    public Scene passenger9;
    public Scene passenger10;
    public Scene managerScene;
    public Scene driverScene;
    public Scene DriverScene3;
    public GridPane passenger1Grid;
    public GridPane passenger2Grid;
    public GridPane passenger3Grid;
    String viewTicket;
   private int selectedIndex=-1;
    private int selectedIndex1=-1;
    private int selectedIndex2=-1;
    private int selectedIndex3=-1;
    private int priceIndex=-1;
    private int priceIndex1=-1;
    ListView IncityList;
    ListView OutcityList;
    TextField passengerTextID;
    TextField driverTextID;
    ListView Selected;
    ListView oneWay;
    ListView twoway;
    ListView twooutway;
    ListView oneoutway;
    private String km;
    private String way;
    private String km1;
    private String way1;
    private String km2;
    private String way2;
    private String km3;
    private String way3;
    String inIndex;
    String inIndex1;
    String inIndex2;
    String inIndex3;
    Label pricelabel23;
    public static void main(String[] args) {
        launch(args);

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Window = primaryStage;
       // trips.getfromFile();

//trips.declarationOfAt();
        Label welcome=new Label("Welcome to Takisa Bus Station App");


        Label choose=new Label("Your Identification");
        ToggleGroup groupp =new ToggleGroup();
        //radio1
        RadioButton welcomePassenger=new RadioButton("Passenger ");
        welcomePassenger.setToggleGroup(groupp);
        welcomePassenger.setSelected(true);
        welcomePassenger.setOnAction(event ->  user="passenger");


        //radio2
        RadioButton welcomemanger=new RadioButton("Manger ");
        welcomemanger.setToggleGroup(groupp);
        welcomemanger.setOnAction(event ->  user="manger");

        //radio3
        RadioButton welcomedriver=new RadioButton("Driver ");
        welcomedriver.setToggleGroup(groupp);
        welcomedriver.setOnAction(event ->  user="driver");
        Button login =new Button("log in");

        login.setOnAction(event -> {
            if(user=="passenger")
            Window.setScene(passengerScene);
            else if(user=="manger")
                Window.setScene(managerScene);
            else if(user=="driver")
                Window.setScene(driverScene);
            else
                Window.setScene(welcomescene);
        });

        VBox welcomeLayout = new VBox();

        welcomeLayout.setSpacing(5);

        welcomeLayout.setMargin(welcome, new Insets(5, 50, 5, 120));
        welcomeLayout.setMargin(choose, new Insets (10, 0, 5, 180));
        welcomeLayout.setMargin(welcomePassenger, new Insets (10, 50, 5, 220));
        welcomeLayout.setMargin(welcomemanger, new Insets (20, 50, 5, 230));
        welcomeLayout.setMargin(welcomedriver, new Insets (20, 50, 5, 235));
        welcomeLayout.setMargin(login, new Insets (50, 20, 5, 250));

        ObservableList<Node> welcomeList  = welcomeLayout.getChildren();

        welcomeList.addAll(welcome,choose,welcomePassenger,welcomemanger,welcomedriver,login);

        welcomescene=new Scene(welcomeLayout,600,600);
        welcomescene.getStylesheets().add("styleAtm.css");
        Window.setScene(welcomescene);
        Window.show();

// passenger Grid 1 //
        Label passengerUserName = new Label("User Name");
        Label passengerPassword = new Label("Password");
        Label passengererror = new Label("");
         passengerTextID = new TextField();
        TextField passengerTextPassword = new TextField();


        passenger passengerValidation=new passenger();
        Button passengerLog_in = new Button("Log in");
        passengerLog_in.setOnAction(event -> {
            String passengerUserNameField = passengerTextID.getText();
            String passengerPasswordField = passengerTextPassword.getText();
            passengerValidation.Validation();
            boolean passengerValid = passengerValidation.Valid(passengerUserNameField, passengerPasswordField);
            if (passengerValid==true) {
                Window.setScene(passenger2);
                passengername.setText(passengerTextID.getText()+"    ");
                passengerTextPassword.setText("");
               // passengerTextID.setText("");
            }
            else{
                passengererror.setText("wrong username or password");
                passengerTextID.setText("");
                passengerTextPassword.setText("");
            }
        });
        Button BackfrompassengertoWelcome=new Button("Back");
        BackfrompassengertoWelcome.setOnAction(event -> {
            Window.setScene(welcomescene);
            passengerTextPassword.setText("");
            passengerTextID.setText("");
        });

        passenger1Grid = new GridPane();
        passenger1Grid.add(passengerUserName, 0, 0);
        passenger1Grid.setAlignment(Pos.CENTER);
        passenger1Grid.add(passengerTextID, 1, 0);
        passenger1Grid.add(passengerPassword, 0, 1);
        passenger1Grid.add(passengererror, 1, 3);
        passenger1Grid.add(passengerTextPassword, 1, 1);
        passenger1Grid.add(passengerLog_in, 0, 2);
        passenger1Grid.add(BackfrompassengertoWelcome, 2, 2);

        passengerScene = new Scene(passenger1Grid, 600, 220);
        passengerScene.getStylesheets().add("styleAtm.css");

// End passenger Grid 1 //

// passenger Grid 2 //
        passengername=new Label();
        passengername.setAlignment(Pos.CENTER);
        Button bookTicket=new Button("Book Your Ticket Now");
bookTicket.setAlignment(Pos.CENTER);
        bookTicket.setOnAction(event -> Window.setScene(passenger3));
        Button viewyourtickets=new Button("View Your Tickets");
        viewyourtickets.setOnAction(event -> {Window.setScene(passenger6);
            ticket.viewTicket(passengerTextID.getText());
        });
        Button backFormpassenger2to1=new Button("Back");
        backFormpassenger2to1.setId("back");
        backFormpassenger2to1.setOnAction(event -> Window.setScene(passengerScene));
        passenger2Grid=new GridPane();
        passenger2Grid.add(passengername, 0, 0);
        passenger2Grid.add(bookTicket, 0, 1);
        passenger2Grid.add(viewyourtickets, 2, 1);
        passenger2Grid.add(backFormpassenger2to1, 1, 2);
        passenger1Grid.setAlignment(Pos.CENTER);
        passenger2=new Scene(passenger2Grid,500,200);
        passenger2.getStylesheets().add("styleAtm.css");
// End passenger Grid 2 //

        // passenger Grid 3 //

        Label chooose=new Label("Choose Your Current Location   ");
        ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
        choiceBox1.setId("choco");
        choiceBox1.getItems().addAll("Alexandria");
        choiceBox1.setValue("Alexandria");
        choiceBox1.getItems().addAll("Cairo");
        choiceBox1.getItems().addAll("Aswan");
        Button backfrom3to2=new Button("Back");
        backfrom3to2.setId("back");
        backfrom3to2.setOnAction(event -> Window.setScene(passenger2));
        Button nextfrom3toin=new Button("InCity");
        nextfrom3toin.setOnAction(event -> {
            Window.setScene(passenger4);
            selectedIndex2=choiceBox1.getSelectionModel().getSelectedIndex();
            String inIndex=choiceBox1.getItems().get(selectedIndex2);
            IncityList.getItems().clear();
            trips2.getcurlocation(inIndex);
        });
        Button nextfrom3toout=new Button("outCity");
        nextfrom3toout.setOnAction(event ->{
            Window.setScene(passenger5);
            selectedIndex2=choiceBox1.getSelectionModel().getSelectedIndex();
            String inIndex=choiceBox1.getItems().get(selectedIndex2);
            OutcityList.getItems().clear();
            trips3.getcurlocation(inIndex);
        });


        passenger3Grid=new GridPane();
        passenger3Grid.add(chooose, 0, 0);
        passenger3Grid.add(choiceBox1, 1, 0);
        passenger3Grid.add(backfrom3to2, 3, 2);
        passenger3Grid.add(nextfrom3toin, 2, 1);
        passenger3Grid.add(nextfrom3toout, 4, 1);

        passenger3=new Scene(passenger3Grid,900,250);
        passenger3.getStylesheets().add("styleAtm.css");
        // End passenger Grid 3 //


        // passenger scene 4//
        IncityList = trips2.getInlistView();
        ToggleGroup ingroup =new ToggleGroup();
        ToggleGroup ingroup1 =new ToggleGroup();
      //  Label pricelabel1=new Label("Price");
        //Label pricelabel2=new Label();
        //Button bookIncity = new Button("Book");
        /*IncityList.setOnMouseClicked(event -> {
            String price= IncityList.getSelectionModel().getSelectedItems().toString();
            priceIndex=IncityList.getSelectionModel().getSelectedIndex();
            strPrice = new StringTokenizer(price," ");
            for (int i=0;i<8;i++){
                km= strPrice.nextToken();
            }
            way=strPrice.nextToken();
            String h=Float.toString(ticket.price(km,way)) ;
            pricelabel2.setText(h);
});*/
   /* bookIncity.setOnAction(event -> {
            String selectbookin= IncityList.getSelectionModel().getSelectedItems().toString();
            passengerObject.book(passengerTextID.getText(),selectbookin);
        });*/
        RadioButton oneWayIn = new RadioButton("One-way Trip");
        oneWayIn.setToggleGroup(ingroup);
        oneWayIn.setOnAction(event -> {
             Window.setScene(passenger7);
             inIndex=choiceBox1.getItems().get(selectedIndex2);
             trips4.ways(inIndex);
        });
        RadioButton twoWayIn = new RadioButton("Round Trip");
        twoWayIn.setToggleGroup(ingroup);
        twoWayIn.setOnAction(event -> {
            Window.setScene(passenger8);
            inIndex1=choiceBox1.getItems().get(selectedIndex2);
            trips4.ways(inIndex1);
        });
        /*RadioButton zeroStopsIn = new RadioButton("Zero Stops");
        zeroStopsIn.setToggleGroup(ingroup1);
        RadioButton oneStopsIn = new RadioButton("One Stops");
       oneStopsIn.setToggleGroup(ingroup1);
        RadioButton manyStopsIn = new RadioButton("Many Stops");
        manyStopsIn.setToggleGroup(ingroup1);*/
        Button backtoscene3 = new Button("Back");
        backtoscene3.setOnAction(event -> Window.setScene(passenger3));
        GridPane incity = new GridPane();
        incity.setAlignment(Pos.CENTER);
     //   incity.add(bookIncity,0,2);
        incity.add(oneWayIn,0,0);
        incity.add(twoWayIn,1,0);
       // incity.add(zeroStopsIn,0,1);
       // incity.add(oneStopsIn,1,1);
      //  incity.add(manyStopsIn,2,1);
        //incity.add(pricelabel1,0,3);
        //incity.add(pricelabel2,1,3);
       // trips2.getfromFileInOrOut();
        passenger4 = new Scene(new Group());
        VBox incitypane = new VBox();
        incitypane.setSpacing(5);
        incitypane.setMargin(backtoscene3,new Insets(10,5,0,0));
        ObservableList<Node> incityList  = incitypane.getChildren();
        //incityList.addAll(bookIncity);
        incitypane.setPadding(new Insets(100,50,10,0));
        incitypane.getChildren().addAll(IncityList);
        incitypane.setAlignment(Pos.CENTER);
        Group group2 = (Group)passenger4.getRoot();
        group2.getChildren().addAll(incitypane,incity);
        group2.setLayoutX(50);
        incityList.addAll(backtoscene3);

        passenger4.getStylesheets().add("styleAtm.css");



        // passenger7//
        passenger7 = new Scene(new Group());
        Label av1=new Label("Avilable Seats");
        Label av2=new Label();
        Button bookIncity = new Button("Book");
        bookIncity.setOnAction(event -> {
            String selectbookin= oneWay.getSelectionModel().getSelectedItems().toString();
            if(passengerObject.AvilableSeats(passengerObject.removebrackets(selectbookin))>0){
            passengerObject.book(passengerTextID.getText(),selectbookin);
            av2.setText(Integer.toString(passengerObject.AvilableSeats(passengerObject.removebrackets(selectbookin))));
            }
            else
                AlarmBox.DisplayAlert();
        });
        Label pricelabel1=new Label("Price");
        Label pricelabel2=new Label();
        oneWay =trips4.getOneWaylistView();
        oneWay.setOnMouseClicked(event -> {

            String price= oneWay.getSelectionModel().getSelectedItems().toString();
           av2.setText(Integer.toString(passengerObject.AvilableSeats(passengerObject.removebrackets(price))));

            priceIndex=oneWay.getSelectionModel().getSelectedIndex();
            strPrice = new StringTokenizer(price," ");
            for (int i=0;i<8;i++){
                km= strPrice.nextToken();
            }
            way=strPrice.nextToken();
            String h=Float.toString(ticket.price(km,way)) ;
            pricelabel2.setText(h);
        });
        Button backtoscene44 = new Button("Back");
        backtoscene44.setOnAction(event -> {Window.setScene(passenger4);
        oneWay.getItems().clear();
            twoway.getItems().clear();
            pricelabel2.setText("");
            ingroup.selectToggle(null);
        });
        VBox onewaypane = new VBox();
        onewaypane.setId("list");
        onewaypane.setSpacing(5);
        onewaypane.setMargin(av1,new Insets(10,5,0,0));
        onewaypane.setMargin(av2,new Insets(10,5,0,0));
        onewaypane.setMargin(backtoscene44,new Insets(10,5,0,0));
        onewaypane.setMargin(bookIncity,new Insets(10,5,0,0));
        onewaypane.setMargin(pricelabel1,new Insets(0,5,0,0));
        onewaypane.setMargin(pricelabel2,new Insets(10,5,0,0));
        ObservableList<Node> onewayList  = onewaypane.getChildren();
        onewayList.addAll(pricelabel1,pricelabel2,av1,av2,bookIncity);
        onewaypane.setPadding(new Insets(50,50,10,0));
        onewaypane.getChildren().addAll(oneWay);
        onewaypane.setAlignment(Pos.CENTER);
        Group group888 = (Group)passenger7.getRoot();
        group888.getChildren().addAll(onewaypane);
        group888.setLayoutX(50);
        onewayList.addAll(backtoscene44);

        passenger7.getStylesheets().add("styleAtm.css");

        // passenger8//
        passenger8 = new Scene(new Group());
        Button bookIncity1 = new Button("Book");
        Label av3=new Label("Avilable Seats");
        Label av4=new Label();
        bookIncity1.setOnAction(event -> {
            String selectbookin= twoway.getSelectionModel().getSelectedItems().toString();
            if(passengerObject.AvilableSeats(passengerObject.removebrackets(selectbookin))>0) {
                passengerObject.book(passengerTextID.getText(), selectbookin);
                av4.setText(Integer.toString(passengerObject.AvilableSeats(passengerObject.removebrackets(selectbookin))));
            }
            else
                AlarmBox.DisplayAlert();
        });
        twoway =trips4.getRoundlistView();
        twoway.setOnMouseClicked(event -> {
            String price2= twoway.getSelectionModel().getSelectedItems().toString();
            av4.setText(Integer.toString(passengerObject.AvilableSeats(passengerObject.removebrackets(price2))));

            //priceIndex=oneWay.getSelectionModel().getSelectedIndex();
            strPrice2 = new StringTokenizer(price2," ");
            for (int i=0;i<8;i++){
                km2= strPrice2.nextToken();
            }
            way2=strPrice2.nextToken();
            String h=Float.toString(ticket.price(km2,way2)) ;
            pricelabel23.setText(h);
        });
        Label pricelabel12=new Label("Price");
         pricelabel23=new Label();
        Button backtoscene444 = new Button("Back");
        backtoscene444.setOnAction(event -> {Window.setScene(passenger4);
            twoway.getItems().clear();
            oneWay.getItems().clear();
            pricelabel23.setText("");
            ingroup.selectToggle(null);
        });
        VBox twowaypane = new VBox();
        twowaypane.setSpacing(5);
        twowaypane.setMargin(backtoscene444,new Insets(10,5,0,0));
        twowaypane.setMargin(bookIncity1,new Insets(10,5,0,0));
        twowaypane.setMargin(av3,new Insets(10,5,0,0));
        twowaypane.setMargin(av4,new Insets(10,5,0,0));
        twowaypane.setMargin(pricelabel12,new Insets(10,5,0,0));
        twowaypane.setMargin(pricelabel23,new Insets(10,5,0,0));
        ObservableList<Node> twowayList  = twowaypane.getChildren();
        twowayList.addAll(pricelabel12,pricelabel23,av3,av4,bookIncity1);
        twowaypane.setPadding(new Insets(100,50,10,0));
        twowaypane.getChildren().addAll(twoway);
        twowaypane.setAlignment(Pos.CENTER);
        Group group8888 = (Group)passenger8.getRoot();
        group8888.getChildren().addAll(twowaypane);
        group8888.setLayoutX(50);
        twowayList.addAll(backtoscene444);

        passenger8.getStylesheets().add("styleAtm.css");


        //passenger scene5//
        ToggleGroup ingroup2 =new ToggleGroup();
        ToggleGroup ingroup3 =new ToggleGroup();
       // Label priceoutlabel1=new Label("Price");
        //Label priceoutlabel2=new Label();
        //Button bookoutcity = new Button("Book");
      /*  bookoutcity.setOnAction(event -> {
            String selectbookout= OutcityList.getSelectionModel().getSelectedItems().toString();
            passengerObject.book(passengerTextID.getText(),selectbookout);
        });*/
        RadioButton oneWayOut = new RadioButton("One-way Trip");
        oneWayOut.setToggleGroup(ingroup2);
        oneWayOut.setOnAction(event -> {
            Window.setScene(passenger9);
            inIndex2=choiceBox1.getItems().get(selectedIndex2);
            trips5.waysOut(inIndex2);
        });
        RadioButton twoWayOut = new RadioButton("Round Trip");
        twoWayOut.setToggleGroup(ingroup2);
        twoWayOut.setOnAction(event -> {
            Window.setScene(passenger10);
            inIndex3=choiceBox1.getItems().get(selectedIndex2);
            trips5.waysOut(inIndex3);
        });
      /*  RadioButton zeroStopsOut = new RadioButton("Zero Stops");
        zeroStopsOut.setToggleGroup(ingroup3);
        RadioButton oneStopsOut = new RadioButton("One Stops");
        oneStopsOut.setToggleGroup(ingroup3);
        RadioButton manyStopsOut = new RadioButton("Many Stops");
        manyStopsOut.setToggleGroup(ingroup3);*/
        Button backtoscene4 = new Button("Back");
        backtoscene4.setOnAction(event -> Window.setScene(passenger3));
        GridPane outcity = new GridPane();
       // outcity.add(bookoutcity,0,2);
        outcity.add(oneWayOut,0,0);
        outcity.add(twoWayOut,1,0);
     //   outcity.add(zeroStopsOut,0,1);
       // outcity.add(oneStopsOut,1,1);
        //outcity.add(manyStopsOut,2,1);
        //outcity.add(priceoutlabel1,0,3);
       // outcity.add(priceoutlabel2,1,3);
        trips3.getfromFileInOrOut();
         OutcityList =trips3.getOutlistView();
       /*  OutcityList.setOnMouseClicked(event -> {
             String price1= OutcityList.getSelectionModel().getSelectedItems().toString();
             priceIndex1=OutcityList.getSelectionModel().getSelectedIndex();
             strPrice1 = new StringTokenizer(price1," ");
             for (int i=0;i<8;i++){
                 km1= strPrice1.nextToken();
             }
             way1=strPrice1.nextToken();
             String h1;
             h1 = Float.toString(ticket1.price(km1,way1));
             priceoutlabel2.setText(h1);
         });*/
        passenger5 = new Scene(new Group());
        VBox outcitypane = new VBox();
        outcitypane.setSpacing(5);
        //outcitypane.setMargin(bookoutcity,new Insets(10,5,0,0));
        outcitypane.setMargin(backtoscene4,new Insets(10,5,0,0));
        ObservableList<Node> outcityList  = outcitypane.getChildren();
       // outcityList.addAll(bookoutcity);
        outcitypane.setPadding(new Insets(100,50,10,0));
        outcitypane.getChildren().addAll(OutcityList);
        outcitypane.setAlignment(Pos.CENTER);
        Group group3 = (Group)passenger5.getRoot();
        group3.getChildren().addAll(outcitypane,outcity);
        group3.setLayoutX(50);
        outcityList.addAll(backtoscene4);

        passenger5.getStylesheets().add("styleAtm.css");


        // passenger9//
        passenger9 = new Scene(new Group());
        Label av5=new Label("Avilable Seats");
        Label av6=new Label();

        Button bookoutcity = new Button("Book");
        bookoutcity.setOnAction(event -> {
            String selectbookout= oneoutway.getSelectionModel().getSelectedItems().toString();
            if(passengerObject.AvilableSeats(passengerObject.removebrackets(selectbookout))>0) {
                passengerObject.book(passengerTextID.getText(),selectbookout);
                av6.setText(Integer.toString(passengerObject.AvilableSeats(passengerObject.removebrackets(selectbookout))));
            }
            else
                AlarmBox.DisplayAlert();
        });
        Label priceoutlabel1=new Label("Price");
        Label priceoutlabel2=new Label();
        oneoutway =trips5.getOneWayOutlistView();
        oneoutway.setOnMouseClicked(event -> {
            String price1= oneoutway.getSelectionModel().getSelectedItems().toString();
            av6.setText(Integer.toString(passengerObject.AvilableSeats(passengerObject.removebrackets(price1))));
            priceIndex1=oneoutway.getSelectionModel().getSelectedIndex();
            strPrice1 = new StringTokenizer(price1," ");
            for (int i=0;i<8;i++){
                km1= strPrice1.nextToken();
            }
            way1=strPrice1.nextToken();
            String h1;
            h1 = Float.toString(ticket1.price(km1,way1));
            priceoutlabel2.setText(h1);
        });
        Button backtoscene55 = new Button("Back");
        backtoscene55.setOnAction(event -> {Window.setScene(passenger5);
            oneoutway.getItems().clear();
            twooutway.getItems().clear();
            priceoutlabel2.setText("");
            ingroup2.selectToggle(null);
        });
        VBox onewayoutpane = new VBox();
        onewayoutpane.setSpacing(5);
        onewayoutpane.setMargin(backtoscene55,new Insets(10,5,0,0));
        onewayoutpane.setMargin(av5,new Insets(10,5,0,0));
        onewayoutpane.setMargin(av6,new Insets(10,5,0,0));
        onewayoutpane.setMargin(bookoutcity,new Insets(10,5,0,0));
        onewayoutpane.setMargin(priceoutlabel1,new Insets(5,5,0,0));
        onewayoutpane.setMargin(priceoutlabel2,new Insets(10,5,0,0));
        ObservableList<Node> onewayoutList  = onewayoutpane.getChildren();
        onewayoutList.addAll(priceoutlabel1,priceoutlabel2,av5,av6,bookoutcity);
        onewayoutpane.setPadding(new Insets(100,50,10,0));
        onewayoutpane.getChildren().addAll(oneoutway);
        onewayoutpane.setAlignment(Pos.CENTER);
        Group group9 = (Group)passenger9.getRoot();
        group9.getChildren().addAll(onewayoutpane);
        group9.setLayoutX(50);
        onewayoutList.addAll(backtoscene55);

        passenger9.getStylesheets().add("styleAtm.css");

        // passenger10//
        passenger10 = new Scene(new Group());
        passenger10.getStylesheets().add("styleAtm.css");

        Label av7=new Label("Avilable Seats");
        Label av8=new Label();
        Button bookoutcity1 = new Button("Book");
        bookoutcity1.setOnAction(event -> {
            String selectbookout= twooutway.getSelectionModel().getSelectedItems().toString();
            if(passengerObject.AvilableSeats(passengerObject.removebrackets(selectbookout))>0) {
                passengerObject.book(passengerTextID.getText(),selectbookout);
                av8.setText(Integer.toString(passengerObject.AvilableSeats(passengerObject.removebrackets(selectbookout))));
            }
            else
                AlarmBox.DisplayAlert();

        });
        Label priceoutlabel12=new Label("Price");
        Label priceoutlabel23=new Label();
        twooutway =trips5.getRoundOutlistView();
        twooutway.setOnMouseClicked(event -> {
            String price3= twooutway.getSelectionModel().getSelectedItems().toString();
            av8.setText(Integer.toString(passengerObject.AvilableSeats(passengerObject.removebrackets(price3))));
            priceIndex1=twooutway.getSelectionModel().getSelectedIndex();
            strPrice3 = new StringTokenizer(price3," ");
            for (int i=0;i<8;i++){
                km3= strPrice3.nextToken();
            }
            way3=strPrice3.nextToken();
            String h1;
            h1 = Float.toString(ticket1.price(km3,way3));
            priceoutlabel23.setText(h1);
        });
        Button backtoscene555 = new Button("Back");
        backtoscene555.setOnAction(event -> {Window.setScene(passenger5);
            oneoutway.getItems().clear();
            twooutway.getItems().clear();
            priceoutlabel23.setText("");
            ingroup2.selectToggle(null);
        });
        VBox roundwayoutpane = new VBox();
        roundwayoutpane.setSpacing(5);
        roundwayoutpane.setMargin(backtoscene555,new Insets(10,5,0,0));
        roundwayoutpane.setMargin(av7,new Insets(10,5,0,0));
        roundwayoutpane.setMargin(av8,new Insets(10,5,0,0));
        roundwayoutpane.setMargin(bookoutcity1,new Insets(10,5,0,0));
        roundwayoutpane.setMargin(priceoutlabel12,new Insets(10,5,0,0));
        roundwayoutpane.setMargin(priceoutlabel23,new Insets(10,5,0,0));
        ObservableList<Node> roundwayoutList  = roundwayoutpane.getChildren();
        roundwayoutList.addAll(priceoutlabel12,priceoutlabel23,av7,av8,bookoutcity1);
        roundwayoutpane.setPadding(new Insets(100,50,10,0));
        roundwayoutpane.getChildren().addAll(twooutway);
        roundwayoutpane.setAlignment(Pos.CENTER);
        Group group10 = (Group)passenger10.getRoot();
        group10.getChildren().addAll(roundwayoutpane);
        group10.setLayoutX(50);
        roundwayoutList.addAll(backtoscene555);


        // passenger scene 6//
        ListView ticketList = ticket.getTicket();
        Button deleteTicket = new Button("Delete");
        Button backtoscene5 = new Button("Back");
        backtoscene5.setOnAction(event -> {Window.setScene(passenger2);
        ticketList.getItems().clear();
        });
        deleteTicket.setOnAction(event -> {
            String selectticket= ticketList.getSelectionModel().getSelectedItems().toString();
            selectedIndex3=ticketList.getSelectionModel().getSelectedIndex();
            ticketList.getItems().remove(selectedIndex3);
             viewTicket =ticketList.getItems().toString();
            ticket.appendinfile(viewTicket,passengerTextID.getText());
        });
        passenger6 = new Scene(new Group());
        passenger6.getStylesheets().add("styleAtm.css");

        VBox ticketpane = new VBox();
        ticketpane.setSpacing(5);
        ticketpane.setMargin(deleteTicket,new Insets(10,5,0,0));
        ticketpane.setMargin(backtoscene5,new Insets(10,5,0,0));
        ObservableList<Node> listticket  = ticketpane.getChildren();
        listticket.addAll(deleteTicket);
        ticketpane.setPadding(new Insets(10,50,10,0));
        ticketpane.getChildren().addAll(ticketList);
        ticketpane.setAlignment(Pos.CENTER);
        Group group4 = (Group)passenger6.getRoot();
        group4.getChildren().addAll(ticketpane);
        group4.setLayoutX(50);
        listticket.addAll(backtoscene5);





// manager scene1//

        Label managerID = new Label("ID");
        Label managerPassword = new Label("Password");
        Label managererror = new Label("");
        TextField managerTextID = new TextField();
        TextField managerTextPassword = new TextField();
        Manager managerValidation = new Manager();
        managerValidation.Validation();
        Button managerLogin = new Button("Login");
        managerLogin.setOnAction(event -> {
            String managerUserNameField = managerTextID.getText();
            String managerPasswordField = managerTextPassword.getText();
            boolean managerValid = managerValidation.Valid(managerUserNameField, managerPasswordField);
            if (managerValid) {
                Window.setScene(managerScene2);
            } else {
                managererror.setText("wrong ID or password");
                managerTextID.setText("");
                managerTextPassword.setText("");
            }
        });
        Button backtfrommanagertoowelcome = new Button("Back");
        backtfrommanagertoowelcome.setOnAction(event -> {
            Window.setScene(welcomescene);
            managerTextID.setText("");
            managerTextPassword.setText("");
        });

        GridPane managerGrid = new GridPane();
        managerGrid.add(managerID, 0, 0);
        managerGrid.add(managerTextID, 1, 0);
        managerGrid.add(managerPassword, 0, 1);
        managerGrid.add(managererror, 1, 3);
        managerGrid.add(managerTextPassword, 1, 1);
        managerGrid.add(managerLogin, 0, 2);
        managerGrid.add(backtfrommanagertoowelcome, 2, 2);

        managerScene = new Scene(managerGrid, 550, 300);

        managerScene.getStylesheets().add("styleAtm.css");


        // manager scene2//
        Label helloManager = new Label("Hello Dr.Mervat");
        Button managerTrip = new Button("Trips");
        managerTrip.setOnAction(event -> {
            Window.setScene(managerTripss);
           // trips.getfromFile();
            });
        Button assignedDriverTrips = new Button("Assign Trips");
        assignedDriverTrips.setOnAction(event -> {Window.setScene(managerScene3);
            driverObject.displayTripsAssigned(driverTextID.getText());
        });
        Button backtfromm2tom1 = new Button("Back");
        backtfromm2tom1.setOnAction(event ->{ Window.setScene(managerScene);
            managerTextID.setText("");
            managerTextPassword.setText("");
        });

        VBox managerVBox = new VBox();

        managerVBox.setSpacing(5);

        managerVBox.setMargin(helloManager, new Insets(50, 50, 5, 200));
        managerVBox.setMargin(assignedDriverTrips, new Insets (50, 50, 5, 200));
        managerVBox.setMargin(managerTrip, new Insets (50, 50, 5, 200));
        managerVBox.setMargin(backtfromm2tom1, new Insets (50, 50, 5, 200));

        ObservableList<Node> managerList  = managerVBox.getChildren();

        managerList.addAll(helloManager,assignedDriverTrips,managerTrip,backtfromm2tom1);

        managerScene2 = new Scene(managerVBox,500,600);
        managerScene2.getStylesheets().add("styleAtm.css");

        //manager scene 3//
        managerScene3 = new Scene(new Group());
        managerScene3.getStylesheets().add("styleAtm.css");

        trips1.getfromFile();
        ListView assigned = trips1.getMlistView();
        ChoiceBox<String> choiceBox= new ChoiceBox<>();
        Button assign = new Button("Assign");
        choiceBox.getItems().addAll("5000");
        choiceBox.getItems().addAll("6000");
        choiceBox.getItems().addAll("7000");
        choiceBox.getItems().addAll("8000");
        choiceBox.getItems().addAll("9000");
        choiceBox.getItems().addAll("10000");
        Button managerBackto2 = new Button("Back");
        managerBackto2.setOnAction(event -> Window.setScene(managerScene2));
        VBox assignedPane = new VBox();
        assignedPane.setSpacing(5);
        assignedPane.setMargin(assign,new Insets(10,5,0,0));
        assignedPane.setMargin(choiceBox,new Insets(10,5,0,0));
        assignedPane.setMargin(managerBackto2,new Insets(10,5,0,0));
        ObservableList<Node>  assignedList  = assignedPane.getChildren();
        assignedList.addAll(choiceBox,assign);
        assignedPane.setPadding(new Insets(10,50,10,0));
        assignedPane.getChildren().addAll(assigned);
        assignedPane.setAlignment(Pos.CENTER);
        Group group7 = (Group)managerScene3.getRoot();
        group7.getChildren().addAll(assignedPane);
        group7.setLayoutX(50);
        assigned.setOnMouseClicked(e -> {

            String select1= assigned.getSelectionModel().getSelectedItems().toString();
            selectedIndex1=assigned.getSelectionModel().getSelectedIndex();

        });
        assignedList.addAll(managerBackto2);
        assign.setOnAction(event -> {
            String tripAssigned =assigned.getItems().get(selectedIndex1).toString();
            String driverIDAssigned= choiceBox.getItems().get(choiceBox.getSelectionModel().getSelectedIndex());
            driverObject.writeinfile(tripAssigned,driverIDAssigned);
            assigned.getItems().remove(selectedIndex1);
        });



        //manager scene4//


        trips.getfromFile();
        Selected =trips.getMlistView();
        managerTripss = new Scene(new Group());
        managerTripss.getStylesheets().add("styleAtm.css");

        Button Delete = new Button("Delete");
        Selected.setOnMouseClicked(e -> {

            String select= Selected.getSelectionModel().getSelectedItems().toString();
            selectedIndex=Selected.getSelectionModel().getSelectedIndex();

        });

        Delete.setOnAction(event -> {
            if(selectedIndex<0);
            else
            Selected.getItems().remove(selectedIndex);
        });

        Button add = new Button("Add");
        TextField addtxt=new TextField();

        Button tripsSave = new Button("Save");
        tripsSave.setOnAction(
                event -> {
                    try{
                       save = Selected.getItems().toString();
                        trips.savetoFile(save);
                    }
                    catch (Exception e)
                    {
                        System.out.println("error");
                          }}
        );
        add.setOnAction(event -> {
    Selected.getItems().add(addtxt.getText());
    addtxt.setText("");
});



        Button managerBackfrom3to2 = new Button("Back");
        managerBackfrom3to2.setOnAction(event -> {Window.setScene(managerScene2);
            Selected.getItems().clear();
        });
        VBox pane = new VBox();
        pane.setSpacing(5);
        pane.setMargin(Delete,new Insets(10,5,0,0));

        pane.setMargin(add,new Insets(10,5,0,0));

        pane.setMargin(addtxt,new Insets(10,5,0,0));

        //pane.setMargin(choiceBox,new Insets(10,5,0,0));

       // pane.setMargin(assign,new Insets(10,5,0,0));

        pane.setMargin(tripsSave,new Insets(10,5,0,0));

        pane.setMargin(managerBackfrom3to2,new Insets(10,5,0,0));
        ObservableList<Node> managerList2  = pane.getChildren();
        managerList2.addAll(Delete,add,addtxt);
        pane.setPadding(new Insets(10,50,10,0));
        pane.getChildren().addAll(trips.getMlistView());
        pane.setAlignment(Pos.CENTER);
        Group group1 = (Group)managerTripss.getRoot();
        group1.getChildren().addAll(pane);
        group1.setLayoutX(50);
        managerList2.addAll(tripsSave,managerBackfrom3to2);





        //driver scene1//

        Label driverID = new Label("ID");
        Label driverPassword = new Label("Password");
        Label drivererror = new Label("");
         driverTextID = new TextField();
        TextField driverTextPassword = new TextField();
        Driver driverValidation = new Driver();
        driverValidation.Validation();

        Button driverLogin = new Button("Login");
        driverLogin.setOnAction(event -> {
            String driverUserNameField = driverTextID.getText();
            String driverPasswordField = driverTextPassword.getText();
            boolean driverValid = driverValidation.Valid(driverUserNameField, driverPasswordField);
            if (driverValid) {
                Window.setScene(driverScene2);
                driverIDText2.setText(driverTextID.getText());
                driverObject.getfromFile(driverTextID.getText());
                driverNameText.setText(driverObject.getDriverName());
                driverCarTypeText.setText(Float.toString( driverObject.getRate()));
                driverCarColorText.setText(driverObject.getCarColor());
                driverCarNumText.setText(driverObject.getCarNumber());
                driverCarNumOfSeatsText.setText("   "+driverObject.getCarNoOfSeats());

            } else {
                drivererror.setText("wrong ID or password");
                driverTextID.setText("");
                driverTextPassword.setText("");
            }
        });
        Button backtfromdrivertoowelcome = new Button("Back");
        backtfromdrivertoowelcome.setOnAction(event -> {Window.setScene(welcomescene);
            driverTextID.setText("");
            driverTextPassword.setText("");
        });


        GridPane driverGrid = new GridPane();
        driverGrid.add(driverID, 0, 0);
        driverGrid.add(driverTextID, 1, 0);
        driverGrid.add(driverPassword, 0, 1);
        driverGrid.add(drivererror, 1, 3);
        driverGrid.add(driverTextPassword, 1, 1);
        driverGrid.add(driverLogin, 0, 2);
        driverGrid.add(backtfromdrivertoowelcome, 2, 2);

        driverScene = new Scene(driverGrid, 500, 400);
        driverScene.getStylesheets().add("styleAtm.css");


        //driver scene2//
        Label driverName = new Label("Name");
        driverID2 = new Label("ID");
        Label driverCarInfo = new Label("Car Information");
        Label driverCarType = new Label("Rate");
        Label driverCarColor = new Label("Car Color");
        Label driverCarNum = new Label("Car Number");
        Label driverCarNumOfSeats = new Label("Car Number Of Seats");
        driverNameText = new Label();
        driverIDText2 = new Label();
        driverCarTypeText = new Label();
        driverCarColorText = new Label();
        driverCarNumText = new Label();
        driverCarNumOfSeatsText = new Label();
        Button driverTrips = new Button("Your Trips");
        driverTrips.setOnAction(event -> {Window.setScene(DriverScene3);
            driverObject.displayTripsAssigned(driverTextID.getText());
            ListView drivertrips = driverObject.getDriverAssignedTrips();

        });
        Button backtfromd2tod1 = new Button("Back");
        backtfromd2tod1.setOnAction(event -> {Window.setScene(driverScene);
            driverTextID.setText("");
            driverTextPassword.setText("");
            // vechileObject.vechileDeclaration();
        });


        GridPane driverGrid2 = new GridPane();

        driverGrid2.add(driverName,0,0);
        driverGrid2.add(driverNameText,1,0);
        driverGrid2.add(driverID2,0,1);
        driverGrid2.add(driverIDText2,1,1);
        driverGrid2.add(driverCarType,0,2);
        driverGrid2.add(driverCarInfo,0,3);
        driverGrid2.add(driverCarTypeText,1,2);
        driverGrid2.add(driverCarColor,0,4);
        driverGrid2.add(driverCarColorText,1,4);
        driverGrid2.add(driverCarNum,0,5);
        driverGrid2.add(driverCarNumText,1,5);
        driverGrid2.add(driverCarNumOfSeats,0,6);
        driverGrid2.add(driverCarNumOfSeatsText,1,6);
        driverGrid2.add(driverTrips,0,7);
        driverGrid2.add(backtfromd2tod1,5,7);

        driverScene2 = new Scene(driverGrid2,500,600);
        driverScene2.getStylesheets().add("styleAtm.css");

        //driver scene3//
        ListView drivertrips = driverObject.getDriverAssignedTrips();
        Button backtoscene2 = new Button("Back");
        backtoscene2.setOnAction(event -> {Window.setScene(driverScene2);
            drivertrips.getItems().clear();
        });
        DriverScene3 = new Scene(new Group());
        DriverScene3.getStylesheets().add("styleAtm.css");

        VBox driverpane = new VBox();
        driverpane.setSpacing(5);
        driverpane.setMargin(backtoscene2,new Insets(10,5,0,0));
        ObservableList<Node> listdriver  = driverpane.getChildren();
        driverpane.setPadding(new Insets(10,50,10,0));
        driverpane.getChildren().addAll(drivertrips);
        driverpane.setAlignment(Pos.CENTER);
        Group group5 = (Group)DriverScene3.getRoot();
        group5.getChildren().addAll(driverpane);
        group5.setLayoutX(50);
        listdriver.addAll(backtoscene2);










    }
}