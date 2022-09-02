import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

public class V3_Alternatives {
  public static void main(String[] args) {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet req = new HttpGet("http://example.org");
    req.addHeader("User-Agent", "Chrome");

    try (CloseableHttpResponse res = httpClient.execute(req)) {
      System.out.println("res code = " + res.getCode());

      try (BufferedReader input = new BufferedReader(
          new InputStreamReader(res.getEntity().getContent()))) {
        String line;
        while ((line = input.readLine()) != null)
          System.out.println(line);
      }
    } catch (MalformedURLException e) {
      System.out.println("URL Malformed: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO Error: " + e.getMessage());
    }

    try {
      httpClient.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}