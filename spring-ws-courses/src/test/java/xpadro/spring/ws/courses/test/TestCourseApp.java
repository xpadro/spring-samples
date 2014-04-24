package xpadro.spring.ws.courses.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;

import xpadro.spring.ws.courses.types.Course;
import xpadro.spring.ws.courses.types.GetCourseListRequest;
import xpadro.spring.ws.courses.types.GetCourseListResponse;
import xpadro.spring.ws.courses.types.GetCourseRequest;
import xpadro.spring.ws.courses.types.GetCourseResponse;

@ContextConfiguration("classpath:xpadro/spring/ws/courses/test/config/test-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCourseApp {
	@Autowired 
	WebServiceTemplate wsTemplate;
	
	@Test
	public void invokeGetCourseOperation() throws Exception {
		GetCourseRequest request = new GetCourseRequest();
		request.setCourseId("BC-45");
		
		GetCourseResponse response = (GetCourseResponse) wsTemplate.marshalSendAndReceive(request);
		
		assertNotNull(response);
		assertEquals("BC-45", response.getCourseId());
		assertEquals("Introduction to Java", response.getName());
		assertEquals("An introduction to Java", response.getDescription());
		assertEquals(new BigInteger("25", 10), response.getSubscriptors());
	}
	
	@Test(expected=SoapFaultClientException.class)
	public void invokeOnInvalidCourse() {
		GetCourseRequest request = new GetCourseRequest();
		request.setCourseId("non_existing_course");
		
		GetCourseResponse response = (GetCourseResponse) wsTemplate.marshalSendAndReceive(request);
		assertNull(response);
	}
	
	@Test
	public void invokeGetCourseListOperation() {
		GetCourseListRequest request = new GetCourseListRequest();
		GetCourseListResponse response = (GetCourseListResponse) wsTemplate.marshalSendAndReceive(request);
		
		assertNotNull(response);
		List<Course> courses = response.getCourse();
		assertEquals(2, courses.size());
	}
}
