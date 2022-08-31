package V1_Intro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

  /*
   * JDBC - Java DataBase Connectivity.
   * All JDBC drivers implement the same interface so if we want to change
   * database all we have to do is to use another driver (of course it's not
   * always 100% portable).
   *
   * When application is finish, connection, statements and result sets has to be
   * closed to avoid memory leaks.
   *
   * Closing Connection closes all Statements (and prepared statements).
   * Closing Statement closes ResultsSet associated with it.
   *
   * However it's good to close Statements explicitly.
   */

  static final String DB_BASE_PATH = "jdbc:sqlite:/home/david/projects/java/java_programming_masterclass/19_database/db";
  static final String DB_NAME = "main.db";
  static final String DB_URL = DB_BASE_PATH + "/" + DB_NAME;

  public static void main(String[] args) throws Exception {
    try (Connection conn = DriverManager.getConnection(DB_URL);
        Statement stm = conn.createStatement()) {

      stm.execute("""
            DROP TABLE IF EXISTS contacts;
          """);

      stm.execute("""
            CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)
          """);

      stm.execute("""
          INSERT INTO contacts (name, phone, email)
          VALUES (
            'Harold',
            111111111
            'harold@mail.com'
          );
          """);

      stm.execute("""
          UPDATE contacts
          SET phone = 999999999
          WHERE name = 'Harold'
          """);

      /* ================================================== */

      ResultSet rs;

      /*
       * There can be only one active ResultSet associated with one Statement.
       *
       * If we reuse Statement object to do another query then if ResultSet
       * associated with this Statement exist it will be closed and cannot be used
       * anymore.
       *
       * Closing statement, automatically closes ResultSet, so we don't have to do it
       * explicitly.
       */

      /*
       * There are two ways to get ResultsSet.
       */

      // #1

      stm.execute("""
          SELECT * FROM contacts;
          """);

      rs = stm.getResultSet();

      // #2

      rs = stm.executeQuery("""
            SELECT * FROM contacts;
          """);

      /*
       * We use cursor to loop through results. This cursor differs from Java's one,
       * e.g. it can only go forward.
       */

      while (rs.next())
        System.out.println("" +
            "name = " + rs.getString("name")
            + "\nphone = " + rs.getInt("phone")
            + "\nemail = " + rs.getString("email"));

      /* ================================================== */

      stm.execute("""
            DELETE FROM contacts
            WHERE name = 'Harold'
          """);

    } catch (SQLException e) {
      System.out.printf("Something went wrong: " + e.getMessage());
    }
  }
}
