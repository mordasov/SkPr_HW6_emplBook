package skpro.hw6.emplBook.service;

import skpro.hw6.emplBook.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee add(String firstName, String lastName);

    public Employee remove(String firstName, String lastName);

    public Employee find(String firstName, String lastName);

    public List<Employee> list();
}
