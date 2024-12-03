package al.polis.jpa01.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CourseInsertReqDto {
    private String name;
    private String description;
    private String location;
    private String code;
}
