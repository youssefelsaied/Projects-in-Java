import java.util.HashMap;

public class Manager implements iUser {


    private int  managerID;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;


    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }
    HashMap managerHashMap = new HashMap();
    @Override
    public void Validation() {
        managerHashMap.put("5000", "5000");
    }

    @Override
    public boolean Valid(String userName, String password) {
        boolean managervalidate = false;
        String fetchpassword = (String)this.managerHashMap.get(userName);
        if (fetchpassword != null) {
            managervalidate = fetchpassword.equals(password);
        }

        return managervalidate;
    }
}
