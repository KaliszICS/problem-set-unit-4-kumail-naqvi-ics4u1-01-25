import java.util.ArrayList;
import java.util.Objects;
/** 
* A single playing card with the name, suit and value
* @author Kumail
* @version 1.0
*/
class Card{
    private final String name;
    private final String suit;
    private final int value;

    /** 
    * Creates a card with the name, suit and value
    * @param name the rank of the card
    * @param suit the suit, category of the card
    * @param value the numeric value for comparisons
    * @throws IllegalArgumentException if name or suit is empty or if value less than one
    */
    public Card(String name, String suit, int value) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Card name can't be empty");
        }
        if (suit ==null || suit.isEmpty() || suit.isBlank()) {
            throw new IllegalArgumentException("The suit can't be empty");
        }
        if (value < 1) {
            throw new IllegalArgumentException("Value must be greater than one");
        }
        this.name = name;
        this.suit = suit;
        this.value = value;
    }
    /**
    * @return the name, suit and value
    */
    public String getName() {
        return name;
    }
    public String getSuit() {
        return suit;
    }
    public int getValue() {
        return value;
    }

    /**
    * @return the card as "name" of "suit"
    */
    @Override public String toString() {
        return name + " of " + suit;
    }
    /**
    * Cards are equal if the name, suit, and value match
    */
    @Override public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Card)){
            return false;
        }

        Card c = (Card) other;
        return value == c.value
                && Objects.equals(name, c.name)
                && Objects.equals(suit, c.suit);
    }

    @Override public int hashCode() {
        return Objects.hash(name, suit, value);
    }
}

//top of deck is the end of the list
class Deck {
    private final ArrayList<Card> cards = new ArrayList<>();

    /**
    * Builds a deck of cards from the existing array
    * @param initial starting set of cards
    * @throws IllegalArgumentException if 
    */
    public Deck(Card[] initial) {
        if (initial != null) {
            for (int i = 0; i<initial.length; i++) {
                if (initial[i] == null) {
                    throw new IllegalArgumentException("Initial deck has null at index" + i);
                }
                cards.add(initial[i]);
            }
        }
    }
    /**
    * Makes an unshuffled deck of cards
    * Makes cards for each suit
    */
    public Deck(){
        String[] suitOrder = {"Hearts", "Clubs", "Diamonds", "Spades"}; //unshuffled deck suit order
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        for (int s =0; s<suitOrder.length; s++ ) {
            for (int n = 0; n<names.length; n++) {
                cards.add(new Card(names[n], suitOrder[s], values[n]));
            }
        }  
    }
    /**
    * Adds cards if not null
    * @param card the card being added
    * @throws IllegalArgumentException if card given is null
    */
    public void addCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Can't add a null card to the deck");
        }
        cards.add(card);
    }
    /**
    * Draws the top card of the deck
    * @return drawn card
    * @return amount of cards in deck
    */
   //null if no cards left
    public Card draw(){
        if (cards.isEmpty()) {
        return null;
        }
        return cards.remove(cards.size() - 1);
    }
    public int size() {
        return cards.size();
    }
    /**
    *Shuffles the order of the deck
    */
    public void shuffle() {
        for (int i = cards.size()-1; i  > 0; i--) {
            int j = (int) (Math.random() * (i+1));
            Card temp = cards.get(i);
            cards.set(i , cards.get(j));
            cards.set(j, temp);
        }
    }
    /**
    * Adds the given cards into the deck and then reshuffles
    * @param moreCards the extra cards
    * @throws IllegalArgumentException if extra cards are null
    */
    public void reshuffle(Card[] moreCards) {
        if (moreCards == null) {
            throw new IllegalArgumentException("Extra cards being put into the deck can't be null");
        }
        for (int i = 0; i<moreCards.length; i++) {
             if (moreCards[i] == null) {
                throw new IllegalArgumentException("Extra cards has null at index"+i);
            }
            cards.add(moreCards[i]);
        }
        shuffle();
    }
}

/**
* Discarded pile of cards
*/
//end of the list is the top of the pile
class DiscardPile {
    private final ArrayList<Card> pile = new ArrayList<>();
    
    /**
    * Creates an empty discard pile
    */
    DiscardPile() { }

    /**
    * Creates a discard pile from the exitsing array
    * @param arr cards to start with
    * @throws IllegalArgumentException if the starting cards from the array are null
    */
    DiscardPile(Card[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Starting cards in discard pile can't be null");
        }
        for (int i = 0; i <arr.length; i++) {
            if (arr[i]  == null) {
                throw new IllegalArgumentException("Starting cards in discard pile have null at index" + i);
            }
            pile.add(arr[i]);
        }
    }

    /**
    * @return the copy of the discard pile
    * @return the size of the pile
    */
    Card[] getAll() {
        return pile.toArray(new Card[0]);
    }
    int size(){
        return pile.size();
    }

    /**
    * Adds the new cards into the discard pile
    * @param card the cards being added
    * @throws IllegalArgumentException if the cards are null
    */
    void addCard(Card card) {
        if (card==null) {
            throw new IllegalArgumentException("Can't add null to the discard pile");
        }
        pile.add(card);
    }
    /**
    * Removes a card and returns it from the discard pile
    * @param card the removed card
    * @return the removed card
    * @throws IllegalArgumentException if removed card is null
    */
    Card removeCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("removed card can't be null");
        }
        for (int i =0; i < pile.size(); i++) {
            if (pile.get(i).equals(card)) {
                return pile.remove(i);
            }
        }
        return null;
    }
    /**
    * Empties the discard pile
    * @return all the cards inside as an array
    */
    Card[] removeAll() {
        Card[] out = pile.toArray(new Card[0]);
        pile.clear();
        return out;
    }

    /**
    * Returns all cards in a certain format
    */
   //in the format of "Ace of hearts, King of Hearts, Queen of Hearts, Jack of Hearts, 9 of Spades"
    @Override public String toString() {
        if (pile.isEmpty()) {
            return "";           
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pile.size(); i++) {
            sb.append(pile.get(i).toString());
            if (i < pile.size() -1) {
                    sb.append(" , ");
            }
        }
        sb.append('.');
        return sb.toString();
    }
}

/**
* A player with a name, age, and a hand of cards
*/
class Player {
    private final String name;
    private final int age;
    private final ArrayList<Card> hand = new ArrayList<>();
    /**
     * Creates a player with that name, age and hand of cards
     * @param name player's name
     * @param age the player's age
     * @param startingHand the player's starting hand of cards
     * @throws IllegalArgumentException if player's name or starting hand is empty or if their age is negative
     */
    Player(String name, int age, Card[] startingHand) {
        if(name==null || name.isBlank()) {
            throw new IllegalArgumentException("Your name can't be empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Your age can't be less than zero");
        }
        if (startingHand == null) {
            throw new IllegalArgumentException("Starting hand can't be empty/null");
        }

        this.name = name;
        this.age = age;
        if (startingHand != null) {
            for (int i = 0; i<startingHand.length; i++) {
                if (startingHand[i] == null) {
                    throw new IllegalArgumentException("the starting hand has null at index" + i);
                }
            hand.add(startingHand[i]);
            }
        }
    }
    /**
     * Creates a player with that name and age but no starting hand
     * @param name player's name
     * @param age player's age
     * @throws IllegalArgumentException if player's name is empty or their age is negative
     */
    Player (String name, int age) {
        if(name==null || name.isBlank()) {
            throw new IllegalArgumentException("Your name can't be empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Your age can't be less than zero");
        }
        this.name = name;
        this.age = age;
    }
    /**
     * @return the player's name
     * @return the player's age
     * @return copy of the player's hand of cards
     */
    String getName() {
        return name;
    }
    int getAge() {
        return age;
    }
    Card[] getHand() {
        return hand.toArray(new Card[0]);
    }

    int size() {
        return hand.size();
    }
    
    /**
     * Takes a card from the deck to the hand
     * @param deck the deck being drawn from
     * @throws IllegalArgumentException if the deck being drawn from is null
     * @throws IllegalStateException if the deck being called on is empty
     */
    void draw(Deck deck) {
        if (deck ==null) {
            throw new IllegalArgumentException("Deck being drawn from is null");
        }
        Card c = deck.draw();
        if (c ==null) {
            throw new IllegalStateException("Can't draw as the deck is empty");  
        } 
        hand.add(c);
    }
    /**
     * Discards a card from the hand
     * Goes into the discard pile
     * @param card the chosen card
     * @param discardPile the discard pile
     * @throws IllegalArgumentException if chosen card or discardPile is null
     */
    void discardCard(Card card, DiscardPile discardPile) {
        if (card == null) {
            throw new IllegalArgumentException("chosen card from hand to discard can't be null");
        }
        if (discardPile ==null) {
            throw new IllegalArgumentException("the discard pile can't be null");
        }
        for (int i = 0; i<hand.size(); i++) {
            if (hand.get(i).equals(card)) {
                Card removed = hand.remove(i);
                discardPile.addCard(removed);
                return;
            }
        }
    }
    /**
     * Takes the card from the hand to the deck
     * @param card the chosen card
     * @param deck the deck
     * @return true if the card was there and returned
     * @throws IllegalArgumentException if chosen card or deck is null
     */
    //if not true, then returns false
    boolean returnCard(Card card, Deck deck) {
        if (card == null) {
            throw new IllegalArgumentException("The chosen card from hand to deck can't be null");
        }
        if (deck == null) {
            throw new IllegalArgumentException("The deck the card is going to can't be null");
        }
        for (int i =0; i< hand.size(); i++) {
            if (hand.get(i).equals(card)) {
                Card removed = hand.remove(i);
                deck.addCard(removed);
                return true;
            }
        }
        return false;
    }
    /**
     * Finds and removes the highest value card from player's hand
     * @return the highest value card
     * @throws IllegalStateException if hand if empty
     */
    Card highCardGameHelper() {
        if (hand.isEmpty()) {
            throw new IllegalStateException("Your hand is empty");
        }
        int bestIdx = 0;       //assume the index 0 is highest right now
        int val = hand.get(0).getValue();
        for (int i = 1; i < hand.size(); i++) {
            int v = hand.get(i).getValue();
            if (v > val) {
                val = v;
                bestIdx = i;
            }
        }
        return hand.remove(bestIdx);
    }
    
    /**
     * Prints out the player's name, age, and hand
     */
    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" , ").append(age);
        if (hand.isEmpty()) {
            sb.append('.'); //if the hand is empty then it just ends with a period
            return sb.toString();
        }
        sb.append(" , ");
        for (int i = 0; i< hand.size(); i++) {
            sb.append(hand.get(i));  //uses Card.toString() for this
            if (i < hand.size() -1) {
                sb.append(" , ");
            }
        }
        sb.append('.');
        return sb.toString();
    }
}