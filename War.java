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
        ArrayList<Card> deltList = new ArrayList();
        ArrayList<Card> deltList2 = new ArrayList();
        while (player1.getDeckSize() > 0 && player2.getDeckSize() > 0) {
            //System.out.println("hi");
            deltList.add(player1.dealCardFromDeck());
            deltList.add(player2.dealCardFromDeck()); 
            for (int i = 0; i < deltList.size(); i++){
                System.out.print(deltList.get(i).getRank());
                System.out.print(", ");
            }
            int i = 0;
            if(deltList.get(i).getRank() > deltList2.get(i).getRank()){
                player1.getRank();
            } else if (deltList.get(i).getRank() < deltList2.get(i).getRank()){
                
            } else if (deltList.get(i).getRank() == deltList2.get(i).getRank()){
                ArrayList<Card> WarList = new ArrayList();
                for(int n = 0; i < 2; n++){
                    WarList.add(deltList.get(i));
                    deltList.remove(i);
                    WarList.add(deltList2.get(i));
                    deltList2.remove(i);
                    i++;
                }
                if(WarList.get(4).getRank() > WarList.get(5).getRank()){
                    for(int m = 0; m < 5; m++){
                        deltList.add(WarList.get(m));
                    }
                    WarList.clear();
                } else if(WarList.get(4).getRank() < WarList.get(5).getRank()){
                    for(int m = 0; m < 5; m++){
                        deltList2.add(WarList.get(m));
                    }
                    WarList.clear();
                } else if(WarList.get(4).getRank() == WarList.get(5).getRank()){
                    
                }
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
