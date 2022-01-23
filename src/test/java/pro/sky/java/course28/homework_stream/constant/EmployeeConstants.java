package pro.sky.java.course28.homework_stream.constant;

import pro.sky.java.course28.homework_stream.repository.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class EmployeeConstants {
    public static final String LAST_NAME_1 = "Голубев";
    public static final String LAST_NAME_2 = "Гольденвейзер";
    public static final String LAST_NAME_3 = "Гончар";
    public static final String LAST_NAME_4 = "Евтушенко";
    public static final String LAST_NAME_5 = "ефремов";
    public static final String LAST_NAME_6 = "Гришковец";

    public static final String FIRST_NAME_1 = "Глеб";
    public static final String FIRST_NAME_2 = "Александр";
    public static final String FIRST_NAME_3 = "Олесь";
    public static final String FIRST_NAME_4 = "Евгений";
    public static final String FIRST_NAME_5 = "георгий";
    public static final String FIRST_NAME_6 = "Валерий";

    public static final int DEPARTMENT_1 = 1;
    public static final int DEPARTMENT_3 = 3;
    public static final float SALARY_1 = 99999;
    public static final float SALARY_2 = 100000;
    public static final float SALARY_3 = 99997;

    public static final Employee EMPLOYEE_WAS_ADDED_1 = new Employee("Евтушенко", "Евгений", 1, 100000);
    public static final Employee EMPLOYEE_WAS_ADDED_2 = new Employee("Ефремов", "Георгий", 3, 100000);
    public static final Employee EMPLOYEE_EXISTS = new Employee("Гольденвейзер", "Александр", 3, 100000);

    public static final Collection<Employee> EMPLOYEE_FACTORY = List.of(
            new Employee("Голубев", "Глеб", 1, 99999),
            new Employee("Гольденвейзер", "Александр", 3, 100000),
            new Employee("Гончар", "Олесь", 1, 99997)
    );
    public static final Collection<Employee> EMPLOYEE_DEPARTMENT_1 = List.of(
            new Employee("Голубев", "Глеб", 1, 99999),
            new Employee("Гончар", "Олесь", 1, 99997)
    );
    public static final Map<String, Employee> EMPLOYEE_BOOK_TRUE = Map.ofEntries(
            Map.entry("Голубев Глеб", new Employee("Голубев", "Глеб", 1, 99999)),
            Map.entry("Гольденвейзер Александр", new Employee("Гольденвейзер", "Александр", 3, 100000)),
            Map.entry("Гончар Олесь", new Employee("Гончар", "Олесь", 1, 99997))


    );
    public static final Map<String, Employee> EMPLOYEE_BOOK_FALSE = Map.ofEntries(
            Map.entry("Голубев Глеб", new Employee("Голубев", "Глеб", 3, 99999)),
            Map.entry("Гольденвейзер Александр", new Employee("Гольденвейзер", "Александр", 1, 100000)),
            Map.entry("Гончар Олесь", new Employee("Гончар", "Олесь", 3, 999997)),
            Map.entry("Горький Максим", new Employee("Горький", "Максим", 1, 999995)),
            Map.entry("Гуревич Любовь", new Employee("Гуревич", "Любовь", 3, 999994))
    );
    public static final Employee EMPLOYEE_SALARY_MIN_1 = new Employee("Гончар", "Олесь", 1, 99997);
    public static final Employee EMPLOYEE_SALARY_MAX_1 = new Employee("Голубев", "Глеб", 1, 99999);
}
