public class V1_Switch {
  public static void main(String[] args) throws Exception {
    String str = "JANUARY";

    // switch statement compares string like with usage of .isEqual() method
    switch (str.toLowerCase()) {
      case "january":
        System.out.println("jan");
        break;

      case "february":
        System.out.println("feb");
        break;

      case "march":
      case "april":
      case "may":
        System.out.println("march, april or may");
        break;

      default:
        System.out.println("idk");
    }
  }
}
