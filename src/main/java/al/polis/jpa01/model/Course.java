package al.polis.jpa01.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private String name;
    @Column(length = 200)
    private String description;
    @Column(length = 5)
    private String location;
    @Column(length = 6)
    private String code;
}
