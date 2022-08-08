package V2_IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * If you want to test errors create folder of same name as filename you want write to.
 */
public class Caretaker<T extends ISaveable> {
  private static final String FILENAME = "data/users.txt";
  private static final String TEMP_FILENAME = "data/users_temp.txt";

  private final T target;

  public Caretaker(T target) {
    this.target = target;
  }

  public T getTarget() {
    return target;
  }

  /*
   * Adding throws keyword in method declaration let us for not handling possible
   * exceptions in method, but it tells that these exceptions must be handled
   * outside method.
   *
   * You can append to file only on its end so to "prepend" a line, you have to
   * add new line to temp file, then rewrite content of input file to it and then
   * delete input file and rename temp file to input file.
   */
  public void backup() throws IOException {
    File inputFile = new File(FILENAME);
    File tempFile = new File(TEMP_FILENAME);

    /*
     * Try..finally block can be used if method throws exception so it has to
     * be handled outside method but we still want to execute some code in method.
     * After throwing exception, code in finally block will be executed and after
     * that, method will throw error outside.
     *
     * In normal try..finally LAST thrown exception is thrown back from method.
     */

    /*
     * BufferedReader/Writer is prefferred way to go if we do many read/write
     * operations. It has built-in buffer (in-memory) so unlike FileReader/Writer
     * it's not making I/O calls for every character but it minimizes the number of
     * I/O operations by reading/writing chunks of data which are stored inside
     * buffer.
     */
    try {
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

      String record = target.getId() + "," + target.getDataString();
      writer.write(record + System.getProperty("line.separator"));

      String line = "";
      while ((line = reader.readLine()) != null)
        writer.write(line + System.getProperty("line.separator"));

      reader.close();
      writer.close();
      inputFile.delete();
      tempFile.renameTo(inputFile);
    } finally {
      System.out.println("backup() finally block");
    }
  }

  public void undo() throws IOException {
    File inputFile = new File(FILENAME);
    File tempFile = new File(TEMP_FILENAME);

    /*
     * Try-resources handles file closing automatically if its arguments (or one
     * argument) implement Closeable interface. In try-resources catch/finally block
     * can also be used.
     *
     * In try-resources FIRST thrown exception is thrown back from method.
     */
    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));) {
      String line;

      while ((line = reader.readLine()) != null) {
        int idx = line.indexOf(",");
        int id = Integer.parseInt(line.substring(0, idx));

        if (id == target.getId()) {
          String dataString = line.substring(idx + 1);
          target.restoreFromDataString(dataString);
          break;
        }

        writer.write(line + System.getProperty("line.separator"));
      }

      while ((line = reader.readLine()) != null)
        writer.write(line + System.getProperty("line.separator"));

      inputFile.delete();
      tempFile.renameTo(inputFile);
    } catch (IOException e) {
      System.out.println("undo() catch block");
      throw e;
    } finally {
      System.out.println("undo() finally block");
    }
  }

  public void refresh() throws IOException {
    /*
     * You can use scanner for parsing capabilities. In scanner you can use
     * BufferedReader too for less I/O operations.
     */
    try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(FILENAME)))) {
      scanner.useDelimiter(",");

      while (scanner.hasNextInt()) {
        int id = scanner.nextInt();
        scanner.skip(",");
        String dataString = scanner.nextLine();

        if (id == target.getId()) {
          target.restoreFromDataString(dataString);
          return;
        }
      }

      System.out.println("user not found");
    }
  }
}
