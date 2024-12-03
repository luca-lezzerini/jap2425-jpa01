package al.polis.jpa01.service.impl;

import al.polis.jpa01.dto.*;
import al.polis.jpa01.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public StudentInsertResDto insert(StudentInsertReqDto student) {
        return null;
    }

    @Override
    public void delete(SimpleIdDto idDto) {

    }

    @Override
    public StudentUpdateResDto update(StudentUpdateReqDto student) {
        return null;
    }
}
