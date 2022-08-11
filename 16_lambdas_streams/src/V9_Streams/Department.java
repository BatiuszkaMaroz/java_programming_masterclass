package V9_Streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
  private String name;
  private List<Employee> list = new ArrayList<>();

  public Department(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public List<Employee> getList() {
    return Collections.unmodifiableList(list);
  }

  public void addEmployee(Employee employee) {
    list.add(employee);
  }
}
