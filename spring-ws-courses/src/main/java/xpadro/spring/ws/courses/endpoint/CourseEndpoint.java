package xpadro.spring.ws.courses.endpoint;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import xpadro.spring.ws.courses.service.CourseService;
import xpadro.spring.ws.courses.service.exception.CourseNotFoundException;
import xpadro.spring.ws.courses.types.Course;
import xpadro.spring.ws.courses.types.GetCourseListRequest;
import xpadro.spring.ws.courses.types.GetCourseListResponse;
import xpadro.spring.ws.courses.types.GetCourseRequest;
import xpadro.spring.ws.courses.types.GetCourseResponse;

@Endpoint
public class CourseEndpoint {
	private static final String NAMESPACE = "http://www.xpadro.spring.samples.com/courses";
	
	@Autowired
	private CourseService service;
	
	@PayloadRoot(localPart="getCourseRequest", namespace=NAMESPACE)
	public @ResponsePayload GetCourseResponse getCourse(@RequestPayload GetCourseRequest request) {
		Course course = service.getCourse(request.getCourseId());
		
		if (course == null) {
			throw new CourseNotFoundException("course [" + request.getCourseId() + "] does not exist");
		}
		
		GetCourseResponse response = new GetCourseResponse();
		response.setCourseId(course.getCourseId());
		response.setDescription(course.getDescription());
		response.setName(course.getName());
		response.setSubscriptors(course.getSubscriptors());
		
		return response;
	}
	
	@PayloadRoot(localPart="getCourseListRequest", namespace=NAMESPACE)
	public @ResponsePayload GetCourseListResponse getCourseList(@RequestPayload GetCourseListRequest request) {
		GetCourseListResponse response = new GetCourseListResponse();
		for (Map.Entry<String, Course> entry : service.getCourses().entrySet()) {
			response.getCourse().add(entry.getValue());
		}
		
		return response;
	}
}
