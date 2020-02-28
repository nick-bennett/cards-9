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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Implements a (presumably) multi-deck shoe of {@link Card} instances. Aside from the multi-deck
 * aspect, there are 2 primary functional differences between this class and {@link Deck}:
 * <ol>
 *   <li><p>The <em>builder pattern</em> is used to create instances of this class. (See {@link
 *   Builder}.)</p></li>
 *   <li><p>A reshuffle trigger point may be set when the shoe is created. If {@link #start()} is
 *   invoked, and the number of cards remaining in the shoe is less than or equal to the reshuffle
 *   trigger points, previously drawn/dealt cards are returned to the shoe, and the shoe is
 *   shuffled automatically.</p></li>
 * </ol>
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public class Shoe extends Stock implements Shuffleable {

  protected static final String ADD_NOT_SUPPORTED = "The only cards allowed in a shoe are those provided on instantiation.";
  private final Random rng;
  private final int reshuffleTrigger;

  private Shoe(Builder builder) {
    List<Card> cards = getCards();
    builder.decks.forEach((deck) -> cards.addAll(deck.getCards()));
    this.rng = builder.rng;
    this.reshuffleTrigger = builder.reshuffleTrigger;
    if (builder.shuffleOnCreate) {
      shuffle();
    }
  }

  /**
   * Shuffles the shoe, after gathering all previously drawn/dealt cards back into the shoe, using
   * the specified source of randomness (rather than the source set on creation of the shoe).
   *
   * @param rng source of randomness.
   */
  @Override
  public void shuffle(Random rng) {
    gather();
    Collections.shuffle(getCards(), rng);
  }

  /**
   * Returns the source of randomness set on creation of the shoe.
   */
  @Override
  public Random getRng() {
    return rng;
  }

  /**
   * Throws an {@link UnsupportedOperationException} if an attempt is made to add a card to shoe.
   * (Only the initial set of decks may be used to provide cards for the shoe.)
   */
  @Override
  public void add(Card card) {
    throw new UnsupportedOperationException(ADD_NOT_SUPPORTED);
  }

  /**
   * Marks the start of a round (hand or round of hands) of play. If the number of cards remaining
   * in the shoe is less than or equal to the reshuffle trigger point, the previously drawn/dealt
   * cards are gathered back into the shoe, and the shoe is reshuffled.
   */
  public void start() {
    if (size() <= reshuffleTrigger) {
      shuffle();
    }
  }

  /**
   * Implements the <em>builder pattern</em> for the creation of {@link Shoe} instances.
   */
  public static class Builder {

    private static final String BAD_DECKS_COLLECTION = "Collections of decks must not be null or empty.";
    private static final String BAD_TRIGGER_VALUE = "Shuffle must be non-negative.";
    private static final String BAD_BUILDER = "Builder is invalid, possibly after an earlier exception.";

    private final Collection<Deck> decks;
    private Random rng;
    private int reshuffleTrigger;
    private boolean shuffleOnCreate;

    /**
     * Initializes the builder with the collection of {@link Deck} instances that will be used to
     * populate the shoe. Since these decks are required to make a shoe, this is a constructor
     * parameter, rather than an optional setting.
     *
     * @param decks {@link Collection Collection&lt;Deck&gt;} that will be used for the shoe
     *              contents.
     */
    public Builder(Collection<Deck> decks) {
      if (decks == null || decks.isEmpty()) {
        throw new IllegalArgumentException(BAD_DECKS_COLLECTION);
      }
      this.decks = decks;
    }

    /**
     * Sets the source of randomness to be used for the shuffles performed by the {@link Shoe}.
     *
     * @return this {@link Builder} instance.
     */
    public Builder randomSource(Random rng) {
      this.rng = rng;
      return this;
    }

    /**
     * Sets the reshuffle trigger point for the {@link Shoe}.
     *
     * @return this {@link Builder} instance.
     */
    public Builder reshuffleTrigger(int count) {
      if (count < 0) {
        throw new IllegalArgumentException(BAD_TRIGGER_VALUE);
      }
      reshuffleTrigger = count;
      return this;
    }

    /**
     * Specifies that the {@link Shoe} is to be shuffled during initialization. Invocation of this
     * method is equivalent to invocation of {@link #shuffleOnCreate(boolean)
     * shuffleOnCreate(true)}.
     *
     * @return this {@link Builder} instance.
     */
    public Builder shuffleOnCreate() {
      return shuffleOnCreate(true);
    }

    /**
     * Sets a flag specifying whether the {@link Shoe} is to be shuffled during initialization.
     *
     * @return this {@link Builder} instance.
     */
    public Builder shuffleOnCreate(boolean shuffleOnCreate) {
      this.shuffleOnCreate = shuffleOnCreate;
      return this;
    }

    /**
     * Constructs and returns an initialized instance of {@link Shoe}.
     */
    public Shoe build() {
      if (decks == null) {
        throw new IllegalStateException(BAD_BUILDER);
      }
      if (rng == null) {
        rng = new SecureRandom();
      }
      return new Shoe(this);
    }

  }

}
