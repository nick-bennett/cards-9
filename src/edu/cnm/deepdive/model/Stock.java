/*
 *  Copyright 2020 Deep Dive Coding/CNM Ingenuity, Inc.
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
 */package edu.cnm.deepdive.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Extends {@link Pile} to add functionality to draw from the ordered collection of cards. {@link
 * Card} instances drawn are maintained in a separate list that can be gathered back into the
 * original collection. This is intended to be used as a base class for decks, shoes, drawable
 * discard piles, etc.
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public abstract class Stock extends Pile {

  private final List<Card> drawn;

  /**
   * Initializes this instance with an empty collection of drawn cards.
   */
  protected Stock() {
    drawn = new LinkedList<>();
  }

  /**
   * Removes and returns a single {@link Card} from the deck. If there are no more cards to be
   * drawn, a {@code null} value is returned. Any card drawn is also added to a list of drawn cards,
   * which can be gathered back into the deck using the {@link #gather()} method.
   *
   * @return first (top) top {@link Card} instance in stockpile; null if the stockpile is empty.
   */
  public Card draw() {
    Card card = remove();
    if (card != null) {
      drawn.add(card);
    }
    return card;
  }

  /**
   * Returns a reference to the collection of {@link Card} instances drawn from this stock since
   * instantiation or the most recent invocation of {@link #gather()}.
   */
  protected List<Card> getDrawn() {
    return drawn;
  }

  /**
   * Returns all cards previously drawn to the stockpile. Note that this will not return the cards
   * their originally order (unless all of the cards have been drawn); instead, the gathered cards
   * will be after (beneath) those that were not already drawn.
   */
  protected void gather() {
    addAll(drawn);
    drawn.clear();
  }

}
