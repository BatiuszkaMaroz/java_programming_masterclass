package V2_Generics;

import java.util.ArrayList;
import java.util.Collections;

/*
 * As far as I'm concerned that's not the right way to nest generics,
 * looking forward for Tim!
 */

public class League<T extends Team<? extends Player>> {
  private String name;
  private ArrayList<T> teams = new ArrayList<>();

  public League(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  private void updateRanking() {
    Collections.sort(teams, Collections.reverseOrder());
  }

  public boolean addTeam(T team) {
    if (teams.contains(team))
      return false;

    teams.add(team);
    updateRanking();

    return true;
  }

  public void showRanking() {
    int i = 1;
    for (T team : teams)
      System.out.printf("[%d] %s with ranking %d\n", i++, team.getName(), team.ranking());
  }
}
