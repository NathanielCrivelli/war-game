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
        ArrayList<Card> dealtList = new ArrayList();
        ArrayList<Card> dealtList2 = new ArrayList();
        while (player1.getDeckSize() > 0 && player2.getDeckSize() > 0) {
            //System.out.println("hi");
            dealtList.add(player1.dealCardFromDeck());
            dealtList.add(player2.dealCardFromDeck()); 
            for (int i = 0; i < dealtList.size(); i++){
                System.out.print(dealtList.get(i).getRank());
                System.out.print(", ");
            }
            System.out.println("");
        }
    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
