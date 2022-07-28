package V2_InnerClasses;

interface IBase {
  public void show();
}

class Base {
  public void show() {
    System.out.println("Hello from base class!");
  }

  public void hide() {
    System.out.println("Goodbye from base class!");
  }
}

public class Anonymous {
  public static void main(String[] args) {
    /*
     * subclass of specified type
     * it extends given class
     */

    Base extended = new Base() {
      @Override
      public void show() {
        System.out.println("Hello from extended anonymous class!");
      }
    };

    extended.show();
    extended.hide();

    /*
     * implementer of specified interface
     * it implements given interface
     */

    IBase implemented = new IBase() {
      @Override
      public void show() {
        System.out.println("Hello from implemented anonymous class!");
      }
    };

    implemented.show();

    /*
     * anonymous classes can extend/implement only one class/interface
     */
  }
}
