import com.dawidprajzner.HelloPrinter;
import com.dawidprajzner.GoodbyePrinter;

public class V3_ExportJar {
  public static void main(String[] args) {

    /*
     * Using "Export Jar" button at "Java Projects" view you can export
     * your project as a .jar file (.jar files are java archives in zip format)
     *
     * Then move this newly created library (.jar file) to "lib/" folder and it'll
     * become accessible in project.
     *
     * ALternatively you can use
     * "Java Project -> Referenced Libraries -> Add Jar Libraries..."
     * but this will only add link in ".vscode/settings.json" so in IntelliJ it
     * won't work. So use first approach.
     */

    HelloPrinter h = new HelloPrinter();
    GoodbyePrinter g = new GoodbyePrinter();

    h.hello();
    g.goodbye();
  }
}
