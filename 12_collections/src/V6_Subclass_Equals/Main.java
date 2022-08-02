package V6_Subclass_Equals;

public class Main {
  public static void main(String[] args) {
    Dog d1 = new Dog("Alex");
    Dog d2 = new Dog("Alex");
    Yorkie d3 = new Yorkie("Alex");

    System.out.println("d1 == d2 = " + d1.equals(d2));
    System.out.println("d2 == d1 = " + d2.equals(d1));
    System.out.println("d1 == d3 = " + d1.equals(d3));

    /*
     * If Yorkie class implement its own equal() method, problems will arise while
     * using equal() method on Yorkie instance. To prevent that issue, mark equal()
     * method on Dog as final.
     */
    System.out.println("d3 == d1 = " + d3.equals(d1));

    /*
     * Maps/sets use hash codes, but standalone equals() method doesn't.
     * In real program ALWAYS adjust hashCode() to equals() !!! Both hashes must me
     * equal if objects are equal.
     */
    System.out.println(d1.hashCode());
    System.out.println(d2.hashCode());
  }
}
