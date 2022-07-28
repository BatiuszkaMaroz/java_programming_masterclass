package V2_InnerClasses;

class OuterA {
  private String name;

  public OuterA(String name) {
    this.name = name;
  }

  public void show() {
    System.out.println("Hello from outer class!");
  }

  class Inner {
    /*
     * nested class have access to all enclosing class members (incl. private)
     *
     * use Outer.this to access enclosing class members
     */

    public void show() {
      System.out.println("Hello from inner class!");
      OuterA.this.show();
    }

    public void printOuterName() {
      System.out.println("Outer class name = " + OuterA.this.name + ".");
    }
  }
}

public class ClassNested {
  public static void main(String[] args) {
    OuterA outer = new OuterA("Arthur");
    OuterA.Inner inner = outer.new Inner();

    /*
     * inner class is implicitly associated with an object of its outer class
     *
     * below line will never work
     * Outer.Inner inner = new Outer.Inner();
     */

    inner.show();
    inner.printOuterName();
  }
}
