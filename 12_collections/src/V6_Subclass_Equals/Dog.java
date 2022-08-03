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
   * errors while comparing instances of class with instances of subclass.
   *
   * More on instanceof vs getClass() in notes.md.
   */
  @Override
  public final boolean equals(Object obj) {
    if (this == obj)
      return true;

    if (!(obj instanceof Dog))
      return false;

    Dog dog = (Dog) obj;
    return name.equals(dog.name);

    /*
     * Alternative syntax with type casting on instanceof.
     */

    // if (obj instanceof Dog dog)
    // return name.equals(dog.name);

    // return false;
  }
}
