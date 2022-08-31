package V5_Prepared_And_Transactions.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

  /* ============================================================ */

  public boolean open() {
    try {
      conn = DriverManager.getConnection(DB_URL);
      prepareStatements();
    } catch (SQLException e) {
      System.out.println("Connection open error: " + e.getMessage());
      return false;
    }

    return true;
  }

  public boolean close() {
    try {
      closeStatements();
      if (conn != null)
        conn.close();
    } catch (SQLException e) {
      System.out.println("Connection close error: " + e.getMessage());
      return false;
    }

    return true;
  }

  public void prepareStatements() throws SQLException {
    /*
     * Statement.RETURN_GENERATED_KEY will make us able to retrieve _id keys
     * generated for new records.
     */

    insertArtistStm = conn.prepareStatement(INSERT_ARTIST_SQL, Statement.RETURN_GENERATED_KEYS);
    insertAlbumStm = conn.prepareStatement(INSERT_ALBUM_SQL, Statement.RETURN_GENERATED_KEYS);
    insertSongStm = conn.prepareStatement(INSERT_SONG_SQL, Statement.RETURN_GENERATED_KEYS);

    selectArtistIdStm = conn.prepareStatement(SELECT_ARTIST_ID_SQL);
    selectAlbumIdStm = conn.prepareStatement(SELECT_ALBUM_ID_SQL);
    selectSongIdStm = conn.prepareStatement(SELECT_SONG_ID_SQL);
  }

  public void closeStatements() throws SQLException {
    if (insertArtistStm != null)
      insertArtistStm.close();
    if (insertAlbumStm != null)
      insertAlbumStm.close();
    if (insertSongStm != null)
      insertSongStm.close();

    if (selectArtistIdStm != null)
      selectArtistIdStm.close();
    if (selectAlbumIdStm != null)
      selectAlbumIdStm.close();
    if (selectSongIdStm != null)
      selectSongIdStm.close();
  }

  /* ============================================================ */

  private PreparedStatement insertArtistStm;
  private static final String INSERT_ARTIST_SQL = ""
      + "INSERT INTO " + TABLE_ARTISTS
      + "(" + COLUMN_ARTIST_NAME + ") VALUES(?)";

  private PreparedStatement selectArtistIdStm;
  private static final String SELECT_ARTIST_ID_SQL = ""
      + "SELECT " + COLUMN_ARTIST_ID + " FROM " + TABLE_ARTISTS
      + " WHERE " + COLUMN_ARTIST_NAME + " = ?";

  private int insertArtist(String artistName) throws SQLException {
    selectArtistIdStm.setString(1, artistName);

    try (ResultSet rs = selectArtistIdStm.executeQuery()) {
      if (rs.next())
        return rs.getInt(COLUMN_ARTIST_ID);
    }

    insertArtistStm.setString(1, artistName);
    int affectedRows = insertArtistStm.executeUpdate();

    if (affectedRows != 1)
      throw new SQLException("Error: Artist not inserted.");

    try (ResultSet rs = insertArtistStm.getGeneratedKeys()) {
      if (rs.next())
        return rs.getInt(1);
      else
        throw new SQLException("Error: Couldn't get _id for artist.");
    }
  }

  /* ============================================================ */

  private PreparedStatement insertAlbumStm;
  private static final String INSERT_ALBUM_SQL = ""
      + "INSERT INTO " + TABLE_ALBUMS
      + "(" + COLUMN_ALBUM_NAME + "," + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";

  private PreparedStatement selectAlbumIdStm;
  private static final String SELECT_ALBUM_ID_SQL = ""
      + "SELECT " + COLUMN_ALBUM_ID + " FROM " + TABLE_ALBUMS
      + " WHERE " + COLUMN_ALBUM_NAME + " = ?"
      + " AND " + COLUMN_ALBUM_ARTIST + " = ?";

  private int insertAlbum(String albumName, int artistId) throws SQLException {
    selectAlbumIdStm.setString(1, albumName);
    selectAlbumIdStm.setInt(2, artistId);

    try (ResultSet rs = selectAlbumIdStm.executeQuery()) {
      if (rs.next())
        return rs.getInt(COLUMN_ALBUM_ID);
    }

    insertAlbumStm.setString(1, albumName);
    insertAlbumStm.setInt(2, artistId);
    int affectedRows = insertAlbumStm.executeUpdate();

    if (affectedRows != 1)
      throw new SQLException("Error: Album not inserted.");

    try (ResultSet rs = insertAlbumStm.getGeneratedKeys()) {
      if (rs.next())
        return rs.getInt(1);
      else
        throw new SQLException("Error: Couldn't get _id for album.");
    }
  }

  /* ============================================================ */

  /*
   * Catch all exceptions and perform rollback.
   * Setting auto commit to true will automatically perform commit()
   */

  private PreparedStatement insertSongStm;
  private static final String INSERT_SONG_SQL = ""
      + "INSERT INTO " + TABLE_SONGS
      + "("
      + COLUMN_SONG_TITLE + "," + COLUMN_SONG_TRACK + "," + COLUMN_SONG_ALBUM
      + ") VALUES(?, ?, ?)";

  private PreparedStatement selectSongIdStm;
  private static final String SELECT_SONG_ID_SQL = ""
      + "SELECT " + COLUMN_SONG_ID + " FROM " + TABLE_SONGS
      + " WHERE " + COLUMN_SONG_TITLE + " = ?"
      + " AND " + COLUMN_SONG_ALBUM + " = ?";

  public void insertSong(
      String songTitle,
      int track,
      String artistName,
      String albumName) throws SQLException {
    try {
      conn.setAutoCommit(false);

      int artistId = insertArtist(artistName);
      int albumId = insertAlbum(albumName, artistId);

      /*
       * You can rollback to specific savepoint.
       */
      // Savepoint s = conn.setSavepoint();
      // conn.rollback(s);

      insertSongStm.setString(1, songTitle);
      insertSongStm.setInt(2, track);
      insertSongStm.setInt(3, albumId);

      int affectedRows = insertSongStm.executeUpdate();

      if (affectedRows == 1)
        conn.commit();
      else
        throw new SQLException("Error: Song not inserted.");

    } catch (Exception e1) {
      System.out.println("Error: Insert song exception: " + e1.getMessage());

      try {
        System.out.println("Performing rollback.");
        conn.rollback();
      } catch (SQLException e2) {
        System.out.println("Error: Rollback exception: " + e2.getMessage());
      }
    } finally {
      conn.setAutoCommit(true);
    }
  }
}
