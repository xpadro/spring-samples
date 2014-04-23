package xpadro.spring.ws.courses.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import xpadro.spring.ws.courses.types.Course;
import xpadro.spring.ws.courses.types.GetCourseListRequest;
import xpadro.spring.ws.courses.types.GetCourseListResponse;
import xpadro.spring.ws.courses.types.GetCourseRequest;
import xpadro.spring.ws.courses.types.GetCourseResponse;
import xpadro.spring.ws.courses.types.GetLastUserRequest;
import xpadro.spring.ws.courses.types.GetLastUserResponse;

@ContextConfiguration("classpath:xpadro/spring/ws/courses/test/config/test-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCourseApp {
	@Autowired 
	WebServiceTemplate wsTemplate;
	
	@Test
	public void invokeGetCourseOperation() throws Exception {
		GetCourseRequest request = new GetCourseRequest();
		request.setCourseId("1");
		
		GetCourseResponse response = (GetCourseResponse) wsTemplate.marshalSendAndReceive(request);
		
		assertNotNull(response);
		assertEquals("BC-45", response.getCourseId());
		assertEquals("Introduction to Java", response.getName());
		assertEquals("An introduction to Java", response.getDescription());
		assertEquals(new BigInteger("25", 10), response.getSubscriptors());
	}
	
	@Test
	public void invokeGetCourseListOperation() {
		GetCourseListRequest request = new GetCourseListRequest();
		GetCourseListResponse response = (GetCourseListResponse) wsTemplate.marshalSendAndReceive(request);
		
		assertNotNull(response);
		List<Course> courses = response.getCourse();
		assertEquals(2, courses.size());
		Course course1 = courses.get(0);
		assertNotNull(course1);
		assertEquals("BC-45", course1.getCourseId());
		
		Course course2 = courses.get(1);
		assertNotNull(course2);
		assertEquals("DF-21", course2.getCourseId());
	}
	
	@Test
	public void invokeGetLastUserRegisteredOperation() {
		GetLastUserRequest request = new GetLastUserRequest();
		GetLastUserResponse response = (GetLastUserResponse) wsTemplate.marshalSendAndReceive(request);
		assertNotNull(response);
	}
}
