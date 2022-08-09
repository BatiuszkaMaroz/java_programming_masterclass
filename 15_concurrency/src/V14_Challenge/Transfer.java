package V14_Challenge;

public class Transfer implements Runnable {
  private BankAccount srcAcc, destAcc;
  private double amount;

  Transfer(BankAccount srcAcc, BankAccount destAcc, double amount) {
    this.srcAcc = srcAcc;
    this.destAcc = destAcc;
    this.amount = amount;
  }

  public void run() {
    while (!srcAcc.transfer(destAcc, amount))
      continue;

    System.out.printf("%s completed\n", Thread.currentThread().getName());
  }
}