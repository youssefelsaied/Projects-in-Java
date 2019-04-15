import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Limosine extends Vechile {
    int count;

    public Limosine(){
        super.setNoOfSeats("4");
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
            File LimosinesFile = new File("Vechile/Limosines.txt");
            Scanner LimosinesReader = new Scanner(LimosinesFile);
            List<String> temps = new ArrayList<>();
            while (LimosinesReader.hasNext()) {
                // find next line
                token1 = LimosinesReader.nextLine();
                temps.add(token1);
                count++;
            }
            LimosinesReader.close();
            this.sizearrays();
            for (int i=0;i<count;i++) {
                StringTokenizer stlimosines = new StringTokenizer(temps.get(i), " ");
                vechlieNo[i] = stlimosines.nextToken();
                color[i] = stlimosines.nextToken();
                model[i] = stlimosines.nextToken();

            }
        }catch (IOException e){
            System.out.println("error in Limosines File or Syntax");
        }


    }

}

