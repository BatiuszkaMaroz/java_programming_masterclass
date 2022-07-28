package V2_Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Theatre t1 = new Theatre("Bugatti Park", 8, 12);

    t1.reserveSeat("D01");
    t1.reserveSeat("D01");
    t1.reserveSeat("D02");

    // t1.showSeats();

    // ==================================================

    List<Seat> priceSeats = new ArrayList<>(t1.getSeats());

    Collections.sort(priceSeats, Theatre.PRICE_ORDER);

    System.out.println(Arrays.toString(priceSeats.toArray()).replace(", ", "\n"));

    /*
     * We can also use anonymous comparator.
     */

    Collections.sort(priceSeats, new Comparator<Seat>() {
      @Override
      public int compare(Seat o1, Seat o2) {
        if (o1.getPrice() < o2.getPrice())
          return -1;
        else if (o1.getPrice() == o2.getPrice())
          return 0;
        else
          return 1;
      }
    });
  }
}