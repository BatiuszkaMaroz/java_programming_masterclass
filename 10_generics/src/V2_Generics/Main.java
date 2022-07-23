package V2_Generics;

public class Main {
  public static void main(String[] args) {
    /*
     * Generics are parameterized types. The idea is to allow type (Integer,
     * String, … etc., and user-defined types) to be a parameter to methods,
     * classes, and interfaces.
     *
     * In example below instead of creating 3 different classess for each discipline
     * generics can be used.
     */

    // ============================================================

    /*
     * Without generics team accepts all types of players, its a nonsense.!
     * This code will run but can throw errors during compilation (!!!).
     */

    // Team team = new Team("The Firsts");

    // BaseballPlayer pat = new BaseballPlayer("Pat");
    // FootballPlayer joe = new FootballPlayer("Joe");
    // SoccerPlayer max = new SoccerPlayer("Max");

    // team.addPlayer(pat);
    // team.addPlayer(joe);
    // team.addPlayer(max);

    // ============================================================

    /*
     * With usage of generics only players of specific discpiline can be added to
     * team of specific discpiline.
     */

    BaseballPlayer alex = new BaseballPlayer("Alex");
    FootballPlayer john = new FootballPlayer("John");
    FootballPlayer xavier = new FootballPlayer("Xavier");

    Team<BaseballPlayer> team1 = new Team<>("The Firsts");
    Team<FootballPlayer> team2 = new Team<>("The Seconds");
    Team<FootballPlayer> team3 = new Team<>("The Thirds");

    team1.addPlayer(alex);
    team2.addPlayer(john);
    team3.addPlayer(xavier);

    // ERROR: teams are of different disciplines
    // team1.matchResult(t2, 0, 0);
    team2.matchResult(team3, 2, 3);
    team3.matchResult(team2, 2, 2);

    /*
     * Team class implements Comparable interface thats why we can use
     * compareTo() method.
     */

    if (team2.compareTo(team3) > 0)
      System.out.println(team2.getName() + " won!");
    else if (team2.compareTo(team3) < 0)
      System.out.println(team3.getName() + " won!");
    else
      System.out.println(team2.getName() + " and " + team3.getName() + " tied.");

    // ============================================================

    /*
     * compareTo() mathod also works on sorting.
     */

    // ArrayList<Team> teams = new ArrayList<>();
    // teams.add(t1);
    // teams.add(t2);
    // teams.add(t3);

    // Collections.sort(teams, Collections.reverseOrder());

    // ============================================================

    /*
     * Generics can be nested like that (but as far as I'm concerned that's not the
     * right way to do it).
     */

    League<Team<FootballPlayer>> premiereLeague = new League<>("Premiere League");

    // ERROR: team is of different discipline
    // premiereLeague.addTeam(team1);
    premiereLeague.addTeam(team2);
    premiereLeague.addTeam(team3);

    premiereLeague.showRanking();
  }
}
