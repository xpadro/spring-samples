package xpadro.spring.ws.courses.service.exception;

public class CourseNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 7164016805769398451L;

	public CourseNotFoundException(String message) {
		super(message);
	}
	
	public CourseNotFoundException(String message, Throwable t) {
		super(message, t);
	}
}
