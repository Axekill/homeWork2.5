package com.example.homework.Service;

import com.example.homework.Employee;
import com.example.homework.Exceptions.EmployeeAlreadyAddedException;
import com.example.homework.Exceptions.EmployeeNotFoundException;
import com.example.homework.Exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.addAll(List.of(
                new Employee("Ivan", "Ivanov"),
                new Employee("Petr", "Petrov"),
                new Employee("Andrey", "Gusev")
        ));
    }


    public void addEmployee(Employee employee)
            throws EmployeeStorageIsFullException,
            EmployeeAlreadyAddedException {
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.add(employee);
        }
        if (employees.size() > 4) {
            throw new EmployeeStorageIsFullException();
        }
    }

    public void employeeRemove(Employee employee) throws EmployeeNotFoundException {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        } else {
            employees.remove(employee);
        }
    }

    public Employee employeeFind(Employee employee) throws EmployeeNotFoundException {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }


}
