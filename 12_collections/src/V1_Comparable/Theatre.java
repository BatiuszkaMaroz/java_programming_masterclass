package V1_Comparable;

import java.util.*;

public class Theatre {
  private final String name;
  private List<Seat> seats = new ArrayList<>();

  // private Collection<Seat> seats = new ArrayList<>();
  // private Collection<Seat> seats = new HashSet<>();
  // private Collection<Seat> seats = new LinkedHashSet<>();

  public Theatre(String name, int rows, int cols) {
    this.name = name;

    char lastRow = (char) ('A' + (rows - 1));

    for (char row = 'A'; row <= lastRow; row++)
      for (int col = 1; col <= cols; col++)
        seats.add(new Seat(String.format("%s%02d", row, col)));
  }

  public String getName() {
    return name;
  }

  public List<Seat> getSeats() {
    return seats;
  }

  public void showSeats() {
    for (Seat s : seats)
      System.out.println(s.getId());
  }

  public boolean reserveSeatBinary(String seatId) {
    /*
     * Binary search takes object that type is type of array element and compares
     * against it. It returns index.
     */

    int reqSeatIdx = Collections.binarySearch(seats, new Seat(seatId), null);
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

  public boolean reserveSeatLinear(String seatId) {
    Seat reqSeat = null;

    for (Seat s : seats) {
      System.out.print(".");
      if (s.getId().equals(seatId)) {
        reqSeat = s;
        break;
      }
    }

    if (reqSeat == null) {
      System.out.printf("Seat %s not found.\n", seatId);
      return false;
    }

    if (reqSeat.isReserved()) {
      System.out.printf("Seat %s already reserved.\n", seatId);
      return false;
    }

    reqSeat.setReserved(true);
    System.out.printf("Seat %s successfully reserved.\n", seatId);

    return true;
  }
}
