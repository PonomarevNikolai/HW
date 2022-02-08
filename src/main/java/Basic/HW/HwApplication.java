package Basic.HW;

import Basic.HW.dto.Car;
import Basic.HW.dto.Driver;
import Basic.HW.dto.Role;
import Basic.HW.dto.request.CarRequest;
import Basic.HW.dto.request.DriverRequest;
import Basic.HW.service.CarService;
import Basic.HW.service.DriverService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class HwApplication {

	public static void main(String[] args) {
		SpringApplication.run(HwApplication.class, args);
	}

	@Bean
	CommandLineRunner run(DriverService driverService,CarService carService){
		return args -> {

			driverService.saveRole(new Role(null,"ROLE_ADMIN"));
			driverService.saveRole(new Role(null,"ROLE_USER"));

			driverService.saveDriver(new DriverRequest( "Admin","admin"));
			driverService.saveDriver(new DriverRequest("User", "user"));

			driverService.addRoleToDriver("Admin","ROLE_ADMIN");
			driverService.addRoleToDriver("User","ROLE_USER");

			carService.saveCar(new CarRequest("Jeep","Black","Admin"));
		};
	}

}