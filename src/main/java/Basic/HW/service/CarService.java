package Basic.HW.service;

import Basic.HW.dto.request.CarRequest;
import Basic.HW.dto.response.CarResponse;

import java.util.List;

public interface CarService {
    CarResponse saveCar(CarRequest car);
    void addCarToDriver(Long idCar, String nameDriver);
    CarResponse getCar(Long Id);
    List<CarResponse> getCars();
    void deleteCar(Long id);
}
