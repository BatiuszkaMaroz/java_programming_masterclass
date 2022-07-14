package com.dawidprajzner.challenges.C2_Printer;

public class Printer {
  private int tonerLevel = 0;
  private int paperSheets = 0;
  private int pagesPrinted = 0;
  private boolean power = false;

  public int getTonerLevel() {
    return tonerLevel;
  }

  public int getPaperSheets() {
    return paperSheets;
  }

  public int getPagesPrinted() {
    return pagesPrinted;
  }

  public boolean isPower() {
    return power;
  }

  public void clickPowerButton() {
    power = !power;
  }

  public void refillToner(int percentage) {
    if (percentage < 0)
      System.out.println("Toner wasn't refilled.");
    else if (tonerLevel + percentage > 100) {
      System.out.println("Toner overflow.");
      tonerLevel = 100;
    } else
      tonerLevel += percentage;

    System.out.printf("Toner filled in %d%%.%n", tonerLevel);
  }

  public void addSheets(int sheets) {
    paperSheets += sheets;
  }

  public void printPage(String content) {
    if (!power) {
      System.out.println("Printer isn't powered.");
      return;
    }

    if (paperSheets == 0) {
      System.out.println("Printer ran out of paper sheets.");
      return;
    }

    if (tonerLevel == 0) {
      System.out.println("Toner ran out of ink.");
      return;
    }

    System.out.println("Printing...");
    pagesPrinted++;
    paperSheets--;
    tonerLevel--;
  }
}
