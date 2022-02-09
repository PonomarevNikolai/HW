package Basic.HW.configuration;

import Basic.HW.dto.Role;
import Basic.HW.dto.request.CarRequest;
import Basic.HW.dto.request.DriverRequest;
import Basic.HW.service.CarService;
import Basic.HW.service.DriverService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    CommandLineRunner run(DriverService driverService, CarService carService) {
        return args -> {

            driverService.saveRole(new Role(null, "ROLE_ADMIN"));
            driverService.saveRole(new Role(null, "ROLE_USER"));

            driverService.saveDriver(new DriverRequest("Admin", "admin"));
            driverService.saveDriver(new DriverRequest("User", "user"));

            driverService.addRoleToDriver("Admin", "ROLE_ADMIN");
            driverService.addRoleToDriver("User", "ROLE_USER");

            carService.saveCar(new CarRequest("Jeep", "Black", "Admin"));
        };
    }
}
