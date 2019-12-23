package gui.controllers;

import gui.GUI;
import gui.layers.*;
import gui.models.*;

import java.awt.*;
import java.awt.event.*;

public class MouseController implements MouseListener, MouseMotionListener{

    private GUI gui;
    private AreaLayer area;
    private CardLayer card;

    public MouseController(
        GUI gui,
        AreaLayer area,
        CardLayer card
    ){
        this.area = area;
        this.area.addMouseMotionListener(this);
        this.area.addMouseListener(this);
        this.card = card;
        //DO NOT ADD MOUSE LISTENER TO CARD LAYER, IT WILL BLOCK AREA INPUTS

        this.gui = gui;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Rectangle rectangle = new Rectangle(
            e.getX(), e.getY(),
            0, 0
        );

        Rectangle rectangleSpace = this.area.viewSpaceToRectangleSpace(rectangle);

        if(this.card.isShowed()){
            if(this.card.isEditable()){

                int cardNumber = this.cardFromCoordinate(new Point((int)rectangleSpace.getX(), (int)rectangleSpace.getY()));
                if(cardNumber != -1){
                    
                    //ENGINE CALL

                }

            }
        } else{

            Point positionSelection = new Point(
                rectangleSpace.x / TerrainLayer.CELL_SIZE.width,
                rectangleSpace.y / TerrainLayer.CELL_SIZE.height
            );

            if(positionSelection.x >= 0 && positionSelection.x < TerrainLayer.TERRAIN_CELL_DIMENSION.width &&
                positionSelection.y >= 0 && positionSelection.y < TerrainLayer.TERRAIN_CELL_DIMENSION.height){
                
                gui.moveBall(positionSelection);
                //ENGINE CALL

            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e){

        if(!this.card.isShowed()){
            Rectangle rectangle = new Rectangle(
                e.getX(), e.getY(),
                0, 0
            );
            Rectangle rectangleSpace = this.area.viewSpaceToRectangleSpace(rectangle);

            Point positionSelection = new Point(
                rectangleSpace.x / TerrainLayer.CELL_SIZE.width,
                rectangleSpace.y / TerrainLayer.CELL_SIZE.height
            );

            boolean repaint = false;

            if(positionSelection.x >= 0 && positionSelection.x < TerrainLayer.TERRAIN_CELL_DIMENSION.width &&
            positionSelection.y >= 0 && positionSelection.y < TerrainLayer.TERRAIN_CELL_DIMENSION.height){
                if(!positionSelection.equals(this.area.getSelectionArea())){
                    repaint = true;
                }
                this.area.setSelectionArea(positionSelection);
            } else{
                if(!positionSelection.equals(this.area.getSelectionArea())){
                    repaint = true;
                }
                this.area.setSelectionArea(null);
            }

            if(repaint){
                this.area.repaint();
            }
        } else{
            Rectangle rectangle = new Rectangle(
                e.getX(), e.getY(),
                0, 0
            );
            Rectangle rectangleSpace = this.area.viewSpaceToRectangleSpace(rectangle);

            int focusCard = this.cardFromCoordinate(new Point((int)rectangleSpace.getX(), (int)rectangleSpace.getY()));
            this.card.setFocusCard(focusCard);
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}

    private int cardFromCoordinate(Point coordinate){
        int x = (int)coordinate.getX();
        int y = (int)coordinate.getY();

        //Check Y cusor position
        if((y < this.card.getVirtualHeight() - VisualCard.MARGIN_Y) &&
        (y > this.card.getVirtualHeight() - VisualCard.MARGIN_Y - VisualCard.CARD_DIMENSION.height)){
            

            final int rowLength = (VisualCard.CARD_DIMENSION.width + VisualCard.MARGIN_X) * VisualCard.DECK_COUNT - VisualCard.MARGIN_X;
            final int offsetX = (this.card.getVirtualWidth() / 2) - (rowLength / 2);    
            
            //Check X cursor position
            if(x >= offsetX && x <= this.card.getVirtualWidth() - offsetX){
                x -= offsetX;
                
                //Check final card position
                int remainingOffset = x % (VisualCard.CARD_DIMENSION.width + VisualCard.MARGIN_X);
                if(remainingOffset <= VisualCard.CARD_DIMENSION.width){
                    int cardNumber = x / (VisualCard.CARD_DIMENSION.width + VisualCard.MARGIN_X);
                    
                    //ENGINE CALL
                    return cardNumber;

                }
            }
        }

        return -1;
    }
}
