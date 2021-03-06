package engine.api;

import engine.Engine;

/**
 * GameInformation
 */
public class GameInformation {

    public CardInformation[][] cards;
    public CellInformation[][] cells;
    public int currentActor = 0;

    public GameInformation(){
        this.cards = new CardInformation[Engine.TEAM_COUNT][Engine.CARD_COUNT];
        this.cells = new CellInformation[Engine.BOARD_X][Engine.BOARD_Y];

        for(int team = 0; team < Engine.TEAM_COUNT; team++){
            for(int card = 0; card < Engine.CARD_COUNT; card++){
                this.cards[team][card] = new CardInformation();
            }
        }
        for(int x = 0; x < Engine.BOARD_X; x++){
            for(int y = 0; y < Engine.BOARD_Y; y++){
                this.cells[x][y] = new CellInformation();
            }
        }
    }
    public GameInformation(GameInformation game){
        this.cards = new CardInformation[Engine.TEAM_COUNT][Engine.CARD_COUNT];
        this.cells = new CellInformation[Engine.BOARD_X][Engine.BOARD_Y];

        for(int team = 0; team < Engine.TEAM_COUNT; team++){
            for(int card = 0; card < Engine.CARD_COUNT; card++){
                this.cards[team][card] = new CardInformation(game.cards[team][card]);
            }
        }
        for(int x = 0; x < Engine.BOARD_X; x++){
            for(int y = 0; y < Engine.BOARD_Y; y++){
                this.cells[x][y] = new CellInformation(game.cells[x][y]);
            }
        }

        this.currentActor = game.currentActor;
    }    
}