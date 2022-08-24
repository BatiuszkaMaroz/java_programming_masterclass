package V3_Music;

import java.util.List;

import V3_Music.model.Artist;
import V3_Music.model.Datasource;

public class Main {
  public static void main(String[] args) {
    Datasource ds = new Datasource();

    if (!ds.open())
      return;

    List<Artist> artists = ds.queryArtists();

    for (int i = 0; i < 10; i++)
      System.out.println(artists.get(i).getName());

    ds.close();
  }
}