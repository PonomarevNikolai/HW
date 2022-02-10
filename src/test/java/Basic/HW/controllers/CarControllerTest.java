package Basic.HW.controllers;

import Basic.HW.service.CarService;
import Basic.HW.service.DriverService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest()
@AutoConfigureMockMvc
@Slf4j
public class CarControllerTest {

    @Autowired
    CarService carService;

    @Autowired
    DriverService driverService;


    @Autowired
    private MockMvc mockMvc;


    @Test
    void saveCar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/car/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"type\":\"UAZ\",\"color\":\"Blue\",\"driverName\":\"User\"}")
                        .header("Content-Type", "application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("type").value("UAZ"))
                .andDo(print());

    }

    @Test
    void getCars() throws Exception {

      mockMvc.perform(MockMvcRequestBuilders.get("/api/car/cars"))
              .andExpect(MockMvcResultMatchers.jsonPath("$[0].type").value("Jeep"));
    }

    @Test
    void getCar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/car/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"type\":\"UAZ\",\"color\":\"Blue\",\"driverName\":\"User\"}")
                        .header("Content-Type", "application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("type").value("UAZ"))
                .andDo(print());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/car/2"))
                .andExpect(MockMvcResultMatchers.jsonPath("type").value("UAZ"));
    }


    @Test
    void deleteDriver() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/car/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"type\":\"UAZ\",\"color\":\"Blue\",\"driverName\":\"User\"}")
                        .header("Content-Type", "application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("type").value("UAZ"))
                .andDo(print());
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/car/delete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":2}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
