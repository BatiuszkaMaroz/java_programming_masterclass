package V3_AbstractClasses;

public abstract class Bird extends Animal implements IFlying {
  public Bird(String name) {
    super(name);
  }

  @Override
  public void breathe() {
    System.out.println("Breath bird, breath!");
  }

  @Override
  public void eat() {
    System.out.println("Ear bird, eat!");
  }

  @Override
  public abstract void fly();

  public abstract void giveVoice();
}
