package Basic.HW.dto.response;

import Basic.HW.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverResponse {
    private Long id;
    private String username;
    private String password;
    private Collection<Role> roles = new ArrayList<>();
    private Collection<CarResponse> cars=new ArrayList<>();
}
