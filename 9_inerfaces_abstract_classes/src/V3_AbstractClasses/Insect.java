package V3_AbstractClasses;

public abstract class Insect extends Animal implements IFlying {
  private boolean evolved = false;

  public Insect(String name) {
    super(name);
  }

  public boolean isEvolved() {
    return evolved;
  }

  @Override
  public void breathe() {
    System.out.println("Breath insect, breath!");
  }

  @Override
  public void eat() {
    System.out.println("Ear insect, eat!");
  }

  @Override
  public abstract void fly();

  public void evolve() {
    evolved = true;
  }
}
