package challenges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C2 {
  public static void main(String[] args) {
    String challenge8 = "abcd.135uvqz.7tzik.999";
    Pattern pattern8 = Pattern.compile("[0-9]+");
    Matcher matcher8 = pattern8.matcher(challenge8);
    while (matcher8.find())
      System.out.println(matcher8.group());

    /* ================================================== */ System.out.println("");

    String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
    Pattern pattern9 = Pattern.compile("[0-9]+");
    Matcher matcher9 = pattern9.matcher(challenge9);
    while (matcher9.find())
      System.out.println(matcher9.group());

    /* ================================================== */ System.out.println("");

    // String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";

    String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
    Pattern pattern11 = Pattern.compile("\\{(.+?)\\}");
    Matcher matcher11 = pattern11.matcher(challenge11);
    while (matcher11.find())
      System.out.println(matcher11.group(1));

    /* ================================================== */ System.out.println("");

    String challenge11a = "{0, 2}, {0, 5}, {1, 3}, {2, 4} {x, y}, {6, 34}, {11, 12}";
    Pattern pattern11a = Pattern.compile("(?<=\\{).+?(?=\\})");
    Matcher matcher11a = pattern11a.matcher(challenge11a);
    while (matcher11a.find())
      System.out.println(matcher11a.group());
  }
}
