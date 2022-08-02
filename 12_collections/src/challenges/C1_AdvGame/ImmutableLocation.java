package challenges.C1_AdvGame;

import java.util.HashMap;
import java.util.Map;

public class ImmutableLocation {
  private final int locationID;
  private final String description;
  private final Map<String, Integer> exits;

  public ImmutableLocation(int locationID, String description, Map<String, Integer> exits) {
    this.locationID = locationID;
    this.description = description;

    if (exits == null)
      this.exits = new HashMap<String, Integer>();
    else
      this.exits = new HashMap<String, Integer>(exits);

    this.exits.put("Q", 0);
  }

  public int getLocationID() {
    return locationID;
  }

  public String getDescription() {
    return description;
  }

  public Map<String, Integer> getExits() {
    return new HashMap<String, Integer>(exits);
  }
}
