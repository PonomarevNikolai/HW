package Basic.HW.service;

import Basic.HW.dto.Car;
import Basic.HW.dto.Driver;
import Basic.HW.dto.request.CarRequest;
import Basic.HW.repository.CarRepo;
import Basic.HW.repository.DriverRepo;
import Basic.HW.dto.response.CarResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CarServiceImpl implements CarService {
    private final CarRepo carRepo;
    private final DriverRepo driverRepo;

    @Override
    public CarResponse saveCar(CarRequest car) {
        Driver driver=driverRepo.findByUsername(car.getDriverName());
        if (driver==null){
            log.error("Driver {} not exist for add car",  car.getDriverName());
            throw new RuntimeException("Driver "+car.getDriverName()+" not exist for add car");
        }
        log.info("Save new car ");
        Car car1=carRepo.save(new Car(null, car.getType(), car.getColor(),driver));
        return convertToCarResponse(car1);
    }

    @Override
    public void addCarToDriver(Long idCar, String nameDriver)  {
        Driver driver =driverRepo.findByUsername(nameDriver);
        if(driver==null){
            log.error("Driver {} not exist for add car",  nameDriver);
            throw new RuntimeException("Driver "+nameDriver+" not exist for add car");
        }
        carRepo.getById(idCar).setDriver(driver);
        log.info("add new car id={} to Driver {}", idCar,nameDriver);

    }

    @Override
    public CarResponse getCar(Long id) {
       CarResponse carResponse= convertToCarResponse(carRepo.getById(id));
        log.info("Fetching  car id={}",  id);
        return carResponse;
    }

    @Override
    public List<CarResponse> getCars() {
        List<CarResponse> carResponseList=new ArrayList<>();
        for (Car car:
                carRepo.findAll()){
            carResponseList.add(new CarResponse(car.getId(), car.getType(), car.getColor(),car.getDriver().getUsername()));
        }
        log.info("Fetching all cars");
        return carResponseList;
    }

   @Override
    public void deleteCar(Long id) {


        carRepo.delete(carRepo.getById(id));
       log.info("Delete car id={}",id);


    }

    private CarResponse convertToCarResponse(Car car){
        CarResponse carResponse=new CarResponse(car.getId(), car.getType(), car.getColor(), car.getDriver().getUsername());
        return carResponse;
    }
}
