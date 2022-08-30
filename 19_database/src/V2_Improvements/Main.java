package V2_Improvements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
  private static final String DB_BASE = "jdbc:sqlite:/home/david/projects/java/java_programming_masterclass/19_database/db";
  private static final String DB_NAME = "main.db";
  private static final String DB_URL = DB_BASE + "/" + DB_NAME;

  /*
   * Sadly there is no very elegant way to build SQL query strings in Java.
   * However you should stick to these rules:
   *
   * 1. For parts of SQL statements that won't change you should go for static
   * variables. Static because they will be created only once, no matter how many
   * datasource instances we have. While constructing them you can use string
   * concatenation (+) or eventually formatting (format()/formatted()) because
   * string will be compiled only one time, the performance impact shouldn't be
   * significant.
   *
   * 2. For parts of SQL statements that will be different during queries you
   * should use string concatenation (+) only, because formatting impact on
   * performance can be significant.
   *
   * 3. Names of tables, columns, views, etc. should be easy to modify and be
   * placed in e.g. static variables. This is correct with DRY principle and can
   * be very profitable if something will change in database structure (e.g.
   * when column name change in database, we only change value of one variable,
   * not string values all across whole project).
   */

  private static final String TABLE_CONTACTS = "contacts_lol";
  private static final String COLUMN_CONTACTS_NAME = "xxx_name_xxx";
  private static final String COLUMN_CONTACTS_PHONE = "_phone";
  private static final String COLUMN_CONTACTS_EMAIL = "email_email";
  private static final int INDEX_CONTACTS_NAME = 1;
  private static final int INDEX_CONTACTS_PHONE = 2;
  private static final int INDEX_CONTACTS_EMAIL = 3;

  private static final String DROP_CONTACTS_TABLE_SQL = "DROP TABLE IF EXISTS " + TABLE_CONTACTS;
  private static final String CREATE_CONTACTS_TABLE_SQL = ""
      + "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS
      + " ( "
      + COLUMN_CONTACTS_NAME + " TEXT, "
      + COLUMN_CONTACTS_PHONE + " INTEGER,"
      + COLUMN_CONTACTS_EMAIL + " TEXT "
      + " ) ";

  private static final String SELECT_ALL_CONTACTS_SQL = "SELECT * FROM " + TABLE_CONTACTS;
  private static final String INSERT_INTO_CONTACTS_SQL_START = ""
      + "INSERT INTO " + TABLE_CONTACTS
      + " ( "
      + COLUMN_CONTACTS_NAME + ", "
      + COLUMN_CONTACTS_PHONE + ", "
      + COLUMN_CONTACTS_EMAIL
      + " ) ";

  public static void main(String[] args) throws Exception {
    try (Connection conn = DriverManager.getConnection(DB_URL);
        Statement stm = conn.createStatement()) {

      stm.execute(DROP_CONTACTS_TABLE_SQL);
      stm.execute(CREATE_CONTACTS_TABLE_SQL);

      stm.execute(INSERT_INTO_CONTACTS_SQL_START + " VALUES('Harold', 111222333, 'harold@mail.com') ");

      /*
       * In ResultSet we can use column names or indexes.
       * Indexes provide better performance, but it can be problematic when e.g. we
       * add new column in table that sits between two existsing columns.
       *
       * !!!
       * Indexing literally ANYTHING in JDBC always starts with 1 (for some stupid
       * sql-mathematic reason...).
       * !!!
       *
       */

      ResultSet rs;

      rs = stm.executeQuery(SELECT_ALL_CONTACTS_SQL);
      while (rs.next())
        System.out.println(""
            + "name = " + rs.getString(COLUMN_CONTACTS_NAME)
            + "\nphone = " + rs.getInt(COLUMN_CONTACTS_PHONE)
            + "\nemail = " + rs.getString(COLUMN_CONTACTS_EMAIL));

      rs = stm.executeQuery(SELECT_ALL_CONTACTS_SQL);
      while (rs.next())
        System.out.println(""
            + "name = " + rs.getString(INDEX_CONTACTS_NAME)
            + "\nphone = " + rs.getInt(INDEX_CONTACTS_PHONE)
            + "\nemail = " + rs.getString(INDEX_CONTACTS_EMAIL));

    } catch (SQLException e) {
      System.out.printf("Something went wrong: " + e.getMessage());
    }
  }
}
