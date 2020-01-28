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
