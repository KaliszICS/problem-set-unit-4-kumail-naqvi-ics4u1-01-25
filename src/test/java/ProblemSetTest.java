//I tested multiple different types of tests thats why it is very long

// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.*;
// import java.util.Arrays;

// public class ProblemSetTest {

//     @Test
//     void card_getters_equals_toString() {
//         Card a = new Card("Queen", "Diamonds", 12);
//         Card b = new Card("Queen", "Diamonds", 12);
//         Card c = new Card("Jack", "Diamonds", 11);

//         assertEquals("Queen", a.getName());
//         assertEquals("Diamonds", a.getSuit());
//         assertEquals(12, a.getValue());

//         assertEquals("Queen of Diamonds", a.toString());
//         assertEquals(a, b);
//         assertNotEquals(a, c);
//     }

//     @Test
//     void deck_unshuffled_has_52_and_known_ends() {
//         Deck deck = new Deck();
//         assertEquals(52, deck.size());

//         Card top = deck.draw();
//         assertNotNull(top);
//         assertEquals("King", top.getName());
//         assertEquals("Spades", top.getSuit());
//         assertEquals(13, top.getValue());
//         assertEquals(51, deck.size());
//     }

//     @Test
//     void deck_draws_down_to_null() {
//         Deck deck = new Deck();
//         int count = 0;
//         while (deck.draw() != null) count++;
//         assertEquals(52, count);
//         assertEquals(0, deck.size());
//         assertNull(deck.draw()); // now empty
//     }

//  @Test
// void deck_addCard_and_reshuffle_increase_size() {
//     Deck deck = new Deck();
//     // draw down a bit
//     deck.draw(); deck.draw(); deck.draw();
//     int afterDraw = deck.size();
//     deck.addCard(new Card("Ace", "Hearts", 1));
//     assertEquals(afterDraw + 1, deck.size());

//     Card[] extras = {
//         new Card("Extra1", "Hearts", 2),
//         new Card("Extra2", "Clubs", 3)
//     };
//     deck.reshuffle(extras);
//     assertEquals(afterDraw + 3, deck.size());
// }

//     @Test
//     void deck_shuffle_changes_order_likely() {
//         Deck deck1 = new Deck();
//         Deck deck2 = new Deck();

//         Card[] first5_noShuffle = new Card[5];
//         for (int i = 0; i < 5; i++) {
//             first5_noShuffle[i] = deck1.draw();
//         }

//         deck2.shuffle();
//         Card[] first5_afterShuffle = new Card[5];
//         for (int i = 0; i < 5; i++) {
//             first5_afterShuffle[i] = deck2.draw();
//         }
//         if (Arrays.equals(first5_noShuffle, first5_afterShuffle)) {
//             Deck deck3 = new Deck();
//             deck3.shuffle();
//             for (int i = 0; i < 5; i++) {
//                 first5_afterShuffle[i] = deck3.draw();
//             }
//         }

//         assertFalse(Arrays.equals(first5_noShuffle, first5_afterShuffle),
//                 "Shuffle should change order (rarely can fail by chance).");
//     }

//     @Test
//     void discardPile_add_remove_removeAll_toString() {
//         Card a = new Card("Ace", "Hearts", 1);
//         Card b = new Card("10", "Spades", 10);
//         Card c = new Card("Jack", "Clubs", 11);

//         DiscardPile pile = new DiscardPile(new Card[] { a });
//         assertEquals(1, pile.size());
//         pile.addCard(b);
//         pile.addCard(c);
//         assertEquals(3, pile.size());

//         // toString format: "<card1> , <card2> , <card3>."
//         String s = pile.toString();
//         assertTrue(s.contains("Ace of Hearts"));
//         assertTrue(s.endsWith("."));

//         // Remove a specific card
//         Card removed = pile.removeCard(b);
//         assertEquals(b, removed);
//         assertEquals(2, pile.size());

//         // removeAll empties and returns all
//         Card[] all = pile.removeAll();
//         assertEquals(2, all.length);
//         assertEquals(0, pile.size());
//     }

//     @Test
//     void discardPile_empty_constructor_and_getAll() {
//         DiscardPile pile = new DiscardPile();
//         assertEquals(0, pile.size());
//         assertEquals(0, pile.getAll().length);
//         assertEquals("", pile.toString());
//     }

//     @Test
//     void player_getters_toString_empty_and_with_cards() {
//         Player p = new Player("Alex", 20);
//         assertEquals("Alex", p.getName());
//         assertEquals(20, p.getAge());
//         assertEquals(0, p.getHand().length);
//         assertTrue(p.toString().endsWith("."));
//         Card[] start = { new Card("2", "Clubs", 2), new Card("8", "Diamonds", 8) };
//         Player q = new Player("Sam", 19, start);
//         assertEquals(2, q.size());
//         String qs = q.toString();
//         assertTrue(qs.contains("Sam"));
//         assertTrue(qs.contains("19"));
//         assertTrue(qs.contains("2 of Clubs"));
//         assertTrue(qs.contains("8 of Diamonds"));
//         assertTrue(qs.endsWith("."));
//     }

//     @Test
//     void player_draw_discard_return() {
//         Deck deck = new Deck();
//         deck.shuffle();
//         Player p = new Player("A", 18);

//         // draw 2 cards
//         p.draw(deck);
//         p.draw(deck);
//         assertEquals(2, p.size());

//         Card[] hand = p.getHand();
//         Card first = hand[0];

//         // discard one to pile
//         DiscardPile pile = new DiscardPile();
//         p.discardCard(first, pile);
//         assertEquals(1, p.size());
//         assertEquals(1, pile.size());
//         Card[] remaining = p.getHand();
//         Card stillInHand = remaining[0];
//         boolean ok = p.returnCard(stillInHand, deck);
//         assertTrue(ok);
//         assertEquals(0, p.size());
//         assertEquals(deck.size(), 52 - 2 + 1);
//     }

//     @Test
//     void option3_invalid_card_throws() {
//         assertThrows(IllegalArgumentException.class, () -> new Card("", "Hearts", 1));
//         assertThrows(IllegalArgumentException.class, () -> new Card("Ace", "", 1));
//         assertThrows(IllegalArgumentException.class, () -> new Card("Ace", "Hearts", -5));
//     }

//     @Test
//     void option3_player_name_age_checks() {
//         assertThrows(IllegalArgumentException.class, () -> new Player("", 10));
//         assertThrows(IllegalArgumentException.class, () -> new Player("Lex", -1));
//     }

//     @Test
//     void option3_deck_inputs_checks() {
//         Deck d = new Deck();
//         assertThrows(IllegalArgumentException.class, ( -> ));
//     }

// }
               //different tests

// import static org.junit.jupiter.api.Assertions.*;   
// import org.junit.jupiter.api.*;            

// import java.util.*;      
// public class ProblemSetTest{ 
// @Test void card_rejects_bad_inputs() {
//   assertThrows(IllegalArgumentException.class, () -> new Card(null, "Hearts", 1));
//   assertThrows(IllegalArgumentException.class, () -> new Card("Ace", null, 1));
//   assertThrows(IllegalArgumentException.class, () -> new Card("", "Hearts", 1));
//   assertThrows(IllegalArgumentException.class, () -> new Card("Ace", " ", 1));
//   assertThrows(IllegalArgumentException.class, () -> new Card("Ace", "Hearts", 0));
// }

// @Test void card_equals_hash_toString() {
//   Card a1 = new Card("Ace","Hearts",1);
//   Card a2 = new Card("Ace","Hearts",1);
//   Card qH = new Card("Queen","Hearts",12);
//   assertEquals(a1, a2);
//   assertEquals(a1.hashCode(), a2.hashCode());
//   assertNotEquals(a1, qH);
//   assertEquals("Ace of Hearts", a1.toString());
// }

// @Test void deck_ctor_and_top_is_end() {
//   Card c1 = new Card("2","Clubs",2);
//   Card c2 = new Card("3","Clubs",3);
//   Deck d = new Deck(new Card[]{c1, c2});
//   assertEquals(2, d.size());
//   assertSame(c2, d.draw()); // top = end
//   assertSame(c1, d.draw());
//   assertNull(d.draw());
// }

// @Test void deck_rejects_nulls() {
//   assertThrows(IllegalArgumentException.class, () -> new Deck(new Card[]{null}));
//   Deck d = new Deck();
//   assertThrows(IllegalArgumentException.class, () -> d.addCard(null));
//   assertThrows(IllegalArgumentException.class, () -> d.reshuffle(null));
//   assertThrows(IllegalArgumentException.class, () -> d.reshuffle(new Card[]{new Card("Ace","Hearts",1), null}));
// }

// @Test void deck_shuffle_preserves_multiset() {
//   Deck d = new Deck();   
//   int before = d.size();
//   java.util.Map<String,Integer> count = new java.util.HashMap<>();
//   for (int i=0;i<52;i++) {
//     Card c = d.draw();
//     count.merge(c.toString(), 1, Integer::sum);
//   }
//   Deck d2 = new Deck();
//   d2.shuffle();
//   assertEquals(before, d2.size());
//   java.util.Map<String,Integer> afterCount = new java.util.HashMap<>();
//   for (int i=0;i<52;i++) afterCount.merge(d2.draw().toString(), 1, Integer::sum);
//   assertEquals(count, afterCount);
// }

// @Test void discardpile_basics() {
//   DiscardPile p0 = new DiscardPile();
//   assertEquals(0, p0.size());
//   assertArrayEquals(new Card[0], p0.getAll());

//   assertThrows(IllegalArgumentException.class, () -> new DiscardPile((Card[])null));
//   assertThrows(IllegalArgumentException.class, () -> new DiscardPile(new Card[]{new Card("Ace","Hearts",1), null}));

//   DiscardPile p = new DiscardPile();
//   Card a = new Card("Ace","Hearts",1);
//   p.addCard(a);
//   assertEquals(1, p.size());
//   assertThrows(IllegalArgumentException.class, () -> p.addCard(null));

//   Card notThere = new Card("2","Hearts",2);
//   assertNull(p.removeCard(notThere));
//   assertSame(a, p.removeCard(a));
//   assertEquals(0, p.size());

//   p.addCard(new Card("Ace","Hearts",1));
//   p.addCard(new Card("King","Clubs",13));
//   String s = p.toString();
//   assertTrue(s.equals("Ace of Hearts , King of Clubs.") || s.equals("King of Clubs , Ace of Hearts."));
//   Card[] all = p.removeAll();
//   assertEquals(0, p.size());
//   assertEquals(2, all.length);
// }

// @Test void player_ctor_validation_and_hand_copy() {
//   assertThrows(IllegalArgumentException.class, () -> new Player("", 10));
//   assertThrows(IllegalArgumentException.class, () -> new Player("Lex", -1));
//   assertThrows(IllegalArgumentException.class, () -> new Player("Lex", 1, null));
//   assertThrows(IllegalArgumentException.class, () -> new Player("Lex", 1, new Card[]{null}));

//   Player p = new Player("Sam", 20, new Card[]{new Card("3","Hearts",3)});
//   Card[] hand1 = p.getHand();
//   hand1[0] = new Card("King","Spades",13);  // mutate the copy
//   assertNotEquals("King of Spades", p.getHand()[0].toString());
// }

// @Test void player_draw_discard_return_highest() {
//   Deck d = new Deck(new Card[]{
//     new Card("2","H",2), new Card("10","D",10), new Card("7","S",7)
//   });
//   Player p = new Player("Bo", 18);
//   assertThrows(IllegalArgumentException.class, () -> p.draw(null));
//   p.draw(d); 
//   assertEquals(1, p.size());
//   p.draw(d); 
//   assertEquals(2, p.size());
//   p.draw(d);
//   assertEquals(3, p.size());
//   assertThrows(IllegalStateException.class, () -> p.draw(d));
//   Card hi = p.highCardGameHelper();
//   assertEquals(10, hi.getValue());
//   assertEquals(2, p.size());

//   DiscardPile pile = new DiscardPile();
//   assertThrows(IllegalArgumentException.class, () -> p.discardCard(null, pile));
//   assertThrows(IllegalArgumentException.class, () -> p.discardCard(hi, null));
//   // discard a card that is equal-by-value/name/suit but different instance
//   Card sameAsSeven = new Card("7","S",7);
//   p.discardCard(sameAsSeven, pile);
//   assertEquals(1, p.size());
//   assertEquals(1, pile.size());

//   Card remaining = p.getHand()[0];
//   assertThrows(IllegalArgumentException.class, () -> p.returnCard(null, new Deck()));
//   assertThrows(IllegalArgumentException.class, () -> p.returnCard(remaining, null));
//   Deck back = new Deck(new Card[0]);
//   assertTrue(p.returnCard(remaining, back));
//   assertEquals(0, p.size());
//   assertEquals(1, back.size());
//   assertFalse(p.returnCard(remaining, back));
// }
// }

                      // more tests 

// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.*;

// public class ProblemSetTest {

//     @Test
//     void card_rejects_empty_fields_and_low_values() {
//         assertThrows(IllegalArgumentException.class, () -> new Card("", "Hearts", 1));
//         assertThrows(IllegalArgumentException.class, () -> new Card("Ace", "", 1));
//         assertThrows(IllegalArgumentException.class, () -> new Card("Ace", "Hearts", 0));
//     }

//     @Test
//     void card_equals_and_hashcode_match_on_all_fields() {
//         Card a = new Card("Ace", "Hearts", 1);
//         Card b = new Card("Ace", "Hearts", 1);
//         Card c = new Card("Ace", "Spades", 1);
//         assertEquals(a, b);
//         assertNotEquals(a, c);
//         assertEquals(a.hashCode(), b.hashCode());
//     }

//     @Test
//     void card_toString_format() {
//         assertEquals("Queen of Diamonds", new Card("Queen", "Diamonds", 12).toString());
//     }

//     @Test
//     void deck_draw_from_empty_returns_null() {
//         Deck d = new Deck(new Card[0]);
//         assertNull(d.draw());
//         assertEquals(0, d.size());
//     }

//     @Test
//     void deck_unshuffled_constructor_builds_52_cards() {
//         Deck d = new Deck();
//         assertEquals(52, d.size());
//         for (int i = 0; i < 52; i++) {
//             assertNotNull(d.draw());
//         }
//         assertNull(d.draw());
//     }

//     @Test
//     void deck_addCard_and_reshuffle_increase_size_and_validate_inputs() {
//         Deck d = new Deck();
//         d.draw(); d.draw();
//         int afterDraw = d.size();

//         assertThrows(IllegalArgumentException.class, () -> d.addCard(null));

//         d.addCard(new Card("4", "Diamonds", 4));
//         assertEquals(afterDraw + 1, d.size());

//         assertThrows(IllegalArgumentException.class, () -> d.reshuffle(null));

//         Card[] withNull = { new Card("X","Hearts", 2), null };
//         assertThrows(IllegalArgumentException.class, () -> d.reshuffle(withNull));

//         int beforeEmpty = d.size();
//         d.reshuffle(new Card[0]);
//         assertEquals(beforeEmpty, d.size());
//         Card[] extras = {
//                 new Card("Extra1", "Clubs", 3),
//                 new Card("Extra2", "Spades", 4)
//         };
//         int prev = d.size();
//         d.reshuffle(extras);
//         assertEquals(prev + 2, d.size());
//     }

//     @Test
//     void discardPile_constructor_rules_and_size() {
//         DiscardPile p0 = new DiscardPile();
//         assertEquals(0, p0.size());
//         DiscardPile p1 = new DiscardPile(new Card[0]);
//         assertEquals(0, p1.size());
//         assertThrows(IllegalArgumentException.class, () -> new DiscardPile(null));
//     }

//     @Test
//     void discardPile_add_remove_removeAll_and_toString() {
//         DiscardPile p = new DiscardPile();
//         assertThrows(IllegalArgumentException.class, () -> p.addCard(null));

//         Card a = new Card("Ace", "Hearts", 1);
//         Card k = new Card("King", "Hearts", 13);
//         p.addCard(a);
//         p.addCard(k);
//         assertEquals("Ace of Hearts , King of Hearts.", p.toString());
//         assertEquals(2, p.size());
//         Card a2 = new Card("Ace", "Hearts", 1);
//         Card removed = p.removeCard(a2);
//         assertNotNull(removed);
//         assertEquals(1, p.size());
//         assertNull(p.removeCard(new Card("Seven","Spades",7)));
//         Card[] rest = p.removeAll();
//         assertEquals(1, rest.length);
//         assertEquals(0, p.size());

//         assertEquals("", p.toString());
//     }

//     @Test
//     void player_constructor_guards() {
//         assertThrows(IllegalArgumentException.class, () -> new Player("", 10));
//         assertThrows(IllegalArgumentException.class, () -> new Player("Lex", -1));
//         assertThrows(IllegalArgumentException.class, () -> new Player("Lex", 10, null));

//         Card[] badHand = { new Card("2","H",2), null };
//         assertThrows(IllegalArgumentException.class, () -> new Player("Lex", 10, badHand));
//     }

//     @Test
//     void player_draw_discard_return_highest() {
//         Deck d = new Deck(new Card[]{
//                 new Card("2","H",2),
//                 new Card("10","D",10),
//                 new Card("7","S",7)
//         });
//         Player p = new Player("Bo", 18);

//         assertThrows(IllegalArgumentException.class, () -> p.draw(null));

//         p.draw(d); // 7S
//         assertEquals(1, p.size());
//         p.draw(d); // 10D
//         assertEquals(2, p.size());
//         p.draw(d); // 2H
//         assertEquals(3, p.size());

//         assertThrows(IllegalStateException.class, () -> p.draw(d));

//         Card hi = p.highCardGameHelper();
//         assertEquals(10, hi.getValue());
//         assertEquals(2, p.size());

//         DiscardPile pile = new DiscardPile();
//         assertThrows(IllegalArgumentException.class, () -> p.discardCard(null, pile));
//         assertThrows(IllegalArgumentException.class, () -> p.discardCard(hi, null));

//         Card sameAsSeven = new Card("7","S",7);
//         p.discardCard(sameAsSeven, pile);
//         assertEquals(1, p.size());
//         assertEquals(1, pile.size());

//         Card remaining = p.getHand()[0];
//         assertThrows(IllegalArgumentException.class, () -> p.returnCard(null, new Deck()));
//         assertThrows(IllegalArgumentException.class, () -> p.returnCard(remaining, null));

//         Deck back = new Deck();
//         assertTrue(p.returnCard(remaining, back));
//         assertEquals(0, p.size());
//         assertEquals(53, back.size()); // 52 + 1 returned

//         assertFalse(p.returnCard(remaining, back));
//     }

//     @Test
//     void integration_deal_five_each_and_compare_hand_highs() {

//         Deck fixed = new Deck(new Card[]{
//                 // bottom ............................................... top
//                 new Card("2","H",2),  new Card("3","H",3),
//                 new Card("4","H",4),  new Card("5","H",5),
//                 new Card("6","H",6),  new Card("7","H",7),
//                 new Card("8","H",8),  new Card("9","H",9),
//                 new Card("10","H",10), new Card("J","H",11)
//         });
//         Player a = new Player("Alice", 20);
//         Player b = new Player("Bob", 21);
//         for (int i = 0; i < 5; i++) {
//             a.draw(fixed);
//             b.draw(fixed);
//         }
//         assertEquals(0, fixed.size());
//         assertEquals(5, a.size());
//         assertEquals(5, b.size());

//         // A's highest should be J(11), B's highest should be 10
//         Card ah = a.highCardGameHelper();
//         Card bh = b.highCardGameHelper();
//         assertEquals(11, ah.getValue());
//         assertEquals(10, bh.getValue());
//     }
// }
