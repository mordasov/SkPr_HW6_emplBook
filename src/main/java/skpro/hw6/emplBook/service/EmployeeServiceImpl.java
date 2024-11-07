package skpro.hw6.emplBook.service;

import org.springframework.stereotype.Service;
import skpro.hw6.emplBook.Employee;
import skpro.hw6.emplBook.EmployeeAlreadyAddedException;
import skpro.hw6.emplBook.EmployeeNotFoundExeption;
import skpro.hw6.emplBook.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final static int SIZE = 3;
    private int count = 0;
    List<Employee> employeeList = new ArrayList<>(SIZE);

    public Employee addEmployee(String firstName, String lastName) {
        if (count >= SIZE) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников");
        }
        Employee newEmployee = new Employee(firstName, lastName);
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee e = iterator.next();
            if (newEmployee.equals(e)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
            }
        }
        employeeList.add(newEmployee);
        count++;
        return newEmployee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee removeEmployee = new Employee(firstName, lastName);
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employeeList.get(i).getFirstName().equals(firstName) && employeeList.get(i).getLastName().equals(lastName)) {
                index = i;
                count--;
            }
        }
        if (index >= 0) {
            employeeList.remove(index);
            return removeEmployee;
        } else {
            throw new EmployeeNotFoundExeption("Сотрудник не найден");
        }
    }

    public Employee findEmployee(String firstName, String lastName) {
        for (int i = 0; i < count; i++) {
            if (employeeList.get(i).getFirstName().equals(firstName) && employeeList.get(i).getLastName().equals(lastName)) {
                return employeeList.get(i);
            }
        }
        throw new EmployeeNotFoundExeption("Сотрудник не найден");
    }

    public List<Employee> printListOfEmployee() {
        return employeeList;
    }

}
