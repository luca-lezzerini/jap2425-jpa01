package al.polis.jpa01.service.impl;

import al.polis.jpa01.dto.*;
import al.polis.jpa01.model.Student;
import al.polis.jpa01.repository.StudentRepository;
import al.polis.jpa01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentInsertResDto insert(StudentInsertReqDto studentDto) {
        if (studentDto == null) {
            return null;
        }
        Student studentEntity = new Student();
        studentEntity.setFirstName(studentDto.getFirstName());
        studentEntity.setLastName(studentDto.getLastName());

        Student studentSaved = studentRepository.save(studentEntity);

        StudentInsertResDto studentInsertResDto = new StudentInsertResDto();
        studentInsertResDto.setId(studentSaved.getId());
        studentInsertResDto.setFirstName(studentSaved.getFirstName());
        studentInsertResDto.setLastName(studentSaved.getLastName());
        return studentInsertResDto;
    }

    @Override
    public void delete(SimpleIdDto idDto) {
        if (idDto == null) {
            return;
        }
        studentRepository.deleteById(idDto.getId());
    }

    @Override
    public StudentUpdateResDto update(StudentUpdateReqDto studentDto) {
        if (studentDto == null) {
            return null;
        }
        Student studentEntity = new Student();
        studentEntity.setId(studentDto.getId());
        studentEntity.setFirstName(studentDto.getFirstName());
        studentEntity.setLastName(studentDto.getLastName());

        Student studentSaved = studentRepository.save(studentEntity);

        StudentUpdateResDto studentUpdateResDto = new StudentUpdateResDto();
        studentUpdateResDto.setId(studentSaved.getId());
        studentUpdateResDto.setFirstName(studentSaved.getFirstName());
        studentUpdateResDto.setLastName(studentSaved.getLastName());
        return studentUpdateResDto;
    }
}
