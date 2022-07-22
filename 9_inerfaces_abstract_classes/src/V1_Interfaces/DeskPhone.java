package V1_Interfaces;

public class DeskPhone implements ITelephone {
  private boolean isRinging;
  private int number;

  public DeskPhone(int number) {
    this.number = number;
  }

  @Override
  public boolean isRinging() {
    return isRinging;
  }

  @Override
  public void powerOn() {
    System.out.println("Desk phone is always powered on.");
  }

  @Override
  public void answer() {
    if (isRinging) {
      System.out.println("Answering on desk phone.");
      isRinging = false;
    }
  }

  @Override
  public void call(int phoneNumber) {
    System.out.printf("Calling to %d on desk phone.\n", phoneNumber);

    if (phoneNumber == number) {
      isRinging = true;
      ring();
    }
  }

  @Override
  public void ring() {
    System.out.println("Ring ring! on desk phone.");
  }
}
