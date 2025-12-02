import java.util.Scanner;
/**
 * Used to play the High Card game
 * @author Kumail
 * @version 1.0
 */
public class ExampleClass {	
    /**
     * Starts the High Card game
     * @param args unused
     * @throws IllegalStateException if theres not enough cards in deck or any player has no cards
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        System.out.print("Enter Player 1 name: ");
        String name1 = sc.nextLine();
        System.out.print("Enter Player 2 name: ");
        String name2 = sc.nextLine();

        //custom method to make sure a positive integer is given for the players age
        int age1 = readPositiveInt(sc, "Enter " + name1 + "'s age: ");
        int age2 = readPositiveInt(sc, "Enter " + name2 + "'s age: ");
        Player p1 = new Player(name1, age1);
        Player p2 = new Player(name2, age2);

        DiscardPile table = new DiscardPile();  //empty discard pile

        //Give the players 5 cards but check before to see if theres enough cards
        if (deck.size() < 10) {
            throw new IllegalStateException("Not enough cards for each player");
        }
        for (int i = 0; i<5; i++) {
            p1.draw(deck);
            p2.draw(deck);
        }

        int score1 = 0;
        int score2 = 0;

        for (int round = 1; round <= 5; round++) {  //if player 1 draws the higher card 
            Card[] high1 = p1.getHand();
            if (high1.length ==0) {
                throw new IllegalStateException("Player 1 has no cards");
            }
            int maxIdx1 = 0;  //we assume index 0 is the highest right now
            for (int i = 1; i<high1.length; i++) {
                if (high1[i].getValue() >high1[maxIdx1].getValue()) {
                    maxIdx1=i;         //update what the highest card is
                }
            }
            Card card1 = high1[maxIdx1];       //uses the index and gets the card
            p1.discardCard(card1, table);

            //if player 2 draws the higher card
            Card[] high2 = p2.getHand();
            if (high2.length ==0) {
                throw new IllegalStateException("Player 2 has no cards");
            }
            int maxIdx2 = 0;
            for (int i = 1; i<high2.length; i++) {
                if (high2[i].getValue() >high2[maxIdx2].getValue()) {
                    maxIdx2=i;
                }
            }
            Card card2 = high2[maxIdx2];
            p2.discardCard(card2, table);
//check which card is higher each round
            if (card1.getValue() > card2.getValue()) {
                score1++;
                System.out.println("Round " + round + ": " + p1.getName() + " gets a point. (" +card1+ " vs " + card2 + ")");
            }
            else if (card2.getValue() > card1.getValue()) {
                score2++;
                System.out.println("Round " + round + ": " + p2.getName() + " gets a point. ("+ card2+ " vs " + card1 + ") ");
            }
            else {
                System.out.println("Round " + round + " was a tie.");
            }

        }
        System.out.println("Final score: " + p1.getName() + ": " + score1 + ", " + p2.getName() + ": " + score2 + ".");
        if (score1 > score2) {
            System.out.println("The winner is " + p1.getName() + " with " + score1 + " points.");
        }
        else if (score2 > score1) {
            System.out.print("The winner is " + p2.getName() + " with "+score2+ " points.");       
        }
        else {
            System.out.println("It was a tie.");
        }
        sc.close();
    }
    /**
     * Looks at the inputted age and checks if it's a positive integer
     * @param sc the scanner
     * @param input the user's age input
     * @return the positive integer
     */
    private static int readPositiveInt(Scanner sc, String input) {
        while (true) {
            System.out.print(input);
            String line = sc.nextLine();
            try {
                int num = Integer.parseInt(line);
                if (num < 0) {
                    System.out.println("Age can't be negative. Try again: ");
                    continue;
                }
                return num;
            } 
            catch (NumberFormatException e) {
                System.out.println("Enter a whole number");
            }
        }
    }
}