package V2_Comparator;

import java.util.*;

public class Theatre {
  private final String name;
  private List<Seat> seats = new ArrayList<>();

  /*
   * Problems can arise because 0 can be returned if two compared objects are not
   * the same object. Problems on sets and maps, what problems - idk.
   */

  static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
    @Override
    public int compare(Seat o1, Seat o2) {
      if (o1.getPrice() < o2.getPrice())
        return -1;
      else if (o1.getPrice() == o2.getPrice())
        return 0;
      else
        return 1;
    }
  };

  public Theatre(String name, int rows, int cols) {
    this.name = name;

    char lastRow = (char) ('A' + (rows - 1));

    for (char row = 'A'; row <= lastRow; row++)
      for (int col = 1; col <= cols; col++) {
        String id = String.format("%s%02d", row, col);
        double price = 12d;

        if ((row < 'D') && (col >= 4 && col <= 9)) {
          price = 14.00;
        } else if ((row > 'F') || (col < 4 || col > 9)) {
          price = 7.00;
        }

        seats.add(new Seat(id, price));
      }
  }

  public String getName() {
    return name;
  }

  public List<Seat> getSeats() {
    return seats;
  }

  public void showSeats() {
    for (Seat s : seats)
      System.out.println(s);
  }

  public boolean reserveSeat(String seatId) {

    int reqSeatIdx = Collections.binarySearch(seats, new Seat(seatId, 0), null);
    if (reqSeatIdx < 0) {
      System.out.printf("Seat %s not found.\n", seatId);
      return false;
    }

    Seat reqSeat = seats.get(reqSeatIdx);

    if (reqSeat.isReserved()) {
      System.out.printf("Seat %s already reserved.\n", seatId);
      return false;
    }

    reqSeat.setReserved(true);
    System.out.printf("Seat %s successfully reserved.\n", seatId);

    return true;
  }
}
