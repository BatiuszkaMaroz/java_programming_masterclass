package challenges;

public class SpeedConverter {
  public static long toMilesPerHour(double km) {
    if (km < 0)
      return -1;

    // mile * 1.609 = km
    // mile = km / 1.609

    double mileConverter = 1.609;

    // Math.round() adds 1/2 to the expression and then executes Math.floor()
    return Math.round(km / mileConverter);
  }

  public static void printConversion(double km) {
    long mil = toMilesPerHour(km);

    if (mil < 0)
      System.out.println("Invalid Value");
    else
      System.out.println(km + " km/h = " + mil + " mi/h");
  }
}