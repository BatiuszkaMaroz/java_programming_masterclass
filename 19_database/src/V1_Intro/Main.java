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
   */
  static final String DB_BASE = "jdbc:sqlite:/home/david/projects/java/java_programming_masterclass/19_database/db";
  static final String DB_NAME = "main.db";
  static final String DB_URL = DB_BASE + "/" + DB_NAME;

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
            'Robbie Willow',
            123123123,
            'rw@mail.com'
          );
          """);

      stm.execute("""
          UPDATE contacts
          SET phone = 111111111
          WHERE name = 'Robbie Willow'
          """);

      /* ================================================== */

      // stat.execute("""
      // SELECT * FROM contacts;
      // """);

      // ResultSet res = stat.getResultSet();

      ResultSet res = stm.executeQuery("""
            SELECT * FROM contacts;
          """);

      /*
       * There can be only one active ResultSet associated with one statement.
       *
       * If we reuse statement object to do a query then any ResultSet associated with
       * that statement is closed and cannot be used (even though its like assigned to
       * some variable).
       *
       * stat.execute("""
       * SELECT name FROM contacts;
       * """);
       *
       * Closing statement, automatically closes ResultSet.
       */

      while (res.next())
        System.out.println("name = " + res.getString("name")
            + "\nphone = " + res.getInt("phone")
            + "\nemail = " + res.getString("email"));

      res.close();

      /* ================================================== */

      stm.execute("""
            DELETE FROM contacts
            WHERE name = 'Robbie Willow'
          """);

    } catch (SQLException e) {
      System.out.printf("Something went wrong: " + e.getMessage());
    }
  }
}
