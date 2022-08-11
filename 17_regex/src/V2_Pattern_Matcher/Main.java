package V2_Pattern_Matcher;

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
     * We can use Pattern and Matcher classes to test texts.
     * - matches() tries to match entire sequence.
     */

    Pattern pattern = Pattern.compile(".*<h2>.*");
    Matcher matcher = pattern.matcher(htmlText);
    System.out.println(matcher.matches());

    /*
     * Regexes in Java cannot use global flag, but with repeated usage of find() we
     * achieve that result.
     *
     * We use below methods:
     * - find() will repeat regex search starting from index of last search,
     * - start() returns starting index of match,
     * - end() returns ending index of match,
     * - group() returns value between starting and ending indexes.
     */

    pattern = Pattern.compile("<h2>");
    matcher = pattern.matcher(htmlText);

    int i = 0;
    while (matcher.find()) {
      System.out.println("Occurrence " +
          i + ": " +
          matcher.start() + " to " +
          matcher.end() + " = " +
          matcher.group());
      i++;
    }

    /*
     * After full-run usage with .find() matcher has to be resetted in oreder to use
     * it again.
     */

    matcher.reset();
  }
}