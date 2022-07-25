package com.challenges;

import com.dawidprajzner.Series;

public class Main {
  public static void main(String[] args) {
    Series s = new Series();

    System.out.println("sum(5) = " + s.sum(5));
    System.out.println("factorial(5) = " + s.factorial(5));

    for (int i = 0; i < 10; i++)
      System.out.printf("fib(%d) = %d\n", i, s.fib(i));
  }
}
