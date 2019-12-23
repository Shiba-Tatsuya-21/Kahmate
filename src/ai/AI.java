package ai;

/**
 * AI
 */
public class AI implements IAI, IActor{

    /**
     * Classical turn play by an actor, actions should be thrown to the
     * engine
     */
    public void performActions(){

    }
    
    /**
     * Card duel is triggered by the other player
     * 
     * @return : card number returned
     */
    public int performDuel(){
        return 0;
    }

    /* ------------- ATTACK --------------------------------------*/

	//public Player chooseBestPlayer(CellInformation tab); //Regarde si joueur avec balle a peut bouger vers l'avant. (Preference tout droit)
	/* 
	si le joueur avec la balle peut franchir la ligne go
	Si joueur2 allié peut se rapprocher du joueur avec balle (preference pas sur la meme ligne y)
	Si joueur avec balle n'est pas choisi en premier joueur alors le deuxieme joueur ne doit pas le dépasser en X et se rapprocher le plus possible pour être à hauteur de passe
	*/

	//public void setMovementToLine(Player player);

	//public Player getBallPlayer(CellInformation tab);

	//public void doPass(Player player);

	//public void doShoot(Point point);

	

// -------------------- DEFENSE -------------------------------


	//public Player getCloserPlayerToBall(CellInformation tab);

	//public void setMovementToBall(Player player);

	//public Player getCloserPlayerOne(Player playerOne);

	//public void setMovementToPlayerOne(Player playerTwo);

	//public void doTackle(Player player, Player enemy);

// ------------- Hybride ----------------------------
	/**
	*@param diff: Difference of points between attack and defense 
	*/
	//public void chooseCard(int diff);

}