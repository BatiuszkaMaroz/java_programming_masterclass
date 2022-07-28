package V1_Composition;

public class Casing {
  private String model;
  private String manufacturer;
  private String powerSupply;
  private Dimensions dimensions;

  public Casing(String model, String manufacturer, String powerSupply, Dimensions dimensions) {
    this.model = model;
    this.manufacturer = manufacturer;
    this.powerSupply = powerSupply;
    this.dimensions = dimensions;
  }

  public void pressPowerButton() {
    System.out.println("Power putton pressed");
  }

  public String getModel() {
    return model;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public String getPowerSupply() {
    return powerSupply;
  }

  public Dimensions getDimensions() {
    return dimensions;
  }
}
