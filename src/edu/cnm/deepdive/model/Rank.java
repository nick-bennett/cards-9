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
