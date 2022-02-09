package Basic.HW.controllers;

import Basic.HW.dto.request.DriverRequest;
import Basic.HW.service.CarService;
import Basic.HW.service.DriverService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class CarControllerTest {
    @MockBean
    CarService carService;
    @MockBean
    DriverService driverService;


    @Autowired
    private MockMvc mockMvc;


    @Test
    void MockMvcShouldStart() {
        assertNotNull(mockMvc);
    }

    @Test
    void saveCar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/driver/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"Test\",\"password\":\"test\"}")
                        .header("Content-Type", "application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
        driverService.saveDriver(new DriverRequest("Gim","111"));
        log.info(driverService.getDrivers().toString() );
        mockMvc.perform(MockMvcRequestBuilders.get("/api/driver/drivers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    void getCars() throws Exception {
   /*     mockMvc.perform(MockMvcRequestBuilders.get("/api/car/cars")).
                andExpect(MockMvcResultMatchers.jsonPath("$[0].type").value("Jeep"));
*/
    }


    @Test
    void deleteDriver() {

    }

}
