package engine.api;

import engine.model.*;

public class CellInformation {
    //General information
    public boolean hasBall = false;
    public boolean hasPlayer = false;
    
    //Player
    public int playerTeam = 0;
    public int playerNumber = 0;
    public PlayerState playerState = null;

    //Balls
    public int ballNumber = 0;

    public CellInformation(){
        
    }
    public CellInformation(CellInformation cell){
        this.hasBall = cell.hasBall;
        this.hasPlayer = cell.hasPlayer;

        this.playerTeam = cell.playerTeam;
        this.playerNumber = cell.playerNumber;
        this.playerState = new PlayerState(cell.playerState);
    
        this.ballNumber = cell.ballNumber;
    }
}