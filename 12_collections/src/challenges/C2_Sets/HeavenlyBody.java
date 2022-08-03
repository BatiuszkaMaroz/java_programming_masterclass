package challenges.C2_Sets;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
  /*
   * Nested enums are always static, so you can omit "static" keyword.
   */
  public enum BodyTypes {
    PLANET, DWARF_PLANET, MOON;
  }

  /*
   * Public class, private constructor means:
   * 1. You can create a variable of this type outside class.
   * 2. You can create instance of this class only in wrapping class.
   */
  public static final class Key {
    private String name;
    private BodyTypes bodyType;

    private Key(String name, BodyTypes bodyType) {
      this.name = name;
      this.bodyType = bodyType;
    }

    public String getName() {
      return name;
    }

    public BodyTypes getBodyType() {
      return bodyType;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;

      if (!(obj instanceof Key))
        return false;

      Key key = (Key) obj;
      return name == key.name && bodyType == key.bodyType;
    }

    @Override
    public int hashCode() {
      return (name.hashCode() + bodyType.hashCode()) * 31;
    }

    @Override
    public String toString() {
      return name + ": " + bodyType;
    }
  }

  public static Key makeKey(String name, BodyTypes bodyType) {
    return new Key(name, bodyType);
  }

  private final Key key;
  private final double orbitalPeriod;
  private final Set<HeavenlyBody> satellites;

  public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
    this.key = new Key(name, bodyType);
    this.orbitalPeriod = orbitalPeriod;
    this.satellites = new HashSet<>();
  }

  public Key getKey() {
    return key;
  }

  public double getOrbitalPeriod() {
    return orbitalPeriod;
  }

  public Set<HeavenlyBody> getSatellites() {
    return new HashSet<>(satellites);
  }

  public boolean addSatellite(HeavenlyBody satellite) {
    return satellites.add(satellite);
  }

  @Override
  public final int hashCode() {
    return key.hashCode();
  }

  @Override
  public final boolean equals(Object obj) {
    if (this == obj)
      return true;

    if (!(obj instanceof HeavenlyBody))
      return false;

    HeavenlyBody body = (HeavenlyBody) obj;
    return this.key.equals(body.key);

    /*
     * WILL THIS WORK?
     */
    // if (!(obj instanceof HeavenlyBody body))
    // return false;

    // return this.key.equals(body.key);
  }

  @Override
  public String toString() {
    return key.getName() + ": " + key.getBodyType() + ", " + orbitalPeriod;
  }
}