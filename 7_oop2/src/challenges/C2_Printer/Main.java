package challenges.C2_Printer;

public class Main {
  public static void main(String[] args) {
    Printer printer = new Printer();
    printer.printPage("Hello World!");

    printer.clickPowerButton();
    printer.printPage("Hello World!");

    printer.refillToner(90);
    printer.refillToner(20);
    printer.printPage("Hello World!");

    printer.addSheets(10);
    printer.printPage("Hello World!");

    System.out.printf("Printed %d pages.", printer.getPagesPrinted());
  }
}
