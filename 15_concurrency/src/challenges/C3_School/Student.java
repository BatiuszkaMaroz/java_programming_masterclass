package challenges.C3_School;

public class Student {
  private Tutor tutor;

  Student(Tutor tutor) {
    this.tutor = tutor;
  }

  public void startStudy() {
    // study
    System.out.println("Student is studying");
  }

  public void handInAssignment() {
    synchronized (tutor) {
      tutor.getProgressReport();

      System.out.println("Student handed in assignment");
      tutor.notifyAll();
    }
  }
}