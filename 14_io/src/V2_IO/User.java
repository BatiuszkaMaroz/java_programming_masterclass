package V2_IO;

import java.util.Random;

public class User implements ISaveable {
  private static final Random random = new Random();

  private final int id;
  private String name;
  private String email;

  public User(int id) {
    this.id = id;
  }

  public User(String name, String email) {
    this.id = random.nextInt(99999);
    this.name = name;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return String.format("{ id: %d, name: \"%s\", email \"%s\" }", id, name, email);
  }

  public String getDataString() {
    return name + "," + email;
  }

  public void restoreFromDataString(String dataString) throws IllegalArgumentException {
    String[] data = dataString.split(",");

    if (data.length != 2)
      throw new IllegalArgumentException("Invalid array size: " + data.length);

    this.name = data[0];
    this.email = data[1];
  }
}
