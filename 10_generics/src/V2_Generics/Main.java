package V2_Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    /*
     * instead of creating 3 classess for each discipline
     * use generics !
     */

    /*
     * this code will work but can throw errors during compilation
     * because this team accepts all types of players, nonsense!
     */

    // BaseballPlayer pat = new BaseballPlayer("Pat");
    // FootballPlayer joe = new FootballPlayer("Joe");
    // SoccerPlayer max = new SoccerPlayer("Max");

    // Team t1 = new Team("The Firsts");
    // t1.addPlayer(pat);
    // t1.addPlayer(joe);
    // t1.addPlayer(max);

    // System.out.println(t1.playersCount());

    // ==============================

    BaseballPlayer alex = new BaseballPlayer("Alex");
    FootballPlayer john = new FootballPlayer("John");
    FootballPlayer xavier = new FootballPlayer("Xavier");

    Team<BaseballPlayer> t1 = new Team<>("The Firsts");
    Team<FootballPlayer> t2 = new Team<>("The Seconds");
    Team<FootballPlayer> t3 = new Team<>("The Thirds");

    t1.addPlayer(alex);
    t2.addPlayer(john);
    t3.addPlayer(xavier);

    // teams do not match !!!
    // t1.matchResult(t2, 0, 0);

    t2.matchResult(t3, 2, 3);
    t3.matchResult(t2, 2, 2);

    if (t2.compareTo(t3) > 0)
      System.out.println(t2.getName() + " won!");
    else if (t2.compareTo(t3) < 0)
      System.out.println(t3.getName() + " won!");
    else
      System.out.println(t2.getName() + " and " + t3.getName() + " tied.");

    // ==============================

    ArrayList<Team> teams = new ArrayList<>();
    teams.add(t1);
    teams.add(t2);
    teams.add(t3);

    Collections.sort(teams, Collections.reverseOrder());

    int i = 0;
    for (Team t : teams)
      System.out.println(++i + " place = " + t);
  }
}
