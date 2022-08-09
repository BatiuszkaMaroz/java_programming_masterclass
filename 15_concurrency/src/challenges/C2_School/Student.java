package challenges.C2_School;

public class Student {
  private Tutor tutor;
  private boolean isStudying = false;

  Student(Tutor tutor) {
    this.tutor = tutor;
  }

  public synchronized void startStudy() {
    isStudying = true;
    System.out.println("Student is studying");

    notify();
  }

  public synchronized void handInAssignment() {
    // try {
    // while (!isStudying)
    // wait(1000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }

    try {
      if (!isStudying)
        wait();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Student handed in assignment");
    tutor.getProgressReport();
  }
}