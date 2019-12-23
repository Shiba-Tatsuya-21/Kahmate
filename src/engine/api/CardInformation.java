package engine.api;

/**
 * CardInformation
 */
public class CardInformation {

    public int value = 0;
    public boolean used = false;

    public CardInformation(){
        
    }
    public CardInformation(CardInformation card){
        this.value = card.value;
        this.used = card.used;
    }
}