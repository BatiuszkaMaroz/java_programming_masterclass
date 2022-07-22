package V1_Interfaces;

public class Main {
  /*
   * interfaces is a abstract type used to specify the behavior of a class
   * they defina a contract between class and outside world
   * ---
   * if we change something (e.g. method) in class it can break app
   * interface is commitment that we'll stick to interface and will not change it
   *
   * many interfaces can be implemented
   * ---
   * mobile phone is way more than a telephone (more like PC these times)
   * but you still can use it as telephone, so it extends telephone interface
   */

  public static void main(String[] args) {
    ITelephone myPhone;

    System.out.println("=========");

    myPhone = new DeskPhone(123_456_789);
    myPhone.call(123_456_789);
    myPhone.powerOn();
    myPhone.call(123_456_789);

    System.out.println("=========");

    myPhone = new MobilePhone(987_654_321);
    myPhone.call(987_654_321);
    myPhone.powerOn();
    myPhone.call(987_654_321);

    System.out.println("=========");
  }
}
