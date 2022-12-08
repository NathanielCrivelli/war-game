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
    private ArrayList<Card> WarList = new ArrayList<Card>();

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
                //set up cards
                Card card1 = player1.dealCardFromDeck();
                Card card2 = player2.dealCardFromDeck();
                //war cards
                Card first1;
                Card first2;
                Card second1;
                Card second2;
                Card third1;
                Card third2;
                //check who wins round
                if (card1.getRank() > card2.getRank()) {
                    //add cards to winner
                    System.out.println("P1: " + card1.getFace()+ " of " +card1.getSuit());
                    System.out.println("P2: " + card2.getFace()+ " of " +card2.getSuit());
                    player1.addCardToDeck(card1);
                    player1.addCardToDeck(card2);
                    //shuffle deck to avoid infinite loop
                    player1.shuffle();
                    player2.shuffle();
                    System.out.println("P1 won round");
                    System.out.println("P1: " + player1.getDeckSize());
                    System.out.println("P2: " + player2.getDeckSize());
                } else if (card1.getRank() < card2.getRank()) {
                    //add cards to winner
                    System.out.println("P1: " + card1.getFace()+ " of " +card1.getSuit());
                    System.out.println("P1: " + card2.getFace()+ " of " +card2.getSuit());
                    player2.addCardToDeck(card1);
                    player2.addCardToDeck(card2);
                    //shuffle deck to avoid infinite loop
                    player1.shuffle();
                    player2.shuffle();
                    System.out.println("P2 won round");
                    System.out.println("P1: " + player1.getDeckSize());
                    System.out.println("P2: " + player2.getDeckSize());
                } else {
                    //deal 3 cards per player for war
                    first1 = player1.dealCardFromDeck();
                    first2 = player2.dealCardFromDeck();
                    second1 = player1.dealCardFromDeck();
                    second2 = player2.dealCardFromDeck();
                    third1 = player1.dealCardFromDeck();
                    third2 = player2.dealCardFromDeck();

                    //check if its a war
                    if(card1.getRank() == card2.getRank()) {
                        //announce war
                        System.out.println("WAR");
                        //check which 3rd card is greater
                        if(third1.getRank() > third2.getRank()) {
                            //add played cards to winner
                            System.out.println("P1: " + card1.getFace()+ " of " +card1.getSuit());
                            System.out.println("P1: " + first1.getFace()+ " of " +first1.getSuit());
                            System.out.println("P1: " + second1.getFace()+ " of " +second1.getSuit());
                            System.out.println("P1: " + third1.getFace()+ " of " +third1.getSuit());
                            System.out.println("P2: " + card2.getFace()+ " of " +card2.getSuit());
                            System.out.println("P2: " + first2.getFace()+ " of " +first2.getSuit());
                            System.out.println("P2: " + second2.getFace()+ " of " +second2.getSuit());
                            System.out.println("P2: " + third2.getFace()+ " of " +third2.getSuit());
                            player1.addCardToDeck(card1);
                            player1.addCardToDeck(card2);
                            player1.addCardToDeck(first1);
                            player1.addCardToDeck(first2);
                            player1.addCardToDeck(second1);
                            player1.addCardToDeck(second2);
                            player1.addCardToDeck(third1);
                            player1.addCardToDeck(third2);
                            //shuffle deck to avoid infinite loop
                            player1.shuffle();
                            player2.shuffle();
                            System.out.println("P1: " + player1.getDeckSize());
                            System.out.println("P2: " + player2.getDeckSize());
                            System.out.println("P1 has won the war");
                        } else if(third1.getRank() < third2.getRank()) {
                            //add played cards to winner
                            System.out.println("P1: " + card1.getFace()+ " of " +card1.getSuit());
                            System.out.println("P1: " + first1.getFace()+ " of " +first1.getSuit());
                            System.out.println("P1: " + second1.getFace()+ " of " +second1.getSuit());
                            System.out.println("P1: " + third1.getFace()+ " of " +third1.getSuit());
                            System.out.println("P2: " + card2.getFace()+ " of " +card2.getSuit());
                            System.out.println("P2: " + first2.getFace()+ " of " +first2.getSuit());
                            System.out.println("P2: " + second2.getFace()+ " of " +second2.getSuit());
                            System.out.println("P2: " + third2.getFace()+ " of " +third2.getSuit());
                            player2.addCardToDeck(card1);
                            player2.addCardToDeck(card2);
                            player2.addCardToDeck(first1);
                            player2.addCardToDeck(first2);
                            player2.addCardToDeck(second1);
                            player2.addCardToDeck(second2);
                            player2.addCardToDeck(third1);
                            player2.addCardToDeck(third2);
                            //shuffle cards to avoid infinite loop
                            player1.shuffle();
                            player2.shuffle();
                            System.out.println("P1: " + player1.getDeckSize());
                            System.out.println("P2: " + player2.getDeckSize());
                            System.out.println("P2 has won the war");
                        } else {
                            //third card played in a war were equal. No winner
                            player1.addCardToDeck(card1);
                            player2.addCardToDeck(card2);
                            player1.addCardToDeck(first1);
                            player2.addCardToDeck(first2);
                            player1.addCardToDeck(second1);
                            player2.addCardToDeck(second2);
                            player1.addCardToDeck(third1);
                            player2.addCardToDeck(third2);
                            System.out.println("TIE");
                        }
                    }
                }
                //check if a player is out of cards to deteremine if they have lost
                if (player1.getDeckSize() <= 0) {
                    System.out.println("P1 Loser");
                }
                if (player2.getDeckSize() <= 0) {
                    System.out.println("P2 Loser");
                }
            }
            //catch error if index goes out of bounds when war happens at 3 cards
        }catch(Exception IndexOutOfBoundsException){
            if(player1.getDeckSize() <= 0){
                //declare loser if they war to end the game
                System.out.println("P1 has run out of cards for a war");
                System.out.println("P2 has won the war");
                System.out.println("P1: 0");
                System.out.println("P2: 52");
                System.out.println("P1 Loser");
            } else if(player2.getDeckSize() <= 0){
                //declare loser if they war to end the game
                System.out.println("P2 has run out of cards for a war");
                System.out.println("P1 has own the war");
                System.out.println("P1: 0");
                System.out.println("P2: 52");
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