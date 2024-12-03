package al.polis.jpa01.dto;

import al.polis.jpa01.model.Course;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CourseInsertResDto extends CourseInsertReqDto {
    private long id;
}
