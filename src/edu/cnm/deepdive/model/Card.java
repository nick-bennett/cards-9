/*
 *  Copyright 2019 Deep Dive Coding/CNM Ingenuity
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.cnm.deepdive.model;

import java.util.Comparator;
import java.util.Objects;

/**
 * Encapsulates a single playing card as a combination of {@link Suit} and {@link Rank}. Instances
 * of this class are immutable.
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public class Card implements Comparable<Card> {

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

  @Override
  public int compareTo(Card other) {
    return Comparator.comparing(Card::getSuit).thenComparing(Card::getRank).compare(this, other);
  }

}
