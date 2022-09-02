import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class V1_URL_URI {
  public static void main(String[] args) {

    /*
     * We have:
     * - base uri,
     * - relative uri,
     * - resolved uri (base + relative)
     */

    try {
      // URI uri = new
      // URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
      // URI uri = new URI("hello");

      URI baseUri = new URI("http://username:password@myserver.com:5000");
      URI relUri = new URI("/catalogue/phones?os=android#samsung");
      URI resUri = baseUri.resolve(relUri);

      URL url = resUri.toURL();
      System.out.println("URL = " + url);

      System.out.println("Scheme = " + resUri.getScheme());
      System.out.println("Scheme-specific part = " + resUri.getSchemeSpecificPart());
      System.out.println("Authority = " + resUri.getAuthority());
      System.out.println("User info = " + resUri.getUserInfo());
      System.out.println("Host = " + resUri.getHost());
      System.out.println("Port = " + resUri.getPort());
      System.out.println("Path = " + resUri.getPath());
      System.out.println("Query = " + resUri.getQuery());
      System.out.println("Fragment = " + resUri.getFragment());

      /* ============================================================ */

      URI relUri1 = new URI("/catalogue/phones?os=android#samsung");
      URI relUri2 = new URI("/catalogue/tvs?os=android#samsung");
      URI relUri3 = new URI("/stores/locations?zip=1234");

      URI resUri1 = baseUri.resolve(relUri1);
      URI resUri2 = baseUri.resolve(relUri2);
      URI resUri3 = baseUri.resolve(relUri3);

      URL url1 = resUri1.toURL();
      System.out.println("url1 = " + url1);
      URL url2 = resUri2.toURL();
      System.out.println("url2 = " + url2);
      URL url3 = resUri3.toURL();
      System.out.println("url3 = " + url3);

      URI relativizedUri = baseUri.relativize(resUri1);
      System.out.println("relativized uri = " + relativizedUri);

    } catch (URISyntaxException e) {
      System.out.println("URI Bad Syntax: " + e.getMessage());
    } catch (MalformedURLException e) {
      System.out.println("URL Malformed: " + e.getMessage());
    }
  }
}
