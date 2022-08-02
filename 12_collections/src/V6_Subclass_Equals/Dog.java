package V6_Subclass_Equals;

public class Dog {
  protected String name;

  public Dog(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  /*
   * Mark method as final so any subclass won't override it and you'll avoid
   * errors while comparing instances of class vs subclass.
   */
  @Override
  public final boolean equals(Object obj) {
    if (this == obj)
      return true;

    if (obj instanceof Dog objDog)
      return name.equals(objDog.name);

    return false;
  }
}
