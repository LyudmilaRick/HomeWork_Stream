package pro.sky.java.course28.homework_stream.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course28.homework_stream.Repository.Employee;
import pro.sky.java.course28.homework_stream.Service.DepartmentService;
import pro.sky.java.course28.homework_stream.ServiceImpl.DepartmentServiceImpl;

import java.util.Collection;

/**
 * контроллер
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    Employee findEmployeeWithMinSalary(@RequestParam(name = "departmentId") int department) {
        return departmentService.findEmployeeWithMaxSalary(department);
    }

    @GetMapping("/min-salary")
    Employee findEmployeeWithMaxSalary(@RequestParam(name = "departmentId") int department) {
        return departmentService.findEmployeeWithMinSalary(department);
    }

    @GetMapping(value = "/all", params = {"departmentId"})
    Collection<Employee> getAllEmployeeInDepartment(@RequestParam(name = "departmentId") int department) {
        return departmentService.getAllEmployeeInDepartment(department);
    }

    @GetMapping("/all")
    Collection<Employee> getAllEmployeeInDepartment() {
        return departmentService.getAllEmployeeInOrganization();
    }
}
