package engine.model;

import engine.api.*;

/**
 * GameState
 */
public class GameState {

    private GameInformation gameInformation;

    public GameState(){
        this.gameInformation = new GameInformation();
    }

    public GameInformation getGameInformation(){
        return this.gameInformation;
    }
}