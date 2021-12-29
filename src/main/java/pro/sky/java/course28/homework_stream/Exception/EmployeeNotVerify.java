package pro.sky.java.course28.homework_stream.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeNotVerify extends  RuntimeException{
     public  EmployeeNotVerify (String message) {super(message);
     }
}
