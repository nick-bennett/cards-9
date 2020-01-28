package edu.cnm.deepdive.model;

import java.util.Objects;

/**
 * Encapsulates a single playing card as a combination of {@link Suit} and {@link Rank}. Instances
 * of this class are immutable.
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public class Card {

  private final Suit suit;
  private final Rank rank;
  private final int hash;

  /**
   * Initializes this {@code Card} instance with the specified {@link Suit} and {@link Rank}.
   *
   * @param suit {@link Suit} value of card.
   * @param rank {@link Rank} value of card.
   */
  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
    hash = Objects.hash(suit, rank);
  }

  /**
   * Returns {@link Suit} of this {@code Card} instance.
   */
  public Suit getSuit() {
    return suit;
  }

  /**
   * Returns {@link Rank} of this {@code Card} instance.
   */
  public Rank getRank() {
    return rank;
  }

  /**
   * Concatenates and returns the values returned by {@link #getRank()}{@link Rank#symbol()
   * symbol()} and {@link #getSuit()}{@link Suit#symbol() symbol()}.
   *
   * @return concatenated {@link Rank} &amp; {@link Suit} symbols.
   */
  @Override
  public String toString() {
    return rank.symbol() + suit.symbol();
  }

  @Override
  public int hashCode() {
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    boolean comparison = false;
    if (obj == this) {
      comparison = true;
    } else if (obj instanceof Card) {
      Card other = (Card) obj;
      if (hash == other.hash && suit == other.suit && rank == other.rank) {
        comparison = true;
      }
    }
    return comparison;
  }
  
}
