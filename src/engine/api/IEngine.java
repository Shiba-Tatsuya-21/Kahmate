package engine.api;

import java.awt.Point;

/**
 * Engine Interface
 */
public interface IEngine {

    /**
     * Start the game
     */
    void play();

    /**
     * Restart the game
     */
    void replay();

    /**
     * Leave the game
     */
    void leave();

    /**
     * Go to next round
     */
    void nextRound();

    /**
     * Perform custom player action
     */
    void performPlayerAction(IPlayerAction action);

    /**
     * Get cell information from cell position
     * 
     * @param position : cell position
     * @return : return cell information
     */
    CellInformation getCellInformation(Point position);

    /**
     * Return general game information
     * 
     * @return : return game information
     */
    GameInformation getGameInformation();
}