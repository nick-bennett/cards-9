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
package edu.cnm.deepdive.controller;

import edu.cnm.deepdive.model.Card;
import edu.cnm.deepdive.model.Deck;
import edu.cnm.deepdive.model.Suit.Color;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Implements a simple card trick that illustrates a mathematical invariant property of certain
 * predicate operations performed on finite sets.
 *
 * <p>Given a finite set <em><strong>S</strong></em>, with even cardinality, and a predicate
 * operator <em><strong>P</strong></em>, which is true for exactly half of the elements of
 * <em><strong>S</strong></em>, perform the following operations:</p>
 * <ul>
 *   <li><p>Define sets <em><strong>T</strong></em> and <em><strong>U</strong></em>, initially
 *   empty.</p></li>
 *   <li>
 *     <p>While any elements remain in <em><strong>S</strong></em></p>
 *     <ul>
 *       <li><p>Select (whether at random or not is immaterial) and remove 2 elements from
 *       <em><strong>U</strong></em>, <em>e</em><sub>1</sub> and <em>e</em><sub>2</sub>.</p></li>
 *       <li>
 *         <p>If <em><strong>P</strong></em>(<em>e</em><sub>1</sub>) is true,</p>
 *         <ul>
 *           <li><p>add <em>e<sub>2</sub></em> to <em><strong>T</strong></em>;</p></li>
 *         </ul>
 *         <p>otherwise,</p>
 *         <ul>
 *           <li><p>add <em>e<sub>2</sub></em> to <em><strong>U</strong></em>.</p></li>
 *         </ul>
 *       </li>
 *     </ul>
 *   </li>
 *   <li>
 *     <p>Exchange <em>n</em> elements (again, randomly chosen or not) between
 *     <em><strong>T</strong></em> and <em><strong>U</strong></em>, where 0 &le; <em>n</em> &le;
 *     |<em><strong>T</strong></em>|, <em>n</em> &le; |<em><strong>U</strong></em>|. This exchange
 *     is simultaneous (conceptually, at least), so that no elements that
 *     <em><strong>U</strong></em> receives from <em><strong>T</strong></em> might be passed back to
 *     <em><strong>T</strong></em> in the exchange.</p>
 *   </li>
 *   <li><p>Now, apply <em><strong>P</strong></em> to <em><strong>T</strong></em> and
 *   <em><strong>U</strong></em>. It will be seen that, regardless of the order in which the
 *   elements of <em><strong>S</strong></em> were drawn, and regardless of the value of <em>n</em>,
 *   the cardinality of {<em>e</em> \u2208 <em><strong>T</strong></em> |
 *   <em><strong>P</strong></em>(<em>e</em>)} is equal to the cardinality of {<em>e</em> \u2208
 *   <em><strong>U</strong></em> | \u00ac<em><strong>P</strong></em>(<em>e</em>)}.</p></li>
 * </ul>
 * <p>In the card trick illustrating the above, a deck of cards (with an equal number of red and
 * black cards) is shuffled and dealt, by pairs, into 3 piles&mdash;a discard pile, a "red" pile,
 * and a "black" pile: The first card of each pair is discarded, after its color is used to place
 * the second card of the pair into the red or black pile. Note that the color of the second card is
 * not examined, and won't necessarily be the same as the color associated with the pile in which it
 * is placed. After all cards are dealt in this fashion, half of the cards will have been discarded,
 * and the remaining half will be split between the red and black piles. Some number of cards is
 * then swapped between the two piles, and the resulting pile contents&mdash;along with the count of
 * actual red cards in the red pile, and actual black cards in the black pile&mdash;are displayed.
 * </p>
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public class Trick {

  private Deck deck;
  private List<Card> redPile;
  private List<Card> blackPile;
  private Random rng = new SecureRandom();

  /**
   * Creates an instance of {@link Deck}, shuffles it, and then executes the card trick described
   * above. On completion, the contents of each of the 2 piles is displayed, along with the count of
   * actual red cards in the red pile, and the count of actual black cards in the black pile.
   *
   * @param args command line arguments (ignored).
   */
  public static void main(String[] args) {
    Trick trick = new Trick();
    trick.prepare();
    trick.split();
    trick.swap();
    trick.report();
  }

  private void prepare() {
    deck = new Deck();
    deck.shuffle(rng);
  }

  private void split() {
    redPile = new LinkedList<>();
    blackPile = new LinkedList<>();
    for (Card selector = deck.deal(); selector != null; selector = deck.deal()) {
      if (selector.getSuit().color() == Color.BLACK) {
        blackPile.add(deck.deal());
      } else {
        redPile.add(deck.deal());
      }
    }
  }

  private void swap() {
    int swapSize = rng.nextInt(1 + Math.min(blackPile.size(), redPile.size()));
    for (int i = 0; i < swapSize; i++) {
      redPile.add(blackPile.remove(0));
      blackPile.add(redPile.remove(0));
    }
  }

  private void report() {
    int redCount = 0;
    int blackCount = 0;
    for (Card c : redPile) {
      if (c.getSuit().color() == Color.RED) {
        redCount++;
      }
    }
    for (Card c : blackPile) {
      if (c.getSuit().color() == Color.BLACK) {
        blackCount++;
      }
    }
    System.out.printf("Red pile: %s. Red count: %d.%n", redPile, redCount);
    System.out.printf("Black pile: %s. Black count: %d.%n", blackPile, blackCount);
  }

}
