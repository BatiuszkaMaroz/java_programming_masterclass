package V3_Inheritance;

public class Dog extends Animal {
  private int eyes;
  private int legs;
  private int tail;
  private int teeth;
  private String coat;

  public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
    super(name, 1, 1, size, weight);
    this.eyes = eyes;
    this.legs = legs;
    this.tail = tail;
    this.teeth = teeth;
    this.coat = coat;
  }

  public int getEyes() {
    return eyes;
  }

  public int getLegs() {
    return legs;
  }

  public int getTail() {
    return tail;
  }

  public int getTeeth() {
    return teeth;
  }

  public String getCoat() {
    return coat;
  }

  private void chew() {
    System.out.println("Dog chewing...");
  }

  @Override
  public void eat() {
    System.out.println("Dog eating...");
    chew();

    // super.eat();
  }

  @Override
  public void move(int speed) {
    System.out.println("Dog moving at speed " + speed + "...");
  }

  /*
   * uses override or inherited move method
   */
  public void walk() {
    System.out.println("Dog walking...");
    move(10);
  }

  /*
   * with super keyword it always uses inherited move method
   */
  public void run() {
    System.out.println("Dog running...");
    super.move(100);
  }
}
