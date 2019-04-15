import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class passenger implements iUser {
    private String username;
    public String afterRemove;
    public String h;

    private int allSeats;
    private int avilableSeats;

    private String password;
    private FileWriter fr;
    private BufferedWriter br;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
public void Book(){

}
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void DisplayTickets(){

    }
    public void  update(){

    }

   public HashMap passengerHashMap = new HashMap();

    @Override
    public void Validation() {
        passengerHashMap.put("Mohamed","0000");
        passengerHashMap.put("Youseef","1111");
        passengerHashMap.put("Ahmed","2222");

    }

    @Override
    public boolean Valid(String userName, String password) {
        boolean validate = false;
         String fetchpassword = (String)passengerHashMap.get(userName);
        if (fetchpassword != null) {
            validate = fetchpassword.equals(password);
        }
        return validate;
    }


    public String removebrackets(String words){
        afterRemove="";
        char[] ar=words.toCharArray();
        for (int i=0;i<ar.length;i++){
            if(ar[i]=='[') {

            }
            else if(ar[i]==']')
            {

            }
            else
            {
                afterRemove=afterRemove+ar[i];
            }

        }
        return afterRemove;

    }
    public int AvilableSeats(String trip){
        String j;
        StringTokenizer sttrip=new StringTokenizer(trip," ");
        for(int i=0;i<11;i++)
            h=sttrip.nextToken();

        allSeats=Integer.parseInt(h);
        avilableSeats=allSeats;
        try {
            File file = new File("Passenger/");
            // Reading directory contents
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                Scanner scanfile=new Scanner(files[i]);
                while (scanfile.hasNextLine())
                {
                    j=scanfile.nextLine();
                    if(j.equals(trip)){
                        avilableSeats--;
                    }
                }
            }
        }catch (IOException e){
            System.out.println("error");
        }
        return avilableSeats;
    }

    public void book(String name,String trip){
        try {
            String filename="Passenger/"+name+".txt" ;
            File book=new File(filename);

            fr = new FileWriter(book,true);
            br = new BufferedWriter(fr);

            char ar[]= trip.toCharArray();
            br.newLine();
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



}
