package challenges;

public class C3 {
  public static void main(String[] args) {
    String challenge12 = "11111";
    System.out.println(challenge12.matches("^[0-9]{5}$"));

    String challenge13 = "11111-1111";
    System.out.println(challenge13.matches("^[0-9]{5}-[0-9]{4}$"));

    System.out.println(challenge12.matches("^[0-9]{5}(-[0-9]{4})?$"));
    System.out.println(challenge13.matches("^[0-9]{5}(-[0-9]{4})?$"));
  }
}
