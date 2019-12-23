package gui.layers;

import javax.swing.JPanel;

import gui.*;
import gui.models.*;

import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.*;
import java.awt.color.*;
import java.awt.*;
import java.util.*;

public class CardLayer extends Layer{

    private VisualCard[] cards;
    private boolean visible = false;
    private boolean isEditable = true;
    private int focusCard = -1;

    public CardLayer(VisualCard[] cards){
        super();

        this.cards = cards;

        this.virtualHeight = TerrainLayer.TERRAIN_TEXTURE_DIMENSION.height;
        this.virtualWidth = TerrainLayer.TERRAIN_TEXTURE_DIMENSION.width;
    }

    public void showCard(boolean toggle){
        this.visible = toggle;
    }
    public boolean isShowed(){
        return this.visible;
    }

    public void setEditable(boolean toggle){
        this.isEditable = toggle;
    }
    public boolean isEditable(){
        return this.isEditable;
    }

    public void setFocusCard(int focus){
        this.focusCard = focus;
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        Graphics2D g2d = (Graphics2D)graphics.create();

        final int rowLength = (VisualCard.CARD_DIMENSION.width + VisualCard.MARGIN_X) * VisualCard.DECK_COUNT - VisualCard.MARGIN_X;
        final int offsetX = (this.virtualWidth / 2) - (rowLength / 2);

        //Should render only when cards are visible.
        //Cards may be visible in the animation (visible == false and alpha != 0.0)
        if(this.visible || alpha != 0.0){
            
            for(int i = 0; i < this.cards.length; i++){
                VisualCard card = this.cards[i];
    
                int x = offsetX + (i % VisualCard.DECK_COUNT) * (VisualCard.CARD_DIMENSION.width + VisualCard.MARGIN_X);
                int visibleY = (i / VisualCard.DECK_COUNT) == 0 ? VisualCard.MARGIN_Y : this.virtualHeight - VisualCard.MARGIN_Y - VisualCard.CARD_DIMENSION.height;
                int unvisibleY = (i / VisualCard.DECK_COUNT) == 0 ? -VisualCard.CARD_DIMENSION.height : this.virtualHeight;

                int y = visibleY; //By default y is visible

                //Animation -> transition should be computed
                if(alpha != 0.0){
                    //Cosine interpolation
                    double alpha2 = (1.0 - Math.cos(alpha * Math.PI)) / 2.0;

                    //Determine animation wise
                    if(this.visible){ //Cards will disappear
                        y = visibleY + (int)(alpha2 * (double)(unvisibleY - visibleY));
                    } else{ //Cards will appear
                        y = unvisibleY + (int)(alpha2 * (double)(visibleY - unvisibleY));
                    }
                }

                //If the focused one, push it up a little bit
                if(((i / VisualCard.DECK_COUNT) == 1) && ((i % VisualCard.DECK_COUNT) == this.focusCard) && 
                this.isEditable() && this.cards[i].isActive()){
                    y -= 20;
                } 

                Rectangle draw = this.rectangleSpaceToViewSpace(new Rectangle(
                    x, y,
                    VisualCard.CARD_DIMENSION.width, VisualCard.CARD_DIMENSION.height
                ));

                //Top deck or not editable
                if((!this.isEditable) || ((i / VisualCard.DECK_COUNT) == 0)){
                    float opacity = 0.6f; //draw half transparent
                    AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
                    g2d.setComposite(ac);
                } else{   
                    //Set full opacity
                    float opacity = 1.0f;
                    AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
                    g2d.setComposite(ac);
                }

                if(card.isActive()){
                    g2d.drawImage(
                        card.getImage(), 
                        (int)draw.getX(), (int)draw.getY(), 
                        (int)draw.getWidth(), (int)draw.getHeight(), 
                        null, this
                    );
                } else{
                    g2d.drawImage(
                        card.getGrayImage(), 
                        (int)draw.getX(), (int)draw.getY(), 
                        (int)draw.getWidth(), (int)draw.getHeight(), 
                        null, this
                    );
                }
            }
        }
    }
}