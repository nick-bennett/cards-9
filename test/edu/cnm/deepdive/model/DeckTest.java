package edu.cnm.deepdive.model;

import static org.junit.jupiter.api.Assertions.*;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class DeckTest {

  @Test
  void init() {
    Deck d = new Deck();
    Set<Card> check = new HashSet<>();
    assertEquals(52, d.remaining());
    for (Card c = d.deal(); c != null; c = d.deal()) {
      check.add(c);
    }
    assertEquals(52, check.size());
  }

  @Test
  void deal() {
    Deck d = new Deck();
    int count = 0;
    for (Card c = d.deal(); c != null; c = d.deal()) {
      count++;
    }
    assertEquals(52, count);
  }

  @Test
  void shuffle() {
    List<Card> originalList = new LinkedList<>();
    Set<Card> originalSet = new HashSet<>();
    List<Card> shuffledList = new LinkedList<>();
    Set<Card> shuffledSet = new HashSet<>();
    Deck d = new Deck();
    for (Card c = d.deal(); c != null; c = d.deal()) {
      originalList.add(c);
      originalSet.add(c);
    }
    d.shuffle(new SecureRandom());
    for (Card c = d.deal(); c != null; c = d.deal()) {
      shuffledList.add(c);
      shuffledSet.add(c);
    }
    assertEquals(originalSet, shuffledSet);
    assertNotEquals(originalList, shuffledList);
  }

  @Test
  void remaining() {
    Deck d = new Deck();
    int count = 52;
    do {
      assertEquals(count, d.remaining());
      d.deal();
      count--;
    } while (count >= 0);
  }

  @Test
  void dealt() {
    Deck d = new Deck();
    int count = 0;
    do {
      assertEquals(count, d.dealt());
      d.deal();
      count++;
    } while (count <= 52);
  }

}