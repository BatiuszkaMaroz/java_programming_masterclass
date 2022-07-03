package challenges;

import java.util.Scanner;

public class C16_InputCalculator {
  public static void inputThenPrintSumAndAverage() {
    Scanner sc = new Scanner(System.in);

    int sum = 0;
    int count = 0;

    while (sc.hasNextInt()) {
      sum += sc.nextInt();
      count++;
    }

    int avg = count == 0 ? 0 : (int) Math.round((double) sum / (double) count);

    System.out.println(String.format("SUM = %d AVG = %d", sum, avg));
    sc.close();
  }

  public static void main(String[] args) {
    inputThenPrintSumAndAverage();
  }
}
