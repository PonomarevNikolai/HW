package Basic.HW.service;

import Basic.HW.dto.Car;
import Basic.HW.dto.Driver;
import Basic.HW.dto.Role;
import Basic.HW.repository.DriverRepo;
import Basic.HW.repository.RoleRepo;
import Basic.HW.response.CarResponse;
import Basic.HW.response.DriverResponse;
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
    private final DriverRepo driverRepo;
    private final RoleRepo roleRepo;


    @Override
    public Driver saveDriver(Driver driver) {
        if (driverRepo.findByUsername(driver.getUsername())!=null){
            throw new RuntimeException("Driver exist");
        }
        log.info("save new Driver {} to DB", driver.getUsername());


        return driverRepo.save(driver);
    }

    @Override
    public Role saveRole(Role role) {
        if (roleRepo.findByName(role.getName())!=null){
            return role;
        }
        log.info("save new Role {} to DB", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToDriver(String nameDriver, String nameRole) {
        Driver driver =driverRepo.findByUsername(nameDriver);
        Role role=roleRepo.findByName(nameRole);
        if (driver.getRoles().contains(role)){
            return;
        }
        driver.getRoles().add(role);
        log.info("add new Role {} to Driver {}", nameRole, nameDriver);


    }

    @Override
    public DriverResponse getDriver(String name) {
        log.info("Fetching  Driver {}",  name);
        DriverResponse driverResponse=converterToResponse(driverRepo.findByUsername(name));
        return driverResponse;
    }

    @Override
    public List<DriverResponse> getDrivers() {
        log.info("Fetching all Drivers");
        List<DriverResponse> driverResponseList=new ArrayList<>();
        for (Driver driver:
                driverRepo.findAll()){
            driverResponseList.add(converterToResponse(driver));
        }
        return driverResponseList;
    }

    @Override
    public void deleteDriver(String name) {
       Driver driver =driverRepo.findByUsername(name);
        driverRepo.delete(driver);
        log.info("Delete Driver {}",name);
    }

    private DriverResponse converterToResponse(Driver driver){
        List<CarResponse> carResponseList=new ArrayList<>();
            for (Car car:
                 driver.getCars()){
                carResponseList.add(new CarResponse(car.getId(), car.getType(), car.getColor()));
            }
        DriverResponse driverResponse=new DriverResponse(driver.getId(), driver.getUsername(), driver.getPassword(), carResponseList);
        return driverResponse;
    }
}
