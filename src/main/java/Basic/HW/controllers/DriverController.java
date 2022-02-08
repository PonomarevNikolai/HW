package Basic.HW.controllers;

import Basic.HW.dto.Driver;
import Basic.HW.dto.Form;
import Basic.HW.dto.Role;
import Basic.HW.dto.request.DriverRequest;
import Basic.HW.dto.response.DriverResponse;
import Basic.HW.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/driver")
public class DriverController {
    private final DriverService driverService;

    @GetMapping("/drivers")
    public ResponseEntity<List<DriverResponse>> getDrivers(){
        return ResponseEntity.ok().body(driverService.getDrivers());
    }
    @GetMapping("/{name}")
    public ResponseEntity<DriverResponse> getDrivers(@PathVariable @RequestBody String name){
        return ResponseEntity.ok().body(driverService.getDriver(name));
    }
    @PostMapping("/save")
    public ResponseEntity<Driver> saveDriver(@RequestBody DriverRequest driver){
        return ResponseEntity.ok().body(driverService.saveDriver(driver));
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return ResponseEntity.ok().body(driverService.saveRole(role));
    }
    @PostMapping("/role/addtodriver")
    public ResponseEntity<?> addRoleToDriver(@RequestBody Form form){

        return ResponseEntity.ok().body(driverService.addRoleToDriver(form.getDriverName(), form.getRoleName()));
    }
    @DeleteMapping ("/delete")
    public ResponseEntity<?> deleteDriver(@RequestBody Form form){
        driverService.deleteDriver(form.getDriverName());
        return ResponseEntity.ok().body("Водитель удален");
    }
}