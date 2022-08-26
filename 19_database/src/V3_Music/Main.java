package V3_Music;

import java.util.List;

import V3_Music.model.Album;
import V3_Music.model.Artist;
import V3_Music.model.Datasource;
import V3_Music.model.Datasource.ORDER;;

public class Main {
  /*
   * Tim Buchalka said to extract parts of SQL statements that do not change to
   * separate static variables. It's good idea in terms of performance!!! Because
   * less new strings are being created during querying. However I didn't have
   * time for it :p
   *
   * The idea is like:
   * String sql = SQL_PART_1 + <my_param> + SQL_PART_2 + ...
   */
  public static void main(String[] args) {
    Datasource ds = new Datasource();

    if (!ds.open())
      return;

    List<Artist> artists = ds.queryArtists(ORDER.DESC);
    for (int i = 0; i < 10; i++)
      System.out.println(artists.get(i).getName());

    /* ================================================== */ System.out.println("");

    List<Album> albums = ds.queryAlbumsByArtist("Pink Floyd", ORDER.ASC);
    for (Album elm : albums)
      System.out.println(elm.getName());

    /* ================================================== */ System.out.println("");

    artists = ds.queryArtistsBySong("Fire");
    for (Artist elm : artists)
      System.out.println(elm.getName());

    /* ============================================================ */ System.out.println("");

    ds.querySongsMetadata();

    /* ============================================================ */ System.out.println("");

    System.out.println(ds.getCount(Datasource.TABLE_ALBUMS));
    System.out.println(ds.getCount(Datasource.TABLE_ARTISTS));
    System.out.println(ds.getCount(Datasource.TABLE_SONGS));

    /* ============================================================ */ System.out.println("");

    ds.close();
  }
}