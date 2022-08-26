package V4_PreparedStatements;

import V4_PreparedStatements.model.Datasource;

public class Main {
  public static void main(String[] args) {
    Datasource ds = new Datasource();

    if (!ds.open())
      return;

    ds.createArtistListView();

    ds.queryArtistList();
    ds.queryArtistList();
    ds.queryArtistList();

    ds.close();
  }
}