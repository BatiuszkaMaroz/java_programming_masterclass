package V4_PreparedStatements.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Datasource {
  /*
   * Implementation with standard SQL string joining can lead to SQL Injection
   * attacks (e.g. WHERE = <param> can contain someting like
   * "' OR 1=1 OR '"
   * and then execution will list everything in table).
   *
   * To prevent SQL Injection attacks we use PreparedStatement.
   * They also benefit on performance because PreparedStatement's SQL is
   * precompiled and then only placeholders are being changed.
   *
   * Of course to profit on performance we have to initialize this statements only
   * once, the best place is after opening connection to database
   * (prepareStatements() method below).
   *
   * Using PreparedStatements is very beneficial when query will be executed
   * frequently (e.g. querying users), but it doesn't make sense to use it in
   * one-time executed queries (e.g. creating view).
   *
   * The "?" sign acts as placeholder. Only VALUES can be substituted (tables,
   * columns, etc. can't).
   */

  private Connection conn;
  private Scanner sc = new Scanner(System.in);

  private static final String DB_BASE = "jdbc:sqlite:/home/david/projects/java/java_programming_masterclass/19_database/db";
  private static final String DB_NAME = "music.db";
  private static final String DB_URL = DB_BASE + "/" + DB_NAME;

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

  private void prepareStatements() throws SQLException {
    queryArtistListStm = conn.prepareStatement(queryArtistListSQL);
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

  private static String createArtistListViewSQL = """
      CREATE VIEW IF NOT EXISTS artist_list AS
      SELECT
        artists.name,
        albums.name AS album,
        songs.track,
        songs.title
      FROM songs
      INNER JOIN albums ON albums._id = songs.album
      INNER JOIN artists ON artists._id = albums.artist
      ORDER BY artists.name, albums.name, songs.track
      """;

  public void createArtistListView() {
    try (Statement stm = conn.createStatement()) {
      stm.execute(createArtistListViewSQL);
    } catch (SQLException e) {
      System.out.println("query error: " + e.getMessage());
    }
  }

  /* ============================================================ */

  private PreparedStatement queryArtistListStm;
  private static String queryArtistListSQL = """
      SELECT
        name,
        album,
        track
      FROM artist_list
      WHERE title = ?
      """;

  public void queryArtistList() {
    System.out.println("Enter song title:");
    String songTitle = sc.nextLine();

    try {
      queryArtistListStm.setString(1, songTitle);
      ResultSet rs = queryArtistListStm.executeQuery();

      while (rs.next())
        System.out.println(""
            + rs.getString(1) + " : "
            + rs.getString(2) + " : "
            + rs.getInt(3));

    } catch (SQLException e) {
      System.out.println("query error: " + e.getMessage());
      return;
    }
  }
}
