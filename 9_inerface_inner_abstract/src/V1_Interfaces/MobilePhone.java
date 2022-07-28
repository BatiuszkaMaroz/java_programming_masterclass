package V1_Interfaces;

public class MobilePhone implements ITelephone {
  private boolean isOn = false;
  private boolean isRinging;
  private int number;

  public MobilePhone(int number) {
    this.number = number;
  }

  @Override
  public boolean isRinging() {
    return isRinging;
  }

  @Override
  public void powerOn() {
    if (!isOn) {
      isOn = true;
      System.out.println("Mobile phone powered on.");
    } else {
      System.out.println("Mobile phone already powered on.");
    }
  }

  @Override
  public void answer() {
    if (!isOn) {
      System.out.println("Mobile phone not powered on.");
      return;
    }

    if (isRinging) {
      System.out.println("Answering on mobile phone.");
      isRinging = false;
    }
  }

  @Override
  public void call(int phoneNumber) {
    if (!isOn) {
      System.out.println("Mobile phone not powered on.");
      return;
    }

    System.out.printf("Calling to %d on mobile phone.\n", phoneNumber);

    if (phoneNumber == number) {
      isRinging = true;
      ring();
    }
  }

  @Override
  public void ring() {
    if (!isOn)
      return;

    System.out.println("Ring ring! on mobile phone.");
  }
}
