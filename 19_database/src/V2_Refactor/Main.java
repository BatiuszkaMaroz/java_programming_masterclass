package V2_Refactor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
  private static final String DB_BASE = "jdbc:sqlite:/home/david/projects/java/java_programming_masterclass/19_database/db";
  private static final String DB_NAME = "main.db";
  private static final String DB_URL = DB_BASE + "/" + DB_NAME;

  private static final String TABLE_CONTACTS = "contacts";
  private static final String COLUMN_NAME = "name";
  private static final String COLUMN_PHONE = "phone";
  private static final String COLUMN_EMAIL = "email";

  public static void insert(Statement stm, String name, int phone, String email) throws SQLException {
    stm.execute("""
        INSERT INTO %s (%s, %s, %s)
        VALUES (
          '%s',
          %d,
          '%s'
        );
        """.formatted(TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL, name, phone, email));
  }

  public static void main(String[] args) throws Exception {
    try (Connection conn = DriverManager.getConnection(DB_URL);
        Statement stm = conn.createStatement()) {
      stm.execute("""
            DROP TABLE IF EXISTS %s;
          """.formatted(TABLE_CONTACTS));

      stm.execute("""
            CREATE TABLE IF NOT EXISTS %s (%s TEXT, %s INTEGER, %s TEXT)
          """.formatted(TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL));

      insert(stm, "Robbie Willow", 123123123, "rw@mail.com");

      stm.execute("""
          UPDATE %s
          SET %s = 111111111
          WHERE %s = 'Robbie Willow'
          """.formatted(TABLE_CONTACTS, COLUMN_PHONE, COLUMN_NAME));

      /* ================================================== */

      ResultSet res = stm.executeQuery("""
            SELECT * FROM %s;
          """.formatted(TABLE_CONTACTS));

      while (res.next())
        System.out.println("name = " + res.getString(COLUMN_NAME)
            + "\nphone = " + res.getInt(COLUMN_PHONE)
            + "\nemail = " + res.getString(COLUMN_EMAIL));

      res.close();

      /* ================================================== */

      // stat.execute("""
      // DELETE FROM %s
      // WHERE %s = 'Robbie Willow'
      // """.formatted(TABLE_CONTACTS, COLUMN_NAME));

    } catch (SQLException e) {
      System.out.printf("Something went wrong: " + e.getMessage());
    }
  }
}
