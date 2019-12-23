package gui.models;

import java.awt.image.*;
import java.awt.color.*;
import java.awt.*;

public class VisualCard{

    public static Dimension CARD_DIMENSION = new Dimension(170, 233);
    public static int DECK_COUNT = 5;
    public static int MARGIN_X = 20;
    public static int MARGIN_Y = 50;

    private boolean active = true;
    private BufferedImage image;
    private BufferedImage grayImage;

    public VisualCard(BufferedImage image){
        this.image = image;

        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp op = new ColorConvertOp(cs, null);

        this.grayImage = new BufferedImage(this.image.getWidth(), this.image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        this.grayImage = op.filter(this.image, null);
    }

    public void setActive(boolean toggle){
        this.active = toggle;
    }
    public boolean isActive(){
        return this.active;
    }

    public BufferedImage getImage(){
        return this.image;
    }
    public BufferedImage getGrayImage(){
        return this.grayImage;
    }
}