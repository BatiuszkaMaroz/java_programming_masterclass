package com.dawidprajzner.V5_Inheritance3;

public class Vehicle {
  protected int mass;
  protected int maxSpeed;
  protected int currentSpeed = 0;

  public int getMass() {
    return mass;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public int getCurrentSpeed() {
    return currentSpeed;
  }

  public Vehicle(int mass, int maxSpeed) {
    this.mass = mass;
    this.maxSpeed = maxSpeed;
  }

  public void move(int speed) {
    if (speed < 0) {
      brake();
      return;
    }
    if (speed > maxSpeed) {
      System.out.println("Vehicle max speed is " + maxSpeed + " km/h.");
      speed = maxSpeed;
    }

    currentSpeed = speed;
    System.out.println("Vehicle is moving at speed of " + currentSpeed + " km/h...");
  }

  public void brake() {
    System.out.println("Vehicle is braking...");
    currentSpeed = 0;
  }
}
