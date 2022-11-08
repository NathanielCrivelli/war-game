import java.util.ArrayList;

/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        Deck deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();
        Deck[] halves = deck.dealDeck();
        Deck player1 = halves[0];
        Deck player2 = halves[1];
        // ...then run the event loop
        this.runEventLoop();
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        ArrayList dealtList = new ArrayList();
        cards.shuffle();
        for(int i = 0; i <
            if(player1[0] > player2[0]){
                player1.addCardToDeck(player2[0]);
            } else if (player1[0] < player2[0]){
                player2.addCardToDeck(player1[0]);
            } else {
                for(int g = 0; g < 
            }
        
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
