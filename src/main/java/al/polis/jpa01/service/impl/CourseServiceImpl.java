package al.polis.jpa01.service.impl;

import al.polis.jpa01.dto.*;
import al.polis.jpa01.model.Course;
import al.polis.jpa01.model.Student;
import al.polis.jpa01.repository.CourseRepository;
import al.polis.jpa01.repository.StudentRepository;
import al.polis.jpa01.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public CourseInsertResDto insert(CourseInsertReqDto courseDto) {
        // Map DTO into Entity
        if (courseDto == null) {
            return null;
        }
        Course course = new Course();
        course.setCode(courseDto.getCode());
        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        course.setLocation(courseDto.getLocation());

        // invoke repository
        Course courseSaved = courseRepository.save(course);

        // Map the Entity returned from repository into DTO
        CourseInsertResDto courseInsertResDto = new CourseInsertResDto();
        courseInsertResDto.setCode(courseSaved.getCode());
        courseInsertResDto.setName(courseSaved.getName());
        courseInsertResDto.setDescription(courseSaved.getDescription());
        courseInsertResDto.setLocation(courseSaved.getLocation());
        courseInsertResDto.setId(courseSaved.getId());
        return courseInsertResDto;
    }

    @Override
    public CourseUpdateResDto update(CourseUpdateReqDto courseDto) {
        if (courseDto == null) {
            return null;
        }
        Course course = new Course();
        course.setCode(courseDto.getCode());
        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        course.setLocation(courseDto.getLocation());

        Course courseSaved = courseRepository.save(course);

        CourseUpdateResDto courseUpdateResDto = new CourseUpdateResDto();
        courseUpdateResDto.setId(courseSaved.getId());
        courseUpdateResDto.setCode(courseSaved.getCode());
        courseUpdateResDto.setName(courseSaved.getName());
        courseUpdateResDto.setDescription(courseSaved.getDescription());
        courseUpdateResDto.setLocation(courseSaved.getLocation());

        return courseUpdateResDto;
    }

    @Override
    public void delete(SimpleIdDto idDto) {
        if (idDto == null) {
            return;
        }
        courseRepository.deleteById(idDto.getId());
    }

    @Override
    public Course associate(Course course, Student student) {
        var list = course.getStudents();
        list.add(student);
        courseRepository.save(course);
        student.setCourse(course);
        studentRepository.save(student);

        return course;
    }
}
