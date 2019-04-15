import java.util.HashMap;

public class logicAtm {

    HashMap userDictionary;

    public logicAtm() {
        userDictionary = new HashMap();
        userDictionary.put("0000", "2222");
        userDictionary.put("1111", "1111");
        userDictionary.put("2222", "0000");
    }

    public boolean validate(String username, String password) {
        boolean validate = false;
        String fetchedPassword = (String) userDictionary.get(username);
        if (fetchedPassword != null) {
            validate = fetchedPassword.equals(password);
        }
        return validate;
    }

    String[] transaction = new String[20];
    public int i = 0, z = 0;
    private int balance;

    void difTranscation(){
        for (int h=0;h<20;h++)
            transaction[h] = "No Transaction Done" ;
    }
    void getbalance() {
        transaction[i] = "Balance: " + balance;
        i++;
    }
    public int Deposite(int depo) {
        balance = balance + depo;
        transaction[i] = "Deposit: " + depo;
        i = i + 1;
        return balance;
    }

    public int Withdraw(int with) {
        if (with > balance) {
            AlertAtm.wrongWithdraw();
        } else {
            balance = balance - with;
            transaction[i] = "wihtdraw: " + with;
            i = i + 1;
        }
        return balance;
    }

    public int incre() {
        if (z >= i - 1)
           z = z + 0;
        else
        z++;
        return z;
    }

    public int decre() {
        if (z <= i - 5 || z <= 0) {

        }
        else
            z--;
        return z;
    }

    public String gettransactione() {
        return transaction[z];
    }

    public String gettransaction() {
        if (i > 0) {
            z = i - 1;
            return transaction[i - 1];
        }
        else
            return transaction[0];
    }
}
