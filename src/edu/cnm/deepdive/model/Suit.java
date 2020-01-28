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

/**
 * Encapsulates the suits of standard playing cards. This {@code enum} includes {@link #symbol()}
 * and {@link #color()} methods, to return the Unicode symbol and {@link Color} {@code enum} value
 * of any suit.
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public enum Suit {

  CLUBS,
  DIAMONDS,
  HEARTS,
  SPADES;

  private static final String[] symbols = {"\u2663", "\u2662", "\u2661", "\u2660"};
  private static final Color[] colors = {Color.BLACK, Color.RED, Color.RED, Color.BLACK};

  /**
   * Returns the Unicode playing card symbol for this suit. This will be one of \u2663, \u2662,
   * \u2661, and \u2660.
   *
   * <p>See <a href="https://en.wikipedia.org/wiki/Playing_cards_in_Unicode">Playing cards in
   * Unicode</a> for details.</p>
   *
   * @return Unicode suit symbol.
   */
  public String symbol() {
    return symbols[ordinal()];
  }

  /**
   * Returns the {@link Color} {@code enum} value for this suit.
   *
   * @return {@link Color#RED} or {@link Color#BLACK}.
   */
  public Color color() {
    return colors[ordinal()];
  }

  /**
   * Encapsulates the two possible colors ({@link #RED} &amp; {@link #BLACK}) of standard playing
   * card suits.
   */
  public enum Color {
    /** Color of {@link #DIAMONDS} and {@link #HEARTS}. */
    RED,
    /** Color of {@link #CLUBS} and {@link #SPADES}. */
    BLACK
  }

}
