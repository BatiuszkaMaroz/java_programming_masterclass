package V1_Comparable;

public class Seat implements Comparable<Seat> {

  private final String id;
  private boolean reserved = false;

  public Seat(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public boolean isReserved() {
    return reserved;
  }

  public void setReserved(boolean reserved) {
    this.reserved = reserved;
  }

  /*
   * Implementing Comparable interface on class allows us to use Collections
   * framework to work on a collaction of this class instances (including
   * binarySearch, sorting, min, max and other).
   */

  @Override
  public int compareTo(Seat seat) {
    System.out.print(".");
    String id1 = this.getId();
    String id2 = seat.getId();

    return id1.compareTo(id2);
  }
}
