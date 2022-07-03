package challenges;

public class C2_NumberOfDaysInMonth {
  public static boolean isLeapYear(int year) {
    if (year < 1 || year > 9999)
      return false;

    if (year % 100 == 0) {
      return year % 400 == 0;
    } else {
      return year % 4 == 0;
    }
  }

  public static int getDaysInMonth(int month, int year) {
    if (year < 0 || 9999 < year || month < 1 || 13 < month)
      return -1;

    switch (month) {
      case 2:
        return isLeapYear(year) ? 29 : 28;

      case 4:
      case 6:
      case 9:
      case 11:
        return 30;

      default:
        return 31;
    }
  }
}
