package V5_Prepared_And_Transactions;

import java.sql.SQLException;

import V5_Prepared_And_Transactions.model.Datasource;

public class Main {
  /*
   * Transaction is a sequence of SQL statements treated as a single unit of
   * execution. If any of the statements fail, results of previous statements will
   * be rolled back (or not saved).
   *
   * Commit - save operation to database.
   *
   * Db transactions must be ACID-compliant:
   * A - Atomicity, treating multiple statements as a single operation.
   * C - Consistency, database is in valid state BEFORE and AFTER transaction.
   * I - Isolation, changes won't be visible to other connections until
   * transaction will finish.
   * D - Durability, once changes from transaction are committed to database.
   * they're permament (even if application crash or db connection will be lost).
   *
   * We use transactions only when changing data in database so in INSERT, UPDATE,
   * DELETE operations.
   *
   * Transactions commands:
   * - BEGIN TRANSACTION
   * - END TRANSACTION
   * - COMMIT
   * - ROLLBACK
   *
   * If connection is lost during transaction, changes are rolled back.
   */

  public static void main(String[] args) {
    Datasource ds = new Datasource();

    ds.open();

    try {
      ds.insertSong("Labamba Bearing", 69, "Labamba Bearing", "Labamba Bearing");
    } catch (SQLException e) {
      System.out.println("Song insertion error.");
    }

    ds.close();
  }
}
