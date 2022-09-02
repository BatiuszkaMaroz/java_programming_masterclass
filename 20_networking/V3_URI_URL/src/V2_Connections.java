import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class V2_Connections {
  public static void option1() {
    try {
      URL url = new URL("http://example.org");

      try (BufferedReader inputStream = new BufferedReader(
          new InputStreamReader(url.openStream()))) {

        String line;
        while ((line = inputStream.readLine()) != null)
          System.out.println(line);

      }
    } catch (MalformedURLException e) {
      System.out.println("URL Malformed: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO Error: " + e.getMessage());
    }
  }

  public static void option2() {
    try {
      URL url = new URL("http://example.org");

      /*
       * Between opening and actual connecting, some additional configuration can be
       * done.
       */
      URLConnection conn = url.openConnection();
      // urlConn.setDoOutput(true);
      conn.connect();

      try (BufferedReader inputStream = new BufferedReader(
          new InputStreamReader(conn.getInputStream()))) {

        Map<String, List<String>> headers = conn.getHeaderFields();
        for (Map.Entry<String, List<String>> elm : headers.entrySet()) {
          System.out.println(elm.getKey() + " : " + elm.getValue());
        }

        String line;
        while ((line = inputStream.readLine()) != null)
          System.out.println(line);

      }

    } catch (MalformedURLException e) {
      System.out.println("URL Malformed: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO Error: " + e.getMessage());
    }
  }

  /*
   * HttpURLConnection is subclass of URLConnection class. It has some additional
   * features that are useful during working with http requests.
   */
  public static void option3() {
    try {
      URL url = new URL("http://example.org/pezet");

      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("User-Agent", "Chrome");
      conn.setReadTimeout(10000);
      conn.connect();

      int resCode = conn.getResponseCode();
      System.out.println("res code = " + resCode);

      if (resCode != 200) {
        System.out.println("Error reading web page: " + conn.getResponseMessage());
        return;
      }

      try (BufferedReader inputStream = new BufferedReader(
          new InputStreamReader(conn.getInputStream()))) {

        String line;
        while ((line = inputStream.readLine()) != null)
          System.out.println(line);

      }
    } catch (MalformedURLException e) {
      System.out.println("URL Malformed: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO Error: " + e.getMessage());
    }
  }

  public static void main(String[] args) {

    // option1();
    // option2();
    option3();
  }
}
