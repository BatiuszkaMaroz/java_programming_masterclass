package com.dawidprajzner.V1_Composition;

public class Main {
  public static void main(String[] args) {
    Dimensions dim = new Dimensions(100, 50, 30);
    Casing casing = new Casing("2B", "Dell", "240X", dim);
    Monitor monitor = new Monitor("Bastard 27'", "Acer", 27, new Resolution(2540, 1440));
    Motherboard mobo = new Motherboard("BJ-Blaze", "Asus", 4, 6, "v6.9");

    PC myPc = new PC(casing, monitor, mobo);

    // myPc.getCasing().pressPowerButton();
    // myPc.getMotherboard().loadProgram("Windows RED");
    // myPc.getMonitor().drawPixelAt(100, 100, "Blue");

    myPc.powerUp();
    myPc.loadProgram("Windows RED");
  }
}
