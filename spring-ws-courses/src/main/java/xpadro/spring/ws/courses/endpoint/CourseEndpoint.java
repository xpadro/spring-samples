package xpadro.spring.ws.courses.endpoint;

import java.math.BigInteger;
import java.util.Random;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import xpadro.spring.ws.courses.types.Course;
import xpadro.spring.ws.courses.types.GetCourseListRequest;
import xpadro.spring.ws.courses.types.GetCourseListResponse;
import xpadro.spring.ws.courses.types.GetCourseRequest;
import xpadro.spring.ws.courses.types.GetCourseResponse;
import xpadro.spring.ws.courses.types.GetLastUserRequest;
import xpadro.spring.ws.courses.types.GetLastUserResponse;

@Endpoint
public class CourseEndpoint {
	private static final String NAMESPACE = "http://www.xpadro.spring.samples.com/courses";

	/**
	 * Used by Spring Integration sample to test a correct invocation to the web service
	 * @param request
	 * @return
	 */
	@PayloadRoot(localPart="getCourseRequest", namespace=NAMESPACE)
	public @ResponsePayload GetCourseResponse getCourse(@RequestPayload GetCourseRequest request) {
		GetCourseResponse response = new GetCourseResponse();
		response.setCourseId("BC-45");
		response.setDescription("An introduction to Java");
		response.setName("Introduction to Java");
		response.setSubscriptors(new BigInteger("25"));
		
		return response;
	}
	
	/**
	 * Used by Spring Integration sample to test configuring a timeout
	 * @param request
	 * @return
	 * @throws InterruptedException 
	 */
	@PayloadRoot(localPart="getCourseListRequest", namespace=NAMESPACE)
	public @ResponsePayload GetCourseListResponse getCourseList(@RequestPayload GetCourseListRequest request) throws InterruptedException {
		Thread.sleep(4000);   //sleep to let the client test timeout
		return getDummyCourseList();
	}
	
	/**
	 * Used by Spring Integration sample to test cacheable operations
	 * @param request
	 * @return
	 */
	@PayloadRoot(localPart="getLastUserRequest", namespace=NAMESPACE)
	public @ResponsePayload GetLastUserResponse getLastUserRegistered(@RequestPayload GetLastUserRequest request) {
		Random random = new Random();
		String userId = String.valueOf(random.nextInt(100));
		
		GetLastUserResponse response = new GetLastUserResponse();
		response.setUserId(new BigInteger(userId));
		
		return response;
	}
	
	private GetCourseListResponse getDummyCourseList() {
		GetCourseListResponse response = new GetCourseListResponse();
		
		Course course1 = new Course();
		course1.setCourseId("BC-45");
		course1.setDescription("An introduction to Java");
		course1.setName("Introduction to Java");
		course1.setSubscriptors(new BigInteger("25"));
		response.getCourse().add(course1);
		
		Course course2 = new Course();
		course2.setCourseId("DF-21");
		course2.setDescription("Learn about functional programming");
		course2.setName("Functional Programming Principles in Scala");
		course2.setSubscriptors(new BigInteger("12"));
		response.getCourse().add(course2);
		
		return response;
	}
}
