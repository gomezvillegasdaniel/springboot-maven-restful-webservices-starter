package springboot.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/course/{id}")
	public void deleteCourse(@PathVariable("id") String id) {
		courseService.deleteCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/course/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable("topicId") String topicId, @PathVariable("id") String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping("/topics/{topicId}/course/{id}")
	public Course getCourse(@PathVariable("id") String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable("id") String id) {
		return courseService.getAllCourses(id);
	}
	
}
