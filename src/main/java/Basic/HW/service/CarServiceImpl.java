package Basic.HW.service;

import Basic.HW.dto.Car;
import Basic.HW.dto.Driver;
import Basic.HW.exception.CarNotFoundException;
import Basic.HW.exception.DriverNotFoundException;
import Basic.HW.repository.CarRepo;
import Basic.HW.repository.DriverRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CarServiceImpl implements CarService {
    private final CarRepo carRepo;
    private final DriverRepo driverRepo;

    @Override
    public Car saveCar(Car car) {
        return carRepo.save(car);
    }

    @Override
    public void addCarToDriver(Long idCar, String nameDriver) throws CarNotFoundException, DriverNotFoundException {
        Driver driver =driverRepo.findByUsername(nameDriver);
        carRepo.getById(idCar).setDriver(driver);

    }

    @Override
    public Car getCar(Long id) {
        return null;
    }

    @Override
    public List<Car> getCars() {
        return carRepo.findAll();
    }

   @Override
    public void deleteCar(Long id) {

    }
}
