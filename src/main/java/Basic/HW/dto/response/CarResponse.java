package Basic.HW.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarResponse {

    private Long id;

    private String type;
    private String color;
    private String driver;
}
