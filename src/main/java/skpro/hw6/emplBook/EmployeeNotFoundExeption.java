package skpro.hw6.emplBook;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundExeption extends RuntimeException {
    public EmployeeNotFoundExeption(String message) {
        super(message);

    }
}
