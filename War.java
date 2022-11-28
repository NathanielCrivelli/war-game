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
        while (player1.getDeckSize() > 0 && player2.getDeckSize() > 0) {
            Card card1 = player1.dealCardFromDeck();
            Card card2 = player2.dealCardFromDeck();
            if (card1.getRank() > card2.getRank()) {
                player1.addCardToDeck(card1);
                player1.addCardToDeck(card2);
                System.out.println("P1 won round");
                System.out.println("P1: " + player1.getDeckSize());
                System.out.println("P2: " + player2.getDeckSize());
            } else if (card1.getRank() < card2.getRank()) {
                player2.addCardToDeck(card1);
                player2.addCardToDeck(card2);
                System.out.println("P2 won round");
                System.out.println("P1: " + player1.getDeckSize());
                System.out.println("P2: " + player2.getDeckSize());
            } else {
                ArrayList<Card> war1 = new ArrayList<Card>();
                ArrayList<Card> war2 = new ArrayList<Card>();
                war1.add(card1);
                war2.add(card2);
                while (card1.getRank() == card2.getRank()) {
                    for (int i = 0; i < 3; i++) {
                        if (player1.getDeckSize() > 0) {
                            war1.add(player1.dealCardFromDeck());
                        }
                        if (player2.getDeckSize() > 0) {
                            war2.add(player2.dealCardFromDeck());
                        }
                    }
                    // if (player1.getDeckSize() <= 0) {
                    //     card1 = player1.dealCardFromDeck();
                    //     war1.add(card1);
                    //     System.out.println("P1 Loser");
                    // }   
                    // if (player2.getDeckSize() <= 0) {
                    //     card2 = player2.dealCardFromDeck();
                    //     war2.add(card2);
                    //     System.out.println("P2 Loser");
                    // }
                }
                if (card1.getRank() > card2.getRank()) {
                    for (int i = 0; i < war1.size(); i++) {
                        player1.addCardToDeck(war1.get(i));
                    }
                    for (int i = 0; i < war2.size(); i++) {
                        player1.addCardToDeck(war2.get(i));
                    }
                } else if (card1.getRank() < card2.getRank()) {
                    for (int i = 0; i < war1.size(); i++) {
                        player2.addCardToDeck(war1.get(i));
                    }
                    for (int i = 0; i < war2.size(); i++) {
                        player2.addCardToDeck(war2.get(i));
                    }
                }
                if (player1.getDeckSize() <= 0) {
                    card1 = player1.dealCardFromDeck();
                    war1.add(card1);
                    System.out.println("P1 Loser");
                }
                if (player2.getDeckSize() <= 0) {
                    card2 = player2.dealCardFromDeck();
                    war2.add(card2);
                    System.out.println("P2 Loser");
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