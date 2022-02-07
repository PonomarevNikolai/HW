package Basic.HW.service;


import Basic.HW.dto.Car;
import Basic.HW.exception.CarNotFoundException;
import Basic.HW.exception.DriverNotFoundException;

import java.util.List;

public interface CarService {
    Car saveCar(Car car);
    void addCarToDriver(Long idCar, String nameDriver) throws CarNotFoundException, DriverNotFoundException;
    Car getCar(Long Id);
    List<Car> getCars();
    void deleteCar(Long id);
}
