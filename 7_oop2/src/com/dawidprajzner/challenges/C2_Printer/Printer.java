package com.dawidprajzner.challenges.C2_Printer;

public class Printer {
  private int tonerLevel;
  private boolean duplex;
  private int pagesPrinted = 0;

  public Printer(int tonerLevel, boolean duplex) {
    if (tonerLevel < 0 || 100 < tonerLevel)
      tonerLevel = -1;

    this.tonerLevel = tonerLevel;
    this.duplex = duplex;
  }

  public int addToner(int tonerAmount) {
    if (tonerAmount <= 0 || 100 < tonerAmount)
      return -1;

    if (tonerLevel + tonerAmount > 100)
      return -1;

    tonerLevel += tonerAmount;
    return tonerLevel;
  }

  public int printPages(int pages) {
    int pagesToPrint = duplex ? (pages / 2) + pages % 2 : pages;

    pagesPrinted += pagesToPrint;
    return pagesToPrint;
  }

  public int getPagesPrinted() {
    return pagesPrinted;
  }
}
