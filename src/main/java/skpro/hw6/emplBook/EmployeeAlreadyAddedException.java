package skpro.hw6.emplBook;

public class EmployeeAlreadyAddedException extends  RuntimeException {
    public EmployeeAlreadyAddedException(String message){
        super(message);
    }
}
