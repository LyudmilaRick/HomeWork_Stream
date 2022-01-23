package pro.sky.java.course28.homework_stream.service;

import pro.sky.java.course28.homework_stream.repository.Employee;

import java.util.Collection;

public interface DepartmentService {
    Employee findEmployeeWithMinSalary(int department);
    Employee findEmployeeWithMaxSalary(int department);

    Collection<Employee> getAllEmployeeInDepartment(int department);
    Collection<Employee> getAllEmployee();
}

