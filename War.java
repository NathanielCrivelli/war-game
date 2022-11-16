import java.util.ArrayList;

/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    private Deck player1;
    private Deck player2;
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
        ArrayList deltList = new ArrayList();
        for(int i = 0; i < 1; i++){
            deltList.add(player1.dealCardFromDeck());
            deltList.add(player2.dealCardFromDeck());
            if(deltList.indexOf(0) > deltList.indexOf(1)){
                for(int o = 0; o < deltList.size(); o++){
                    
                }
            } else if (deltList.indexOf(1) > deltList.indexOf(0)){
                for(int k = 0; k < deltList.size(); k++){
                    
                }
            } else if (deltList.indexOf(0) == deltList.indexOf(1)){
                
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
