package Basic.HW.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
    @OneToMany(
            mappedBy = "id",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Collection<Car> cars=new ArrayList<>();

    public Driver( String username, String password) {
        this.id = null;
        this.username = username;
        this.password = password;
    }
}
