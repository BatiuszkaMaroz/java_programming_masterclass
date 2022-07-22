package V3_AbstractClasses;

public class Main {
  /*
   * "is" relation - is something - abstract class
   * "has" relation - has some abilities - interface
   *
   * abstract class can:
   * - declare fields
   * - declare abstract methods
   * - declare and implement methods
   *
   * subclass of abstract class have to:
   * - implement abstract methods
   * - OR become abstract class (if doesn't implement them)
   *
   * usage:
   * - provide common definition of base class that multiple classes will base on
   */

  public static void main(String[] args) {
    Parrot parrot = new Parrot("Alpha");
    Butterfly butterfly = new Butterfly("Omega");

    parrot.fly();
    parrot.giveVoice();

    System.out.println("====================");

    butterfly.fly();
    butterfly.evolve();
    butterfly.fly();
  }
}
