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
 * Encapsulates all ranks of standard playing cards. These do not include the Knight that is present
 * for some specialized games/decks. This {@code enum} includes a {@link #symbol()} method that
 * returns the common 1- or 2-character symbol used in shorthand notation for play: A, 2, 3,
 * &hellip;, 10, J, Q, K.
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public enum Rank {
  ACE,
  TWO,
  THREE,
  FOUR,
  FIVE,
  SIX,
  SEVEN,
  EIGHT,
  NINE,
  TEN,
  JACK,
  QUEEN,
  KING;

  private static final String[] symbols = {
      "A",
      "2",
      "3",
      "4",
      "5",
      "6",
      "7",
      "8",
      "9",
      "10",
      "J",
      "Q",
      "K"
  };

  /**
   * Returns the 1- or 2-character shorthand symbol commonly used in card play notation. This will
   * be one of A, 2, 3, &hellip;, 10, J, Q, K.
   *
   * @return shorthand rank symbol.
   */
  public String symbol() {
    return symbols[ordinal()];
  }

}
