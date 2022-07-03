package com.dawidprajzner.V3_Inheritance;

public class Fish extends Animal {
  private int eyes;
  private int gills;
  private int fins;

  public Fish(String name, int brain, int body, int size, int weight, int eyes, int gills, int fins) {
    super(name, brain, body, size, weight);
    this.eyes = eyes;
    this.gills = gills;
    this.fins = fins;
  }

  public int getEyes() {
    return eyes;
  }

  public int getGills() {
    return gills;
  }

  public int getFins() {
    return fins;
  }

  private void moveMuscles() {
    //
  }

  private void moveBackFin() {
    //
  }

  private void swim(int speed) {
    moveMuscles();
    moveBackFin();
    super.move(speed);
  }
}
