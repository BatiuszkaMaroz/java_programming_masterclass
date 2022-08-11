package challenges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C1 {
  public static void main(String[] args) {
    String str1 = "I want a bike.";
    String str2 = "I want a ball.";

    Pattern pattern = Pattern.compile("^I want a \\w+\\.$");
    Matcher matcher;

    matcher = pattern.matcher(str1);
    System.out.println(matcher.matches());

    matcher = pattern.matcher(str2);
    System.out.println(matcher.matches());

    // ==================================================

    String str = "Replace all whitespaces with underscores.";
    str = str.replaceAll(" ", "_");
    System.out.println(str);

    // ==================================================

    str = "abbcccddddeeeeeffffff";
    System.out.println(str.matches("[a-f]*"));
    System.out.println(str.matches("^ab{2}c{3}d{4}e{5}f{6}$"));

    // ==================================================

    String regExp = "^[a-z]+\\.[0-9]+$";

    System.out.println("abcd.123".matches(regExp));
    System.out.println("abcd1.123".matches(regExp));
    System.out.println("abcd.123a".matches(regExp));
    System.out.println("123.abcd".matches(regExp));
  }
}
