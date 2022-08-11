package V1_Intro;

public class Main {
  public static void main(String[] args) {
    String str = "Ala has 123 cats called Ala.";

    /*
     * - Regex patterns in Java are written using strings.
     * - To add flags we have to add (?i) in beggining of pattern.
     * - Global flag is not required in replaceAll because this method behaves like
     * it has global flag.
     * - Global flag behavior can be imitated using repeated find() method.
     */

    System.out.println(str.replaceAll("^Ala", "Barbara"));
    System.out.println(str.replaceAll("Ala\\.$", "Barbara!"));
    System.out.println(str.replaceAll("(?i)[^a]", "_"));
    System.out.println(str.replaceAll("[1-9]", "_"));
    System.out.println(str.replaceAll("\\d", "_"));
    System.out.println(str.replaceAll("\\D", "_"));
    /*
     * Negative lookahead (?!ABC) means do not match this sequence after matching
     * previous sequence.
     */
    System.out.println(str.replaceAll("(^| |\\.)(?!Ala)[^ ]*", " "));
    System.out.println(str.replaceAll("\\b", "|"));

    System.out.println(str.matches("^Ala"));
    System.out.println(str.matches("^Ala.+"));
  }
}
