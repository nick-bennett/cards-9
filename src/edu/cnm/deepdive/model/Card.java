package edu.cnm.deepdive.model;

import java.util.Objects;

public class Card {

  private final Suit suit;
  private final Rank rank;
  private final int hash;

  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
    hash = Objects.hash(suit, rank);
  }

  public Suit getSuit() {
    return suit;
  }

  public Rank getRank() {
    return rank;
  }

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
