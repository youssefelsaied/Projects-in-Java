import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Minibus extends Vechile {
    int count;

    public Minibus(){
        super.setNoOfSeats("10");
        count = 0;
    }

    public void sizearrays(){
        vechlieNo=new String[count];
        color=new String[count];
        model=new String[count];
    }

    public void getFromFile(){
        try {
            String token1;
            File MiniBusesFile = new File("Vechile/MiniBuses.txt");
            Scanner MiniBusesReader = new Scanner(MiniBusesFile);
            List<String> temps = new ArrayList<>();
            while (MiniBusesReader.hasNext()) {
                // find next line
                token1 = MiniBusesReader.nextLine();
                temps.add(token1);
                count++;
            }
            MiniBusesReader.close();
            this.sizearrays();
            for (int i=0;i<count;i++) {
                StringTokenizer stMiniBuses = new StringTokenizer(temps.get(i), " ");
                vechlieNo[i] = stMiniBuses.nextToken();
                color[i] = stMiniBuses.nextToken();
                model[i] = stMiniBuses.nextToken();

            }
        }catch (IOException e){
            System.out.println("error in Limosines File or Syntax");
        }


    }

}
