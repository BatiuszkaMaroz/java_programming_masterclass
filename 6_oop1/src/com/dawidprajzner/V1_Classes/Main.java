package com.dawidprajzner.V1_Classes;

public class Main {
  public static void main(String[] args) {
    /*
     * initialization
     */
    Car porsche = new Car();

    // every class inherits from Object
    // porsche.[...]

    /*
     * declaration only
     */
    Car holden;

    // uninitialized
    // holden.setModel("Carrera");

    /*
     * setting to null
     */
    Car volvo = new Car();
    volvo = null;

    // will also throw error
    // volvo.setModel("Carrera");
  }
}
