package Basic.HW.repository;

import Basic.HW.dto.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car,Long> {
    List<Car> getByDriver_Id(Long id);
}
