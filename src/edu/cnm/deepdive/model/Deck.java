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
 */
package edu.cnm.deepdive.model;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.Random;

/**
 * Encapsulates a single deck of standard playing cards, which can be shuffled, dealt one card at a
 * time, and reshuffled (optionally gathering all previously dealt cards back into the deck).
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public class Deck extends Stock implements Shuffleable {

  private Random rng;

  /**
   * Initializes this instance with 52 cards, sorted in natural order&mdash;i.e. the order enforced
   * by the {@link Comparable Comparable&lt;Card&gt;} implementation of {@link Card}.
   */
  public Deck() {
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        add(new Card(s, r));
      }
    }
    sort();
  }

  /**
   * Shuffles the deck, after gathering all previousy drawn/dealt cards to the deck. Invoking this
   * method is equivalent to invoking {@link #shuffle(Random) shuffle(getRng())}.
   */
  @Override
  public void shuffle() {
    shuffle(true);
  }

  /**
   * Shuffles the deck, optionally gathering all previously drawn/dealt cards to the deck. Invoking
   * this method is equivalent to invoking {@link #shuffle(Random, boolean)
   * shuffle(getRng(), gather)}.
   *
   * @param gather flag specifying whether previously drawn/dealt cards are returned to the deck
   *               before shuffling.
   */
  public void shuffle(boolean gather) {
    shuffle(getRng(), gather);
  }

  /**
   * Shuffles the deck contents, after gathering any previously dealt cards to the deck, using the
   * specified source of randomness. Invoking this method is equivalent to invoking {@link
   * #shuffle(Random, boolean) shuffle(rng, true)}.
   *
   * @param rng source of randomness for the shuffle.
   */
  @Override
  public void shuffle(Random rng) {
    shuffle(rng, true);
  }

  /**
   * Shuffles the deck contents, optionally gathering any previously dealt cards to the deck, and
   * then using the specified source of randomness.
   *
   * @param rng source of randomness for the shuffle.
   * @param gather flag specifying whether previously drawn/dealt cards are returned to the deck
   *               before shuffling.
   */
  public void shuffle(Random rng, boolean gather) {
    if (gather) {
      gather();
    }
    Collections.shuffle(getCards(), rng);
  }

  /**
   * Sorts the deck in natural order&mdash;that is, according to the order enforced by {@link Card},
   * which implements {@link Comparable Comparable&lt;Card&gt;}. If {@code gather} is{@code true},
   * previously drawn cards back are gathered back into the deck before sorting.
   *
   * @param gather flag specifying whether previously dealt cards should be gathered back into the
   *               deck before sorting.
   */
  public void sort(boolean gather) {
    if (gather) {
      gather();
    }
    Collections.sort(getCards());
  }

  /**
   * Sorts the deck in natural order&mdash;that is, according to the order enforced by {@link Card},
   * which implements {@link Comparable Comparable&lt;Card&gt;}&mdash;after returning any previously
   * drawn/dealt cards to the deck. The resulting order
   * is the same as that used when the instance is first created via {@link
   * #Deck()}. Invoking this method is equivalent to invoking {@link #sort(boolean) sort(true}.
   */
  public void sort() {
    sort(true);
  }

  /**
   * Sets the source of randomness that will be used by {@link #shuffle(boolean)} and {@link
   * #shuffle()}&mdash;that is, those overloads that do not include a parameter for a source of
   * randomness.
   *
   * @param rng fallback source of randomness.
   */
  public void setRng(Random rng) {
    this.rng = rng;
  }

  /**
   * Returns the source of randomness that will be used by {@link #shuffle(boolean)} and {@link
   * #shuffle()}. If {@link #setRng(Random)} has not yet been invoked to set the source of
   * randomness, an instance of {@link SecureRandom} will be created and returned by this and
   * subsequent invocations.
   *
   * @return fallback source of randomness.
   */
  @Override
  public Random getRng() {
    if (rng == null) {
      rng = new SecureRandom();
    }
    return rng;
  }

}
