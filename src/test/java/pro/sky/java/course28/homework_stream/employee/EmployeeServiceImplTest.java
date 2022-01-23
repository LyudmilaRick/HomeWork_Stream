package pro.sky.java.course28.homework_stream.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course28.homework_stream.exception.EmployeeExistException;
import pro.sky.java.course28.homework_stream.exception.EmployeeNotFoundException;
import pro.sky.java.course28.homework_stream.service_impl.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course28.homework_stream.constant.EmployeeConstants.*;

public class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @BeforeEach
    public void initTestService() {
        out.addEmployee(LAST_NAME_1, FIRST_NAME_1, DEPARTMENT_1, SALARY_1);
        out.addEmployee(LAST_NAME_2, FIRST_NAME_2, DEPARTMENT_3, SALARY_2);
        out.addEmployee(LAST_NAME_3, FIRST_NAME_3, DEPARTMENT_1, SALARY_3);
    }

    @Test
    void addTest() {
        assertEquals(out.addEmployee(LAST_NAME_4, FIRST_NAME_4, DEPARTMENT_1, SALARY_2), EMPLOYEE_WAS_ADDED_1);
        assertEquals(out.addEmployee(LAST_NAME_5, FIRST_NAME_5, DEPARTMENT_3, SALARY_2), EMPLOYEE_WAS_ADDED_2);
    }

    @Test
    void addExistTest() {
        assertThrows(EmployeeExistException.class, () -> out.addEmployee(LAST_NAME_2, FIRST_NAME_2, DEPARTMENT_3, SALARY_2));
    }

    @Test
    void findTestTrue() {
        assertEquals(out.findEmployee(LAST_NAME_2, FIRST_NAME_2), EMPLOYEE_EXISTS);
    }

    @Test
    void findTestFalse() {
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(LAST_NAME_6, FIRST_NAME_6));
    }

    @Test
    void removeTestTrue() {
        assertEquals(out.removeEmployee(LAST_NAME_2, FIRST_NAME_2), EMPLOYEE_EXISTS);
    }

    @Test
    void removeTestFalse() {
        assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee(LAST_NAME_6, FIRST_NAME_6));
    }

    @Test
    public void getAllEmployeeTest() {
        assertTrue(EMPLOYEE_FACTORY.containsAll(out.getAllEmployee()));
    }
}
