package Basic.HW.service;

import Basic.HW.dto.Driver;
import Basic.HW.dto.Role;
import Basic.HW.dto.request.DriverRequest;
import Basic.HW.dto.response.DriverResponse;

import java.util.List;

public interface DriverService {
    Driver saveDriver(DriverRequest driver) throws ServiceException;
    Role saveRole(Role role);
    Driver addRoleToDriver(String nameDriver, String nameRole) throws ServiceException;
    DriverResponse getDriver(String name) throws ServiceException;
    List<DriverResponse> getDrivers();
    void deleteDriver(String name) throws ServiceException;
}
