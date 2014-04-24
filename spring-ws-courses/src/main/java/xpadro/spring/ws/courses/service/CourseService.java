package xpadro.spring.ws.courses.service;

import java.util.Map;

import xpadro.spring.ws.courses.types.Course;

public interface CourseService {

	Map<String, Course> getCourses();
	
	Course getCourse(String courseId);
}
