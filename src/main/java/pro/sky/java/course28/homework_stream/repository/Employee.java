package pro.sky.java.course28.homework_stream.repository;
import java.util.Objects;
public class Employee {


    private final Person person;                  // Фамилия // Имя
    private int    department;                     // Отдел сотрудника.
    private float  salary;                         // Текущая заработная плата сотрудника

    /**
     * Конструктор нового экземпляра класса  Полное имя (Ф.И.).
     *
     * @param person     // Фамилия  // Имя
     * @param department;   // Отдел сотрудника.
     * @param salary;       // Текущая заработная плата сотрудника
     */
    public Employee(Person person, int department, float salary) {
        this.person      = person;
        this.department  = department;
        this.salary      = salary;
    }

    /**
     * Конструктор нового экземпляра класса {@code Employee},
     * заполняющий все реквизиты сотрудника,
     * @param department Отдел, где трудится сотрудник.
     * @param lastName    * ФИО сотрудника.     Фамилия
     * @param firstName  * ФИО сотрудника.     Имя
     * @param salary     * Размер заработной платы сотрудника
     */
    public Employee( String lastName, String firstName, int department, float salary) {
        this(new Person(lastName, firstName), department, salary);
    }
    //  Добавить возможность получать значения полей из Employee (геттеры) для всех полей.

    /**
     * Получить полное имя (Ф.И.О.) сотрудника.
     * @return Значение Ф.И.О. сотрудника.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Получить значение заработной платы сотрудника.
     *
     * @return Зарплата сотрудника.
     */
    public float getSalary() {
        return salary;
    }

    /**
     * Получить отдел сотрудника.
     *
     * @return Отдел сотрудника.
     */
    public int getDepartment() {
        return department;
    }

    //5. Добавить возможность устанавливать значения полей отдела и зарплаты (сеттеры).

    /**
     * Установить новое значение отдела сотрудника.
     *
     * @param department Отдел сотрудника.
     */
    public void setDepartment(int department) {
        this.department = department;
    }

    /**
     * Получить значение заработной платы сотрудника.
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
     //   return String.format("\"%6s %3d %-15s %-15s %-15s %.2f\", ",
     //           department, person.getLastName(), person.getFirstName(), salary);
        return String.join(" ", person.getLastName(),person.getFirstName());
                //           department, person.getLastName(), person.getFirstName(), salary);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Float.compare(employee.salary, salary) == 0 && Objects.equals(person, employee.person);

    }

    @Override
    public int hashCode() {
        return Objects.hash(person, department, salary);
    }
}


