package al.polis.jpa01.service;

import al.polis.jpa01.dto.*;
import al.polis.jpa01.model.Course;
import al.polis.jpa01.model.Student;

public interface CourseService {
    CourseInsertResDto insert(CourseInsertReqDto course);
    CourseUpdateResDto update(CourseUpdateReqDto course);
    void delete(SimpleIdDto idDto);
    Course associate(Course course, Student student);
}
