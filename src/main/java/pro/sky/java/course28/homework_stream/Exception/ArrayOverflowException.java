package pro.sky.java.course28.homework_stream.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ArrayOverflowException extends RuntimeException {
   public ArrayOverflowException(String message) {
       super(message);
   }
}
