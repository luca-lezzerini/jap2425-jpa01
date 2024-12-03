package al.polis.jpa01.repository;

import al.polis.jpa01.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
