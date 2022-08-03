package V2_Comparator;

public class Seat implements Comparable<Seat> {
  private final String id;
  private double price;
  private boolean reserved = false;

  public Seat(String id, double price) {
    this.id = id;
    this.price = price;
  }

  public String getId() {
    return id;
  }

  public double getPrice() {
    return price;
  }

  public boolean isReserved() {
    return reserved;
  }

  public void setReserved(boolean reserved) {
    this.reserved = reserved;
  }

  @Override
  public int compareTo(Seat seat) {
    if (seat == null)
      throw new NullPointerException();

    String id1 = this.getId();
    String id2 = seat.getId();

    return id1.compareTo(id2);
  }

  @Override
  public String toString() {
    return getId() + ": " + getPrice() + "$";
  }
}
