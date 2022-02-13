package Basic.HW.controllers;

import Basic.HW.service.CarService;
import Basic.HW.service.DriverService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest()
@AutoConfigureMockMvc
@Slf4j
public class DriverControllerTest {

    @Autowired
    CarService carService;

    @Autowired
    DriverService driverService;


    @Autowired
    private MockMvc mockMvc;

    @Test
    void getDrivers() throws Exception {
        Assert.assertNotNull(driverService.getDrivers());

    }

    @Test
    void getDriver() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/driver/Admin"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("username").value("Admin"))
                .andDo(print());
    }

    @Test
    void saveDriver() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/driver/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"Test\",\"password\":\"Test\"}")
                        .header("Content-Type", "application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("username").value("Test"))
                .andDo(print());
    }

    @Test
    void saveRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/driver/role/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":null,\"name\":\"Test\"}")
                        .header("Content-Type", "application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Test"))
                .andDo(print());
    }

    @Test
    void addRoleToDriver() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/driver/role/addtodriver")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "        \"driverName\": \"User\",\n" +
                                "        \"roleName\": \"ROLE_ADMIN\"\n" +
                                "    }")
                        .header("Content-Type", "application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("roles.[1].name" ).value("ROLE_ADMIN"))
                .andDo(print());
    }

    @Test
    void deleteDriver() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/driver/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"Test\",\"password\":\"Test\"}")
                        .header("Content-Type", "application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("username").value("Test"))
                .andDo(print());
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/driver/delete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"driverName\":\"Test\"}")
                        .header("Content-Type", "application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

    }
}
