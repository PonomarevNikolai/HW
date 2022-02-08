package Basic.HW.controllers;

import Basic.HW.dto.Car;
import Basic.HW.dto.Form;
import Basic.HW.dto.request.CarRequest;
import Basic.HW.dto.response.CarResponse;
import Basic.HW.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/car")
public class CarController {
    private final CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarResponse>> getCars(){
        return ResponseEntity.ok().body(carService.getCars());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> getCars(@PathVariable @RequestBody Long id){
        return ResponseEntity.ok().body(carService.getCar(id));
    }
    @PostMapping("/save")
    public ResponseEntity<CarResponse> saveDriver(@RequestBody CarRequest car){
        return ResponseEntity.ok().body(carService.saveCar(car));
    }

    @DeleteMapping ("/delete")
    public ResponseEntity<?> deleteDriver(@RequestBody Form form){
        carService.deleteCar(form.getId());
        return ResponseEntity.ok().body("Машина удалена");
    }

}
