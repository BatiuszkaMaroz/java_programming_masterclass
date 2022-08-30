package V3_ComplexExample;

import java.util.List;

import V3_ComplexExample.model.Album;
import V3_ComplexExample.model.Artist;
import V3_ComplexExample.model.Datasource;
import V3_ComplexExample.model.Datasource.ORDER;

public class Main {
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

    System.out.println(ds.getTableRowCount(Datasource.TABLE_ALBUMS));
    System.out.println(ds.getTableRowCount(Datasource.TABLE_ARTISTS));
    System.out.println(ds.getTableRowCount(Datasource.TABLE_SONGS));

    /* ============================================================ */

    ds.close();
  }
}