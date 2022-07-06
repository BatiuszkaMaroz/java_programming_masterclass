package com.dawidprajzner.challenges.C3_Cars;

public class Holden extends Car {
  public Holden(int cylinders, String name) {
    super(cylinders, name);
  }

  @Override
  public String accelerate() {
    return "Holden -> accelerate()";
  }

  @Override
  public String brake() {
    return "Holden -> brake()";
  }

  @Override
  public String startEngine() {
    return "Holden -> startEngine()";
  }
}
