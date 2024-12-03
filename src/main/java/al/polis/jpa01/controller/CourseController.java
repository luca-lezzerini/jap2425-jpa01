package al.polis.jpa01.controller;

import al.polis.jpa01.dto.CourseInsertResDto;
import al.polis.jpa01.dto.CourseUpdateResDto;
import al.polis.jpa01.dto.SimpleIdDto;
import al.polis.jpa01.repository.CourseRepository;
import al.polis.jpa01.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/insert-course")
    public CourseInsertResDto insert(CourseInsertResDto courseInsertResDto) {
        return courseService.insert(courseInsertResDto);
    }

    @PostMapping("/update-course")
    public CourseUpdateResDto update(CourseUpdateResDto courseUpdateResDto) {
        return courseService.update(courseUpdateResDto);
    }

    @PostMapping("/delete-course")
    public void delete(SimpleIdDto idDto) {
        courseService.delete(idDto);
    }
}
