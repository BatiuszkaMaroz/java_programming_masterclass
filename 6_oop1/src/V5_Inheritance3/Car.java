package V5_Inheritance3;

public class Car extends Vehicle {
  protected String brand;
  protected String model;

  protected int currentGear = 1;
  protected int maxGear;

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public int getCurrentGear() {
    return currentGear;
  }

  public int getMaxGear() {
    return maxGear;
  }

  public Car(int mass, int maxSpeed, String brand, String model, int maxGear) {
    super(mass, maxSpeed);
    this.brand = brand;
    this.model = model;
    this.maxGear = maxGear;
  }

  public void changeGear(int gear) {
    if (gear < 1 || maxGear < gear)
      System.out.println("This car does not have " + gear + " gear...");
    else {
      System.out.println("Changing gear to " + gear + "...");
      currentGear = gear;
    }
  }

  public void turnLeft() {
    System.out.println("Turning left...");
  }

  public void turnRight() {
    System.out.println("Turning right...");
  }

  @Override
  public void move(int speed) {
    for (int i = 1; i <= maxGear; i++)
      if (i > currentGear && speed > ((maxSpeed * (i - 1)) / (maxGear)))
        changeGear(i);

    super.move(speed);
  }

  @Override
  public void brake() {
    changeGear(1);
    super.brake();
  }

}
