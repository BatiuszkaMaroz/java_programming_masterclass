package V4_Lookaround;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    /*
     * Positive lookbehind matches a group before main expression without including
     * it in the result.
     *
     * Positive lookahead matches a group after main expression without including
     * it in the result.
     */

    String str = "prefix I love Java";

    Pattern pattern = Pattern.compile("(?<=prefix ).+");
    Matcher matcher = pattern.matcher(str);

    while (matcher.find())
      System.out.println(matcher.group());

    /* ================================================== */ System.out.println("");

    str = "I love Java suffix";

    pattern = Pattern.compile(".+?(?= suffix)");
    matcher = pattern.matcher(str);

    while (matcher.find())
      System.out.println(matcher.group());

    /* ================================================== */ System.out.println("");

    str = "{0, 2}, {0, 5}, {1, 3}, {2, 4} {x, y}, {6, 34}, {11, 12}";

    pattern = Pattern.compile("(?<=\\{).+?(?=\\})");
    matcher = pattern.matcher(str);

    while (matcher.find())
      System.out.println(matcher.group());
  }
}
