package Basic.HW.service;

import Basic.HW.dto.Car;
import Basic.HW.dto.Driver;
import Basic.HW.dto.request.CarRequest;
import Basic.HW.exception.ExcHandler.TypicalError;
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
     final CarRepo carRepo;
     final DriverRepo driverRepo;

    @Override
    public CarResponse saveCar(CarRequest car) throws ServiceException {
        Driver driver=driverRepo.findByUsername(car.getDriverName());
        if (driver==null){
            log.error("Driver {} not exist for add car",  car.getDriverName());
            throw new ServiceException("Driver "+car.getDriverName()+" not exist for add car", TypicalError.NOT_FOUND);
        }
        log.info("Save new car ");
        Car car1=carRepo.save(new Car(null, car.getType(), car.getColor(),driver));
        return convertToCarResponse(car1);
    }

    @Override
    public void addCarToDriver(Long idCar, String nameDriver) throws ServiceException {
        Driver driver =driverRepo.findByUsername(nameDriver);
        if(driver==null){
            log.error("Driver {} not exist for add car",  nameDriver);
            throw new ServiceException("Driver "+nameDriver+" not exist for add car",TypicalError.NOT_FOUND);
        }
        carRepo.getById(idCar).setDriver(driver);
        log.info("add new car id={} to Driver {}", idCar,nameDriver);

    }

    @Override
    public CarResponse getCar(Long id) throws ServiceException {
        log.info("Fetching  car id={}",  id);
       CarResponse carResponse= convertToCarResponse(carRepo.getById(id));
        if(carResponse==null){
            log.error("Car id={} not exist ",  id);
            throw new ServiceException("Car id={} "+id+" not exist ",TypicalError.NOT_FOUND);
        }
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
    public void deleteCar(Long id) throws ServiceException {
       if(carRepo.getById(id)==null){
           log.error("Car id={} not exist ",  id);
           throw new ServiceException("Car id={} "+id+" not exist ",TypicalError.NOT_FOUND);
       }
        carRepo.delete(carRepo.getById(id));
       log.info("Delete car id={}",id);


    }

    private CarResponse convertToCarResponse(Car car){
        CarResponse carResponse=new CarResponse(car.getId(), car.getType(), car.getColor(), car.getDriver().getUsername());
        return carResponse;
    }
}
