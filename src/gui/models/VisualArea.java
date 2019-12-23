package gui.models;

import java.awt.*;

import gui.layers.TerrainLayer;

public class VisualArea{

    private Point position;
    private Color color;

    public VisualArea(Point position, Color color){
        this.position = position;
        this.color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 100);
    }
    public VisualArea(int x, int y, Color color){
        this.position = new Point(x, y);
        this.color = color;
    }

    public Point getPosition(){
        return new Point(
            this.position.x * TerrainLayer.CELL_SIZE.width,
            this.position.y * TerrainLayer.CELL_SIZE.height
        );
    }
    public Color getColor(){
        return this.color;
    }
}