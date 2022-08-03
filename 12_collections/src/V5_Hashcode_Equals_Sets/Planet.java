package V5_Hashcode_Equals_Sets;

public final class Planet {
  private final String name;
  private final double orbitalPeriod;

  public Planet(String name, double orbitalPeriod) {
    this.name = name;
    this.orbitalPeriod = orbitalPeriod;
  }

  public String getName() {
    return name;
  }

  public double getOrbitalPeriod() {
    return orbitalPeriod;
  }

  /*
   * You always have to use Object class parameter for comparing.
   * Otherwise instead of overriding you'll overload equals method.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;

    // remember this line
    if (obj == null || this.getClass() != obj.getClass())
      return false;

    return name.equals(((Planet) obj).getName());
  }

  @Override
  public int hashCode() {
    return name.hashCode() * 31;

    /*
     * If hash code is combined of more values you can use this.
     */
    // return Objects.hash(a, b, c);
  }
}
