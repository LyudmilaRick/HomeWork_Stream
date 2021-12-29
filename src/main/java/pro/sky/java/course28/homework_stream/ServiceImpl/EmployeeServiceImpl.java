package pro.sky.java.course28.homework_stream.ServiceImpl;

import org.springframework.stereotype.Service;
import pro.sky.java.course28.homework_stream.Exception.EmployeeExistException;
import pro.sky.java.course28.homework_stream.Exception.EmployeeNotFoundException;
import pro.sky.java.course28.homework_stream.Repository.Employee;
import pro.sky.java.course28.homework_stream.Repository.Person;
import pro.sky.java.course28.homework_stream.Service.EmployeeService;

import java.util.*;

/**
 * имплементация
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Collection<Employee> getAllEmployee() {
        return new ArrayList<>(employees.values());
    }

    /**
     * метод добавления сотрудника
     *
     * @param lastName  фамилия
     * @param firstName имя
     * @return должен вернуться добавленный объект
     */
    @Override
    public Employee addEmployee(String lastName, String firstName, int department, float salary) {
        Employee employee = new Employee(lastName, firstName, department, salary);
        // ключ - полное имя. Допущение - полных тезок нет
        if (employees.containsKey(employee.getPerson().getFullName())) {
            throw new EmployeeExistException("Employee exist!");
        }
        employees.put(employee.getPerson().getFullName(), employee);
        return employee;

    }

    /**
     * поиск сотрудника по имени и фвмилии
     *
     * @param lastName  фамилия
     * @param firstName имя
     * @return должен вернуться объект Employee !!! ( согласно ДЗ )
     * @throws EmployeeNotFoundException не найден сотрудник
     */
    @Override
    public Employee findEmployee(String lastName, String firstName) {
        Person person = new Person(lastName, firstName);
        if (employees.containsKey(person.getFullName())) {
            return employees.get(person.getFullName());
        }
        throw new EmployeeNotFoundException("Employee not found...today");
    }

    /**
     * @param lastName  фамилия
     * @param firstName имя
     * @return должен вернуться объект, которого удалили
     * @throws EmployeeNotFoundException если такой сотрудник отсутствует
     */
    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        Person person = new Person(lastName, firstName);
        if (employees.containsKey(person.getFullName())) {
            return employees.remove(person.getFullName());
        }
        throw new EmployeeNotFoundException("Employee not found for deleting");
    }
}

