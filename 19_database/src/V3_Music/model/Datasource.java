package V3_Music.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
  private Connection conn;

  private static final String DB_BASE = "jdbc:sqlite:/home/david/projects/java/java_programming_masterclass/19_database/db";
  private static final String DB_NAME = "music.db";
  private static final String DB_URL = DB_BASE + "/" + DB_NAME;

  public static final String TABLE_ARTISTS = "artists";
  public static final String COLUMN_ARTIST_ID = "_id";
  public static final String COLUMN_ARTIST_NAME = "name";

  public static final String TABLE_ALBUMS = "albums";
  public static final String COLUMN_ALBUM_ID = "_id";
  public static final String COLUMN_ALBUM_NAME = "name";
  public static final String COLUMN_ALBUM_ARTIST = "artist";

  public static final String TABLE_SONGS = "songs";
  public static final String COLUMN_SONG_ID = "_id";
  public static final String COLUMN_SONG_TITLE = "title";
  public static final String COLUMN_SONG_TRACK = "track";
  public static final String COLUMN_SONG_ALBUM = "album";

  public boolean open() {
    try {
      conn = DriverManager.getConnection(DB_URL);
    } catch (SQLException e) {
      System.out.println("Connection open error: " + e.getMessage());
      return false;
    }

    return true;
  }

  public boolean close() {
    try {
      if (conn != null)
        conn.close();
    } catch (SQLException e) {
      System.out.println("Connection close error: " + e.getMessage());
      return false;
    }

    return true;
  }

  public List<Artist> queryArtists() {
    if (conn == null) {
      System.out.println("Connection not established");
      return null;
    }

    List<Artist> res = new ArrayList<>();

    try (Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM " + TABLE_ARTISTS)) {

      while (rs.next()) {
        Artist a = new Artist();
        a.setId(rs.getInt(COLUMN_ARTIST_ID));
        a.setName(rs.getString(COLUMN_ARTIST_NAME));

        res.add(a);
      }
    } catch (SQLException e) {
      System.out.println("Query artists error: " + e.getMessage());
      return null;
    }

    return res;
  }
}
