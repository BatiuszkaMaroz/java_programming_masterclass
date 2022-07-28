package V3_Polymorphism;

public class Flower extends Plant {
  private String color;

  public Flower(String name, String color) {
    super(name, 3);
    this.color = color;
  }

  @Override
  public void grow() {
    if (size + 1 > maxSize) {
      System.out.printf("%s cannot grow more.\n", name);
      return;
    }

    size++;
    switch (size) {
      case 2:
        System.out.printf("%s now has pitches!\n", name);
        break;

      case 3:
        System.out.printf("%s now has petals!\n", name);
        break;
    }
  }

  public String getColor() {
    return color;
  }
}
