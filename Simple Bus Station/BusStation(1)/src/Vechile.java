public abstract class Vechile {
    protected String[] vechlieNo;
    protected String[] color;
    protected   String[] model;
    private String noOfSeats;

    public String[] getVechlieNo() {return vechlieNo;}
    public String[] getColor() {
        return color;
    }
    public String[] getModel() {
        return model;
    }
    public String getNoOfSeats() {
        return noOfSeats;
    }

    public void setVechlieNo(String[] vechlieNo) {this.vechlieNo = vechlieNo;}
    public void setColor(String[] color) {this.color = color;}
    public void setModel(String[] model) {this.model = model;}
    public void setNoOfSeats(String noOfSeats) {this.noOfSeats = noOfSeats;}

    public abstract void getFromFile();
}