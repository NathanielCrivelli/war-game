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
        Deck deck =  new Deck();
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
        for(int i = 0; i < player1 || player2;) {
            player1.dealCardFromDeck;
            player2.dealCardFromDeck;
            if(dealtList[0] > dealtList[1]) {
                player1.addCardToDeck;
            } else if (dealtList[0] < dealtList[1]) {
                player2.addCardToDeck;
            } else if (dealtList[0] = dealtList[1]) {
                player1.dealCardFromDeck[2];
                player2.dealCardFromDeck[2];
                if(dealtList[0] > dealtList[1]) {
                    player1.addCardToDeck;
                } else if(dealtList[0] < dealtList[1]) {
                    player2.addCardToDeck;
                }
            }
        }
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
