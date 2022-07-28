package V3_AbstractClasses;

public class Parrot extends Bird {
  public Parrot(String name) {
    super(name);
  }

  @Override
  public void fly() {
    System.out.println("Fly parrot, fly!");
  }

  @Override
  public void giveVoice() {
    System.out.println("Harr, I'm parrot, harr!");
  }
}
