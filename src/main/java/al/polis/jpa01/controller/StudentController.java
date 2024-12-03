package al.polis.jpa01.controller;

import al.polis.jpa01.dto.*;
import al.polis.jpa01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/insert-student")
    public StudentInsertResDto insert(StudentInsertReqDto student){
        return studentService.insert(student);
    }

    @PostMapping("/update-student")
    public StudentUpdateResDto update(StudentUpdateReqDto student){
        return studentService.update(student);
    }

    @PostMapping("/delete-student")
    public void delete(SimpleIdDto idDto){
        studentService.delete(idDto);
    }
}
