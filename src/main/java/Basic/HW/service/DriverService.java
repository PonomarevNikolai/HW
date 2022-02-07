package Basic.HW.service;

import Basic.HW.dto.Driver;
import Basic.HW.dto.Role;
import Basic.HW.response.DriverResponse;

import java.util.List;

public interface DriverService {
    Driver saveDriver(Driver driver);
    Role saveRole(Role role);
    void addRoleToDriver(String nameDriver, String nameRole);
    DriverResponse getDriver(String name);
    List<DriverResponse> getDrivers();
    void deleteDriver(String name);
}
