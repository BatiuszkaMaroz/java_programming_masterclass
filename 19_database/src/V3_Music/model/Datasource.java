package V3_Music.model;

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
    NONE, ASC, DESC
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
   * In ResultSet we can use column names or indexes.
   * Indexes provide better performance, but is problematic when e.g. we add new
   * column between existsing columns.
   */
  public List<Artist> queryArtists() {
    return queryArtists(ORDER.NONE);
  }

  public List<Artist> queryArtists(ORDER order) {
    if (conn == null) {
      System.out.println("Connection not established");
      return null;
    }

    StringBuilder sql = new StringBuilder("SELECT * FROM ");
    sql.append(TABLE_ARTISTS);
    if (order != ORDER.NONE) {
      sql.append(" ORDER BY ");
      sql.append(COLUMN_ARTIST_NAME);
      sql.append(" COLLATE NOCASE ");

      if (order == ORDER.DESC)
        sql.append("DESC");
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

  public List<Album> queryAlbumsByArtist(String artistName) {
    return queryAlbumsByArtist(artistName, ORDER.NONE);
  }

  public List<Album> queryAlbumsByArtist(String artistName, ORDER order) {
    if (conn == null) {
      System.out.println("Connection not established");
      return null;
    }

    /*
     * SELECT albums.*
     * FROM albums
     * INNER JOIN artists ON albums.artist = artists._id
     * WHERE artists.name = 'Pink Floyd'
     * ORDER BY albums.name COLLATE NOCASE
     */

    StringBuilder sql = new StringBuilder();
    sql.append("SELECT ");
    sql.append(TABLE_ALBUMS);
    sql.append(".* ");
    sql.append("FROM ");
    sql.append(TABLE_ALBUMS);

    sql.append(" INNER JOIN ");
    sql.append(TABLE_ARTISTS);
    sql.append(" ON ");
    sql.append(TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST);
    sql.append(" = ");
    sql.append(TABLE_ARTISTS + "." + COLUMN_ARTIST_ID);
    sql.append(" WHERE ");
    sql.append(TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME);
    sql.append(" = ");
    sql.append("'" + artistName + "'");

    if (order != ORDER.NONE) {
      sql.append(" ORDER BY ");
      sql.append(COLUMN_ARTIST_NAME);
      sql.append(" COLLATE NOCASE ");

      if (order == ORDER.DESC)
        sql.append("DESC");
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

  public List<Artist> queryArtistsBySong(String songName) {
    if (conn == null) {
      System.out.println("Connection not established");
      return null;
    }

    /*
     * SELECT artists.* FROM artists
     * INNER JOIN albums ON albums.artist = artists._id
     * INNER JOIN songs ON songs.album = albums._id
     * WHERE songs.title = "Echoes"
     */

    StringBuilder sql = new StringBuilder();
    sql.append("SELECT " + TABLE_ARTISTS + ".* FROM " + TABLE_ARTISTS);

    sql.append(" INNER JOIN " + TABLE_ALBUMS + " ON ");
    sql.append(TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID);

    sql.append(" INNER JOIN " + TABLE_SONGS + " ON ");
    sql.append(TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID);

    sql.append(" WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = '" + songName + "'");

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

  public void querySongsMetadata() {
    String sql = "SELECT * FROM " + TABLE_SONGS;

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

}
