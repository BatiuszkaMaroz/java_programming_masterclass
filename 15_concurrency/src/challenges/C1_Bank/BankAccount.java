package challenges.C1_Bank;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
  private String accountNumber;
  private double balance;

  private final ReentrantLock lock = new ReentrantLock();

  public BankAccount(String accountNumber, double initialBalance) {
    this.accountNumber = accountNumber;
    this.balance = initialBalance;
  }

  // synchronized method
  // ==================================================

  // public synchronized void deposit(double amount) {
  // balance += amount;
  // }

  // public synchronized void withdraw(double amount) {
  // balance -= amount;
  // }

  // synchronized statement
  // ==================================================

  // public void deposit(double amount) {
  // synchronized (this) {
  // balance += amount;
  // }
  // }

  // public void withdraw(double amount) {
  // synchronized (this) {
  // balance -= amount;
  // }
  // }

  // lock
  // ==================================================

  // public void deposit(double amount) {
  // lock.lock();
  // try {
  // balance += amount;
  // } finally {
  // lock.unlock();
  // }
  // }

  // public void withdraw(double amount) {
  // lock.lock();
  // try {
  // balance -= amount;
  // } finally {
  // lock.unlock();
  // }
  // }

  // tryLock
  // ==================================================

  // public void deposit(double amount) {
  // try {
  // if (lock.tryLock(1, TimeUnit.SECONDS)) {
  // try {
  // balance += amount;
  // } finally {
  // lock.unlock();
  // }
  // } else {
  // System.out.println("Could not get the lock.");
  // }
  // } catch (InterruptedException e) {
  // e.printStackTrace();
  // }
  // }

  // public void withdraw(double amount) {
  // try {
  // if (lock.tryLock(1, TimeUnit.SECONDS)) {
  // try {
  // balance -= amount;
  // } finally {
  // lock.unlock();
  // }
  // } else {
  // System.out.println("Could not get the lock.");
  // }
  // } catch (InterruptedException e) {
  // e.printStackTrace();
  // }
  // }

  // transfer between accounts exercise
  // ==================================================

  // public boolean withdraw(double amount) {
  // if (lock.tryLock()) {
  // try {
  // try {
  // // Simulate database access
  // Thread.sleep(100);
  // } catch (InterruptedException e) {
  // return false;
  // }

  // balance -= amount;
  // System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(),
  // amount);
  // return true;
  // } finally {
  // lock.unlock();
  // }
  // }

  // return false;
  // }

  // public boolean deposit(double amount) {
  // if (lock.tryLock()) {
  // try {
  // try {
  // // Simulate database access
  // Thread.sleep(100);
  // } catch (InterruptedException e) {
  // return false;
  // }

  // balance += amount;
  // System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(),
  // amount);
  // return true;
  // } finally {
  // lock.unlock();
  // }
  // }

  // return false;
  // }

  public boolean withdraw(double amount) {
    try {
      // Simulate database access
      Thread.sleep(10);
    } catch (InterruptedException e) {
      return false;
    }

    try {
      if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
        try {
          balance -= amount;
        } finally {
          lock.unlock();
        }

        System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
        return true;
      }
    } catch (InterruptedException e) {
      //
    }

    return false;
  }

  public boolean deposit(double amount) {
    try {
      // Simulate database access
      Thread.sleep(10);
    } catch (InterruptedException e) {
      return false;
    }

    try {
      if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
        try {
          balance -= amount;
        } finally {
          lock.unlock();
        }

        System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
        return true;
      }
    } catch (InterruptedException e) {
      //
    }

    return false;
  }

  public boolean transfer(BankAccount destinationAccount, double amount) {
    if (withdraw(amount)) {
      if (destinationAccount.deposit(amount)) {
        return true;
      } else {
        // The deposit failed. Refund the money back into the account.
        System.out.printf("%s: Destination account busy. Refunding money\n", Thread.currentThread().getName());

        while (!deposit(amount)) {
          //
        }
      }
    }

    return false;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  @Override
  public String toString() {
    return String.format("Account = %s Balance = %.2f$", accountNumber, balance);
  }
}
