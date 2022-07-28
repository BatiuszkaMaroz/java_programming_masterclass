package challenges.C3_Cars;

public class Car {
  private boolean engine = true;
  private int cylinders;
  private String name;
  private int wheels = 4;

  public Car(int cylinders, String name) {
    this.cylinders = cylinders;
    this.name = name;
  }

  public int getCylinders() {
    return cylinders;
  }

  public String getName() {
    return name;
  }

  public String accelerate() {
    return "Car -> accelerate()";
  }

  public String brake() {
    return "Car -> brake()";
  }

  public String startEngine() {
    return "Car -> startEngine()";
  }
}
