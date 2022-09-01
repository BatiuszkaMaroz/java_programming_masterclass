package V3_Streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
  private static final String FILENAME = "data.txt";

  /*
   * We can write data in binary format using DataOutputStream and read from
   * binary format using DataInputStream.
   *
   * These streams are used for reading byte-oriented data (streams of raw bytes)
   * such as image data, audio, video etc. You can also read character-stream
   * data. But, for reading streams of characters, it is recommended to use
   * FileReader class.
   */

  public static void main(String[] args) {
    Map<String, Integer> data = new HashMap<>();
    data.put("kilometer", 1000);
    data.put("mile", 1609);
    data.put("nautical_mile", 1852);

    try {
      write(data);
      data = read();

      for (Entry<String, Integer> elm : data.entrySet())
        System.out.println(elm.getKey() + ":" + elm.getValue());

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void write(Map<String, Integer> data) throws IOException {
    try (DataOutputStream output = new DataOutputStream(
        new BufferedOutputStream(new FileOutputStream(FILENAME)))) {

      for (Entry<String, Integer> elm : data.entrySet()) {
        output.writeUTF(elm.getKey());
        output.writeInt(elm.getValue());
      }
    }
  }

  public static Map<String, Integer> read() throws IOException {
    Map<String, Integer> res = new HashMap<>();

    try (DataInputStream input = new DataInputStream(
        new BufferedInputStream(new FileInputStream(FILENAME)))) {

      try {
        while (true) {
          String key = input.readUTF();
          int value = input.readInt();

          res.put(key, value);
        }
      } catch (EOFException e) {
        System.out.println("EOF");
      }
    }

    return res;
  }
}