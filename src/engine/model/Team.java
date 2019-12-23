package engine.model;

/**
 * Team
 */
public class Team {
    private Player[] teamPlayer = new Player[6];
    private int[][] cards = new int[6][2];

    /**
     * @param teamPlayer the array of Player
     * @param thimble    the thimble
     * @param cards      the stat of cards
     */
    public Team(Player[] teamPlayer, int[][] cards) {
        this.teamPlayer = teamPlayer;
        this.thimble = thimble;
        this.cards = cards;
    }

    /**
     * @return the stat of cards
     */
    public int[][] getCards() {
        return cards;
    }

    /**
     * @return the array of Player
     */
    public Player[] getTeamPlayer() {
        return teamPlayer;
    }

    /**
     * @param cards set the stat of cards
     */
    public void setCards(int[][] cards) {
        this.cards = cards;
    }

    /**
     * @param teamPlayer set the array of Player
     */
    public void setTeamPlayer(Player[] teamPlayer) {
        this.teamPlayer = teamPlayer;
    }
}