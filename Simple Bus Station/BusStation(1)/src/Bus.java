import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bus extends Vechile {
    public List<String> getTemps() {
        return temps;
    }

    public List<String> temps;
    int count=0;

    public Bus(){
        super.setNoOfSeats("20");
    }

    public void sizearrays(){
        vechlieNo=new String[count];
        color=new String[count];
        model=new String[count];
    }

    public void getFromFile(){
        try {
            String token1;
            File BusFile = new File("Vechile/Buses.txt");
            Scanner BusReader = new Scanner(BusFile);
            temps = new ArrayList<>();
            while (BusReader.hasNext()) {
                // find next line
                token1 = BusReader.nextLine();
                temps.add(token1);
                count++;
            }
            BusReader.close();
            this.sizearrays();
            for (int i=0;i<count;i++) {
                StringTokenizer stbus = new StringTokenizer(temps.get(i), " ");
                vechlieNo[i] = stbus.nextToken();
                color[i] = stbus.nextToken();
                model[i] = stbus.nextToken();
            }
        }catch (IOException e){
            System.out.println("error in Bus File or Syntax");
        }


    }



}
