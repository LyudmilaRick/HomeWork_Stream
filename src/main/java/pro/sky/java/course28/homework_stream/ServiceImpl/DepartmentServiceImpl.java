package pro.sky.java.course28.homework_stream.ServiceImpl;

import org.springframework.stereotype.Service;
import pro.sky.java.course28.homework_stream.Exception.EmployeeNotFoundException;
import pro.sky.java.course28.homework_stream.Repository.Employee;
import pro.sky.java.course28.homework_stream.Service.DepartmentService;
import pro.sky.java.course28.homework_stream.Service.EmployeeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    public final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMinSalary(int department) {
        return employeeService.getAllEmployee().stream()
                .filter(s -> s.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Работник с миимальной ЗП не найден" + department));
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int department) {
        //Optional<Employee> maxEmployee = employeeService.getAllEmployee().stream()
        //        .filter(s -> s.getDepartment() == department)
        //        .max(Comparator.comparing(Employee::getSalary));
        //if (maxEmployee.isPresent()) {
        //    return maxEmployee.get();
        //}
        //throw new EmployeeNotFoundException("Работник с максимальной ЗП не найден" + department);

        return employeeService.getAllEmployee().stream()
                .filter(s -> s.getDepartment() == department)
                .max(Comparator.comparing(s -> s.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Работник с миимальной ЗП не найден" + department));
    }

    //s -> s.getSalary
    @Override
    public Collection<Employee> getAllEmployeeInDepartment(int department) {
        return employeeService.getAllEmployee().stream()
                .filter(s -> s.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Collection<Employee> getAllEmployee() {
        return employeeService.getAllEmployee().stream()
                .sorted(Comparator.comparing(Employee::getDepartment).thenComparing(e -> e.getPerson().getFullName()))
                .collect(Collectors.toList());
    }
}
