package V6_Subclass_Equals;

public class Yorkie extends Dog {
  public Yorkie(String name) {
    super(name);
  }

  /*
   * Overriding this method will cause errors in compairsions with instances of
   * upper class.
   */
  // @Override
  // public boolean equals(Object obj) {
  // if (this == obj)
  // return true;

  // if (obj instanceof Yorkie objYorkie)
  // return name.equals(objYorkie.name);

  // return false;
  // }
}
