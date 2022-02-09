package Basic.HW.controllers;

import Basic.HW.dto.Driver;
import Basic.HW.dto.Form;
import Basic.HW.dto.Role;
import Basic.HW.dto.request.DriverRequest;
import Basic.HW.dto.response.DriverResponse;
import Basic.HW.service.CarService;
import Basic.HW.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebMvcTest(DriverController.class)
public class DriverControllerTest {

    @MockBean
    CarService carService;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    MockMvc mockMvc;

    @Test
    void MockMvcShouldStart() {
        assertNotNull(mockMvc);
    }

    @Test
    void getDrivers() {
    }

    @Test
    void getDriver() {

    }

    @Test
    void saveDriver() {
    }

    @Test
    void saveRole() {
    }

    @Test
    void addRoleToDriver() {
    }

    @Test
    void deleteDriver() {
    }
}
