package V3_Maps;

public class SameHash {
  private String name;

  public SameHash(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public int hashCode() {
    return 1;
  }

  // @Override
  // public boolean equals(Object obj) {
  // return true;
  // }
}
