package engine.model;

public class Player extends Entity{
    
    private int team;
    
    /**
    *Initialize team and initial position
    *team 0 = left, team 1 = right
    *posInit=Y-Position
    *lineInit= first line or second line (1 or 2)
    * @param t: team
    * @param posInit : initial Y-Position player
    * @param lineInit : initial line player 
    */
    public Player(int t, int posx, int posy){
        super(x, y);

        this.team = t;
    }

    /**
    *Return the player team
    * @return : return team player
    */
    public int getTeam(){
        return this.team;
    }

    /**
    *Set the player team
    * @param t : team player
    */
    public void setTeam(int t){
        this.team = t;
    }
}