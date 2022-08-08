package V2_IO;

import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    try {
      Caretaker<User> c1 = new Caretaker<>(new User("Dawid", "david@mail.com"));
      Caretaker<User> c2 = new Caretaker<>(new User("Natalia", "natalia@mail.com"));

      System.out.println(c1.getTarget());
      System.out.println(c2.getTarget());

      System.out.println("==================================================");

      c1.backup();
      c2.backup();

      c1.getTarget().setName("Eugene");
      c1.backup();

      c2.getTarget().setName("Oprah");
      c2.backup();

      c1.getTarget().setName("Finn");
      c1.backup();

      c2.getTarget().setName("Penelope");
      c2.backup();

      c1.undo();
      c1.undo();
      c1.undo();

      c2.undo();
      c2.undo();
      c2.undo();

      System.out.println(c1.getTarget());
      System.out.println(c2.getTarget());

      System.out.println("==================================================");

      c1.backup();
      c1 = new Caretaker<>(new User(c1.getTarget().getId()));
      System.out.println(c1.getTarget());

      c1.refresh();
      System.out.println(c1.getTarget());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
