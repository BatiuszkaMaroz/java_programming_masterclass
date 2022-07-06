package com.dawidprajzner.V3_Polymorphism;

public class Tree extends Plant {
  private boolean hasFruits = false;

  public Tree(String name) {
    super(name, 4);
  }

  @Override
  public void grow() {
    if (size + 1 > maxSize) {
      System.out.printf("%s cannot grow more.\n", name);
      return;
    }

    size++;
    switch (size) {
      case 2:
        System.out.printf("%s now has pitches!\n", name);
        break;

      case 3:
        System.out.printf("%s now has petals!\n", name);
        break;

      case 4:
        System.out.printf("%s now has fruits!\n", name);
        hasFruits = true;
        break;
    }
  }

  public boolean isHasFruits() {
    return hasFruits;
  }
}
