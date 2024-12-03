package al.polis.jpa01.service;

import al.polis.jpa01.dto.*;
import al.polis.jpa01.model.Student;

public interface StudentService {
    StudentInsertResDto insert(StudentInsertReqDto student);
    void delete(SimpleIdDto idDto);
    StudentUpdateResDto update(StudentUpdateReqDto student);
}
