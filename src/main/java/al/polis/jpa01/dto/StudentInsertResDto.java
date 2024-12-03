package al.polis.jpa01.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class StudentInsertResDto extends StudentInsertReqDto{
    private long id;
}
