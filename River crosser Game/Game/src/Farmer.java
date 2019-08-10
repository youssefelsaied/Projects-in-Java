
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Farmer extends Crosser implements ICrosser {
    private String information = "Farmers:\n"+" -can raft the boat.\n" + " -don’t eat any crosser.\n"+ "-can’t be eaten by any crosser.";
    String img0;
    String img1;
    Image img00=new Image("f1.png");
    Image img01=new Image("f2.png");
     public Farmer (String image0,String image1)
    {
        img0=image0;
        img1=image1;
        setPositionX(0);
        setPositionY(0);
    }

    @Override
    public boolean canSail() {
        return true;
    }

    @Override
    public double getWight() {
        return getWeight1();
    }

    @Override
    public int getEatingrank() {
        return -1;
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
        information =label;
    }

    @Override
    public String getLabelToBeShown​() {
        return information;
    }

    public void render(GraphicsContext gc){
        gc.drawImage(img00,200,185);

    }
}
