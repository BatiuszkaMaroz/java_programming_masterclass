package V4_Immutable;

import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    Map<String, Integer> config = new HashMap<>();

    config.put("rollerblades", 10);
    config.put("juice", 1);
    config.put("usb cable", 7);

    TimeCapsule ts = new TimeCapsule(config);
  }
}
