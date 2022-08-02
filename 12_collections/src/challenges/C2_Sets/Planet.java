package challenges.C2_Sets;

public class Planet extends HeavenlyBody {
  public Planet(String name, double orbitalPeriod) {
    super(name, orbitalPeriod, HeavenlyBody.BodyTypes.PLANET);
  }

  @Override
  public boolean addSatellite(HeavenlyBody satellite) {
    BodyTypes bodyType = satellite.getKey().getBodyType();
    if (!bodyType.equals(HeavenlyBody.BodyTypes.MOON))
      return false;

    return super.addSatellite(satellite);
  }
}
