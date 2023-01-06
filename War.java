
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    Deck deck;
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();
        Deck[] twoDecks = deck.dealDeck();
        Deck plA = twoDecks[1];
        Deck plB = twoDecks[0];

        // ...then run the event loop
        this.runEventLoop(plA, plB);
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(Deck plA, Deck plB) {
        Card A;
        Card B;
        System.out.println("War:");
        System.out.println("");
        int turn = 1;
        Deck storage = new Deck();
        while (plA.getDeckSize() > 0 && plA.getDeckSize() > 0 && turn <= 300) {
                System.out.println("It is turn " + turn + ".");
                 System.out.println("Player A has " + plA.getDeckSize() + 
                " and player B has " + plB.getDeckSize() + " cards left.");
                A = plA.dealCardFromDeck();
                B = plB.dealCardFromDeck();
                if (plA.getDeckSize() > 0) {
                    System.out.println("Player A drew a " + A.getFace() + " of " +  
                    A.getSuit());
                }
                else {
                    System.out.println("Player B wins!");
                    break;
                }
                if (plB.getDeckSize() > 0) {
                    System.out.println("and player B drew a " + B.getFace() + " of " +  
                    B.getSuit());
                }
                else {
                    System.out.println("Player A wins!");
                    break;
                }
                turnWinner(plA, plB, A, B, storage);
                turn++;
                System.out.println("");
            
        }
        if (plA.getDeckSize() > plB.getDeckSize()) {
          System.out.print("Player A wins!");
         }
        else {
          System.out.print("Player B wins!");
        }
        
    }
    public void war(Deck plA, Deck plB, Card A, Card B, Deck storage) {
        if (plA.getDeckSize() >= 4 && plB.getDeckSize() >= 4) {
            System.out.println("A and B both drew the same card! time for war.");
            storage.addCardToDeck(A);
            storage.addCardToDeck(B);
            for (int i = 0; i < 3; i++) {
                storage.addCardToDeck(plA.dealCardFromDeck());
            }
            for (int i = 0; i < 3; i++) {
                storage.addCardToDeck(plB.dealCardFromDeck());
            }
            Card A2 = plA.dealCardFromDeck();
            Card B2 = plB.dealCardFromDeck();
            System.out.println("Player A drew a " + A2.getFace() + " of " +  
            A2.getSuit());
            System.out.println("and Player B drew a " + B2.getFace() + " of " + 
            B2.getSuit());
            turnWinner(plA, plB, A2, B2, storage);
        }
      else if (plA.getDeckSize() > plB.getDeckSize()) {
          System.out.print("Player A wins!");
      }
      else {
          System.out.print("Player B wins!");
      }
    }
    public void turnWinner (Deck plA, Deck plB, Card A, Card B, Deck storage) {
        if (A.getRank() == B.getRank()) {
                    war(plA, plB, A, B, storage);
        }
        else if (A.getRank() > B.getRank()) {
            System.out.println("A's card is higher than B's card, so A wins");
            plA.addCardToDeck(A);
            plA.addCardToDeck(B);
            while (storage.getDeckSize() > 0) {
                plA.addCardToDeck(storage.dealCardFromDeck());
            }
        }
        else {
            System.out.println("B's card is higher than A's card, so B wins");
            plB.addCardToDeck(A);
            plB.addCardToDeck(B);
            while (storage.getDeckSize() > 0) {
                plB.addCardToDeck(storage.dealCardFromDeck());
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
