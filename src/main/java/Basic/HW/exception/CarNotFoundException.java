package Basic.HW.exception;

public class CarNotFoundException extends Exception{

    public CarNotFoundException(String message) {
        super("Машина не найдена в БД "+message );
    }

}
