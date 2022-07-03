package com.dawidprajzner.V5_Inheritance3;

public class Main extends Object {
  public static void main(String[] args) {
    Tesla myTesla = new Tesla(1500, 260, "X", 6, 1500);

    myTesla.move(100);
    myTesla.charge();

    myTesla.move(50);
    myTesla.move(100);
    myTesla.move(150);
    myTesla.move(200);
    myTesla.move(250);
    myTesla.brake();

    // ...

    myTesla.summon();

    // fuck...
  }
}
