package com.dawidprajzner.V3_Polymorphism;

public class Main {
  public static void grow(Plant plant) {
    plant.grow();
  }

  public static void main(String[] args) {
    Flower f1 = new Flower("Margarine Lapsaps", "Blue");
    Tree t1 = new Tree("Oak Vivenus");

    grow(f1);
    grow(f1);
    grow(f1);
    grow(f1);

    grow(t1);
    grow(t1);
    grow(t1);
    grow(t1);
  }
}