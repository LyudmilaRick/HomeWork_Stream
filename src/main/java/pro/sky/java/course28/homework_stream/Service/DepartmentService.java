package pro.sky.java.course28.homework_stream.Service;

import pro.sky.java.course28.homework_stream.Repository.Employee;

import java.util.Collection;

public interface DepartmentService {
    Employee findEmployeeWithMinSalary(int department);
    Employee findEmployeeWithMaxSalary(int department);

    Collection<Employee> getAllEmployeeInDepartment(int department);
    Collection<Employee> getAllEmployeeInOrganization();
}

