package V3_Polymorphism;

public class Plant {
  protected String name;
  protected int size = 1;
  protected int maxSize;

  public Plant(String name, int maxSize) {
    if (maxSize < 1)
      maxSize = 1;

    this.name = name;
    this.maxSize = maxSize;
  }

  public String getName() {
    return name;
  }

  public int getSize() {
    return size;
  }

  public void grow() {
    if (size + 1 == maxSize) {
      System.out.printf("%s cannot grow more.\n", name);
      return;
    }

    size++;
    System.out.printf("%s grew to size %d.\n", name, size);
  }

}
