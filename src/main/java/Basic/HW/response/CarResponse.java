package Basic.HW.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarResponse {

    private Long id;

    private String type;
    private String color;
}
