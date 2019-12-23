package engine;

import engine.api.*;
import engine.model.*;

import java.awt.Point;

public class Engine implements IEngine{

    public static int BOARD_X = 13;
    public static int BOARD_Y = 8;
    public static int CARD_COUNT = 5;
    public static int TEAM_COUNT = 2;

    private GameState gameState;

    /**
     * Constructor
     */
    public Engine(){
        this.gameState = new GameState();
    }

    /**
     * Start the game
     */
    public void play(){

    }

    /**
     * Restart the game
     */
    public void replay(){

    }

    /**
     * Leave the game
     */
    public void leave(){

    }

    /**
     * Go to next round
     */
    public void nextRound(){

    }

    /**
     * Perform custom player action
     */
    public void performPlayerAction(IPlayerAction action){
        action.perform(this.gameState, this);
    }

    /**
     * Get cell information from cell position
     * 
     * @param position : cell position
     * @return : return cell information
     */
    public CellInformation getCellInformation(Point position){
        return this.gameState.getGameInformation().cells[position.x][position.y];
    }

    /**
     * Return general game information
     * 
     * @return : return game information
     */
    public GameInformation getGameInformation(){
        return this.gameState.getGameInformation();
    }
}