import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Plant extends Crosser implements ICrosser {
    private String img0;
    private String img1;
    private String information = "plant:\n"+" -can not raft the boat.\n" + " -can not eat any crosser.\n"+ " -can be eaten by herbivorous.";
    public Plant( String image0,String image1)
    {
        img0=image0;
        img1=image1;
        setWeight(20);
        setPositionX(0);
        setPositionY(0);
        Image i0=new Image(image0);
        Image i1=new Image(image1);
        setWidth(i0.getWidth());
        setHeight(i1.getHeight());
    }


    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public double getWight() {
        return 0;
    }

    @Override
    public int getEatingrank() {
        return 1;
    }

    @Override
    public BufferedImage[] getImages() {
        BufferedImage[] b1 =new BufferedImage[2] ;
        try {
            b1[0]= ImageIO.read(new File(img0));
            b1[1]= ImageIO.read(new File(img1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  b1;
    }

    @Override
    public ICrosser makeCopy() {
        return null;
    }

    @Override
    public void setLabelToBeShown​(String label) {
        information=label;
    }

    @Override
    public String getLabelToBeShown​() {
        return information;
    }
}
