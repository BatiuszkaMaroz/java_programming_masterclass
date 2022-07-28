package challenges.C3_Cars;

public class Ford extends Car {
  public Ford(int cylinders, String name) {
    super(cylinders, name);
  }

  @Override
  public String accelerate() {
    return "Ford -> accelerate()";
  }

  @Override
  public String brake() {
    return "Ford -> brake()";
  }

  @Override
  public String startEngine() {
    return "Ford -> startEngine()";
  }
}
