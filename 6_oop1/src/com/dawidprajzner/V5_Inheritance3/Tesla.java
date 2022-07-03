package com.dawidprajzner.V5_Inheritance3;

public class Tesla extends Car {
  private int batteryCapacity;
  private int battery = 0;

  public int getBatteryCapacity() {
    return batteryCapacity;
  }

  public int getBattery() {
    return battery;
  }

  public Tesla(int mass, int maxSpeed, String model, int maxGear, int batteryCapacity) {
    super(mass, maxSpeed, "Tesla", model, maxGear);
    this.batteryCapacity = batteryCapacity;
  }

  public void charge() {
    System.out.println("Charging your Tesla...");
    battery = batteryCapacity;
  }

  public void summon() {
    if (battery == 0) {
      System.out.println("Your Tesla run out of battery...");
      return;
    }

    System.out.println("Summoning tesla at your palace...");
    setBattery(battery - batteryCapacity / 5);
  }

  public void setBattery(int battery) {
    if (battery < 0)
      this.battery = 0;
    else
      this.battery = battery;
  }

  @Override
  public void move(int speed) {
    if (battery == 0) {
      System.out.println("Your Tesla run out of battery...");
      return;
    }

    setBattery(battery - batteryCapacity / 5);
    super.move(speed);
  }

}
