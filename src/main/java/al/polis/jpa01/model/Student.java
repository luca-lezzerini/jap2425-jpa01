package al.polis.jpa01.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 40)
    private String firstName;
    @Column(length = 40)
    private String lastName;
    @Column(length = 32)
    private String serialNumber;
}
