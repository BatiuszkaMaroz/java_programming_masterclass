package challenges.C1_Bank;

/*
 * Finally is executed after return!
 */
public class Main {
  public static void main(String[] args) {
    BankAccount acc = new BankAccount("0000.0000.0001", 1000);
    System.out.println(acc);

    // anonymous thread
    // ==================================================

    // Thread t1 = new Thread() {
    // @Override
    // public void run() {
    // acc.deposit(300);
    // acc.withdraw(50);
    // }
    // };

    // Thread t2 = new Thread() {
    // @Override
    // public void run() {
    // acc.deposit(203.75);
    // acc.withdraw(100);
    // }
    // };

    // anonymous runnable
    // ==================================================

    // Thread t1 = new Thread(new Runnable() {
    // @Override
    // public void run() {
    // acc.deposit(300);
    // acc.withdraw(50);
    // }
    // });

    // Thread t2 = new Thread(new Runnable() {
    // @Override
    // public void run() {
    // acc.deposit(203.75);
    // acc.withdraw(100);
    // }
    // });

    // ==================================================

    // t1.start();
    // t2.start();

    // try {
    // t1.join();
    // t2.join();
    // System.out.println(acc);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }

    // ==================================================

    BankAccount acc1 = new BankAccount("12345-678", 500.00);
    BankAccount acc2 = new BankAccount("98765-432", 1000.00);

    for (int i = 0; i < 100; i++) {
      new Thread(new Transfer(acc1, acc2, 10.00), "Transfer1").start();
      new Thread(new Transfer(acc2, acc1, 55.88), "Transfer2").start();
    }
  }
}
