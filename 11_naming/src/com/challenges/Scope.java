package com.challenges;

import java.util.Scanner;

public class Scope {
  public static Scanner x = new Scanner(System.in);

  public static class X {
    public static int x;

    public static void x() {
      System.out.print("Please enter number: ");
      X.x = Scope.x.nextInt();

      for (int x = 1; x <= 12; x++)
        System.out.printf("%d * %d = %d\n", x, X.x, x * X.x);
    }
  }

  public static void main(String[] args) {
    X.x();
  }
}
