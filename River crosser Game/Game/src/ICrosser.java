

import java.awt.image.BufferedImage;

public interface ICrosser {

    boolean canSail();

    double getWight();

    int getEatingrank();

    BufferedImage[] getImages();

    ICrosser makeCopy();

    void setLabelToBeShown​(String label);

    String getLabelToBeShown​();

}
