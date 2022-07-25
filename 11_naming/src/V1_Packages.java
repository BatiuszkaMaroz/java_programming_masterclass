import java.nio.file.DirectoryStream.Filter;

public class V1_Packages {
  public static void main(String[] args) {
    /*
     * If you want to use many classes that have equal names you have to refer to
     * them using entire path.
     */

    java.util.logging.Filter filter1 = null;
    javax.imageio.spi.ServiceRegistry.Filter filter2 = null;

    /*
     * Only one class of the same name can be imported.
     */

    Filter filter3 = null;
  }
}
