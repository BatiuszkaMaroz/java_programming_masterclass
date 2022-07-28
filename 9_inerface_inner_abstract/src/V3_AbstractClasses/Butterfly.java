package V3_AbstractClasses;

public class Butterfly extends Insect {
  public Butterfly(String name) {
    super(name);
  }

  @Override
  public void fly() {
    if (!isEvolved()) {
      System.out.println("This butterfly has to evolve in order to fly.");
      return;
    }

    System.out.println("Fly, butterfly, fly!");
  }
}
