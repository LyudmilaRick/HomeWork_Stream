package pro.sky.java.course28.homework_stream.department;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import pro.sky.java.course28.homework_stream.service.EmployeeService;
import pro.sky.java.course28.homework_stream.service_impl.DepartmentServiceImpl;


import static pro.sky.java.course28.homework_stream.constant.EmployeeConstants.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    void getAllEmployeeTest() {
        when(employeeServiceMock.getAllEmployee()).thenReturn(EMPLOYEE_FACTORY);
//      assertEquals(EMPLOYEE_BOOK_TRUE.values(), out.getAllEmployee());

        assertTrue(EMPLOYEE_BOOK_TRUE.values().size() == out.getAllEmployee().size() &&
                EMPLOYEE_BOOK_TRUE.values().containsAll(out.getAllEmployee()));
    }

    @Test
    void getAllEmployeeInDepartmentTest() {
        when(employeeServiceMock.getAllEmployee()).thenReturn(EMPLOYEE_FACTORY);
        assertTrue(EMPLOYEE_DEPARTMENT_1.containsAll(out.getAllEmployeeInDepartment(DEPARTMENT_1)));

    }

    @Test
    void findEmployeeWithMaxSalaryTest() {
        when(employeeServiceMock.getAllEmployee()).thenReturn(EMPLOYEE_FACTORY);
        assertEquals(out.findEmployeeWithMaxSalary(DEPARTMENT_1), EMPLOYEE_SALARY_MAX_1);

    }

    @Test
    void findEmployeeWithMinSalaryTest() {
        when(employeeServiceMock.getAllEmployee()).thenReturn(EMPLOYEE_FACTORY);
        assertEquals(EMPLOYEE_SALARY_MAX_1, out.findEmployeeWithMaxSalary(DEPARTMENT_1));
    }
}

