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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Abstract class representing an ordered collection of {@link Card} instances, which can be added
 * to, iterated over, compared to other {@link Pile} instances, etc. {@code protected} methods are
 * also provided for access to and operations on the underlying collection, intended for invocation
 * by concrete subclasses.
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public abstract class Pile implements Iterable<Card> {

  private final List<Card> cards;

  /**
   * Initializes this instance with an empty ordered collection of {@link Card} instances.
   */
  protected Pile() {
    cards = new ArrayList<>();
  }

  /**
   * Adds the specified {@link Card} to this pile of cards. If more specific behavior is needed in a
   * subclass, this method should be overridden as necessary and <em>must</em> be invoked, e.g.
   *
   * <pre><code>@Override
   * public void add(Card card) {
   *   super.add(card); // Invoke the superclass method.
   *   // Perform any additional processing, as needed.
   *   // ...
   * }</code></pre>
   *
   * @param card {@link Card} instance to be added to the pile.
   */
  public void add(Card card) {
    cards.add(card);
  }

  /**
   * Returns the number of {@link Card} instances in this pile.
   *
   * @return count of cards in the pile.
   */
  public int size() {
    return cards.size();
  }

  @Override
  public Iterator<Card> iterator() {
    return cards.iterator();
  }

  /**
   * Computes and returns the hash value for the cards in the pile. Note that since the collection
   * is ordered, the behavior implemented here will usually give different values for the same set
   * of cards, but in different orders.
   *
   * @return computed hash value.
   */
  @Override
  public int hashCode() {
    return cards.hashCode();
  }

  /**
   * Performs an equality comparison between this instance and {@code other}. Note that this is an
   * order-dependendent comparison&mdash;that is, even if 2 piles contain the same cards, but in a
   * different order, they will not be considered equal, according to this method. If an
   * order-independent comparison is needed, this method must be overridden in a subclass.
   *
   * @param obj instance this instance will be compared to.
   * @return comparison result (negative, positive, or zero).
   */
  @Override
  public boolean equals(Object obj) {
    return (obj == this
        || (obj instanceof Pile
            && cards.equals(((Pile) obj).cards)));
  }

  @Override
  public String toString() {
    return cards.toString();
  }

  /**
   * Adds the specified {{@link Collection Collection&lt;Card&gt;} to this pile of cards. If more
   * specific behavior is needed in a subclass, this method should be overridden as necessary; any
   * such override should invoke {@link #addAll(Collection) super.addAll(cards)} or (iteratively)
   * {@link #add(Card)}, as appropriate, e.g.
   *
   * <pre><code>@Override
   * protected void addAll(Collection&lt;Card&gt; cards) {
   *   super.addAll(cards); // Invoke the superclass method.
   *   // Perform any additional processing, as needed.
   *   // ...
   * }</code></pre>
   *
   * @param cards cards to be added to this pile.
   */
  protected void addAll(Collection<Card> cards) {
    this.cards.addAll(cards);
  }

  /**
   * Removes and returns the first card in the pile, or {@code null} if the pile is empty. This
   * method will generally need to be invoked (and possibly overridden) by subclasses.
   *
   * @return first (presumably top) {@link Card} in the pile, or {@code null} if there are none.
   */
  protected Card remove() {
    return cards.isEmpty() ? null : cards.remove(0);
  }

  /**
   * Returns a reference to the underlying {@link List} of cards. Care should be taken when
   * modifying the list returned, as that will modify the underlying collection.
   */
  protected List<Card> getCards() {
    return cards;
  }

}
