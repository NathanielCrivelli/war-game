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
        try{
            while (player1.getDeckSize() > 0 && player2.getDeckSize() > 0) {
                Card card1 = player1.dealCardFromDeck();
                Card card2 = player2.dealCardFromDeck();
                if (card1.getRank() > card2.getRank()) {
                    player1.addCardToDeck(card1);
                    player1.addCardToDeck(card2);
                    player1.shuffle();
                    player2.shuffle();
                    System.out.println("P1 won round");
                    System.out.println("P1: " + player1.getDeckSize());
                    System.out.println("P2: " + player2.getDeckSize());
                } else if (card1.getRank() < card2.getRank()) {
                    player2.addCardToDeck(card1);
                    player2.addCardToDeck(card2);
                    player1.shuffle();
                    player2.shuffle();
                    System.out.println("P2 won round");
                    System.out.println("P1: " + player1.getDeckSize());
                    System.out.println("P2: " + player2.getDeckSize());
                } else {
                    // ArrayList<Card> war1 = new ArrayList<Card>();
                    // ArrayList<Card> war2 = new ArrayList<Card>();
                    // war1.add(card1);
                    // war2.add(card2);
                    if(card1.getRank() == card2.getRank()) {
                        Card first1 = player1.dealCardFromDeck();
                        Card first2 = player1.dealCardFromDeck();
                        Card second1 = player1.dealCardFromDeck();
                        Card second2 = player1.dealCardFromDeck();
                        System.out.println("WAR");
                        Card third1 = player1.dealCardFromDeck();
                        Card third2 = player2.dealCardFromDeck();
                        if(third1.getRank() > third2.getRank()) {
                            player1.addCardToDeck(card1);
                            player1.addCardToDeck(card2);
                            player1.addCardToDeck(first1);
                            player1.addCardToDeck(first2);
                            player1.addCardToDeck(second1);
                            player1.addCardToDeck(second2);
                            player1.addCardToDeck(third1);
                            player1.addCardToDeck(third2);
                            player1.shuffle();
                            player2.shuffle();
                            System.out.println("This is p1");
                            System.out.println("pog");
                            System.out.println("P1: " + player1.getDeckSize());
                            System.out.println("P2: " + player2.getDeckSize());
                            System.out.println("P1 has won the war");
                        } else if(third1.getRank() < third2.getRank()) {
                            player2.addCardToDeck(card1);
                            player2.addCardToDeck(card2);
                            player2.addCardToDeck(first1);
                            player2.addCardToDeck(first2);
                            player2.addCardToDeck(second1);
                            player2.addCardToDeck(second2);
                            player2.addCardToDeck(third1);
                            player2.addCardToDeck(third2);
                            player1.shuffle();
                            player2.shuffle();
                            System.out.println("This is p2");
                            System.out.println("pog");
                            System.out.println("P1: " + player1.getDeckSize());
                            System.out.println("P2: " + player2.getDeckSize());
                            System.out.println("P2 has won the war");
                        } else {
                            player1.addCardToDeck(card1);
                            player2.addCardToDeck(card2);
                            player1.addCardToDeck(first1);
                            player2.addCardToDeck(first2);
                            player1.addCardToDeck(second1);
                            player2.addCardToDeck(second2);
                            player1.addCardToDeck(third1);
                            player2.addCardToDeck(third2);
                            System.out.println("TIE");
                            continue;
                        }
                    }

                    if (player1.getDeckSize() <= 0) {
                        System.out.println("P1 Loser");
                    }
                    if (player2.getDeckSize() <= 0) {
                        System.out.println("P2 Loser");
                    }
                }
            }
        } catch(Exception IndexOutOfBoundsException){
            if(player1.getDeckSize() == 0){
                System.out.println("P2 has won the war");
                System.out.println("P1: "+player1.getDeckSize());
                System.out.println("P2: "+player2.getDeckSize());
                System.out.println("P1 Loser");
            } else if(player2.getDeckSize() == 0){
                System.out.println("P1 has own the war");
                System.out.println("P1: "+player1.getDeckSize());
                System.out.println("P2: "+player2.getDeckSize());
                System.out.println("P2 Loser");
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
