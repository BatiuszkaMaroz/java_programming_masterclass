package V1_Classes;

/*
 * public - unrestricted access
 * private - no other class can access (has sense only as nested class)
 * protected - classes in package can access
 */
public class Car {
  /*
   * (OOP good practice)
   * all fields should be private because of encapsulation
   * setters/getters should be provided for needed fields
   * internal object state should not be exposed
   */
  private String model;
  private String engine;
  private String color;
  private int maxSpeed;
  private int acceleration;

  /*
   * validation/normalization can be done on setter
   */
  public void setModel(String model) {
    model = model.toLowerCase();
    this.model = model;
  }

  public String getModel() {
    return model;
  }
}
