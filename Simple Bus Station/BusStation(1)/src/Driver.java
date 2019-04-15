import javafx.scene.control.ListView;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Driver implements iUser {
    int DriverID;
    private float rate;
    private String password;
    private String[] driverCarNo;
    private String[] Driverarray;
    private String driverName;
    private String carType;
    private String carColor;
    private String carNumber;
    private String carNoOfSeats;
    private Scanner DriverReader;
    public ListView getDriverAssignedTrips() {
        return driverAssignedTrips;
    }

    public void setDriverAssignedTrips(ListView driverAssignedTrips) {
        this.driverAssignedTrips = driverAssignedTrips;
    }

    private ListView driverAssignedTrips=new ListView();


    public float getRate() {return rate;}
    public String[] getDriverarray() {return Driverarray;}
    public String getDriverName() {return driverName;}
    public String getCarNoOfSeats() {return carNoOfSeats; }
    public int getDriverID() {
        return DriverID;
    }
    public String getPassword() {
        return password;
    }
    public String getCarNumber() {return carNumber; }
    public String getCarColor() { return carColor; }
    public String getCarType() {return carType; }

    public void setCarType(String carType) {this.carType = carType; }
    public void setCarColor(String carColor) {this.carColor = carColor; }
    public void setDriverarray(String[] driverarray) {Driverarray = driverarray;}
    public void setCarNumber(String carNumber) {this.carNumber = carNumber;}
    public void setDriverName(String driverName) {this.driverName = driverName;}
    public void setCarNoOfSeats(String carNoOfSeats) {this.carNoOfSeats = carNoOfSeats; }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRate(float rate) {this.rate = rate;}
    public void setDriverID(int driverID) {
        DriverID = driverID;
    }



    // public Driver() {
    //   driverCarNo = driverVechile.getVechlieNo();
    //}

    HashMap driverHashMap = new HashMap();
    @Override
    public void Validation() {
        this.driverHashMap.put("5000", "0000");
        this.driverHashMap.put("6000", "1111");
        this.driverHashMap.put("7000", "2222");
        this.driverHashMap.put("8000", "3333");
        this.driverHashMap.put("9000", "4444");
        this.driverHashMap.put("10000", "5555");
    }
    @Override
    public boolean Valid(String userName, String password) {
        boolean drivervalidate = false;
        String fetchpassword = (String)this.driverHashMap.get(userName);
        if (fetchpassword != null) {
            drivervalidate = fetchpassword.equals(password);
        }
        return drivervalidate;
    }


    public File[] fileFinder(){
        int i=0;
        File[] arOfFile=new File[3];
        File dir = new File("Drivers");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                arOfFile[i]=child;
                i++;
            }
        } else {
            System.out.println("eroooooor");
        }

        return arOfFile;
    }
/*public int noOflines(File lines){
        int count=0;
        try {
            Scanner DriverReader = new Scanner(lines);
            DriverReader.nextLine();
            while (DriverReader.next()=="4"){
                count++;
            }
        }catch(IOException e){
            System.out.println("Eroor");
        }
return count;
}*/
    public  ListView displayTripsAssigned(String id){
        try {
            String token1;
            String fileName = "Drivers/" + id + ".txt";
            File DriverFile = new File(fileName);
            Scanner DriverReader = new Scanner(DriverFile);
            DriverReader.nextLine();
            while (DriverReader.hasNextLine())
            {
                token1 = DriverReader.nextLine();
                driverAssignedTrips.getItems().add(token1);
            }

        }
        catch (IOException e){

        }

return driverAssignedTrips;
    }




    public String[] getfromFile(String id) {
        try {
            String token1;
            String fileName = "Drivers/" + id + ".txt";
            File DriverFile = new File(fileName);
            DriverReader = new Scanner(DriverFile);
            List<String> temps = new ArrayList<>();
            while (DriverReader.hasNext()) {
                // find next
                token1 = DriverReader.next();
                temps.add(token1);
            }
            DriverReader.close();
            Driverarray = temps.toArray(new String[0]);
            driverName = Driverarray[0];
            rate = Float.valueOf(Driverarray[1]);
            carType = Driverarray[2];
            Vechile busDriver=new Bus();

            Vechile minibusDriver=new Minibus();

            Vechile limosineDriver=new Limosine();

            busDriver.getFromFile();
            minibusDriver.getFromFile();
            limosineDriver.getFromFile();
            for(int i=0;i<2;i++)
                if (carType.equals( busDriver.vechlieNo[i])) {
                    setCarColor(busDriver.getColor()[i]);
                    carNumber = busDriver.getVechlieNo()[i];
                    carNoOfSeats = busDriver.getNoOfSeats();
                    break;
                } else if (carType.equals(minibusDriver.vechlieNo[i])) {
                    carColor = minibusDriver.getColor()[i];
                    carNumber = minibusDriver.getVechlieNo()[i];
                    carNoOfSeats = minibusDriver.getNoOfSeats();
                    break;
                } else if (carType.equals(limosineDriver.vechlieNo[i]) ) {
                    carColor = limosineDriver.getColor()[i];
                    carNumber = limosineDriver.getVechlieNo()[i];
                    carNoOfSeats = limosineDriver.getNoOfSeats();
                    break;
                } else {
                    carColor = null;
                    carNumber = null;
                    carNoOfSeats = null;

                }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return Driverarray;
    }

    public void writeinfile(String info, String name){
        String fileName = "Drivers/"+name+".txt";
        File assignedTrips = new File(fileName);
        try {
            FileWriter fr = null;
            BufferedWriter br = null;
            fr = new FileWriter(assignedTrips,true);
            br = new BufferedWriter(fr);
            br.newLine();
            br.write(info);
            br.close();
            fr.close();

        }
        catch (IOException e){

        }
    }







}
