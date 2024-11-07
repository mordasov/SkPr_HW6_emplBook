package skpro.hw6.emplBook.service;

import skpro.hw6.emplBook.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee addEmployee(String firstName, String lastName);

    public Employee removeEmployee(String firstName, String lastName);

    public Employee findEmployee(String firstName, String lastName);

    public List<Employee> printListOfEmployee();
}
