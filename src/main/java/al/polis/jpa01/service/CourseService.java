package al.polis.jpa01.service;

import al.polis.jpa01.dto.*;
import al.polis.jpa01.model.Course;

public interface CourseService {
    CourseInsertResDto insert(CourseInsertReqDto course);
    CourseUpdateResDto update(CourseUpdateReqDto course);
    void delete(SimpleIdDto idDto);
}
