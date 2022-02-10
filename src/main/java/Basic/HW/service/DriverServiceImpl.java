package Basic.HW.service;

import Basic.HW.dto.Car;
import Basic.HW.dto.Driver;
import Basic.HW.dto.Role;
import Basic.HW.dto.request.DriverRequest;
import Basic.HW.exception.ExcHandler.TypicalError;
import Basic.HW.repository.CarRepo;
import Basic.HW.repository.DriverRepo;
import Basic.HW.repository.RoleRepo;
import Basic.HW.dto.response.CarResponse;
import Basic.HW.dto.response.DriverResponse;
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
public class DriverServiceImpl implements DriverService {
     final DriverRepo driverRepo;
     final RoleRepo roleRepo;
     final CarRepo carRepo;


    @Override
    public Driver saveDriver(DriverRequest driver) throws ServiceException {
        if (driverRepo.findByUsername(driver.getUsername()) != null) {
            throw new ServiceException("Driver exist",TypicalError.DUPLICATE);
        }
        log.info("save new Driver {} to DB", driver.getUsername());
        driverRepo.save(new Driver(driver.getUsername(), driver.getPassword()));

        return driverRepo.findByUsername(driver.getUsername());
    }

    @Override
    public Role saveRole(Role role) {
        if (roleRepo.findByName(role.getName()) != null) {
            return role;
        }
        log.info("save new Role {} to DB", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public Driver addRoleToDriver(String nameDriver, String nameRole) throws ServiceException {
        Driver driver = driverRepo.findByUsername(nameDriver);
        Role role = roleRepo.findByName(nameRole);
        if (driver.getRoles().contains(role)) {
            throw new ServiceException("Driver has this role",TypicalError.DUPLICATE);
        }
        driver.getRoles().add(role);
        log.info("add new Role {} to Driver {}", nameRole, nameDriver);
        return driver;


    }

    @Override
    public DriverResponse getDriver(String name) throws ServiceException {
        log.info("Fetching  Driver {}", name);
        Driver driver = driverRepo.findByUsername(name);
        if (driver == null) {
            log.error("Driver {} not exist ", name);
            throw new ServiceException("Driver " + name + " not exist ", TypicalError.NOT_FOUND);
        }
        DriverResponse driverResponse = converterToDriverResponse(driver);
        return driverResponse;
    }

    @Override
    public List<DriverResponse> getDrivers() {
        log.info("Fetching all Drivers");
        List<DriverResponse> driverResponseList = new ArrayList<>();
        for (Driver driver :
                driverRepo.findAll()) {
            driverResponseList.add(converterToDriverResponse(driver));
        }
        return driverResponseList;
    }

    @Override
    public void deleteDriver(String name) throws ServiceException {
        Driver driver = driverRepo.findByUsername(name);
        if (driver == null) {
            log.error("Driver {} not exist ", name);
            throw new ServiceException("Driver " + name + " not exist ", TypicalError.NOT_FOUND);
        }
        for (Car car :
                carRepo.getByDriver_Id(driver.getId())) {
            carRepo.delete(carRepo.getById(car.getId()));

        }
        driverRepo.delete(driver);
        log.info("Delete Driver {}", name);
    }

    private DriverResponse converterToDriverResponse(Driver driver) {
        List<CarResponse> carResponseList = new ArrayList<>();
        for (Car car:
                carRepo.getByDriver_Id(driver.getId())) {
            carResponseList.add(new CarResponse(car.getId(), car.getType(), car.getColor(), car.getDriver().getUsername()));
        }
        DriverResponse driverResponse = new DriverResponse(driver.getId(), driver.getUsername(), driver.getPassword(), driver.getRoles(), carResponseList);
        return driverResponse;
    }
}
