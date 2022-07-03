package com.dawidprajzner.challenges;

public class C2_Person {
  private String firstName;
  private String lastName;
  private int age;

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setAge(int age) {
    if (age < 0 || 100 < age)
      age = 0;

    this.age = age;
  }

  public boolean isTeen() {
    return 12 < age && age < 20;
  }

  public String getFullName() {
    if (!firstName.isEmpty() && !lastName.isEmpty())
      return firstName + " " + lastName;
    else if (!firstName.isEmpty())
      return firstName;
    else if (!lastName.isEmpty())
      return lastName;
    else
      return "";
  }
}
