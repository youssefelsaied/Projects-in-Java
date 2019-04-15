import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import java.io.*;
import java.util.*;

public class Trips {
    private  String found;
    private int count,count1,count2,y;
    private ListView mlistView = new ListView();
    private ListView inlistView = new ListView();
    private ListView outlistView = new ListView();
    private ListView oneWaylistView = new ListView();
    private ListView roundlistView = new ListView();
    private ListView oneWayOutlistView = new ListView();
    private ListView roundOutlistView = new ListView();
    File Save=new File("Trips.txt");
    FileWriter fr = null;
    BufferedWriter br = null;

    public ListView getOneWayOutlistView() {
        return oneWayOutlistView;
    }

    public void setOneWayOutlistView(ListView oneWayOutlistView) {
        this.oneWayOutlistView = oneWayOutlistView;
    }

    public ListView getRoundOutlistView() {
        return roundOutlistView;
    }

    public void setRoundOutlistView(ListView roundOutlistView) {
        this.roundOutlistView = roundOutlistView;
    }

    public void setTrip(String trip) {
        String[] strArray = new String[] {trip};
        Trip = strArray;
    }

public String[] getfromFile() {
    try {
        String token1;
        File Tripfile = new File("Trips.txt");
        Scanner TripReader = new Scanner(Tripfile);
        List<String> temps = new ArrayList<>();
        while (TripReader.hasNext()) {
            // find next line
            token1 = TripReader.nextLine();
            temps.add(token1);
            count++;
        }
        TripReader.close();
         Trip = temps.toArray(new String[0]);
        for (String s : Trip) {
                mlistView.getItems().add(s);
            }
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    return Trip;
}
public void ways(String cr) {
      getcurlocation(cr);
     // System.out.println(cr);
    for(int i=0;i<count2;i++) {
        String oneWay = getInlistView().getItems().get(i).toString();
        System.out.println(oneWay);
        StringTokenizer strway = new StringTokenizer(oneWay," ");
        for (int j=0;j<8;j++){
           found=strway.nextToken();

        }
        if(found.equals("one_way")){
           // System.out.println(getInlistView().getItems().toString());
            oneWaylistView.getItems().add(getInlistView().getItems().get(i).toString());
        }
        else if(found.equals("round_trip")){
            roundlistView.getItems().add(getInlistView().getItems().get(i).toString());
        }
    }
}


    public void waysOut(String cr) {
        getcurlocation(cr);
        for(int i=0;i<count2;i++) {
            String oneWay = outlistView.getItems().get(i).toString();
            StringTokenizer strway = new StringTokenizer(oneWay," ");
            for (int j=0;j<8;j++){
                found=strway.nextToken();

            }
            if(found.equals("one_way")){
                oneWayOutlistView.getItems().add(outlistView.getItems().get(i).toString());
            }
            else if(found.equals("round_trip")){
                roundOutlistView.getItems().add(outlistView.getItems().get(i).toString());
            }
        }
    }





public void getcurlocation(String cl) {
    getfromFileInOrOut();
    count2=0;
    y=0;
    if(count1%2==0){
        y=count1/2;
    }else if(count1%2==1){
        y=(count1/2)+1;
    }
    else {

    }

for(int i=0;i<y;i++){
    String in=getIn()[i];
    StringTokenizer strr = new StringTokenizer(in," ");
    int inst=Integer.parseInt(strr.nextToken());
   // System.out.println(inst);
    String out=getOut()[i];
    StringTokenizer strrr = new StringTokenizer(out," ");

    if (cl.equals("Alexandria")) {
        if (inst>=100&&inst<200){
            inlistView.getItems().add(getIn()[i]);
         count2++;
            outlistView.getItems().add(getOut()[i]);
        }
    } else if (cl.equals("Cairo")) {
        if (inst>=200&&inst<300){
           // System.out.println(getIn()[i]);
            inlistView.getItems().add(getIn()[i]);
            count2++;
            outlistView.getItems().add(getOut()[i]);
        }
    } else if(cl.equals("Aswan")) {
        if (inst>=300&&inst<400){
            inlistView.getItems().add(getIn()[i]);
            count2++;
            outlistView.getItems().add(getOut()[i]);
    }}

}
  /*  */
}



    public void getfromFileInOrOut() {
        try {
            count1=0;
            String token1,token2,token3;
            File Tripfile = new File("Trips.txt");
            Scanner TripReader = new Scanner(Tripfile);
            List<String> temps0 = new ArrayList<>();
            List<String> temps1 = new ArrayList<>();
            while (TripReader.hasNextLine()) {
                token1 = TripReader.next();
                if(token1.equals("in")){
                    token2 = TripReader.nextLine();
                    temps0.add(token2);
                    count1++;
                }
                else {
                    token3 = TripReader.nextLine();
                    temps1.add(token3);
                    count1++;
                }
            }
            TripReader.close();
            impinorout();
            in=temps0.toArray(new String[0]);
            out = temps1.toArray(new String[0]);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }


    private String[] Trip;

    private String[] inOrOut;
    private int[] tripNo;
    private String[] in;
    private String[] out;

    private String[] currentLocation;
    private String[] distinationLocation;
    private String[] distance;
    private String[] date;
    private String[] time;
    private String[] duration;
    private String[] way;
    private String[] noOfStops;
    private String[] carnum;
    private String[]  avilablenumOfSeats;

    public void impinorout() {
        in=new String[count1];
        out=new String[count1];
    }
    public void imp(){
         tripNo=new int[count];
        currentLocation=new String[count];
         distinationLocation=new String[count];
        Trip=new String[count];
        distance=new String[count];
        date=new String[count];
    time=new String[count];
        duration=new String[count];
        way=new String[count];
        noOfStops=new String[count] ;
        carnum=new String[count];
        avilablenumOfSeats=new String[count];
        inOrOut=new String[count];
    }

public void savetoFile(String input) {
    try {
        fr = new FileWriter(Save);
        br = new BufferedWriter(fr);

        char ar[]= input.toCharArray();
        for (int i=0;i<ar.length;i++){
            if(ar[i]=='[') {

            }
            else if(ar[i]==']')
            {

            }
            else if(ar[i]==',')
            {   if (ar[i+1]==' ')
                i++;

                br.newLine();
            }
            else {
                br.write(ar[i]);

            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public void declarationOfAt() {
    imp();
    ArrayList<String> arrayListTrip = new ArrayList<>();
    String ar[] = getfromFile();
    for (int i = 0; i < ar.length; i++) {
        StringTokenizer st1 = new StringTokenizer(ar[i], " ");
        inOrOut[i] = st1.nextToken();
        tripNo[i] = Integer.parseInt(st1.nextToken());
        currentLocation[i] = st1.nextToken();
        distinationLocation[i] = st1.nextToken();
        date[i] = st1.nextToken();
        time[i] = st1.nextToken();
        duration[i] = st1.nextToken();
        distance[i] = st1.nextToken();
        way[i] = st1.nextToken();
        noOfStops[i] = st1.nextToken();
        carnum[i] = st1.nextToken();
        avilablenumOfSeats[i] = st1.nextToken();
     }

}

    public ListView getMlistView() {return mlistView; }

    public void setMlistView(ListView mlistView) {this.mlistView = mlistView; }

    public String[] getTrip() { return Trip; }

  //  public void setTrip(String[] trip) {Trip = trip; }

    public String[] getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(String[] inOrOut) {
        this.inOrOut = inOrOut;
    }

    public int[] getTripNo() {
        return tripNo;
    }

    public void setTripNo(int[] tripNo) {
        this.tripNo = tripNo;
    }

    public String[] getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String[] currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String[] getDistinationLocation() {
        return distinationLocation;
    }

    public void setDistinationLocation(String[] distinationLocation) {
        this.distinationLocation = distinationLocation;
    }

    public String[] getDistance() {
        return distance;
    }

    public void setDistance(String[] distance) {
        this.distance = distance;
    }

    public String[] getDate() {
        return date;
    }

    public void setDate(String[] date) {
        this.date = date;
    }

    public String[] getTime() {
        return time;
    }

    public void setTime(String[] time) {
        this.time = time;
    }

    public String[] getDuration() {
        return duration;
    }

    public void setDuration(String[] duration) {
        this.duration = duration;
    }

    public String[] getWay() {
        return way;
    }

    public void setWay(String[] way) {
        this.way = way;
    }

    public String[] getNoOfStops() {
        return noOfStops;
    }

    public void setNoOfStops(String[] noOfStops) {
        this.noOfStops = noOfStops;
    }

    public String[] getCarnum() {
        return carnum;
    }

    public void setCarnum(String[] carnum) {
        this.carnum = carnum;
    }

    public String[] getAvilablenumOfSeats() {
        return avilablenumOfSeats;
    }

    public void setAvilablenumOfSeats(String[] avilablenumOfSeats) {
        this.avilablenumOfSeats = avilablenumOfSeats;
    }

    public ListView getInlistView() {
        return inlistView;
    }

    public void setInlistView(ListView inlistView) {
        this.inlistView = inlistView;
    }

    public ListView getOutlistView() {
        return outlistView;
    }

    public void setOutlistView(ListView outlistView) {
        this.outlistView = outlistView;
    }

    public String[] getIn() {
        return in;
    }

    public void setIn(String[] in) {
        this.in = in;
    }

    public String[] getOut() {
        return out;
    }

    public void setOut(String[] out) {
        this.out = out;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public ListView getOneWaylistView() {
        return oneWaylistView;
    }

    public void setOneWaylistView(ListView oneWaylistView) {
        this.oneWaylistView = oneWaylistView;
    }

    public ListView getRoundlistView() {
        return roundlistView;
    }

    public void setRoundlistView(ListView roundlistView) {
        this.roundlistView = roundlistView;
    }
}
