package gui.models;

import gui.layers.TerrainLayer;
import gui.models.*;

import java.awt.*;

public class VisualBall{

    public static Dimension BALL_DIMENSION = new Dimension(45, 45);

    private Point position;
    private Point nextPosition;
    private VisualPlayer player;

    public VisualBall(Point position, VisualPlayer player){
        this.position = position;
        this.nextPosition = this.position;
        this.player = player;
    }

    public void attachTo(VisualPlayer player){
        this.player = player;
    }

    public void setPosition(Point position){
        this.position = position;
    }
    public void setNextPosition(Point position){
        this.nextPosition = position;
    }
    public Point getPosition(){
        return this.position;
    }
    public Point getPosition(double alpha){

        if(this.player != null){
            return this.player.getPosition(alpha);
        } else{
            Point A = new Point(
                (this.position.x + 1) * TerrainLayer.CELL_SIZE.width - VisualBall.BALL_DIMENSION.width - 10, 
                (this.position.y + 1) * TerrainLayer.CELL_SIZE.height - VisualBall.BALL_DIMENSION.height - 10
            );
            Point B = new Point(
                (this.nextPosition.x + 1) * TerrainLayer.CELL_SIZE.width - VisualBall.BALL_DIMENSION.width - 10, 
                (this.nextPosition.y + 1) * TerrainLayer.CELL_SIZE.height - VisualBall.BALL_DIMENSION.height - 10
            );

            //Cosine interpolation
            double alpha2 = (1.0 - Math.cos(alpha * Math.PI)) / 2.0;

            return new Point(
                A.x + (int)(alpha2 * (double)(B.x - A.x)),
                A.y + (int)(alpha2 * (double)(B.y - A.y))
            );
        }        
    }
    public Point getNextPosition(){
        return this.nextPosition;
    }

    public boolean isAttached(){
        return this.player != null;
    }
}