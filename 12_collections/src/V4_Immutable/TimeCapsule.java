package V4_Immutable;

import java.util.HashMap;
import java.util.Map;

public final class TimeCapsule {
  /*
   * Immutable object strategy:
   * - no setters,
   * - final and private access modificators,
   * - subclasses can't override methods (easiest way - final class),
   * - if class has references to mutable objects, don't allow those objects to be
   * changed:
   * -> don't provide methods that modify the mutable objects,
   * -> don't share references to the mutable objects.
   *
   * * Not all classess documented as "immutable" follow
   * these rules.
   */

  private final Map<String, Integer> items;

  /*
   * Hermetization on constructor level. If user edit something on passed items,
   * items in capsule won't be affected.
   */
  public TimeCapsule(Map<String, Integer> items) {
    this.items = new HashMap<>(items);
  }

  public boolean hasItem(String key) {
    return items.containsKey(key);
  }

  public int getItemAmount(String key) {
    return items.get(key);
  }

  /*
   * Getter returns copy of items in capsule. If user edit
   * something on received items, items in capsule won't be affected.
   *
   * Below code shows how to accomplish 4th immutable object strategy rule.
   */
  public Map<String, Integer> getItems() {
    return new HashMap<>(items);
  }
}
