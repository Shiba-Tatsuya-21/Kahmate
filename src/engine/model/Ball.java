package engine.model;

public class Ball extends Entity{
    
    private Player player;

    /**
    *Initialize ball position
    */
    public Ball(){
        super(0, 0);
    }

    /**
    *Return the player who have the ball
    * @return Player
    */
    public Player getPlayer(){
        return this.player;
    }

    /**
    *Set the player who take the ball
    * @param p : player
    */
    public void setPlayer(Player p){
        this.player = p;
    }

}