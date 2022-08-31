package V3_Complex_Example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
  public static final int INDEX_ARTIST_ID = 1;
  public static final int INDEX_ARTIST_NAME = 2;

  public static final String TABLE_ALBUMS = "albums";
  public static final String COLUMN_ALBUM_ID = "_id";
  public static final String COLUMN_ALBUM_NAME = "name";
  public static final String COLUMN_ALBUM_ARTIST = "artist";
  public static final int INDEX_ALBUM_ID = 1;
  public static final int INDEX_ALBUM_NAME = 2;
  public static final int INDEX_ALBUM_ARTIST = 3;

  public static final String TABLE_SONGS = "songs";
  public static final String COLUMN_SONG_ID = "_id";
  public static final String COLUMN_SONG_TITLE = "title";
  public static final String COLUMN_SONG_TRACK = "track";
  public static final String COLUMN_SONG_ALBUM = "album";
  public static final int INDEX_SONG_ID = 1;
  public static final int INDEX_SONG_TITLE = 2;
  public static final int INDEX_SONG_TRACK = 3;
  public static final int INDEX_SONG_ALBUM = 4;

  public enum ORDER {
    NONE(""),
    ASC("ASC"),
    DESC("DESC");

    private String SQL;

    ORDER(String SQL) {
      this.SQL = SQL;
    }

    public String getSQL() {
      return SQL;
    }
  }

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

  /* ============================================================ */

  /*
   * SELECT * FROM artists
   * ORDER BY name ASC
   */

  private static final String QUERY_ARTISTS_SQL = "SELECT * FROM " + TABLE_ARTISTS;
  private static final String QUERY_ARTISTS_SQL_ORDER = " ORDER BY " + COLUMN_ARTIST_NAME + " ";

  public List<Artist> queryArtists() {
    return queryArtists(ORDER.NONE);
  }

  public List<Artist> queryArtists(ORDER order) {
    if (conn == null) {
      System.out.println("Connection not established");
      return null;
    }

    StringBuilder sql = new StringBuilder(QUERY_ARTISTS_SQL);
    if (order != ORDER.NONE) {
      sql.append(QUERY_ARTISTS_SQL_ORDER);
      sql.append(order.getSQL());
    }

    List<Artist> list = new ArrayList<>();
    try (Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql.toString())) {

      while (rs.next()) {
        Artist elm = new Artist();
        elm.setId(rs.getInt(INDEX_ARTIST_ID));
        elm.setName(rs.getString(INDEX_ARTIST_NAME));

        list.add(elm);
      }
    } catch (SQLException e) {
      System.out.println("Query artists error: " + e.getMessage());
      return null;
    }

    return list;
  }

  /* ============================================================ */

  /*
   * SELECT albums.*
   * FROM albums
   * INNER JOIN artists ON albums.artist = artists._id
   * WHERE artists.name = 'Pink Floyd'
   * ORDER BY albums.name
   */

  private static final String QUERY_ALBUMS_BY_ARTIST_SQL = ""
      + "SELECT " + TABLE_ALBUMS + ".* FROM " + TABLE_ALBUMS
      + " INNER JOIN " + TABLE_ARTISTS + " ON "
      + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID
      + " WHERE "
      + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + " = ";
  private static final String QUERY_ALBUMS_BY_ARTIST_SQL_ORDER = " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME
      + " ";

  public List<Album> queryAlbumsByArtist(String artistName) {
    return queryAlbumsByArtist(artistName, ORDER.NONE);
  }

  public List<Album> queryAlbumsByArtist(String artistName, ORDER order) {
    if (conn == null) {
      System.out.println("Connection not established");
      return null;
    }

    StringBuilder sql = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_SQL);
    sql.append("'");
    sql.append(artistName);
    sql.append("'");

    if (order != ORDER.NONE) {
      sql.append(QUERY_ALBUMS_BY_ARTIST_SQL_ORDER);
      sql.append(order.getSQL());
    }

    List<Album> list = new ArrayList<>();
    try (Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql.toString())) {

      while (rs.next()) {
        Album elm = new Album();
        elm.setId(rs.getInt(INDEX_ALBUM_ID));
        elm.setName(rs.getString(INDEX_ALBUM_NAME));
        elm.setArtistId(rs.getInt(INDEX_ALBUM_ARTIST));

        list.add(elm);
      }

    } catch (SQLException e) {
      System.out.println("Query albums error: " + e.getMessage());
      return null;
    }

    return list;
  }

  /* ============================================================ */

  /*
   * SELECT artists.* FROM artists
   * INNER JOIN albums ON albums.artist = artists._id
   * INNER JOIN songs ON songs.album = albums._id
   * WHERE songs.title = "Echoes"
   */

  private static final String QUERY_ARTIST_BY_SONG_SQL = ""
      + "SELECT " + TABLE_ARTISTS + ".* FROM " + TABLE_ARTISTS
      + " INNER JOIN " + TABLE_ALBUMS + " ON "
      + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID
      + " INNER JOIN " + TABLE_SONGS + " ON "
      + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID
      + " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = ";

  public List<Artist> queryArtistsBySong(String songName) {
    if (conn == null) {
      System.out.println("Connection not established");
      return null;
    }

    StringBuilder sql = new StringBuilder(QUERY_ARTIST_BY_SONG_SQL);
    sql.append("'");
    sql.append(songName);
    sql.append("'");

    List<Artist> list = new ArrayList<>();
    try (Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql.toString())) {

      while (rs.next()) {
        Artist elm = new Artist();
        elm.setId(rs.getInt(INDEX_ARTIST_ID));
        elm.setName(rs.getString(INDEX_ARTIST_NAME));

        list.add(elm);
      }

    } catch (SQLException e) {
      System.out.println("Query artists error: " + e.getMessage());
      return null;
    }

    return list;
  }

  /* ============================================================ */

  private static final String QUERY_SONGS_SQL = "SELECT * FROM " + TABLE_SONGS;

  public void querySongsMetadata() {
    String sql = QUERY_SONGS_SQL;

    try (Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql)) {

      ResultSetMetaData meta = rs.getMetaData();
      for (int i = 1; i <= meta.getColumnCount(); i++) {
        System.out.printf("Column %d in the songs table is named %s\n",
            i, meta.getColumnName(i));
      }

    } catch (SQLException e) {
      System.out.println("Query songs metadata error: " + e.getMessage());
      return;
    }
  }

  /* ============================================================ */

  private static final String TABLE_ROW_COUNT_SQL = "SELECT COUNT(*) AS count, MAX(_id) AS max_id FROM ";

  public int getTableRowCount(String tableName) {
    String sql = TABLE_ROW_COUNT_SQL + tableName;

    int count;
    try (Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql)) {

      count = rs.getInt(1);
      System.out.println("COUNT = " + rs.getInt(1) + " MAX_ID = " + rs.getInt(2));

    } catch (SQLException e) {
      System.out.println("Query for counting error: " + e.getMessage());
      count = -1;
    }

    return count;
  }
}
