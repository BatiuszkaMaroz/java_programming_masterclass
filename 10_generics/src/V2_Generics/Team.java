package V2_Generics;

import java.util.ArrayList;

/*
 * Single generic type can extend one class and many interfaces.
 *
 * [syntax]
 * <T extends A & B & C>
 */

public class Team<T extends Player> implements Comparable<Team<T>> {
  private ArrayList<T> members = new ArrayList<T>();

  private String name;
  private int gamesPlayed = 0;
  private int wins = 0;
  private int loses = 0;
  private int ties = 0;

  public Team(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  /*
   * Method used in e.g. .compareTo(), Collections.sort().
   */

  @Override
  public int compareTo(Team<T> opponent) {
    return ranking() - opponent.ranking();
  }

  @Override
  public String toString() {
    return name;
  }

  public boolean addPlayer(T player) {
    if (members.contains(player)) {
      System.out.printf("Player already exists in %s team.\n", name);
      return false;
    }

    System.out.printf("Player added to %s team.\n", name);
    members.add(player);
    return true;
  }

  public int playersCount() {
    return members.size();
  }

  public void matchResult(Team<T> opponent, int teamScore, int opponentScore) {
    String message;
    gamesPlayed++;

    if (teamScore > opponentScore) {
      message = "won";
      wins++;
    } else if (teamScore < opponentScore) {
      message = "lost";
      loses++;
    } else {
      message = "tied";
      ties++;
    }

    if (opponent != null) {
      System.out.printf("%s %s to %s %d:%d.\n", name, message, opponent.getName(), teamScore, opponentScore);
      opponent.matchResult(null, opponentScore, teamScore);
    }
  }

  public int ranking() {
    return (wins * 2) + ties;
  }
}
