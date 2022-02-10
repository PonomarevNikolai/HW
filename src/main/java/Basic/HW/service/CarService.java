package Basic.HW.service;

import Basic.HW.dto.request.CarRequest;
import Basic.HW.dto.response.CarResponse;

import java.util.List;

public interface CarService {
    CarResponse saveCar(CarRequest car) throws ServiceException;
    void addCarToDriver(Long idCar, String nameDriver) throws ServiceException;
    CarResponse getCar(Long Id) throws ServiceException;
    List<CarResponse> getCars();
    void deleteCar(Long id) throws ServiceException;
}
