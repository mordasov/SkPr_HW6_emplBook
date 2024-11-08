package skpro.hw6.emplBook.service;

import org.springframework.stereotype.Service;
import skpro.hw6.emplBook.model.Employee;
import skpro.hw6.emplBook.EmployeeAlreadyAddedException;
import skpro.hw6.emplBook.EmployeeNotFoundExeption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>();
    }

    public Employee add(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        if (employeeList.contains(e)) {
            throw new EmployeeAlreadyAddedException("ALREADY ADDED");
        }
        employeeList.add(e);
        return e;
    }

    public Employee remove(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        if (employeeList.contains(e)) {
            employeeList.remove(e);
            return e;
        }
        throw new EmployeeNotFoundExeption("NOT FOUND");
    }

    public Employee find(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        if (employeeList.contains(e)) {
            return e;
        }
        throw new EmployeeNotFoundExeption("NOT FOUND");
    }

    public List<Employee> list() {
        return Collections.unmodifiableList(employeeList);
    }

}
