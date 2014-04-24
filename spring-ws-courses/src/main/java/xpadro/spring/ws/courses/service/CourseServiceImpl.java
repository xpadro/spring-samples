package xpadro.spring.ws.courses.service;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import xpadro.spring.ws.courses.types.Course;

@Component("courseService")
public class CourseServiceImpl implements CourseService {
	private final Map<String, Course> courses;
	
	public CourseServiceImpl() {
		courses = new HashMap<>();
		
		Course course1 = new Course();
		course1.setCourseId("BC-45");
		course1.setDescription("An introduction to Java");
		course1.setName("Introduction to Java");
		course1.setSubscriptors(new BigInteger("25"));
		courses.put("BC-45", course1);
		
		Course course2 = new Course();
		course2.setCourseId("DF-21");
		course2.setDescription("Learn about functional programming");
		course2.setName("Functional Programming Principles in Scala");
		course2.setSubscriptors(new BigInteger("12"));
		courses.put("DF-21", course2);
	}

	@Override
	public Map<String, Course> getCourses() {
		return Collections.unmodifiableMap(courses);
	}

	@Override
	public Course getCourse(String courseId) {
		if ("DF-21".equals(courseId)) {
			try {
				Thread.sleep(4000); //added sleep in order to test client timeout
			} catch (InterruptedException e) { }
		}
		
		return courses.get(courseId);
	}

}
