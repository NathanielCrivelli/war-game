    import java.lang.reflect.Array;
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
    
    private Deck player1;
    private Deck player2;

    //ArrayList dealtList1 = new ArrayList();
    //ArrayList dealtList2 = new ArrayList();

    public War()
    {
        // Initializations here...
        Deck deck =  new Deck();
        deck.initializeNewDeck();
        deck.shuffle();
        Deck[] halves = deck.dealDeck();
        player1 = halves[0];
        player2 = halves[1];
        
        
        
        // ...then run the event loop
        this.runEventLoop();
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        //ArrayList dealtList = new ArrayList();
        ArrayList dealtList = new ArrayList();
        for(int i = 0; i < 1;i++) {
            dealtList.add(player1.dealCardFromDeck());
            dealtList.add(player2.dealCardFromDeck());
            if(dealtList.indexOf(0) > dealtList.indexOf(1)) {
                player1.addCardToDeck(dealtList);
            }
            else if(dealtList.indexOf(0) < dealtList.indexOf(1)) {
                player2.addCardToDeck(dealtList);
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
