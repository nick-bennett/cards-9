package edu.cnm.deepdive.model;

public enum Suit {

  CLUBS, DIAMONDS, HEARTS, SPADES;

  private static final String[] symbols = {"\u2663", "\u2662", "\u2661", "\u2660"};
  private static final Color[] colors = {Color.BLACK, Color.RED, Color.RED, Color.BLACK};

  public String symbol() {
    return symbols[ordinal()];
  }

  public Color color() {
    return colors[ordinal()];
  }

  public enum Color {
    RED, BLACK;
  }

}
