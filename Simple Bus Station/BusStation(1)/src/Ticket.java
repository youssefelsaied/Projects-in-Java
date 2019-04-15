import javafx.scene.control.ListView;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ticket {
    Trips trip=new Trips();
    private int ticketNo;
    private float price;
    private ListView ticket=new ListView();

    public ListView getTicket() {
        return ticket;
    }

    public void setTicket(ListView ticket) {
        this.ticket = ticket;
    }

    private int[] tripNo = trip.getTripNo();

    public int[] getTripNo() {
        return tripNo;
    }

    public void setTripNo(int[] tripNo) {
        this.tripNo = tripNo;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public ListView viewTicket(String id){
        try {
            String token1;
            String fileName = "Passenger/" + id + ".txt";
            File DriverFile = new File(fileName);
            Scanner DriverReader = new Scanner(DriverFile);
            DriverReader.nextLine();
            while (DriverReader.hasNextLine())
            {
                token1 = DriverReader.nextLine();
                ticket.getItems().add(token1);
            }

        }
        catch (IOException e){

        }
        return ticket;
    }

    public void appendinfile(String info, String name){
        String fileName = "Passenger/"+name+".txt";
        File viewticket = new File(fileName);
        try {
            FileWriter fr = null;
            BufferedWriter br = null;
            fr = new FileWriter(viewticket);
            br = new BufferedWriter(fr);
            br.write(name);
            br.newLine();
            // br.write(info);
            char ar[] = info.toCharArray();
            System.out.println(ar[0]);
            for (int i = 0; i < ar.length; i++) {
                if (ar[i] == '[') {

                }
                else if(ar[i] == ' '){
                }
                else if (ar[i] == ']') {

                } else if (ar[i] == ',') {
                    br.newLine();
                } else {
                    br.write(ar[i]);

                }
            }
            br.close();
            fr.close();
        }
        catch (IOException e){

        }
    }

    public float  price(String dis,String way){
        StringTokenizer km = new StringTokenizer(dis,"km");
        String Kmeter=km.nextToken();
        int distance=Integer.parseInt(Kmeter);
        if(way.equals("one_way")){
        price= (float) (distance*1.25);
        }
        else if(way.equals("round_trip"))
        {
            price= (float) (2*distance*1.25*.3);
        }else ;
        return price;
    }

}
