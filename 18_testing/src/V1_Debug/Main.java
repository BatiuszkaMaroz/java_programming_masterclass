package V1_Debug;

public class Main {
  /*
   * Caveats:
   * - Downloaded libraries doesn't always provide us with source code needed for
   * debugging. Usually you can download 2 versions, with debug info and without.
   * For dev purposes use debug one, for prod use second one because of
   * performance.
   * - Debugging can be hard with threads.
   *
   * Pausing takes place on dot, so before highlighted line is executed.
   *
   * We can set watchers to watch variables or instance fields.
   * We can set breakpoints on variable read/write/access (run&debug -> variables
   * -> R-click -> Break on ...).
   * We can set breakpoints using F9.
   * We can set inline breakpoints using shift+F9.
   *
   * Debugger shows current value of variables inline.
   *
   * !!! COMMENT IT BETTER :P !!!
   * Debugger options:
   * - "Continue" - continue to next breakpoint.
   * - "Step Over" - make one line step forward.
   * - "Step Into" - method is about to be invoked, and you want to debug into
   * the code of that method, so the next step is to go into that method and
   * continue debugging step-by-step.
   * - "Step Out" - you're done debugging this method step-by-step, and you just
   * want the debugger to run the entire method until it returns as one entire
   * step.
   *
   * To continue executing just disconnect debugger with shift+F5.
   *
   * We have "run to cursor" what is it ?????
   *
   * In JS we have "step into target" and "add inline breakpoint" in context menu.
   */
  public static void main(String[] args) {
    StringUtilities utils = new StringUtilities();

    StringBuilder sb = new StringBuilder();
    while (sb.length() < 10) {
      utils.addChar(sb, 'a');
    }

    System.out.println(sb);

    /* ================================================== */ System.out.println("");

    String res = capitalize(lower(trim("  arnold  ")));

    System.out.printf(res);
  }

  public static String trim(String str) {
    return str.trim();
  }

  public static String capitalize(String str) {
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }

  public static String lower(String str) {
    return str.toLowerCase();
  }
}
