package gui.models;

import java.awt.image.BufferedImage;
import java.awt.*;

import gui.layers.TerrainLayer;

public class VisualPlayer{

    public static Dimension PLAYER_DIMENSION = new Dimension(
        (int)((double)TerrainLayer.CELL_SIZE.width * (90.0 / 100.0)),
        (int)((double)TerrainLayer.CELL_SIZE.height * (90.0 / 100.0))
    );

    private BufferedImage image;
    private BufferedImage tacklImage;
    private Point position;
    private Point nextPosition;
    private boolean isTackled;

    public VisualPlayer(
        BufferedImage image,
        BufferedImage tacklImage,
        Point position,
        boolean isTackled
    ){
        this.image = image;
        this.tacklImage = tacklImage;
        this.position = position;
        this.nextPosition = position;
        this.isTackled = isTackled;
    }

    public BufferedImage getImage(){
        return this.image;
    }
    public BufferedImage getTacklImage(){
        return this.tacklImage;
    }
    public Point getPosition(){
        return this.position;
    }
    //T(s) = A + s*(B-A)
    public Point getPosition(double alpha){

        Point A = new Point(
            (this.position.x * TerrainLayer.CELL_SIZE.width) + (TerrainLayer.CELL_SIZE.width / 2) - (PLAYER_DIMENSION.width / 2),
            (this.position.y * TerrainLayer.CELL_SIZE.height) + (TerrainLayer.CELL_SIZE.height / 2) - (PLAYER_DIMENSION.height / 2)
        );
        Point B = new Point(
            (this.nextPosition.x * TerrainLayer.CELL_SIZE.width) + (TerrainLayer.CELL_SIZE.width / 2) - (PLAYER_DIMENSION.width / 2),
            (this.nextPosition.y * TerrainLayer.CELL_SIZE.height) + (TerrainLayer.CELL_SIZE.height / 2) - (PLAYER_DIMENSION.height / 2)
        );

        //Cosine interpolation
        double alpha2 = (1.0 - Math.cos(alpha * Math.PI)) / 2.0;

        return new Point(
            A.x + (int)(alpha2 * (double)(B.x - A.x)),
            A.y + (int)(alpha2 * (double)(B.y - A.y))
        );
    }
    public Point getNextPosition(){
        return this.nextPosition;
    }
    public void setPosition(Point position){
        this.position = position;
    }
    public void setNextPosition(Point position){
        this.nextPosition = position;
    }

    public void setTackled(boolean toggle){
        this.isTackled = toggle;
    }
    public boolean isTackled(){
        return this.isTackled;
    }
}