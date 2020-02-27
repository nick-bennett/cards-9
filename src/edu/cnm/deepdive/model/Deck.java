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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Encapsulates a single deck of standard playing cards, which can be shuffled, dealt one card at a
 * time, and reshuffled (automatically gathering all previously dealt cards back into the deck).
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public class Deck implements Comparator<Card> {

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
    gather();
    Collections.shuffle(cards, rng);
  }

  private void gather() {
    cards.addAll(dealt);
    dealt.clear();
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

  public void sort(boolean gather) {
    if (gather) {
      gather();
    }
    cards.sort(this);
  }

  @Override
  public int compare(Card card1, Card card2) {
    return Comparator.comparing(Card::getSuit).thenComparing(Card::getRank).compare(card1, card2);
  }

}
