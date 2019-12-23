package gui.api;

import java.awt.Point;
import gui.models.*;

/**
 * GUI Interface
 */
public interface IGUI {
    /**
     * Select the scene to work on
     * @param type scene to choose
     */
    void setScene(SceneType type);

    /**
     * Create new player entity associated to
     * a graphical resource
     * @param position : initial player position
     * @param image : main image
     * @param tackled : tackled image
     * @return : player handler
     */
    public int createPlayer(Point position, String image, String tackled);
    /**
     * Control if the player is turned or not
     * 
     * @param id     : player entity id
     * @param toggle : turned or not
     */
    void setTacklPlayer(int id, boolean toggle);
    /**
     * Move graphical player
     * 
     * @param id       : player id
     * @param position : new player position
     */
    void movePlayer(int id, Point position);
    /**
     * Move ball graphical entity
     * 
     * @param position : new ball position
     */
    void moveBall(Point position);

    /**
     * Change selection area
     * @param areas : areas list
     */
    void setArea(VisualArea[] areas);

    /**
     * Attach ball to a player. When the player move, the ball move also.
     * 
     * @param player : player entity id
     */
    void attachBall(int player);
    /**
     * Detach ball from player
     */
    void detachBall();

    /**
     * Control if the card has already been use
     * 
     * @param card   : card number
     * @param toggle : use or not
     */
    void toggleCard(int card, boolean toggle);
    /**
     * Display card deck or not
     * 
     * @param toggle : control
     */
    void toggleCardDeck(boolean toggle);

    /**
     * Show black screen or not
     * 
     * @param toggle  : control
     * @param message : message to display (eg: "player 1")
     */
    void toggleBlackScreen(boolean toggle, String message);
}