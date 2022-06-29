package challenges;

public class MinutesToYearsDaysCalculator {
  public static void printYearsAndDays(long minutes) {
    if (minutes < 0) {
      System.out.println("Invalid Value");
      return;
    }

    long days = minutes / 60 / 24;
    long years = days / 365;
    days %= 365;

    System.out.println(String.format("%d min = %d y and %d d", minutes, years, days));
  }
}
