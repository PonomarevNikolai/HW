package Basic.HW.configuration;

import Basic.HW.dto.Role;
import Basic.HW.dto.request.CarRequest;
import Basic.HW.dto.request.DriverRequest;
import Basic.HW.service.CarService;
import Basic.HW.service.DriverService;
import Basic.HW.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Config {

    @Autowired
    DriverService driverService;

    @Autowired
    CarService carService;

    @Bean
    void firstAddUsers() throws ServiceException {
        if (driverService.getDrivers().isEmpty()) {
            driverService.saveRole(new Role(null, "ROLE_ADMIN"));
            driverService.saveRole(new Role(null, "ROLE_USER"));

            driverService.saveDriver(new DriverRequest("Admin", "admin"));
            driverService.saveDriver(new DriverRequest("User", "user"));

            driverService.addRoleToDriver("Admin", "ROLE_ADMIN");
            driverService.addRoleToDriver("User", "ROLE_USER");

            carService.saveCar(new CarRequest("Jeep", "Black", "Admin"));
        }
    }

}
