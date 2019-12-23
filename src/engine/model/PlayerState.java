package engine.model;

/**
 * PlayerState
 */
public class PlayerState {

    public int mov;
    public int att;
    public int def;
    public boolean ret;
    public boolean play;

    /**
     * @param name the name of the player
     * @param mov  the number of movement point
     * @param att  the number of attack points
     * @param def  the number of defense points
     * @param ret  the return state
     * @param play the play state
     */
    public PlayerState(int mov, int att, int def, boolean ret, boolean play) {
        this.mov = mov;
        this.att = att;
        this.def = def;
        this.ret = ret;
        this.play = play;
    }
    public PlayerState(PlayerState state){
        this.mov = state.mov;
        this.att = state.att;
        this.def = state.def;
        this.ret = state.ret;
        this.play = state.play;
    }
}