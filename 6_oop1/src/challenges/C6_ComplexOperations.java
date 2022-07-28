package challenges;

class ComplexNumber {
  private double real;
  private double imaginary;

  public double getImaginary() {
    return imaginary;
  }

  public double getReal() {
    return real;
  }

  public ComplexNumber(double real, double imaginary) {
    this.real = real;
    this.imaginary = imaginary;
  }

  public void add(double real, double imaginary) {
    this.real += real;
    this.imaginary += imaginary;
  }

  public void add(ComplexNumber c) {
    add(c.getReal(), c.getImaginary());
  }

  public void subtract(double real, double imaginary) {
    this.real -= real;
    this.imaginary -= imaginary;
  }

  public void subtract(ComplexNumber c) {
    subtract(c.getReal(), c.getImaginary());
  }
}

public class C6_ComplexOperations {

}
