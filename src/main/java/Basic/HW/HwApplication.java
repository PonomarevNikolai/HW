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



}
