package V2_Interface;

public class Operator {
  private String execute(DoubleOperation<String> op, String arg1, String arg2) {
    return op.operation(arg1, arg2);
  }

  public String classOrder(String str1, String str2) {
    DoubleOperation<String> op = new DoubleOperation<String>() {
      @Override
      public String operation(String arg1, String arg2) {
        System.out.println("anonymous class name = " + getClass().getSimpleName());
        return arg1.toUpperCase() + " " + arg2.toUpperCase();
      };
    };

    return execute(op, str1, str2);
  }

  public String lambdaOrder(String str1, String str2) {
    DoubleOperation<String> op = (arg1, arg2) -> {
      System.out.println("lambda class name = " + getClass().getSimpleName());
      return arg1.toUpperCase() + " " + arg2.toUpperCase();
    };

    return execute(op, str1, str2);
  }
}
