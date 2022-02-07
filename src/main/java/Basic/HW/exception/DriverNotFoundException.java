package Basic.HW.exception;

public class DriverNotFoundException extends Exception{
    public DriverNotFoundException(String message) {
        super("Водитель не найден в БД");
    }
}
