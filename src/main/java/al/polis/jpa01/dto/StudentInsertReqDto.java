package al.polis.jpa01.dto;

import lombok.Data;

@Data
public class StudentInsertReqDto {
    private String firstName;
    private String lastName;
    private String serialNumber;
}
