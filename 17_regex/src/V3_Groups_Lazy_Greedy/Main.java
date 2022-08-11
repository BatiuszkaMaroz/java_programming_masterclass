package V3_Groups_Lazy_Greedy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
    htmlText.append("<h2>Sub-heading</h2>");
    htmlText.append("<p>This is a paragraph about something.</p>");
    htmlText.append("<p>This is another paragraph about something else.</p>");
    htmlText.append("<h2>Summary</h2>");
    htmlText.append("<p>Here is the summary.</p>");

    /*
     * [Greedy and lazy quantifiers]
     * "*", "+" and "?" are quantifiers. They are greedy by default meaning match as
     * many characters as possible.
     * To enable lazy mode, meaning match as few as possible, you have to add "?" to
     * them resulting in "*?", "+?" and "??".
     *
     * [Multiple groups]
     * Multiple groups can be matched, groups (marked by us) start from index 1
     * while group with index 0 is a whole match.
     */

    Pattern pattern = Pattern.compile("(<h2>)(.*?)(</h2>)");
    Matcher matcher = pattern.matcher(htmlText);

    int i = 0;
    while (matcher.find()) {
      System.out.println("Occurrence " + i + ":");
      System.out.println("\tG1 = " + matcher.group(1));
      System.out.println("\tG2 = " + matcher.group(2));
      System.out.println("\tG3 = " + matcher.group(3));
      i++;
    }

    /* ================================================== */ System.out.println("");

    /*
     * We can also like extract part of match.
     *
     * And we can also get indexes of group matches.
     */

    pattern = Pattern.compile("<h2>(.*?)</h2>");
    matcher = pattern.matcher(htmlText);

    i = 0;
    while (matcher.find()) {
      System.out.println("Occurrence " + i + ":");
      System.out.println("\tG1 = " + matcher.group(1));
      System.out.println("\tStart = " + matcher.start(1) + " End = " + matcher.end(1));
      i++;
    }

    /* ================================================== */ System.out.println("");

    /*
     * We can use look-ahead/back too!
     */

    pattern = Pattern.compile("(?<=<h2>).+?(?=</h2>)");
    matcher = pattern.matcher(htmlText);

    i = 0;
    while (matcher.find()) {
      System.out.println("Occurrence " + i + ": " + matcher.group());
      i++;
    }

    /* ================================================== */ System.out.println("");

    /*
     * We can create optional groups.
     */

    String regExp = "^[0-9]{5}(-[0-9]{4})?$";

    System.out.println("11111".matches(regExp));
    System.out.println("11111-1111".matches(regExp));
  }
}
