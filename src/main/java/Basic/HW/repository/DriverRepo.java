package Basic.HW.repository;

import Basic.HW.dto.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepo extends JpaRepository<Driver,Long> {
    Driver findByUsername(String username);
}
