package edu.cnm.deepdive.model;

import java.util.Arrays;
import java.util.Random;

public class Deck {

  private Card[] cards;

  public Deck(Random rng) {
    cards = new Card[Suit.values().length * Rank.values().length];
    int position = 0;
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        cards[position++] = new Card(s, r);
      }
    }
    for (int i = cards.length - 1; i > 0; i--) {
      int j = rng.nextInt(i + 1);
      Card temp = cards[i];
      cards[i] = cards[j];
      cards[j] = temp;
    }
  }

  @Override
  public String toString() {
    return Arrays.toString(cards);
  }

  public static void main(String[] args) {
    Deck deck = new Deck(new Random());
    System.out.println(deck);
  }

}
