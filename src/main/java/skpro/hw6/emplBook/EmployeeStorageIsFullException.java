package skpro.hw6.emplBook;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String message){
        super(message);
    }
}
