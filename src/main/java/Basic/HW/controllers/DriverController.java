package Basic.HW.controllers;

import Basic.HW.dto.Form;
import Basic.HW.dto.Role;
import Basic.HW.dto.request.DriverRequest;
import Basic.HW.dto.response.DriverResponse;
import Basic.HW.service.DriverService;
import Basic.HW.service.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/driver")
public class DriverController {
    private final DriverService driverService;


    @GetMapping("/drivers")
    public String  getDrivers(Model model) {
        model.addAttribute("drivers",driverService.getDrivers());
        return "drivers";
    }

    @GetMapping("/{name}")
    public ResponseEntity<DriverResponse> getDriver(@PathVariable @RequestBody String name)throws ServiceException{
        return ResponseEntity.ok().body(driverService.getDriver(name));

    }

    @PostMapping("/save")
    public String saveDriver(@ModelAttribute DriverRequest driver,Model model) throws ServiceException{
        driverService.saveDriver(driver);
        model.addAttribute("driver",driver);


        return "train";
    }
    @GetMapping("/save")
    public String saveDriverGet(){

        return "addDriverGet";
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role)throws ServiceException {
        return ResponseEntity.ok().body(driverService.saveRole(role));
    }

    @PostMapping("/role/addtodriver")
    public ResponseEntity<?> addRoleToDriver(@RequestBody Form form) throws ServiceException{

        return ResponseEntity.ok().body(driverService.addRoleToDriver(form.getDriverName(), form.getRoleName()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteDriver(@RequestBody Form form) throws ServiceException{
        driverService.deleteDriver(form.getDriverName());
        return ResponseEntity.ok().body("???????????????? ????????????");
    }
}
