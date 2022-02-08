package Basic.HW.service;

import Basic.HW.dto.Driver;
import Basic.HW.dto.Role;
import Basic.HW.dto.request.DriverRequest;
import Basic.HW.dto.response.DriverResponse;

import java.util.List;

public interface DriverService {
    Driver saveDriver(DriverRequest driver);
    Role saveRole(Role role);
    Driver addRoleToDriver(String nameDriver, String nameRole);
    DriverResponse getDriver(String name);
    List<DriverResponse> getDrivers();
    void deleteDriver(String name);
}
