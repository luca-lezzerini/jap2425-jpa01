package al.polis.jpa01;

import al.polis.jpa01.dto.CourseInsertReqDto;
import al.polis.jpa01.dto.CourseInsertResDto;
import al.polis.jpa01.dto.StudentInsertReqDto;
import al.polis.jpa01.model.Course;
import al.polis.jpa01.model.Student;
import al.polis.jpa01.repository.CourseRepository;
import al.polis.jpa01.repository.StudentRepository;
import al.polis.jpa01.service.CourseService;
import al.polis.jpa01.service.StudentService;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class Jpa01ApplicationTests {

	@Autowired
	CourseService courseService;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	StudentService studentService;
	@Autowired
	StudentRepository studentRepository;

	@Test
	@Order(1)
	public void createCourse() {
		CourseInsertReqDto courseInsertReqDto = new CourseInsertReqDto();
		courseInsertReqDto.setCode("JAP");
		courseInsertReqDto.setName("Java Advanced Programming");
		courseInsertReqDto.setDescription("Lorem ipsum");
		courseInsertReqDto.setLocation("B3");

		var cx = courseService.insert(courseInsertReqDto);
		Assertions.assertNotNull(cx);
		Assertions.assertNotNull(cx.getId());
		Long id = cx.getId();
		Optional<Course> course = courseRepository.findById(id);
		Assertions.assertTrue(course.isPresent());
		Assertions.assertEquals(cx.getCode(), course.get().getCode());
		Assertions.assertEquals(cx.getName(), course.get().getName());
		Assertions.assertEquals(cx.getDescription(), course.get().getDescription());
		Assertions.assertEquals(cx.getLocation(), course.get().getLocation());
	}

	@Test
	@Order(2)
	public void createStudent(){
		StudentInsertReqDto studentInsertReqDto = new StudentInsertReqDto();
		studentInsertReqDto.setFirstName("John");
		studentInsertReqDto.setLastName("Doe");
		studentInsertReqDto.setSerialNumber("123456789");
		var sx = studentService.insert(studentInsertReqDto);
		Assertions.assertNotNull(sx);
		Assertions.assertNotNull(sx.getId());
		Long id = sx.getId();
		Optional<Student> student = studentRepository.findById(id);
		Assertions.assertTrue(student.isPresent());
		Assertions.assertEquals(sx.getFirstName(), student.get().getFirstName());
		Assertions.assertEquals(sx.getLastName(), student.get().getLastName());
		Assertions.assertEquals(sx.getSerialNumber(), student.get().getSerialNumber());
	}

	@Test
	@Order(3)
	public void addStudentToCourse(){
		// get the list of all courses and students
		List<Student> studs = studentRepository.findAll();
		var courses = courseRepository.findAll();

		// associate the last ones
		var lastStud = studs.get(studs.size() - 1);
		var lastStud2 = studs.get(studs.size() - 2);
		var lastCourse = courses.get(courses.size() - 1);

		// associate the student to the course
		courseService.associate(lastCourse, lastStud);
		courseService.associate(lastCourse, lastStud2);

		System.out.println(lastCourse.getStudents().size());

	}

}
