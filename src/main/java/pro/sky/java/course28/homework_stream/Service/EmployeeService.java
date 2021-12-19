package pro.sky.java.course28.homework_stream.Service;

import pro.sky.java.course28.homework_stream.Repository.Employee;

import java.util.Collection;

public interface EmployeeService {
    Collection<Employee> getAllEmployee();

    Employee addEmployee(String lastName, String firstName, int department, float salary);

    Employee findEmployee(String lastName, String firstName);

    Employee removeEmployee(String lastName, String firstName);
}

