package edu.cnm.deepdive.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTest {

  static final Object[][] cardData = {
      {Suit.CLUBS, Rank.ACE},
      {Suit.DIAMONDS, Rank.TWO},
      {Suit.HEARTS, Rank.THREE}
  };

  @Test
  void getSuit() {
    for (Object[] testCase : cardData) {
      Card c = new Card((Suit) testCase[0], (Rank) testCase[1]);
      assertEquals(testCase[0], c.getSuit());
    }
  }

  @Test
  void getRank() {
    for (Object[] testCase : cardData) {
      Card c = new Card((Suit) testCase[0], (Rank) testCase[1]);
      assertEquals(testCase[1], c.getRank());
    }
  }

  @Test
  void testHashCode() {
    for (Object[] testCase : cardData) {
      Card c1 = new Card((Suit) testCase[0], (Rank) testCase[1]);
      Card c2 = new Card((Suit) testCase[0], (Rank) testCase[1]);
      assertEquals(c1.hashCode(), c2.hashCode());
    }
  }

  @Test
  void testEquals() {
    Card prev = null;
    for (Object[] testCase : cardData) {
      Card c1 = new Card((Suit) testCase[0], (Rank) testCase[1]);
      Card c2 = new Card((Suit) testCase[0], (Rank) testCase[1]);
      assertEquals(c1, c2);
      assertNotEquals(c1, prev);
      prev = c1;
    }
  }

}