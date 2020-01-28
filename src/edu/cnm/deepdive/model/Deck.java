package edu.cnm.deepdive.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Encapsulates a single deck of standard playing cards, which can be shuffled, dealt one card at a
 * time, and reshuffled (automatically gathering all previously dealt cards back into the deck).
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public class Deck {

  private List<Card> cards;
  private List<Card> dealt;

  /**
   * Initializes this instance with 52 cards, sorted by suit and rank.
   */
  public Deck() {
    cards = new ArrayList<>();
    dealt = new LinkedList<>();
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        cards.add(new Card(s, r));
      }
    }
  }

  /**
   * Removes and returns a single {@link Card} from the deck. If there are no more cards to be
   * dealt, a {@code null} value is returned.
   *
   * @return top {@link Card} instance on deck.
   */
  public Card deal() {
    Card card = cards.isEmpty() ? null : cards.remove(0);
    if (card != null) {
      dealt.add(card);
    }
    return card;
  }

  /**
   * Shuffles the deck contents (after returning any previously dealt cards to the deck) using the
   * specified source of randomness.
   *
   * @param rng {@link Random} instance, used as source of randomness for shuffle.
   */
  public void shuffle(Random rng) {
    cards.addAll(dealt);
    dealt.clear();
    Collections.shuffle(cards, rng);
  }

  /**
   * Returns the number of {@link Card} instances remaining to be dealt.
   */
  public int remaining() {
    return cards.size();
  }

  /**
   * Returns the number of {@link Card} instances that have been dealt since the last shuffle (or
   * since instance initialization).
   */
  public int dealt() {
    return dealt.size();
  }

  @Override
  public String toString() {
    return cards.toString();
  }

}
